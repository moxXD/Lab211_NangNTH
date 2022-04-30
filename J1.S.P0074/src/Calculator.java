/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducle
 */
public class Calculator {
    // method to add 2 matrix
    // param matrix1; matrix 2
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2){
        int row=matrix1.length;
        int column=matrix1[0].length;
        int[][] result=new int[row][column];
        // Traverse each element of row
        for (int i = 0; i < row; i++) {
            // Traverse each element of column
            for (int j = 0; j < column; j++) {
                result[i][j]=matrix1[i][j]+matrix2[i][j];
            }          
        }
        return result;
    }
//    1   2       5   6
//    3   4       7   8
    // method to subtraction 2 matrix
    // param matrix1; matrix 2
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2){
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] result = new int[row][column];
        // Traverse each element of row
        for (int i = 0; i < row; i++) {
            // Traverse each element of column
            for (int j = 0; j < column; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    // method to multipli 2 matrix
    // param matrix1; matrix 2
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2){
        int row = matrix1.length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row][col2];
        // Traverse each element of row of matrix 1
        for (int i = 0; i < row; i++) {
            //Traverse each element of column of matrix 2
            for (int j = 0; j < col2; j++) {
                // Traverse each element of row of matrix 2
                for (int k = 0; k < row2; k++) {
                    result[i][j]=result[i][j]+matrix1[i][k]*matrix2[k][j];
                    
                }
            }
        }
        return result;
    }
//    1   2   3           7   8
//    4   5   6           9   10
//                        11  12 
}
