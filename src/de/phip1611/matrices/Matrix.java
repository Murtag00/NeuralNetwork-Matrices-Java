package de.phip1611.matrices;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Matrix implements BasicArithmetic {
    protected MatrixDimension dim;
    protected int[] [] matrix;
    public Matrix(int rows, int cols) {
        this.dim = new MatrixDimension(rows, cols);
        this.matrix = new int[dim.rows()][dim.cols()];
    }

    /**
     * Returns the value at the index.
     * @param row
     * @param col
     */
    public int get(int row, int col) {
        this.dim.check(row, col);
        return this.matrix[row-1][col-1];
    }

    /**
     * Sets the value at the index.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, int value) {
        this.dim.check(row, col);
        this.matrix[row-1][col-1] = value;
    }

    /**
     * Set's all fields of the matrix to the value.
     * @param value
     */
    public void setAll(int value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] = value;
            }
        }
    }

    @Override
    public void addAll(int value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] += value;
            }
        }
    }

    @Override
    public void subAll(int value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] -= value;
            }
        }
    }

    @Override
    public void multAll(int value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] *= value;
            }
        }
    }

    @Override
    public void divAll(int value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] /= value;
            }
        }
    }

    @Override
    public void modAll(int value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] %= value;
            }
        }
    }

    @Override
    public void add(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] += value;
    }

    @Override
    public void sub(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] -= value;
    }

    @Override
    public void mult(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] *= value;
    }

    @Override
    public void div(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] /= value;
    }

    @Override
    public void mod(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] %= value;
    }

    public void print() {
        int i = 0;
        while (i < dim.rows()) {
            System.out.println(Arrays.toString(this.matrix[i]));
            i++;
        }
    }

    public boolean isInvertable() throws OperationNotSupportedException, NonQuadraticMatrixException {
        if (det() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Calculates the determinant of a matrix.
     * @return
     */
    public int det() throws NonQuadraticMatrixException, OperationNotSupportedException {
        if (!isQuadraticMatrix()) throw new NonQuadraticMatrixException();
        if (dim.rows() == 2) {
            return matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
        }
        else if (dim.rows() == 3) {
            return matrix[0][0]*matrix[1][1]*matrix[2][2]+matrix[0][1]*matrix[1][2]*matrix[2][0]+matrix[0][2]*matrix[1][0]*matrix[2][1]
                    -matrix[2][0]*matrix[1][1]*matrix[0][2]-matrix[2][1]*matrix[1][2]*matrix[0][0]-matrix[2][2]*matrix[1][0]*matrix[0][1];
        }
        else {
            throw new OperationNotSupportedException("For now you only can calc the determinant of 2x2 and 3x3 matrices!");
        }
    }

    public boolean isQuadraticMatrix() {
        return dim.rows() == dim.cols();
    }

    @Override
    public String toString() {
        return "Matrix: " +
                "dim=" + dim;
    }

    public int getColCount() {
        return this.dim.cols();
    }

    public int getRowCount() {
        return this.dim.rows();
    }


    public class NonQuadraticMatrixException extends Exception {}
}
