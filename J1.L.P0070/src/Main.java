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
        GetData getData = new GetData();
        Ebank ebank = new Ebank();
        do {
            // Display Menu
            ebank.displayMenu();
            // Enter choice from user
            int choice = getData.getChoice("Please choice one option:", 1, 3);
            // Perform option base on the user choice
            switch (choice) {
                case 1:
                    //login with Vietnamese language
                    ebank.VietnameseSystem();
                    break;
                case 2:
                    //login with English language
                    ebank.EnglishSystem();
                    break;
                case 3:
                    //Exist
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
