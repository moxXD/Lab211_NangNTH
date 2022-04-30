/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author ducle
 */
public class Task {
    private int TaskID;
    private int TaskTypeID;
    private String RequirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String Assignee;
    private String Reviewer;

    public Task() {
    }

    public Task(int TaskID, int TaskTypeID, String RequirementName, String date, double planFrom, double planTo, String Assignee, String Reviewer) {
        this.TaskID = TaskID;
        this.TaskTypeID = TaskTypeID;
        this.RequirementName = RequirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int TaskID) {
        if (TaskID >= 0) {
            this.TaskID = TaskID;
        }
    }

    public int getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(String TaskTypeID) {
        try {
            if (Integer.parseInt(TaskTypeID) >= 1 && Integer.parseInt(TaskTypeID) <= 4) {
                this.TaskTypeID = Integer.parseInt(TaskTypeID);
            }
        } catch (Exception e) {
            System.out.println("TaskType can only be in range 1 to 4");
        }
    }

    public String getRequirementName() {
        return RequirementName;
    }

    public void setRequirementName(String RequirementName) {
        if (RequirementName != null) {
            this.RequirementName = RequirementName;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null) {
            this.date = date;
        }
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        double value = 0;
        try {
            value = Double.parseDouble(planFrom);
        } catch (NumberFormatException ex) {
            System.out.println("Plan From must be a DOUBLE");
        }
        if (value >= 8.0 && value <= 17.5) {
            if (value % 0.5 == 0) {
                this.planFrom = value;
            } else {
                System.out.println("Plan From only except value x.0 and x.5");
            }
        } else {
            System.out.println("Plan from only except value in range 8.0 to 17.5");
        }
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        double value = 0;
        try {
            value = Double.parseDouble(planTo);
        } catch (NumberFormatException ex) {
            System.out.println("Plan To must be a DOUBLE");
        }
        if (value >= 8.0 && value <= 17.5) {
            if (value % 0.5 == 0) {
                this.planTo = value;
            } else {
                System.out.println("Plan To only except value x.0 and x.5");
            }
        } else {
            System.out.println("Plan To only except value in range 8.0 to 17.5");
        }
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        if (Assignee != null) {
            this.Assignee = Assignee;
        }
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        if (Reviewer != null) {
            this.Reviewer = Reviewer;
        }
    }
    public String GetTaskType() {
        String result = "";
        switch (TaskTypeID) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;
    }
    @Override
    public String toString() {
        double time = planTo -planFrom;
        String planTime = String.format("%.1f", time);
        String result = String.format("%-7d%-20s%-12s%-15s%-7s%-15s%-15s", TaskID, RequirementName,GetTaskType(), date, planTime, Assignee, Reviewer );
        return result;
    }

}
