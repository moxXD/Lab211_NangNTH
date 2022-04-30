
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
public class Main {
    public static void main(String[] args) {
        // promt ask user to input size of array
        int size= InputSize();
        // promt ask user to input element in array with user input size
        int[] array=inputArray(size);
        // display array before sorting
        display(array,"Unsorted array: ");
        //sort the array with selection sort
        selectionSort(array);
        // display array after sorting
        display(array,"Sorted array: ");
    }
    public static int InputSize(){
        String input;
        double number;
        Scanner sc = new Scanner(System.in);
        // check user input match the requirment :Positive decimal number
        do{
            System.out.println("Enter number of array:");
            input=sc.nextLine();
            // check input is empty
            if(input.isEmpty()){
                System.out.println("Input can't be empty ,"
                        + "please input a positive"
                            + " integer");
                continue;
            }
            try{
                //check input is <0
                number=Double.parseDouble(input);
                if(number < 0){
                    System.out.println("Input can't be smaller"
                            + " than 0 , please input a positive"
                            + " integer");
                }
                //check input =0
                else if(number ==0){
                    System.out.println("Input can't be 0,"
                            + " please input a positive"
                            + " integer");
                }
                // check input is realnumber
                else if(number !=(int)number){
                    System.out.println("Input can't be real number,"
                            + " please input a positive"
                            + " integer");
                }else break;
            }catch(Exception e){ // check input is a string
                System.out.println("Input can't be a string,"
                        + " please input a positive"
                            + " integer");
            }
        }while(true);       
        return (int)number;
    }
    
    // input element of array param size
    public static int[] inputArray(int Size){
        int array[]=new int[Size];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i <array.length; i++) {
            System.out.println("Enter element: ");
            array[i]=sc.nextInt();
        }
        return array;
    }
    // display array 
    //param int array[],String msg
    public static void display(int[] array,String msg){
        System.out.print(msg);
        System.out.print("[");
        // loop to print out array element and comma after each element
        for (int i = 0; i <array.length; i++) {
            System.out.print(array[i]);
            if(i<array.length-1) System.out.print(", ");
        }
        // interface matching
        if(msg.equalsIgnoreCase("Unsorted array: ")) System.out.println("]");
        else   System.out.print("]");
    }
    public static void selectionSort(int[] array){
        int temp;
        // loop access each element of array
        for (int i = 0; i <array.length-1; i++) {  
            // find the smallest element in the unsorted array
            int min= i;
            for (int j =i+1; j <array.length; j++) {
                if(array[j]<array[min]) min=j;
            }
            // swap the smallest element from the unsorted 
            // array with the first element of the unsorted list
            temp=array[min];
            array[min]=array[i];
            array[i]=temp;     
        }
    }
}
