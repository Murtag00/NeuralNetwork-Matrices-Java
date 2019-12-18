
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
 *
 * 	Edited By Justin Horn
 * 	Email:
 *  ju-horn@web.de
 *  Web:
 *  https://justinhorn.name/
 *  GiHub:
 *  https://github.com/Murtag00/Matrices_with_simple_Neuralnet
 *  
 */

/**
 * Arithmetic withing the matrix, not between matrices.
 */
public interface BasicMatrixArithmetic {
    /**
     * Adds a value to all elements of the matrix.
     * @param value
     */
    void addAll(double value);

    /**
     * Subtracts all elements of the matrix by the value.
     * @param value
     */
    void subAll(double value);

    /**
     * Multiply all elements of the matrix by the value.
     * @param value
     */
    void multAll(double value);

    /**
     * Divides all elements of the matrix by the value.
     * @param value
     */
    void divAll(double value);

    /**
     * Modulo all elements of the matrix by the value.
     * @param value
     */
    void modAll(double value);

    /**
     * Adds a row to another one: rowDestination = rowDestination + row.
     * For example: [1,2,3] + [4,5,6] = [1+4, 2+5, 3+6]
     * @param row
     * @param rowDestination
     */
    void addRowToRow(int row, int rowDestination);

    /**
     * Subtracts a row to another one: rowDestination = rowDestination - row.
     * For example: [1,2,3] - [4,5,6] = [1-4, 2-5, 3-6]
     * @param row
     * @param rowDestination
     */
    void subRowToRow(int row, int rowDestination);

    /**
     * Multiplies a row to another one: rowDestination = rowDestination * row.
     * For example: [1,2,3] * [4,5,6] = [1*4, 2*5, 3*6]
     * @param row
     * @param rowDestination
     */
    void multRowToRow(int row, int rowDestination);

    /**
     * Divides a row to another one: rowDestination = rowDestination / row.
     * For example: [1,2,3] / [4,5,6] = [1/4, 2/5, 3/6]
     * @param row
     * @param rowDestination
     */
    void divRowToRow(int row, int rowDestination);

    /**
     * Modulo a row to another one: rowDestination = rowDestination * row.
     * For example: [1,2,3] % [4,5,6] = [1%4, 2%5, 3%6]
     * @param row
     * @param rowDestination
     */
    void modRowToRow(int row, int rowDestination);

    /**
     * Adds a value to all elements of a row.
     * @param row
     * @param value
     */
    void addToRow(int row, double value);

    /**
     * Subtracts a value to all elements of a row.
     * @param row
     * @param value
     */
    void subToRow(int row, double value);

    /**
     * Multiplies a value to all elements of a row.
     * @param row
     * @param value
     */
    void multToRow(int row, double value);

    /**
     * Divides a value to all elements of a row.
     * @param row
     * @param value
     */
    void divToRow(int row, double value);

    /**
     * Divides a value to all elements of a row.
     * @param row
     * @param value
     */
    void modToRow(int row, double value);

    /**
     * Adds a value to all elements of a column.
     * @param col
     * @param value
     */
    void addToCol(int col, double value);

    /**
     * Subtracts a value to all elements of a column.
     * @param col
     * @param value
     */
    void subToCol(int col, double value);

    /**
     * Adds a value to all elements of a column.
     * @param col
     * @param value
     */
    void multToCol(int col, double value);

    /**
     * Divides a value to all elements of a column.
     * @param col
     * @param value
     */
    void divToCol(int col, double value);

    /**
     * Modulo a value to all elements of a column.
     * @param col
     * @param value
     */
    void modToCol(int col, double value);

    /**
     * Adds a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void add(int col, int row, double value);

    /**
     * Subtracts a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void sub(int col, int row, double value);

    /**
     * Multiplies a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void mult(int col, int row, double value);

    /**
     * Divides a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void div(int col, int row, double value);

    /**
     * Modulo a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void mod(int col, int row, double value);
}
