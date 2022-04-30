/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author ducle
 */
public class GetData {
    Scanner sc=new Scanner(System.in);
    // method to get user input integer
    // param msg; err; min; max
    public int getInt(String msg, String err,int min,int max){
        String input;
        int output;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println(err);
            }
            try {
                output = Integer.parseInt(input);
                // check if input is out of range
                if (output <= min && output >= max) {
                    System.out.println("Input is out of range"+min+" to"+max);
                } else {
                    break;
                }
                // catch if user input a string or char
            } catch (NumberFormatException e) {
                System.out.println(" user input must be an integer");
            }
        } while (true);
        return output;
    }
    // method to get user input element in matrix
    // param msg
    public int getMatrix(String msg) {
        String input;
        int output;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            // check if user input is empty
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty!");
            } else {
                try {
                    output = Integer.parseInt(input);
                    break;
                     // catch if user input a string or char
                }catch(NumberFormatException numex){
                    System.out.println("Value of matrix is digit");
                }
            }
        }while(true);
    return output;
    }
}
