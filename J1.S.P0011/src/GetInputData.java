
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducle
 */
public class GetInputData {
    Scanner sc = new Scanner(System.in);
    // function to get user base choice
    public int getBase(String mess, int min, int max, int baseIn) {
        int choice;
        int base = -1;
        String input;
        // validate base choice of user
        do {
            System.out.print(mess);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Choice could not be empty");
            } else {
                try {
                    choice = Integer.parseInt(input);
                    //Compare variable choice with value min and max
                    if (choice >= min && choice <= max) {
                        switch (choice) {
                            case 1:
                                base = 2;
                                break;
                            case 2:
                                base = 10;
                                break;
                            case 3:
                                base = 16;
                                break;
                            case 4:
                                System.exit(0);
                        }
                        //Check value of variable baseIn with base choose by user
                        if (baseIn == base) {
                            System.out.println("Base output could not same base input");
                        } else {
                            return base;
                        }
                    } else {
                        System.out.println("Choice must be in range " + min + " to " + max);
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Choice must be Integer");
                }
            }
        } while (true);
    }
    // function to get user number input
    public String getInput(String mess, int baseInput) {
        String input;
        String regexBase = "";
        // format of user input using regex
        switch (baseInput) {
            case 2:
                //accept input is digit is 0 or 1 unlimited length
                regexBase = "^[0-1]+$";
                break;
            case 10:
                //accept input is digit from 0 to 9 unlimited length
                regexBase = "^[0-9]+$";
                break;
            case 16:
                //accept input is a to z both Uppercase or Lowercase 
                //and digit from 0 to 9
                regexBase = "^[a-fA-F0-9]+$";
                break;
        }
        // validate input number
        do {
            System.out.print(mess);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input value could not be empty");
            } else {
                //check variable 'input' format by regex
                if (input.matches(regexBase)) {
                    return input.toUpperCase();
                } else {
                    System.out.println("Input is wrong format of base " + baseInput);
                }
            }
        } while (true);
    }
}
