/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducle
 */
public class Main {
    public static void main(String[] args) {
        Manager manager=new Manager();
        GetData getdata=new GetData();
        Calculator calculator=new Calculator();
        do {
            // display menu
            manager.displayMenu();
            // get user choice
            int choice = getdata.getInt("Enter choice: ", "Invalid input", 1, 4);
            switch (choice) {
                // addition of 2 matrix
                case 1:
                    // display addition anouncement
                    manager.displayAddition();
                    // get matrix 1
                    int[][] matrix1=manager.getMatrix1();   
                    // get matrix 2
                    int[][] matrix2=manager.getmatrix2(matrix1, choice);
                    // adding matrix 1 and 2
                    int[][] result=calculator.additionMatrix(matrix1, matrix2);
                    // display adding result
                    manager.displayResult(matrix1, matrix2, result, choice);
                    break;
                // subtraction of 2 matrix
                case 2:
                    // display subtraction anouncement
                    manager.displaySubtraction();
                    // get matrix 1
                    matrix1=manager.getMatrix1();
                    // get matrix 2
                    matrix2=manager.getmatrix2(matrix1, choice);
                    // subtract matrix 1 and 2
                    result=calculator.subtractionMatrix(matrix1, matrix2);
                    // display subtraction result
                    manager.displayResult(matrix1, matrix2, result, choice);
                    break;
                // multiplication of 2 matrix    
                case 3:
                    // display miltipli anouncement
                    manager.displayMultiplication();
                    // get matrix 1
                    matrix1=manager.getMatrix1(); 
                    // get matrix 2
                    matrix2=manager.getmatrix2(matrix1, choice);
                    // multipli 2 matrix
                    result=calculator.multiplicationMatrix(matrix1, matrix2);
                    // display multiplication result
                    manager.displayResult(matrix1, matrix2, result, choice);
                    break;
                // exit the program    
                case 4:
                    System.exit(0);
            }
        }while(true);
    }
}
