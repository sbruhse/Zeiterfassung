package backend;

import java.sql.Time;
import java.util.Date;

/**
 * Created by steven on 08.06.17.
 */
public class Aufgaben {

    private int taskId;
    private String taskName;
    private String taskDescription;
    private Time taskDeadline;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Time getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(Time taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    

    public void createTask() {


    }

    public void editTask() {

    }
}
