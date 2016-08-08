package de.phip1611.matrices;

/**
 * A vector is a matrix with 1 column and n rows.
 */
public class Vector extends Matrix {
    public Vector(int rows) {
        super(rows, 1);
    }

    /**
     * Returns the value at the index.
     * @param row
     */
    public int get(int row) {
        this.dim.check(row, 1);
        return this.matrix[row-1][0];
    }

    /**
     * Sets the value at the index.
     * @param row
     */
    public void set(int row, int value) {
        this.dim.check(row, 1);
        this.matrix[row-1][0] = value;
    }
}
