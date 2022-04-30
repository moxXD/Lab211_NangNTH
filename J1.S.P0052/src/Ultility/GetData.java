/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultility;

import java.util.Scanner;

/**
 *
 * @author ducle
 */
public class GetData {
    // method to get user string input
    public String getString(String mess) {
        String str = "";
        System.out.print(mess);
        while (true) {
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();
            //check if input is empty
            if (str.isEmpty()) {
                System.out.println("Can not null, please input again: ");
            } else {
                break;
            }
        }
        return str;
    }
    // method to get user area input
    public float getArea(String mess) {
        float area = 0;
        String input="";
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(mess);
            input=sc.nextLine();
            //check if input is empty
            if(input.isEmpty()){
                System.out.println("Input cannot be empty");
            }else{
            try{                
                area=Float.parseFloat(input);
                // check if area is >0
                if(area<=0){
                    System.out.println("Area can't be smaller than 0");
                }else break;
            }catch(Exception e){
                System.out.println("Input invalid, please input again!!!");
            }}
        }while(true);       
        return area;
    }
    // get user input choice
    public int getChoice(String mess, int min, int max) {
        String input;
        int result;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(mess);
            input = sc.nextLine();
            // check is user input is empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty");
            }
            try {
                result = Integer.parseInt(input);
                // check if user input is in range min and max
                if (result <= max && result >= min) {
                    break;
                } else {
                    System.out.println("Input out of range");
                }
            } catch (Exception e) {
                System.out.print("Invalid int, please input again: ");
            }
        }while (true);
        return result;
    }
}
