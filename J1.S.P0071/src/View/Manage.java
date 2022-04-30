/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.TaskManagement;
import Model.Task;
import Ultility.getData;

/**
 * 
 * @author ducle
 */
public class Manage {
    getData get = new getData();
    TaskManagement tManager = new TaskManagement();
    Task task=new Task();
    // function to show interface create task
    public void createTask() {
        System.out.println("----------------Add Task------------------");
        String reName = get.getString("Requirement Name: ", "", "");
        String TaskType = get.getString("Task Type: ", "Input must be in range [1 to 4]", "[1-4]");
        String date = get.getDate("Date: ");
        double planFrom = get.getDouble("From: ", "Plan From must be within 8h-17h", 8.0, 17.0);
        double planTo = get.getDouble("To: ", "Plan To must be within From to 17h30", planFrom + 0.5, 17.5);
        String Assignee = get.getString("Assignee: ", "", "");
        String reviewer = get.getString("Reviewer: ", "", "");
        //check if new task is duplicated or not
        try {
            if (-1 != tManager.addTask(TaskType, reName.trim(), date.trim(), planFrom, planTo, Assignee.trim(), reviewer.trim())) {
                System.out.println("Task has been added");
            } else {
                System.out.println("Task already exist!!!");
            }
        } catch (Exception e) {
            System.out.println("Add task fail!!!");
        }
    }

    // function show interface delete task
    public void deleteTask() {
        // show task is empty
        if (tManager.getDataTask().isEmpty()) {
            System.out.println("List Task is empty");
        }
        try {// try catch to catch if task not exist
            System.out.println("------------------Del Task------------------");
            int delID = get.getInt("ID: ", "Task id is out of range!", 1, Integer.MAX_VALUE);
            tManager.deleteTask(delID);
            System.out.println("Task deleted");
        } catch (Exception e) {
            System.out.println("Task not exist");
        }
    }
    //function to show interface task list

    public void showTask() {
        if (tManager.getDataTask().isEmpty()) {
            System.out.println("List task is empty!");
        } else {
            System.out.println("------------------Task------------------");
            System.out.format("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n", "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            //loop use to access each element of arraylist from begining to the end
            for (Task task : tManager.getDataTask()) {
                System.out.println(task);
            }
        }
    }
}
