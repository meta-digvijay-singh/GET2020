package problem;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import problem.SparseMatrix;

@RunWith(Parameterized.class)
public class AddTest {

    private int firstInput[][];
    private int secondInput;
    private int thirdInput;
    private SparseMatrix fourthInput;
    private int fExpected[][];

    public AddTest(int firstinput[][], int secondinput, int thirdinput, SparseMatrix fourthinput,int expected[][]) {
        this.firstInput = firstinput;
        this.secondInput = secondinput;
        this.thirdInput = thirdinput;
        this.fourthInput = fourthinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[][]{{ 1, 0, 3},
                              { 1, 0, 3},
                              { 0, 2, 0}},3, 3, new SparseMatrix (new int[][]{{ 0, 2, 3},
                                                          { 1, 0, 3},
                                                          { 1, 2, 0}}, 3,3), new int[][]{{ 1, 2, 6},
                                                                                       { 2, 0, 6},
                                                                                       { 1, 4, 0}}  },
                { new int[][]{{ 1, 1, 0},
                        { 0, 0, 1},
                        { 1, 0, 0}}, 3,3, new SparseMatrix (new int[][]{{ 1, 0, 3},
                                                    { 0, 2, 3},
                                                    { 1, 0, 0}}, 3,3), new int[][]{{ 2, 1, 3},
                                                                                 { 0, 2, 4},
                                                                                 { 2, 0, 0}}  }});
    }

    @Test
    public void test() {
        SparseMatrix sum = new SparseMatrix(firstInput,secondInput,thirdInput);
        assertArrayEquals(fExpected, sum.add(fourthInput));
    }

}
