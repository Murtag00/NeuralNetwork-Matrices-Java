package de.phip1611.math.matrices;

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

import java.util.Arrays;

/**
 * A matrix as we know it from mathematics.
 */
public class Matrix implements BasicMatrixArithmetic, Comparable<Matrix> {
    protected MatrixDimension dim;
    protected int[] [] matrix;
    public Matrix(String dimension) {
        if (dimension.matches("([0-9])+([x])([0-9])+")) {
            int rows, cols;
            String[] split = dimension.split("x");
            rows = Integer.valueOf(split[0]);
            cols = Integer.valueOf(split[1]);

            this.dim = new MatrixDimension(rows, cols);
            this.matrix = new int[dim.rows()][dim.cols()];
        } else {
            throw new IllegalArgumentException("Dimension-String has to match" +
                    " with \"([0-9])+([x])([0-9])+\", for example 3x2, 0x0, 20x7");
        }
    }
    public Matrix(int rows, int cols) {
        this.dim = new MatrixDimension(rows, cols);
        this.matrix = new int[dim.rows()][dim.cols()];
    }

    /**
     * Inits a matrix with a set of values. For examle if you have a 3x3 matrix
     * and want to have it look like
     * {
     *   [1,2,3]
     *   [4,-2,6]
     *   [1,4,0]
     * }
     * use .init(1, 2, 3, 4, -2, 6, 1, 4, 0)
     * @param args
     */
    public void init(int... args) throws MatrixDimension.MatrixDimensionOutOfBoundsException {
        if (args.length > this.dim.cols()*this.dim.rows()) {
            throw new MatrixDimension.MatrixDimensionOutOfBoundsException("If you init values make sure to have rows*cols values!");
        }
        int index = 0;
        for (int i = 0; i < this.dim.rows(); i++) {
            for (int j = 0; j < this.dim.cols(); j++) {
                // wenn z.b. nur drei Elemente eingegeben wurden bei einer 3x3 Matrix
                if (index+1 > args.length) {
                    break;
                }
                this.matrix[i][j] = args[index];
                index++;
            }
        }
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
     * Returns a whole row of the matrix as an array of ints with the corresponding values.
     * @param row
     * @return
     */
    public int[] getRow(int row) {
        this.dim.check(row, 1);
        return this.matrix[row-1];
    }

    /**
     * Returns a whole column of the matrix as an array of ints with the corresponding values.
     * @param col
     * @return
     */
    public int[] getCol(int col) {
        this.dim.check(1, col);
        int[] result = new int[this.dim.rows()];
        int i = 0;
        while (i < this.dim.rows()) {
            result[i] = this.matrix[i][col-1];
            i++;
        }
        return result;
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

    /**
     * Adds a row to another one: rowDestination = rowDestination + row.
     * For example: [1,2,3] + [4,5,6] = [1+4, 2+5, 3+6]
     *
     * @param row
     * @param rowDestination
     */
    @Override
    public void addRowToRow(int row, int rowDestination) {
        this.dim.check(row, 1);
        this.dim.check(rowDestination, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination-1][i] += this.matrix[row-1][i];
        }
    }

    /**
     * Subtracts a row to another one: rowDestination = rowDestination - row.
     * For example: [1,2,3] - [4,5,6] = [1-4, 2-5, 3-6]
     *
     * @param row
     * @param rowDestination
     */
    @Override
    public void subRowToRow(int row, int rowDestination) {
        this.dim.check(row, 1);
        this.dim.check(rowDestination, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination-1][i] -= this.matrix[row-1][i];
        }
    }

    /**
     * Multiplies a row to another one: rowDestination = rowDestination * row.
     * For example: [1,2,3] * [4,5,6] = [1*4, 2*5, 3*6]
     *
     * @param row
     * @param rowDestination
     */
    @Override
    public void multRowToRow(int row, int rowDestination) {
        this.dim.check(row, 1);
        this.dim.check(rowDestination, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination-1][i] *= this.matrix[row-1][i];
        }
    }

    /**
     * Divides a row to another one: rowDestination = rowDestination / row.
     * For example: [1,2,3] / [4,5,6] = [1/4, 2/5, 3/6]
     *
     * @param row
     * @param rowDestination
     */
    @Override
    public void divRowToRow(int row, int rowDestination) {
        this.dim.check(row, 1);
        this.dim.check(rowDestination, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination-1][i] /= this.matrix[row-1][i];
        }
    }

    /**
     * Modulo a row to another one: rowDestination = rowDestination * row.
     * For example: [1,2,3] % [4,5,6] = [1%4, 2%5, 3%6]
     *
     * @param row
     * @param rowDestination
     */
    @Override
    public void modRowToRow(int row, int rowDestination) {
        this.dim.check(row, 1);
        this.dim.check(rowDestination, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination-1][i] %= this.matrix[row-1][i];
        }
    }

    /**
     * Adds a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void addToRow(int row, int value) {
        this.dim.check(row, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row-1][i] += value;
        }
    }

    /**
     * Subtracts a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void subToRow(int row, int value) {
        this.dim.check(row, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row-1][i] -= value;
        }
    }

    /**
     * Multiplies a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void multToRow(int row, int value) {
        this.dim.check(row, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row-1][i] *= value;
        }
    }

    /**
     * Divides a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void divToRow(int row, int value) {
        this.dim.check(row, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row-1][i] /= value;
        }
    }

    /**
     * Divides a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void modToRow(int row, int value) {
        this.dim.check(row, 1);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row-1][i] %= value;
        }
    }

    /**
     * Adds a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void addToCol(int col, int value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col-1] += value;
        }
    }

    /**
     * Subtracts a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void subToCol(int col, int value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col-1] -= value;
        }
    }

    /**
     * Adds a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void multToCol(int col, int value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col-1] *= value;
        }
    }

    /**
     * Divides a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void divToCol(int col, int value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col-1] /= value;
        }
    }

    /**
     * Modulo a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void modToCol(int col, int value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col-1] %= value;
        }
    }

    /**
     * Adds a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void add(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] += value;
    }

    /**
     * Subs a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void sub(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] -= value;
    }

    /**
     * Mults a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void mult(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] *= value;
    }

    /**
     * Divs a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void div(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] /= value;
    }

    /**
     * Modulo a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void mod(int col, int row, int value) {
        this.dim.check(col, row);
        this.matrix[row-1][col-1] %= value;
    }

    /**
     * Prints the matrix to the console.
     */
    public void print() {
        int i = 0;
        while (i < dim.rows()) {
            System.out.println(Arrays.toString(this.matrix[i]));
            i++;
        }
    }

    /**
     * Checks if a matrix is invertible alias if determinant != 0
     * @return
     * @throws NonQuadraticMatrixException
     */
    public boolean isInvertable() throws IllegalArgumentException, NonQuadraticMatrixException {
        if (!this.isSquareMatrix()) return false;
        if (this.det() != 0) {
            return true;
        }
        return false;
    }

    /**
     * Calculates the determinant of a matrix.
     * (For now only 0x0 up to 3x3 matrices and any triangular matrix)
     * @return
     */
    public int det() throws NonQuadraticMatrixException {
        if (!isSquareMatrix()) throw new NonQuadraticMatrixException();
        if (dim.rows() == 0) return 0;
        if (dim.rows() == 1) return this.matrix[0][0];
        if (dim.rows() == 2) {
            return matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
        }
        if (dim.rows() == 3) {
            return matrix[0][0]*matrix[1][1]*matrix[2][2]+matrix[0][1]*matrix[1][2]*matrix[2][0]+matrix[0][2]*matrix[1][0]*matrix[2][1]
                    -matrix[2][0]*matrix[1][1]*matrix[0][2]-matrix[2][1]*matrix[1][2]*matrix[0][0]-matrix[2][2]*matrix[1][0]*matrix[0][1];
        }
        else {
            if (this.isTriangularMatrix()) {
                int det = this.matrix[0][0];
                for (int i = 1; i < this.dim.rows(); i++) {
                    det *= this.matrix[i][i];
                }
                return det;
            } else {
                throw new IllegalArgumentException("For now you only can calc the determinant of 2x2 and 3x3 matrices!");
            }
        }
    }

    /**
     * Checks if a matrix is a mxn matrix where m=n
     * @return
     */
    public boolean isSquareMatrix() {
        return dim.rows() == dim.cols();
    }

    /**
     * Checks if a matrix is a diagonal matrix.
     * A diagonal matrix is a triangular matrix,
     * but not all triangular matrices
     * are diagonal matrices.
     * @return
     */
    public boolean isDiagonalMatrix() {
        return this.isUpperTriangularMatrix() && this.isLowerTriangularMatrix();
    }

    /**
     * Checks if a matrix is a triangular matrix.
     * A diagonal matrix is a triangular matrix,
     * but not all triangular matrices
     * are diagonal matrices.
     * @return
     */
    public boolean isTriangularMatrix() {
        return this.isUpperTriangularMatrix() || this.isLowerTriangularMatrix();
    }

    /**
     * Checks if a matrix is a upper triangular matrix.
     * @return
     */
    public boolean isUpperTriangularMatrix() {
        if (!this.isSquareMatrix()) return false;
        for (int i = 0; i < this.dim.rows(); i++) {
            for (int j = i+1; j < this.dim.cols(); j++) {
                if (this.matrix[i][j] != 0) return false;
            }
        }
        return true;
    }

    /**
     * Checks if a matrix is a upper triangular matrix.
     * @return
     */
    public boolean isLowerTriangularMatrix() {
        if (!this.isSquareMatrix()) return false;
        for (int i = 0; i < this.dim.rows(); i++) {
            for (int j = 0; j < i; j++) {
                if (this.matrix[i][j] != 0) return false;
            }
        }
        return true;
    }

    /**
     * (generated by IntelliJ)
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;

        Matrix matrix1 = (Matrix) o;

        if (!dim.equals(matrix1.dim)) return false;
        return Arrays.deepEquals(matrix, matrix1.matrix);

    }

    /**
     * (generated by IntelliJ)
     * @return
     */
    @Override
    public int hashCode() {
        int result = dim.hashCode();
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
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

    /**
     * Compares a matrix to the current one by their dimensions.
     */
    @Override
    public int compareTo(Matrix o) {
        return dim.compareTo(o.dim);
    }


    public class NonQuadraticMatrixException extends Exception {}
}
