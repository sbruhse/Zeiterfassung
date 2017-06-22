package backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

/**
 * Created by steven on 08.06.17.
 */
public class Aufgaben extends Datei<Aufgaben>{

    //Deklaration
    private int taskId;
    private String taskName;
    private String taskDescription;
    private Date taskDeadline;

    //Gson initialisierung
    Gson gson = new GsonBuilder().create();


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

    public Date getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(Date taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public void createTask() {

        Aufgaben task = new Aufgaben();

        task.setTaskName("Testname");
        task.setTaskDescription("blablabla");
        task.setTaskId(01);

        task.setTaskDeadline(new Date());

        String json = gson.toJson(task);

        try {
            FileWriter writer = new FileWriter("aufgaben.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void editTask() {

    }
}
