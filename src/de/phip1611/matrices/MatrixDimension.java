package de.phip1611.matrices;

/**
 * Represents a Matrix dimension
 */
public class MatrixDimension {
    private int i = 0; // rows count
    private int j = 0; // cols count
    public MatrixDimension(int i, int j) {
        if (i < 0 || j < 0) {
            throw new MatrixDimensionOutOfBoundsException("A Matrix dimension can't be negative!");
        }
        this.i = i;
        this.j = j;
    }
    public int rows() {
        return i;
    }
    public int cols() {
        return j;
    }
    public void check(int i, int j) {
        if (i < 0 || j < 0) {
            throw new MatrixDimensionOutOfBoundsException("Can't access negative index of matrix.");
        }
        if (i > this.i || j > this.j) {
            throw new MatrixDimensionOutOfBoundsException("Index out of matrix bounds!");
        }
    }

    @Override
    public String toString() {
        return "MatrixDimension{"+i+"x"+j+"}";
    }

    public class MatrixDimensionOutOfBoundsException extends ArrayIndexOutOfBoundsException {
        public MatrixDimensionOutOfBoundsException(String msg) {
            super(msg);
        }
        public MatrixDimensionOutOfBoundsException() {
            super();
        }
    }
}
