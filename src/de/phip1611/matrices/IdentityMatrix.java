package de.phip1611.matrices;

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
}
