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

import javax.naming.OperationNotSupportedException;

/**
 * A class with a private constructor that
 * offers basic static operations on matrices similar
 * to the class Collections
 */
public class VectorUtils {
    /**
     * Dot product (scalar product) of a vector.
     * (Due to I'm not an expert in math I only can ensure you
     * that this implementation get's you the right results
     * for 3x1 vectors!
     */
    public static int dotProduct(Vector v1, Vector v2) {
        int result = 0;
        for (int i = 1; i <= v1.getRowCount(); i++) {
            result += v1.get(i)*v2.get(i);
        }
        return result;
    }

    /**
     * Cross product (vector product) of two vectors.
     * (3x1-Matrix only)
     * @param v1
     * @param v2
     * @return
     */
    public static Vector crossProduct(Vector v1, Vector v2) throws OperationNotSupportedException {
        if (v1.getRowCount() == 3 && 3 == v2.getRowCount()) {
            Vector product = new Vector(3);
            int x1, x2, x3;
            x1 = v1.get(2)*v2.get(3)-v1.get(3)*v2.get(2);
            x2 = v1.get(3)*v2.get(1)-v1.get(1)*v2.get(3);
            x3 = v1.get(1)*v2.get(2)-v1.get(2)*v2.get(1);
            product.init(x1,x2,x3);
            return product;
        } else {
            throw new OperationNotSupportedException("Cross product only works for 3x1 vectors");
        }
    }

    /**
     * Checks if two vectors are orthogonally by checking
     * if the dot product is zero.
     * @param v1
     * @param v2
     * @return
     */
    public static boolean areOrthogonally(Vector v1, Vector v2) {
        return VectorUtils.dotProduct(v1,v2) == 0;
    }
}
