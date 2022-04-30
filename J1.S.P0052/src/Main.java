/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Ultility.GetData;
import View.Display;
/**
 *
 * @author ducle
 */
public class Main {
    public static void main(String[] args) {
        GetData getdata=new GetData();
        Display display=new Display();
        do{
            // display menu
            display.displayMenu();
            // get user choice
            int choice=getdata.getChoice("Enter user choice: ", 1, 5);
            switch(choice){
                // create country
                case 1:
                    display.addCountry();
                    break;
                // display last inputd country
                case 2:
                    display.displayLastInputCountry();
                    break;
                // search country by name
                case 3:
                    display.search();
                    break;
                // sort by name and display country    
                case 4:
                    display.displayCountryAfterSort();
                    break;
                // exit program    
                case 5:
                    System.exit(0);                    
            }
        }while(true);
    }
}
