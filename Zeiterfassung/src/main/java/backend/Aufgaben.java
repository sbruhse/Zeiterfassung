package backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by steven on 08.06.17.
 */
public class Aufgaben extends Datei<Aufgaben>{

    //Deklaration
    private int taskId;
    private String taskName;
    private String taskDescription;
    private Date taskDeadline;




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
    
    public void setTaskDeadline(String taskDeadlineString)
    {
    	try {
			this.setTaskDeadline(new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse(taskDeadlineString));
		} catch (ParseException e) {
			e.printStackTrace();
		}

    }

    public final static String path = "/aufgaben.json";

    public static String getPath()
    {
        return path;
    }
}
