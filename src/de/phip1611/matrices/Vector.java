package de.phip1611.matrices;

/**
 * A vector is a matrix with 1 column and n rows.
 */
public class Vector extends Matrix {
    public Vector(int rows) {
        super(rows, 1);
    }
}
