

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
    Scanner sc = new Scanner(System.in);

    public int getChoice(String msg, int min, int max) {
        int choice = 0;
        String input = "";
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Choice could not be empty. Please enter again!");
            } else {
                try {
                    choice = Integer.parseInt(input);
                    //choice must be in range min to max
                    if (choice >= min && choice <= max) {
                        break;
                    } else {
                        System.out.println("Choice must be in range from " + min + " to " + max);
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Choice must be positive integer number");
                }
            }
        } while (true);
        return choice;
    }
    public String getString(){
        String input;
        input=sc.nextLine();
        return input;
    }
}
