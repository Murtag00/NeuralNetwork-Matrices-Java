package de.phip1611.matrices;

/*
 * AUTHOR: PHILIPP SCHUSTER
 *   Web:     https://phip1611.de
 *   Twitter: https://twitter.com/phip1611
 *
 * This project on GitHub:
 *   https://github.com/phip1611/Matrices-Java
 *
 * License: MIT-License
 *   https://github.com/phip1611/Matrices-Java/blob/master/LICENSE
 *
 */

/**
 * A class with a private constructor that
 * offers basic static operations on matrices similar
 * to the class Collections
 */
public class MatrixUtils /*implements MatrixArithmetic*/ {
    private MatrixUtils() {};

    /**
     * Add two matrices.
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix add(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new NullPointerException("Matrix is null");
        }
        if (m1.getColCount() == m2.getColCount()
                && m1.getRowCount() == m2.getRowCount()) {
            Matrix result = new Matrix(m1.getRowCount(), m1.getColCount());
            for (int i = 1; i <= result.getRowCount(); i++) {
                for (int j = 1; j <= result.getColCount(); j++) {
                    result.set(i,j, m1.get(i, j) + m2.get(i, j));
                }
            }
            return result;
        } else {
            throw new InvalidMatrixDimensionxException("If you want to add two matrices make sure both have the same dimension!");
        }
        //return null;
    }

    /**
     * Substract two matrices.
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix sub(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new NullPointerException("Matrix is null");
        }
        if (m1.getColCount() == m2.getColCount()
                && m1.getRowCount() == m2.getRowCount()) {
            Matrix result = new Matrix(m1.getRowCount(), m1.getColCount());
            for (int i = 1; i <= result.getRowCount(); i++) {
                for (int j = 1; j <= result.getColCount(); j++) {
                    result.set(i,j, m1.get(i, j) - m2.get(i, j));
                }
            }
            return result;
        } else {
            throw new InvalidMatrixDimensionxException("If you want to substract two matrices make sure both have the same dimension!");
        }
        //return null;
    }

    /**
     * Values of Matrix 1 (nxm) modulo values of Matrix 2 (nxm)
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix mod(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new NullPointerException("Matrix is null");
        }
        if (m1.getColCount() == m2.getColCount()
                && m1.getRowCount() == m2.getRowCount()) {
            Matrix result = new Matrix(m1.getRowCount(), m1.getColCount());
            for (int i = 1; i <= result.getRowCount(); i++) {
                for (int j = 1; j <= result.getColCount(); j++) {
                    result.set(i,j, m1.get(i, j) % m2.get(i, j));
                }
            }
            return result;
        } else {
            throw new InvalidMatrixDimensionxException("If you want to substract two matrices make sure both have the same dimension!");
        }
        //return null;
    }


    /**
     * Multiply two matrices.
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix mult(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new NullPointerException("At least one matrix is null");
        }
        if (m1.getColCount() != m2.getRowCount()) {
            throw new InvalidMatrixDimensionxException("Multiplying two matrices is only allowed/possible if m1.cols == m2.rows");
        }
        Matrix result = new Matrix(m1.getRowCount(), m2.getColCount());
        int c = 0;
        // for each row of the result matrix
        for (int a = 1; a <= result.getRowCount(); a++) {
            // for each col of the result matrix
            for (int b = 1; b <= result.getColCount(); b++) {
                c = 0;
                // calc the value of result matrix[a][b]
                for (int x = 1; x <= m1.getColCount(); x++) {
                    c += m1.get(a,x) * m2.get(x, b);
                }
                result.set(a,b,c);
            }
        }
        return result;
    }

    /**
     * Divides two matrix. Similar to multiplying, but replaces the * with /
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix div(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new NullPointerException("Matrix is null");
        }
        if (m1.getColCount() != m2.getRowCount()) {
            throw new InvalidMatrixDimensionxException("Multiplying/Dividing two matrices is only allowed/possible if m1.cols == m2.rows");
        }
        Matrix result = new Matrix(m1.getRowCount(), m2.getColCount());
        int c = 0;
        // for each row of the result matrix
        for (int a = 1; a <= result.getRowCount(); a++) {
            // for each col of the result matrix
            for (int b = 1; b <= result.getColCount(); b++) {
                c = 0;
                // calc the value of result matrix[a][b]
                for (int x = 1; x <= m1.getColCount(); x++) {
                    c += m1.get(a,x) / m2.get(x, b);
                }
                result.set(a,b,c);
            }
        }
        return result;
    }

    /**
     * Transpose a matrix.
     * @param m
     * @return
     */
    public static Matrix transpose(Matrix m) {
        if (m == null) {
            throw new NullPointerException("Matrix is null");
        }
        Matrix result = new Matrix(m.getColCount(), m.getRowCount());
        for (int i = 1; i <= result.getRowCount(); i++) {
            for (int j = 1; j <= result.getColCount(); j++) {
                result.set(i,j, m.get(j,i));
            }
        }
        return result;
    }

    public static class InvalidMatrixDimensionxException extends IllegalArgumentException {
        public InvalidMatrixDimensionxException(String msg) {
            super(msg);
        }
        public InvalidMatrixDimensionxException() {
            super();
        }
    }
}
