/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultility;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author ducle
 */
public class getData {
    Scanner sc = new Scanner(System.in);
//    Function to get user String input,validate input if input is empty 
//    or input is wrong format
//    param msg; param outRangeMsg; param min; param max
    public int getInt(String msg, String outRangeMsg, int min, int max) {
        String input;
        int result;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
            } else {
                try {
                    result = Integer.parseInt(input);
                    //check choice in range min and max
                    if (result >= min && result <= max) {
                        break;
                    } else {
                        System.out.println(outRangeMsg);
                    }
                    // return if user input a string or character
                } catch (NumberFormatException ex) {
                    System.out.println("Input must be integer");
                }
            }
        } while (true);
        return result;
    }
//    function to get user String input, check if user input could be empty 
//    or match, unmatch regex format
//    param msg; param formatMsg; param regex
    public String getString(String msg, String formatMsg, String regex) {
        String input;
        // loop to input and validate input
        do {
            System.out.print(msg);
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
            } else {
                // if user doesn't input regex format break the loop
                if (regex.isEmpty()) {
                    break;
                    //compare input with regex
                } else if (input.matches(regex)) {
                    break;
                } else {
                    System.out.println(formatMsg);
                }
            }
        } while (true);
        return input;
    }
//    function to get user input Date,validate input Date
//    param msg
    public String getDate(String msg) {
        String input;
        Date date;
        String resultDate;
        // loop to get user input and validate
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            //check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            }// check if input match regex format
            // \d{1,2}: the number have 1 or 2 digit number
            //[-]: contain character -
            //\d{4}: the number must have 4 digit
            else if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                System.out.println("Input must follow dd-MM-yyy");
                continue;
            }
            // check if date is in the past
            try {
                date = dateFormat.parse(input);
                Date now = new Date();
                //check date must be before now
                if (date.before(now)) {
                    System.out.println("Date could not be the past. Please enter again!");
                    continue;
                }
                break;
                // check if date exist
            } catch (ParseException exception) {
                System.out.println("Date doesn't existed!!");
            }
        } while (true);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        resultDate = dateFormat.format(date);
        return resultDate;
    }
//    function to get user double input, validate user input
//    param msg; param outRangeMsg; param min; param max
    public double getDouble(String msg, String outRangeMsg, double min, double max) {
        double result;
        String input;
        // get user input and validate
        do {// get user string input
            //\d: accept input be a digit from 0-9
            //\.: after digit is a dot
            //([5]|[0])): after a dot just accpet digit 5 or 0
            input = getString(msg, "Input just accept x.0 or x.5 number", "^(\\d+\\.([5]|[0]))$");
            // check user input is empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!");
            } else {
                try {
                    result = Double.parseDouble(input);
                    //check choice in range min and max
                    if (result >= min && result <= max) {
                        break;
                    } else {
                        System.out.println(outRangeMsg);
                    } 
                } catch (NumberFormatException ex) {
                    System.out.println("Input could be a real number!");
                }
            }
        } while (true);
        return result;
    }
}
