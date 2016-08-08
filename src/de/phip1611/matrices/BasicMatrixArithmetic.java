package de.phip1611.matrices;

/**
 * Arithmetic withing the matrix, not between matrices.
 */
public interface BasicMatrixArithmetic {
    /**
     * Adds a value to all elements of the matrix.
     * @param value
     */
    void addAll(int value);

    /**
     * Subtracts all elements of the matrix by the value.
     * @param value
     */
    void subAll(int value);

    /**
     * Multiply all elements of the matrix by the value.
     * @param value
     */
    void multAll(int value);

    /**
     * Divides all elements of the matrix by the value.
     * @param value
     */
    void divAll(int value);

    /**
     * Modulo all elements of the matrix by the value.
     * @param value
     */
    void modAll(int value);

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
    void addToRow(int row, int value);

    /**
     * Subtracts a value to all elements of a row.
     * @param row
     * @param value
     */
    void subToRow(int row, int value);

    /**
     * Multiplies a value to all elements of a row.
     * @param row
     * @param value
     */
    void multToRow(int row, int value);

    /**
     * Divides a value to all elements of a row.
     * @param row
     * @param value
     */
    void divToRow(int row, int value);

    /**
     * Divides a value to all elements of a row.
     * @param row
     * @param value
     */
    void modToRow(int row, int value);

    /**
     * Adds a value to all elements of a column.
     * @param col
     * @param value
     */
    void addToCol(int col, int value);

    /**
     * Subtracts a value to all elements of a column.
     * @param col
     * @param value
     */
    void subToCol(int col, int value);

    /**
     * Adds a value to all elements of a column.
     * @param col
     * @param value
     */
    void multToCol(int col, int value);

    /**
     * Divides a value to all elements of a column.
     * @param col
     * @param value
     */
    void divToCol(int col, int value);

    /**
     * Modulo a value to all elements of a column.
     * @param col
     * @param value
     */
    void modToCol(int col, int value);

    /**
     * Adds a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void add(int col, int row, int value);

    /**
     * Subtracts a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void sub(int col, int row, int value);

    /**
     * Multiplies a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void mult(int col, int row, int value);

    /**
     * Divides a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void div(int col, int row, int value);

    /**
     * Modulo a value to a cell of the matrix.
     * @param col
     * @param row
     * @param value
     */
    void mod(int col, int row, int value);
}
