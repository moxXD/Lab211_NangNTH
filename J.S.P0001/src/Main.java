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
        //  ask user to input positive decimal
        int Size=InputNumber();
        //  generate array using user input as Size of array
        int array[]=GenerateArray(Size);
        //  display array before sort
        DisplayArray(array,"Unsorted array: ");
        //  sort array
        BubbleSort(array);
        //  display array after sort
        DisplayArray(array, "Sorted array: ");
    }
    /*  Ask user to input positive number and check user input
        if input is correct return input */
    public static int InputNumber(){
        // string to store user input
        String input;
        // double number to receive input when user input checkout
        double number;
        Scanner sc = new Scanner(System.in);
        // check user input match the requirment Positive decimal number
        do{
            System.out.println("Enter number of array:");
            input=sc.nextLine();           
            if(input.isEmpty()){
                System.out.println("Input can't be empty ,"
                        + "please input a positive"
                            + " integer");
                continue;
            }
            try{
                number=Double.parseDouble(input);
                if(number < 0){
                    System.out.println("Input can't be smaller"
                            + " than 0 , please input a positive"
                            + " integer");
                }
                else if(number ==0){
                    System.out.println("Input can't be 0,"
                            + " please input a positive"
                            + " integer");
                }
                else if(number !=(int)number){
                    System.out.println("Input can't be real number,"
                            + " please input a positive"
                            + " integer");
                }else break;
            }catch(Exception e){
                System.out.println("Input can't be a string,"
                        + " please input a positive"
                            + " integer");
            }
        }while(true);       
        return (int)number;
    }
    /* generate random array
    param size
    */
    public static int[] GenerateArray(int Size){
        // array of random number
        int array[]=new int[Size];
        Random rd=new Random();
        // loop to insert random number into array
        for (int i = 0; i < Size; i++) {
            array[i]=rd.nextInt(Size);
        }
        return array;
    }
    /*  function to display array
    param array
    param msg
    */
    public static void DisplayArray( int[] array, String msg){
        System.out.print(msg);
        System.out.print("[");
        // print out every element in array and after printing 1 element
        // we put an , after it
        for (int i = 0; i <array.length; i++) {
            System.out.print(array[i]);
            if(i<array.length-1) System.out.print(", ");
        }
        // put [ in the in of array
        if( msg.equals("Unsorted array: ")){
            System.out.println("]");
            }else System.out.print("]");
        }
    public static void BubbleSort(int[] array){
        // temporary position to store value when performing bubble sort
        int temp;
        //  Loop to access from first element to last
        for (int i = 0; i < array.length-1; i++) {
            // Loop to bring largest element to the back
            for (int j = 0; j < array.length-i-1; j++) {
                // Compare each pair adjacent elements
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp; 
                }
            }
        }
    }
    }

