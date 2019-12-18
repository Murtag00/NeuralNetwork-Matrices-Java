package main.java.de.phip1611.math.matrices;

/*
 * AUTHOR: PHILIPP SCHUSTER
 *   Web:     https://phip1611.de
 *   Twitter: https://twitter.com/phip1611
 *
 * other project version on GitHub:
 *   https://github.com/phip1611/Matrices-Java
 *
 * License: MIT-License
 *   https://github.com/phip1611/Matrices-Java/blob/master/LICENSE
 *
 * 	Edited by Justin Horn 14.05.2019
 * 
 * 	Edited By Justin Horn
 * 	Email:
 *  ju-horn@web.de
 *  Web:
 *  https://justinhorn.name/
 *  this version on GitHub:
 *  https://github.com/Murtag00/Matrices_with_simple_Neuralnet
 *  
 *  int Arrays -> double
 *  Matrixs .get starts with 0,0 instead of 1,1
 */

/**
 * Represents a Matrix's dimension
 */
public class MatrixDimension implements Comparable<MatrixDimension> {
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
        if (i >= this.i || j >= this.j) {
            throw new MatrixDimensionOutOfBoundsException("Index out of matrix bounds!");
        }
    }



    /**
     * (Generated by IntelliJ)
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatrixDimension)) return false;

        MatrixDimension that = (MatrixDimension) o;

        if (i != that.i) return false;
        return j == that.j;

    }

    /**
     * (Generated by IntelliJ)
     * @return
     */
    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }

    @Override
    public String toString() {
        return "MatrixDimension{"+i+"x"+j+"}";
    }

    /**
     * Compares the sum of the dimensions.
     * @param o
     * @return
     */
    @Override
    public int compareTo(MatrixDimension o) {
        return  i+j-(o.i+o.j);
    }

    public static class MatrixDimensionOutOfBoundsException extends ArrayIndexOutOfBoundsException {
        public MatrixDimensionOutOfBoundsException(String msg) {
            super(msg);
        }
        public MatrixDimensionOutOfBoundsException() {
            super();
        }
    }
}
