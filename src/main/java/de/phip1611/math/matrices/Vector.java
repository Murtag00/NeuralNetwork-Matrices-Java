
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

/**
 * A vector is a matrix with 1 column and n rows.
 */
public class Vector extends Matrix {
    public Vector(int rows) {
        super(rows, 1);
    }

    public void arrayInit(double[] values) {
    	int l = this.matrix.length;
    	for(int i = 0; i < l; i++) {
    		this.matrix[i][0] = values[i];
    	}
    }
    /**
     * Returns largest index.
     * @return Index of element with the largest number
     */
    public int largestIndex() {
    	double a = Double.MIN_VALUE;
    	int b = -1;
    	for(int i = 0; i < matrix.length;i++) {
    		if(matrix[i][0] > a) {
    			a = matrix[i][0];
    			b = i;
    		}
    	}
    	return b;
    }
    /**
     * Useful for NeuralNetworks if you want to exclude certain values from beeing taken into
     * consideration.
     * @param include
     * @return largest index that was not excluded
     */
    public int largestIndex(boolean[] include) {
    	if(include.length != matrix.length) {
    		throw new IllegalArgumentException("Vektoren und boolean[] include sind unterschiedlich lang! Vektor:"+this.dim.rows()+" der Andere:"+include.length);
    	}
    	double a = Double.MIN_VALUE;
    	int b = -1;
    	for(int i = 0; i < matrix.length;i++) {
    		if(matrix[i][0] > a && include[i]) {
    			a = matrix[i][0];
    			b = i;
    		}
    	}
    	return b;
    }
    
    public Vector clone() {
    	Vector m = new Vector(dim.rows());
    	for(int i = 0; i < dim.rows();i++) {
    		for(int j = 0; j < dim.cols(); j++) {
    			m.matrix[i][j] = matrix[i][j];
    		}
    	}
		return m;
    }
    
    /**
     * Returns the value at the index.
     * @param row
     */
    public double get(int row) {
        this.dim.check(row, 0);
        return this.matrix[row][0];
    }

    /**
     * (a) (d)		(ad)
     * (b)*(e) == 	(be)
     * (c) (f)		(cf)
     * @param v
     * @return Vektorn which is the direkt Multiplakation of this vektor and v
     */
    public Vector multiVector(Vector v) {
    	if(v.dim.rows() == this.dim.rows()) {
    		Vector d = new Vector(this.dim.rows());
    		for(int i = 0; i < dim.rows();i++) {
    			d.set(i, v.get(i) * this.get(i));
    		}
        	return d;
    	} else {
    		throw new IllegalArgumentException("Vektoren sind aus unterschiedlichen Dimensionen: dieser Vektor:"+this.dim.rows()+" der Andere:"+v.dim.rows());
    	}
    }
    
    /**
     * Sets the value at the index.
     * @param row
     */
    public void set(int row, double value) {
        this.dim.check(row, 0);
        this.matrix[row][0] = value;
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
