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

/**
 * the identity matrix, or sometimes ambiguously called a unit matrix,
 * of size n is the n × n square matrix with ones on the main diagonal and zeros elsewhere
 */
public class IdentityMatrix extends Matrix {

    public IdentityMatrix(int dimension) {
        super(dimension, dimension);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][i] = 1;
        }
    }

    /**
     * No effect for Identity matrices
     */
    @Override
    public void add(int col, int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void sub(int col, int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void mult(int col, int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void div(int col, int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void mod(int col, int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void addAll(int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void subAll(int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void multAll(int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void divAll(int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void modAll(int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void addToRow(int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void subToRow(int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void multToRow(int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void divToRow(int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void modToRow(int row, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void addToCol(int col, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void subToCol(int col, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void multToCol(int col, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void divToCol(int col, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void modToCol(int col, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void set(int row, int col, int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void setAll(int value) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void addRowToRow(int row, int rowDestination) {}

    /**
     * No effect for Identity matrices
     */
    @Override
    public void init(int... args) {}
}
