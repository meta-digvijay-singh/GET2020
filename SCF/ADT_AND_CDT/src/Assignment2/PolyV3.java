package Assignment2;

/**
 * Represent a single term of polynomial.
 */
class TermV3 {
	private int power;
	private int coefficient;
	
	public TermV3(int coefficient, int power) {
		this.power = power;
		this.coefficient = coefficient;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getCoefficient() {
		return coefficient;
	}
	
}

/**
 * Represent polynomial equation and its operations.
 */
public class PolyV3 {
	private TermV3[] terms;
	private final static int COEFFICIENT_TERM = 0;
	private final static int POWER_TERM = 1;
	private int size = 0;
	private int degree = -1;
	private int MINIMUM_TERMS_REQUIRED = 1;
	
	/**
	 * Creates a polynomial.
	 * @param array : n X 2 array where first column consists coefficient of each term. 
	 * 				  and second column consists power of each term.
	 * 				  It requires coefficient to be non-zero, power to be non negative.
	 * 				  And at least one row in the array.
	 * @throws ArithmeticException if any of the power is negative.
	 */
	public PolyV3(int[][] array) throws ArithmeticException{
		int numberOfTerms = array.length;
		
		if (numberOfTerms < MINIMUM_TERMS_REQUIRED) {
			throw new ArithmeticException("Polynomial should have atleast one term.");
		}
		
		final int FIRST_TERM = 0;
		terms = new TermV3[numberOfTerms];
		
		/* Iterate through the array and create terms for our polynomial. */
		for (int[] term : array) {
			if (term == null) {
				break;
			}
			int coefficient = term[COEFFICIENT_TERM];
			int power = term[POWER_TERM];
			if (power < 0) {
				throw new ArithmeticException("Power cannot be negative.");
			}
			if (coefficient != 0) {
				terms[size] = new TermV3(coefficient, power);
				size++;
			}
		}
		
		/* Sorts the terms in decreasing sequence based on power using bubble sort. */
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				int powerOfCurrentTerm = terms[j].getPower();
				int powerOfNextTerm = terms[j + 1].getPower();
				if (powerOfCurrentTerm < powerOfNextTerm) {
					TermV3 temp = terms[j];
					terms[j] = terms[j + 1];
					terms[j + 1] = temp;
				} if (powerOfCurrentTerm == powerOfNextTerm) {
					throw new ArithmeticException("Duplicate values not allowed.");
				}
			}
		}
		
		if (size != 0) {
			degree = terms[FIRST_TERM].getPower();
		}
	}
	
	/**
	 * Gives equation of current polynomial in user-readable format.
	 * @return equation of polynomial easily readable by user.
	 */
	public String getEquation() {
		String equation = "";
		for (int termNumber = 0; termNumber < size; termNumber++) {
			equation += terms[termNumber].getCoefficient() + "x^" + terms[termNumber].getPower();
			if (termNumber != size - 1) {
				equation += " + ";
			}
		}
		return equation;
	}
	
	/**
	 * Checks whether power is present in the given polynomial.
	 * @param p : terms of polynomial in n X 2 array where
	 * 			  column1 represents coefficient and column2 represents power.
	 * @param valueOfPower : value of power to be searched.
	 * @return index of the term such that p[index] is the term which contains given power. otherwise -1. 
	 */
	private static int isPowerExist(int[][] p, int valueOfPower) {
		int sizeOfP = p.length;
		if (sizeOfP == 0) {
			return -1;
		}
		/* search the given power using linear search. */
		for (int index = 0; index < sizeOfP; index++) {
			int powerOfCurrentTerm = p[index][POWER_TERM];
			if (powerOfCurrentTerm == valueOfPower) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	 * Checks whether given polynomial consists the given power or not.
	 * @param p : polynomial in which power is searched.
	 * @param valueOfPower : value to be searched.
	 * @return index of the term such that p[term] contains the given power. otherwise -1.
	 */
	private static int isPowerExist(PolyV3 p, int valueOfPower) {
		int sizeOfP = p.size;
		if (sizeOfP == 0) {
			return -1;
		}
		int minIndex = 0;
		int maxIndex = sizeOfP - 1;
		int midIndex = (minIndex + maxIndex) / 2;
		
		/* Searching using binary search. */
		while (minIndex <= maxIndex) {
			int powerOfCurrentTerm = p.terms[midIndex].getPower();
			if (powerOfCurrentTerm == valueOfPower) {
				return midIndex;
			} else if (valueOfPower > powerOfCurrentTerm) {
				maxIndex = midIndex - 1;
			} else {
				minIndex = midIndex + 1;
			}
			midIndex = (minIndex + maxIndex) / 2;
		}
		return -1;
	
	}
	
	/**
	 * Evaluate the polynomial equation for the given value.
	 * @param valueOfX : value of the variable x. 
	 * @return computed value, for the valueOfX.
	 */
	public double evaluate(float valueOfX) {
		float result = 0;
		if (size == 0) {
			return result;
		}
		/* 
		 * compute value by solving the expression [coefficient * (valueOfX ^ power)] for each term. 
		 * and perform addition while computing. 
		 */
		for (int termNumber = 0; termNumber < size; termNumber++) {
			TermV3 term = terms[termNumber];
			int powerOfCurrentTerm = term.getPower();
			int coefficientOfCurrentTerm = term.getCoefficient();
			double evaluatedPower = Math.pow(valueOfX, powerOfCurrentTerm);
			result += (coefficientOfCurrentTerm * evaluatedPower);
		}
		return result;
	}
	
	/**
	 * Gives the degree of polynomial.
	 * @return degree of the polynomial.
	 */
	public int degree() {
		return degree;
	}
	
	/**
	 * Perform addition of two polynomials.
	 * @param p1 : first polynomial.
	 * @param p2 : second polynomial.
	 * @return addition of two polynomial.
	 */
	public static PolyV3 addPoly(PolyV3 p1, PolyV3 p2) {
		int sizeOfP1 = p1.size;
		int sizeOfP2 = p2.size;
		int maxTerms = sizeOfP1 + sizeOfP2;
		int[][] addition = new int[maxTerms][2];
		int currentNumberOfTerms = 0;
		
		/* Iterate through each term of "p1" and add the term if a term has same power in "p2". */
		for (int termNumber = 0; termNumber < sizeOfP1; termNumber++) {
			int powerOfCurrentTermOfP1 = p1.terms[termNumber].getPower();
			int coefficientOfCurrentTermOfP1 = p1.terms[termNumber].getCoefficient();
			int index = isPowerExist(p2, powerOfCurrentTermOfP1);
			
			addition[currentNumberOfTerms] = new int[2];
			addition[currentNumberOfTerms][POWER_TERM] = powerOfCurrentTermOfP1;
			
			if (index == -1) {
				addition[currentNumberOfTerms][COEFFICIENT_TERM] = coefficientOfCurrentTermOfP1;
			} else {
				addition[currentNumberOfTerms][COEFFICIENT_TERM] = coefficientOfCurrentTermOfP1 
																   + p2.terms[index].getCoefficient();
			}
			currentNumberOfTerms++;
		}
		
		/* iterate through each term in "p2" and add only those terms that wasn't computed before. */
		for (int termNumber = 0; termNumber < sizeOfP2; termNumber++) {
			int powerOfCurrentTermOfP2 = p2.terms[termNumber].getPower();
			int coefficientOfCurrentTermOfP2 = p2.terms[termNumber].getCoefficient();
			int index = isPowerExist(p1, powerOfCurrentTermOfP2);
			
			addition[currentNumberOfTerms] = new int[2];
			
			if (index == -1) {
				addition[currentNumberOfTerms] = new int[2];
				addition[currentNumberOfTerms][COEFFICIENT_TERM] = coefficientOfCurrentTermOfP2;
				addition[currentNumberOfTerms][POWER_TERM] =  powerOfCurrentTermOfP2;
				currentNumberOfTerms++;
			}
			
		}
		if (addition.length == 0) {
			return new PolyV3(new int[0][0]);
		}
		return new PolyV3(addition);
	}
	
	/**
	 * Multiply two polynomials.
	 * @param p1 : first polynomial.
	 * @param p2 : second polynomial.
	 * @return multiplication of two polynomial.
	 */
	public static PolyV3 multiplyPolyV3(PolyV3 p1, PolyV3 p2) {
		int sizeOfP1 = p1.size;
		int sizeOfP2 = p2.size;
		int powerComputed;
		int coefficientComputed;
		
		int[][] multiplication = new int[sizeOfP1 * sizeOfP2][2];
		int currentNumberOfTerms = 0;
		
		/* 
		 * picks each term from polynomial "p1" and multiply this with each term in polynomial "p2". 
		 * and stores in the multiplication array.
		 */
		for (int termNumberOfP1 = 0; termNumberOfP1 < sizeOfP1; termNumberOfP1++) {
			int powerOfTermP1 = p1.terms[termNumberOfP1].getPower();
			int coefficientOfTermP1 = p1.terms[termNumberOfP1].getCoefficient();
			
			for (int termNumberOfP2 = 0; termNumberOfP2 < sizeOfP2; termNumberOfP2++) {
				int powerOfTermP2 = p2.terms[termNumberOfP2].getPower();
				int coefficientOfTermP2 = p2.terms[termNumberOfP2].getCoefficient();
				
				powerComputed = powerOfTermP1 + powerOfTermP2;
				coefficientComputed = coefficientOfTermP1 * coefficientOfTermP2;
				
				int index = isPowerExist(multiplication, powerComputed);
				
				if (index == -1) {
					multiplication[currentNumberOfTerms] = new int[2];
					multiplication[currentNumberOfTerms][COEFFICIENT_TERM] = coefficientComputed;
					multiplication[currentNumberOfTerms][POWER_TERM] = powerComputed;
					currentNumberOfTerms++;
				} else {
					multiplication[index][COEFFICIENT_TERM] += coefficientComputed;
				}
			}
		}
		return new PolyV3(multiplication); 
	}
}
