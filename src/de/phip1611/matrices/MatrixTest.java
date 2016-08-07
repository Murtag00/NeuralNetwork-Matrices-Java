package de.phip1611.matrices;

public class MatrixTest {
    /*
    * TODO!!!!
    * */

    /*private Matrix matrix;

    @Before
    public void setUp() {
        this.matrix = new Matrix(3,3);
    }

    @Test
    public void general1() throws Exception {
        assertEquals("Should have 3 Rows!", 3, this.matrix.getRowsCount());
        assertEquals("Should have 3 Cols!", 3, this.matrix.getColsCount());
    }

    @Test
    public void general2() throws Exception {
        this.matrix.setValue(1, 1, 3);
        this.matrix.setValue(2, 2, 6);
        this.matrix.setValue(3, 3, 9);
        assertEquals("Value at (1,1) should be 3 but it isn't!", 3, this.matrix.getValue(1,1));
        assertEquals("Value at (2,2) should be 6 but it isn't!", 6, this.matrix.getValue(2,2));
        assertEquals("Value at (3,3) should be 9 but it isn't!", 9, this.matrix.getValue(3,3));
    }

    @Test(expected=IllegalArgumentException.class)
    public void arithmetic1() {
        this.matrix.setValue(1, 1, 3);
        this.matrix.setValue(2, 2, 6);
        this.matrix.setValue(3, 3, 9);
        Matrix m = new Matrix(2,2);
        this.matrix.add(m);
    }

    @Test
    public void arithmetic2() {
        this.matrix.setValue(1, 1, 3);
        this.matrix.setValue(2, 2, 6);
        this.matrix.setValue(3, 3, 9);
        Matrix m = new Matrix(3,3);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                m.setValue(i, j, 7);
            }
        }
        this.matrix.add(m);
        assertEquals("Value at (1,1) should be -4 but it isn't!", 10, this.matrix.getValue(1,1));
        assertEquals("Value at (1,2) should be 6 but it isn't!", 7, this.matrix.getValue(1,2));
        assertEquals("Value at (1,3) should be 9 but it isn't!", 7, this.matrix.getValue(1,3));
        assertEquals("Value at (2,1) should be 3 but it isn't!", 7, this.matrix.getValue(2,1));
        assertEquals("Value at (2,2) should be 6 but it isn't!", 13, this.matrix.getValue(2,2));
        assertEquals("Value at (2,3) should be 9 but it isn't!", 7, this.matrix.getValue(2,3));
        assertEquals("Value at (3,1) should be 3 but it isn't!", 7, this.matrix.getValue(3,1));
        assertEquals("Value at (3,2) should be 6 but it isn't!", 7, this.matrix.getValue(3,2));
        assertEquals("Value at (3,3) should be 9 but it isn't!", 16, this.matrix.getValue(3,3));
    }
*/
}
