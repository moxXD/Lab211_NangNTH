/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Model.Task;
/**
 *
 * @author ducle
 */
public class TaskManagement {
    ArrayList<Task> Tasklist=new ArrayList<>();
    Task task=new Task();
    public TaskManagement(){       
        Tasklist.add(new Task(1,1,"program java","23-04-2023", 8.0, 17.0, "dev", "Lead"));
        Tasklist.add(new Task(2,2,"program c#","23-04-2023", 8.0, 17.0, "dev", "Lead"));
        Tasklist.add(new Task(3,4,"program c#","22-06-2022", 8.0, 14.0, "dev", "Lead"));
    }
    public ArrayList<Task> getDataTask(){
        return Tasklist;
    }
    // function to add new task 
    // param TaskTypeID, param RequirementName, param date, param planFrom
    // param planTo, param Assignee , param Reviewer
    public int addTask( String TaskTypeID, String RequirementName, String date,
            double planFrom, double planTo, String Assignee, String Reviewer) throws Exception{    
        int id;
        int lastID=Tasklist.size()-1;
        // id set to 1 if list is empty
        if(Tasklist.isEmpty()){
            id=1;
        }
        // id increase by 1 after each add
        else{
            id=Tasklist.get(lastID).getTaskID()+1;
        }
        // check duplicate
        if(checkDuplicate(RequirementName, date, planFrom, planTo, Assignee, Reviewer)){
            return id=-1;
        }else{
            Tasklist.add(new Task(id,Integer.parseInt(TaskTypeID), RequirementName, date, planFrom, planTo, Assignee, Reviewer));            
            return id;
        }        
    }
//  function to check duplicate task in list
//  param RequirementName, param date, param planFrom
//  param planTo, param Assignee , param Reviewer 
    public boolean checkDuplicate( String RequirementName, String date,
            double planFrom, double planTo, String Assignee, String Reviewer){
        // check if list is empty
        if(Tasklist.isEmpty()) return false;
        // loop to access each element in array list
        for (Task task : Tasklist) {
            if(RequirementName.trim().equalsIgnoreCase(task.getRequirementName())
            && date.trim().equalsIgnoreCase(task.getDate())
            && planFrom==task.getPlanFrom()
            && planTo==task.getPlanTo()
            && Assignee.trim().equalsIgnoreCase(task.getAssignee())
            && Reviewer.trim().equalsIgnoreCase(task.getReviewer())){
                return true;
            }   
        }
        return false;
    }
//    function to deleteTask
//    param id
    public void deleteTask(int id)throws Exception{      
        Task temp = getTaskByID(id);
        if(temp!=null){
        Tasklist.remove(temp);}
        else throw new Exception("Task not exist");
    }
//    function to get task by ID
//    param id
    public Task getTaskByID(int id){
        for (Task task : Tasklist) {
            if(task.getTaskID()==id)
                return task;
        }
        return null;
    }
}
