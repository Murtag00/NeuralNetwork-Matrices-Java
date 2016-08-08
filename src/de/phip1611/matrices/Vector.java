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

    /**
     * Returns the magnitude/length of a vector.
     * l = sqrt(x1^2 + ... +xn^2)
     * @return
     */
    public double magnitude() {
        double result = 0;
        for (int i = 0; i < this.dim.rows(); i++) {
            result += this.matrix[i][0]*this.matrix[i][0];
        }
        return Math.pow(result, 0.5d);
    }

    @Override
    public String toString() {
        return String.format("Vector{%dx1}",this.dim.rows());
    }

    /**
     * Compares a matrix to the current one by their dimensions.
     *
     * @param o
     */
    @Override
    public int compareTo(Matrix o) {
        if (this.getRowCount() != o.getRowCount()) {
            return super.compareTo(o);
        } else {
            // similar vectors are compared by their length
            return (int)(this.magnitude() - ((Vector)o).magnitude());
        }
    }
}
