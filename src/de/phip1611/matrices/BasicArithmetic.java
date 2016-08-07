package de.phip1611.matrices;

/**
 * Arithmetic withing the matrix, not between matrices.
 */
public interface BasicArithmetic {
    void addAll(int value);
    void subAll(int value);
    void multAll(int value);
    void divAll(int value);
    void modAll(int value);
    void add(int col, int row, int value);
    void sub(int col, int row, int value);
    void mult(int col, int row, int value);
    void div(int col, int row, int value);
    void mod(int col, int row, int value);
}
