package Question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MolecularWeight {

    private static HashMap<Character, Integer> massOfElements;
    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    String molecule;
    static char[] moleculeArray;
    static int weight = 0, temporaryWeight = 0;
    static boolean flag = false;

    /**
     * To initialize the weight of C, H and O.
     */
    static {
        massOfElements = new HashMap<Character, Integer>();
        massOfElements.put('C', 12);
        massOfElements.put('O', 16);
        massOfElements.put('H', 1);
    }

    /**
     * Get the molecular weight of the given chemical compound.
     * @param molecule : molecule
     * @return the molecular weight.
     * @throws NumberFormatException
     * @throws IOException
     */
    public static int getMolecularWeight(String molecule)
            throws NumberFormatException, IOException {
        molecule = molecule.toUpperCase().trim();
        if (molecule.contains(" ")) {
            molecule.replace("\\s", " ");
            
            System.out.println("Did you Mean " + molecule 
                                + "?\nPress : "
                                + "\n1) Yes\n2) No\nSelect Your Option : ");
            
            switch (Integer.parseInt(br.readLine())) {
                case 1:
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Input...");
            }
        }
        moleculeArray = molecule.toCharArray();
        return getWeight(moleculeArray, 0, flag);

    }

    /**
     * Get weight of the given molecule.
     * @param moleculeArray2 : array consists each atom separately.
     * @return
     */
    private static int getWeight(char[] moleculeArray2, int index, boolean flag) {
        if (index == moleculeArray2.length) {
            return weight;
        }
        if (Character.isDigit(moleculeArray[index])) {
            if (moleculeArray[index - 1] == ')') {
                weight += temporaryWeight
                        * Integer.parseInt(Character
                                .toString(moleculeArray[index]))
                        - temporaryWeight;
            } else if (flag) {
                temporaryWeight += massOfElements.get(moleculeArray[index - 1])
                        * Integer.parseInt(Character
                                .toString(moleculeArray[index]))
                        - massOfElements.get(moleculeArray[index - 1]);
            } else {
                weight += massOfElements.get(moleculeArray[index - 1])
                        * Integer.parseInt(Character
                                .toString(moleculeArray[index]))
                        - massOfElements.get(moleculeArray[index - 1]);
                System.out.println(moleculeArray[index - 1] + " : " + weight);
            }
            return getWeight(moleculeArray, index + 1, flag);
        } else {
            if (moleculeArray[index] == ')') {
                weight += temporaryWeight;
                flag = false;
            } else if (moleculeArray[index] == '(') {
                flag = true;
            } else if (flag) {
                temporaryWeight += massOfElements.get(moleculeArray[index]);
            } else {
                weight += massOfElements.get(moleculeArray[index]);
                System.out.println("weight : " + weight);
            }
            return getWeight(moleculeArray, index + 1, flag);
        }
    }
}
