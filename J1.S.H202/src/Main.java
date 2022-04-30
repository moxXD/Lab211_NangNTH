/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author ducle
 */
public class Main {
    public static void main(String[] args) {
        // promt ask user to input a string
        String input = inputString();
        // reverse and print out the output
        printReverse(input);
    }
    /* function to ask for user input a String*/
    public static String inputString() {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        input = sc.nextLine();
        return input;
    }
    /* function to reverse and print out string
       param String input*/
    public static void printReverse(String input) {
        input.trim();
        StringBuilder builder=new StringBuilder();
        // if string is empty do notthing
        if (input.isEmpty()) {
        } 
        else {
            // append string into stringbuilder
            builder.append(input);
            // print reverse string
            System.out.println(builder.reverse().toString());
        }
    }
}
