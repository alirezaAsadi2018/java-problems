package ir.javacup.matrix;

public class Matrix {
    private int row;
    private int column;
    private int[][] elements;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        elements = new int[row][column];
    }

    public Matrix(int length) {
        this.row = length;
        this.column = length;
        elements = new int[length][length];
    }

    public Matrix(int[][] elements) {
        row = elements.length;
        column = elements[0].length;
        this.elements = elements;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getElements() {
        return elements;
    }

    public boolean add(Matrix newMatrix) {
        if (newMatrix.row != row || newMatrix.column != column)
            return false;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                setElement(i, j, newMatrix.elements[i][j] + elements[i][j]);
            }
        }
        return true;
    }

    public void setElement(int i, int j, int value) {
        elements[i][j] = value;
    }

    public boolean isSquareMatrix() {
        if (row == column)
            return true;
        return false;
    }

    public void toLowerTriangular() {
        if (isSquareMatrix()) {
            for (int i = 0; i < row; ++i) {
                for (int j = i + 1; j < column; ++j) {
                    setElement(i, j, 0);
                }
            }
        }
    }

    public void toUpperTriangular() {
        if (isSquareMatrix()) {
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < i; ++j) {
                    setElement(i, j, 0);
                }
            }
        }
    }

}
