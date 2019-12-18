
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
 *  
 */

import java.util.Arrays;

/**
 * A matrix as we know it from mathematics as informatics.
 */
public class Matrix implements BasicMatrixArithmetic, Comparable<Matrix> {
    protected MatrixDimension dim;
    protected double[] [] matrix;
    public Matrix(String dimension) {
        if (dimension.matches("([0-9])+([x])([0-9])+")) {
            int rows, cols;
            String[] split = dimension.split("x");
            rows = Integer.parseInt(split[0]); // value of not needed
            cols = Integer.parseInt(split[1]);

            this.dim = new MatrixDimension(rows, cols);
            this.matrix = new double[dim.rows()][dim.cols()];
        } else {
            throw new IllegalArgumentException("Dimension-String has to match" +
                    " with \"([0-9])+([x])([0-9])+\", for example 3x2, 0x0, 20x7");
        }
    }
    
    public Matrix(int rows, int cols) {
        this.dim = new MatrixDimension(rows, cols);
        this.matrix = new double[dim.rows()][dim.cols()];
    }
    /**
     * clones Matrix 
     * @return this Matrix as a clone
     */
    public Matrix clone() {
    	Matrix m = new Matrix(dim.rows(),dim.cols());
    	for(int i = 0; i < dim.rows();i++) {
    		for(int j = 0; j < dim.cols(); j++) {
    			m.matrix[i][j] = matrix[i][j];
    		}
    	}
		return m;
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
    public void init(double... args) throws MatrixDimension.MatrixDimensionOutOfBoundsException {
        if (args.length > this.dim.cols()*this.dim.rows()) {
            throw new MatrixDimension.MatrixDimensionOutOfBoundsException("If you init values make sure to have rows*cols values!");
        }
        int index = 0;
        for (int i = 0; i < this.dim.rows(); i++) {
            for (int j = 0; j < this.dim.cols(); j++) {
                // wenn z.b. nur drei Elemente eingegeben wurden bei einer 3x3 Matrix
                if (index+1 > args.length) {
                	//System.out.println("args.length:" +  args.length);
                    break;
                }
                this.matrix[i][j] = args[index];
                index++;
            }
        }
    }
    

    
    
    /**
     *´fills the Matrix with a numbers of a random intervall
     *  matrix[i][j] = Math.random()*multiplyer+modifier
     */
    public void randomInit(double multiplyer, double modifier) throws MatrixDimension.MatrixDimensionOutOfBoundsException {
        int index = 0;
        for (int i = 0; i < this.dim.rows(); i++) {
            for (int j = 0; j < this.dim.cols(); j++) {
              
                this.matrix[i][j] = Math.random()*multiplyer+modifier;
            }
        }
    }

    /**
     * Returns the value at the index.
     * @param row
     * @param col
     */
    public double get(int row, int col) {
        this.dim.check(row, col);
        return this.matrix[row][col];
    }

    /**
     * Sets the value at the index.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value) {
        this.dim.check(row, col);
        this.matrix[row][col] = value;
    }

    /**
     * Returns a whole row of the matrix as an array of ints with the corresponding values.
     * @param row
     * @return
     */
    public double[] getRow(int row) {
        this.dim.check(row, 0);
        return this.matrix[row];
    }

    /**
     * Returns a whole column of the matrix as an array of ints with the corresponding values.
     * @param col
     * @return
     */
    public double[] getCol(int col) {
        this.dim.check(0, col);
        double[] result = new double[this.dim.rows()];
        int i = 0;
        while (i < this.dim.rows()) {
            result[i] = this.matrix[i][col];
            i++;
        }
        return result;
    }
    
    /**
     * Set's all fields of the matrix to the value.
     * @param value
     */
    public void sigmoid() {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] = sigmoid(matrix[i][j]);
            }
        }
    }
    
    public static double sigmoid(double x)
    {
        return 1 / (1 + Math.exp(-x));
    }
    
    /**
     * Set's all fields of the matrix to the value.
     * @param value
     */
    public void setAll(double value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] = value;
            }
        }
    }

    @Override
    public void addAll(double value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] += value;
            }
        }
    }

    @Override
    public void subAll(double value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] -= value;
            }
        }
    }

    @Override
    public void multAll(double value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] *= value;
            }
        }
    }

    @Override
    public void divAll(double value) {
        for (int i = 0; i < dim.rows(); i++) {
            for (int j = 0; j < dim.cols(); j++) {
                this.matrix[i][j] /= value;
            }
        }
    }

    @Override
    public void modAll(double value) {
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
        this.dim.check(row, 0);
        this.dim.check(rowDestination, 0);
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
        this.dim.check(row, 0);
        this.dim.check(rowDestination, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination][i] -= this.matrix[row][i];
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
        this.dim.check(row, 0);
        this.dim.check(rowDestination, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination][i] *= this.matrix[row][i];
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
        this.dim.check(row, 0);
        this.dim.check(rowDestination, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination][i] /= this.matrix[row][i];
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
        this.dim.check(row, 0);
        this.dim.check(rowDestination, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[rowDestination][i] %= this.matrix[row][i];
        }
    }

    /**
     * Adds a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void addToRow(int row, double value) {
        this.dim.check(row, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row][i] += value;
        }
    }

    /**
     * Subtracts a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void subToRow(int row, double value) {
        this.dim.check(row, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row][i] -= value;
        }
    }

    /**
     * Multiplies a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void multToRow(int row, double value) {
        this.dim.check(row, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row][i] *= value;
        }
    }

    /**
     * Divides a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void divToRow(int row, double value) {
        this.dim.check(row, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row][i] /= value;
        }
    }

    /**
     * Divides a value to all elements of a row.
     *
     * @param row
     * @param value
     */
    @Override
    public void modToRow(int row, double value) {
        this.dim.check(row, 0);
        for (int i = 0; i < this.dim.cols(); i++) {
            this.matrix[row][i] %= value;
        }
    }

    /**
     * Adds a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void addToCol(int col, double value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col] += value;
        }
    }

    /**
     * Subtracts a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void subToCol(int col, double value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col] -= value;
        }
    }

    /**
     * Adds a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void multToCol(int col, double value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col] *= value;
        }
    }

    /**
     * Divides a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void divToCol(int col, double value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col] /= value;
        }
    }

    /**
     * Modulo a value to all elements of a column.
     *
     * @param col
     * @param value
     */
    @Override
    public void modToCol(int col, double value) {
        this.dim.check(this.dim.rows(),col);
        for (int i = 0; i < this.dim.rows(); i++) {
            this.matrix[i][col] %= value;
        }
    }

    /**
     * Adds a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void add(int col, int row, double value) {
        this.dim.check(col, row);
        this.matrix[row][col] += value;
    }

    /**
     * Subs a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void sub(int col, int row, double value) {
        this.dim.check(col, row);
        this.matrix[row][col] -= value;
    }

    /**
     * Mults a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void mult(int col, int row, double value) {
        this.dim.check(col, row);
        this.matrix[row][col] *= value;
    }

    /**
     * Divs a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void div(int col, int row, double value) {
        this.dim.check(col, row);
        this.matrix[row][col] /= value;
    }

    /**
     * Modulo a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    @Override
    public void mod(int col, int row, double value) {
        this.dim.check(col, row);
        this.matrix[row][col] %= value;
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
     * writes Matrix a way suitable fo
     * @return
     */
    public String toFile() {
    	StringBuilder a = new StringBuilder();
    	int r = this.dim.rows();
    	int c = this.dim.cols();
    	 for (int i = 0; i < r; i++) {
        	 for (int j = 0; j < c; j++) {
        		 if(i < r-1 || j < c-1) { // damit man das Splitten splitten kann
        			 a.append(this.matrix[i][j]+" ");
        		 } else {
        			 a.append(this.matrix[i][j]);
        		 }
        	}
         }
    	 return a.toString();
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
    public double det() throws NonQuadraticMatrixException {
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
            	double det = this.matrix[0][0];
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
    	StringBuilder a = new StringBuilder();
    	for(int i = 0; i < matrix.length;i++) { //cols
    		a.append("( ");
    		for(int j = 0; j < matrix[i].length;j++) {//rows
    			a.append(String.format(" %2.3f ",matrix[i][j]));
    		}
    		a.append(" )"+System.lineSeparator());
    	}
        return a.toString();
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
