/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Ultility.getData;
import View.Display;
import View.Manage;
/**
 *
 * @author ducle
 */
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        getData getdata = new getData();
        Manage m=new Manage();
        while(true){
            // display program menu
            display.displayMenu();
            // get user choice
            int choice=getdata.getInt("Your choice: ", "Choice must be in range [1-4]", 1, 4);
            switch(choice){
                case 1:
                    // add new task to the list
                    m.createTask();
                    break;
                case 2:
                    // delete a task from list
                    m.deleteTask();
                    break;
                case 3:
                    // show task list
                    m.showTask();
                    break;
                case 4:
                    // exit the program
                    System.exit(0);
                    break;               
            }
        }
    }
}
