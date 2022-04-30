/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducle
 */
public class Manager {

    GetData getData = new GetData();

    // method to display program menu
    public void displayMenu() {
        System.out.println("=====Calculator program====");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    // method to display matrix
    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // Traverse each element of row
        for (int i = 0; i < row; i++) {
            // Traverse each element of column
            for (int j = 0; j < column; j++) {
                System.out.format("[%d]", matrix[i][j]);
            }
            System.out.println();// change line after 1 row end
        }
    }

    // method to get matrix1
    public int[][] getMatrix1() {
        int row, column;
        int[][] matrix;
        do {
            row = getData.getInt("Enter Row Matrix 1:", "Input Invalid, please re-Enter", 1, Integer.MAX_VALUE);
            column = getData.getInt("Enter Column Matrix 1:", "Input Invalid, please re-Enter", 1, Integer.MAX_VALUE);
            try {
                matrix = new int[row][column];
                break;
                //catch javalang out of memory error
            } catch (OutOfMemoryError e) {
                System.out.println("Number user input is too big ,please re-Enter");
            }
        } while (true);
        // add data to matrix
        // Traverse each element of row
        for (int i = 0; i < row; i++) {
            // Traverse each element of column
            for (int j = 0; j < column; j++) {
                String msg = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix[i][j] = getData.getMatrix(msg);
            }
        }
        return matrix;
    }

    // method to get matrix 2
    // param matrix1; choice
    public int[][] getmatrix2(int[][] matrix, int choice) {
        int[][] matrix2;
        int row = matrix.length;
        int column = matrix[0].length;
        int row2, column2;
        if (choice == 3) {// get row and column for multiplication with condition column==row2
            do {
                row2 = getData.getInt("Enter Row Matrix 2:", "Input Invalid, please re-Enter", 1, Integer.MAX_VALUE);
                try {
                    if (column != row2) {
                        System.out.println("Row of matrix 2 need to be equal to Column of matrix 1");
                        continue;
                    }
                    column2 = getData.getInt("Enter Column Matrix 2:", "Input Invalid, please re-Enter", 1, Integer.MAX_VALUE);
                    matrix2 = new int[row2][column2];
                    break;
                    //catch javalang out of memory error
                } catch (OutOfMemoryError e) {
                    System.out.println("Number user input is too big ,please re-Enter");
                }
            } while (true);
        } else {// get row and column for addition and subtraction of matrix (row==row2; column==column2)
            do {
                row2 = getData.getInt("Enter Row Matrix 2:", "Input Invalid, please re-Enter", 1, Integer.MAX_VALUE);
                if (row2 != row) {
                    System.out.println("Row of matrix 2 need to be equals to matrix 1");
                    continue;
                }
                break;
            } while (true);
            do {
                column2 = getData.getInt("Enter Column Matrix 2:", "Input Invalid, please re-Enter", 1, Integer.MAX_VALUE);
                if (column2 != column) {
                    System.out.println("Column of matrix 2 need to be equal to matrix 1");
                    continue;
                }
                break;
            } while (true);
            matrix2 = new int[row2][column2];
        }
        // add data to the matrix
        // Traverse each element of row
        for (int i = 0; i < row2; i++) {
            // Traverse each element of column
            for (int j = 0; j < column2; j++) {
                String msg = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix2[i][j] = getData.getMatrix(msg);
            }
        }
        return matrix2;
    }
    // method to display calculating result 
    // param matrix1; matrix2; result; choice
    public void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int choice) {
        System.out.println("------- Result ----------");
        displayMatrix(matrix1);
        switch (choice) {
            // display "+" for addition of matrix
            case 1:
                System.out.println("+");
                break;
            // display "-" for subtraction of matrix    
            case 2:
                System.out.println("-");
                break;
            // display "*" for multiplication of matrix    
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }
    // method to display addition anouncement
    public void displayAddition() {
        System.out.println("--------- Addition ------------");
    }
    // method to display subtraction anouncement
    public void displaySubtraction() {
        System.out.println("--------- Subtraction ------------");
    }
    // method to display multiplication anouncement
    public void displayMultiplication() {
        System.out.println("--------- Multiplication ------------");
    }
}
