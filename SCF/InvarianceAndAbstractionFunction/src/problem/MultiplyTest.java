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
public class MultiplyTest {

    private int firstInput[][];
    private int secondInput;
    private int thirdInput;
    private SparseMatrix fourthInput;
    private int fExpected[][];

    public MultiplyTest(int firstinput[][], int secondinput, int thirdinput, SparseMatrix fourthinput,int expected[][]) {
        this.firstInput = firstinput;
        this.secondInput = secondinput;
        this.thirdInput = thirdinput;
        this.fourthInput = fourthinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[][]{{ 2, 1, 0},
                        { 0, 2, 0},
                        { 0, 0, 2}}, 3, 3, new SparseMatrix (new int[][]{{ 4, 0, 0},
                                                          { 1, 2, 2},
                                                          { 0, 0, 1}},3, 3), new int[][]{{ 9, 2, 2},
                                                                                       { 2, 4, 4},
                                                                                       { 0, 0, 2}}  },
                { new int[][]{{ 10, 20, 10 }, 
                        { 4, 5, 6 }, 
                        { 2, 3, 5 }},3, 3, new SparseMatrix (new int[][]{{ 3, 2, 4 }, 
                                                            { 3, 3, 9 }, 
                                                            { 4, 4, 2 }},3, 3), new int[][]{{ 130, 120, 240}, 
                                                                                            { 51, 47, 73}, 
                                                                                            { 35, 33, 45}}  },
                { new int[][]{{ 2, 1, 0},
                        { 0, 2, 0}}, 2, 3, new SparseMatrix (new int[][]{{ 4, 0, 0},
                                                            { 1, 2, 2},
                                                            { 0, 0, 1}},3, 3), new int[][]{{ 9, 2, 2},
                                                                                           { 2, 4, 4}}  }});
    }

    @Test
    public void test() {
        SparseMatrix mul = new SparseMatrix(firstInput,secondInput,thirdInput);
        assertArrayEquals(fExpected, mul.multiply(fourthInput));
    }

}
