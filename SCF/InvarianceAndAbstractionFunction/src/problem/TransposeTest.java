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
public class TransposeTest {

    private int fInput[][];
    private int sInput;
    private int tInput;
    private int fExpected[][];

    public TransposeTest(int finput[][], int sinput, int tinput, int expected[][]) {
        this.fInput = finput;
        this.sInput = sinput;
        this.tInput = tinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[][]{{ 2, 0, 0},
                              { 0, 1, 3}
                              }, 2,3, new int[][]{{ 2, 0},
                                                  { 0, 1},
                                                  { 0, 3}}  },
                { new int[][]{{ 10, 0 }, 
                              { 0, 5 }, 
                              { 2, 0 }},3, 2, new int[][]{{ 10, 0, 2 }, 
                                                           { 0, 5, 0 }} }});
    }

    @Test
    public void test() {
        SparseMatrix tra = new SparseMatrix(fInput,sInput,tInput);
        assertArrayEquals(fExpected, tra.transpose());
    }

}
