package de.phip1611.math.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Matrix3x3Test {
    private static final int X_DIM = 3;
    private static final int Y_DIM = 3;

    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix matrix3;

    @BeforeEach
    public void setUp() {
        matrix1 = new Matrix(X_DIM, Y_DIM);
        matrix2 = new Matrix(X_DIM, Y_DIM);
        matrix2.init(1,-2,3,-4,5,-6,7,-8,9);
        matrix3 = new Matrix(X_DIM, Y_DIM);
        matrix3.init(0,0,0,-1,-1,-1,2,0,-3);
    }

    @Test
    public void addAllTest() {
        matrix1.addAll(1);
        for (int i = 1; i <= X_DIM; i++) {
            for (int j = 1; j <= Y_DIM; j++) {
                Assertions.assertEquals(1,matrix1.get(i,j));
            }
        }
    }

    @Test
    public void addToColTest() {
        matrix2.addToCol(1,-2);
        Assertions.assertEquals(-1, matrix2.get(1,1));
        Assertions.assertEquals(-6, matrix2.get(2,1));
        Assertions.assertEquals(5, matrix2.get(3,1));
    }

    @Test
    public void addToRowTest() {
        matrix3.addToRow(3,42);
        Assertions.assertEquals(44, matrix3.get(3,1));
        Assertions.assertEquals(42, matrix3.get(3,2));
        Assertions.assertEquals(39, matrix3.get(3,3));
    }

    @Test
    public void addRowToRowTest() {
        matrix1.addRowToRow(1,2);
        for (int i = 1; i <= X_DIM; i++) {
            for (int j = 1; j <= Y_DIM; j++) {
                Assertions.assertEquals(0,matrix1.get(i,j));
            }
        }

        matrix2.addRowToRow(1,2);
        // (1,-2,3) + (-4,5,-6)
        Assertions.assertEquals(-3, matrix2.get(2,1));
        Assertions.assertEquals(3, matrix2.get(2,2));
        Assertions.assertEquals(-3, matrix2.get(2,3));
    }
}
