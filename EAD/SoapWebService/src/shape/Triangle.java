package shape;
public class Triangle {
	public String areaOfTriangle(double firstSide, double secondSide, double thirdSide) {
		if ((firstSide <= 0) && (secondSide <= 0) && (thirdSide <= 0)) {
			return "Each side should be greater than zero.";
		}
		double semiPerimeter = (firstSide + secondSide + thirdSide) / 2.0;
		double semiArea = semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide);
		double triangleArea = Math.sqrt(semiArea);
		return String.valueOf(triangleArea);
	}
}
