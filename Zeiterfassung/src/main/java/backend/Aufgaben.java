package backend;

import java.sql.Time;
import java.util.Date;

/**
 * Created by steven on 08.06.17.
 */
public class Aufgaben
{

    /**
     * ID
     */
	private int taskId;
    /**
     * Name
     */
	private String taskName;
    /**
     * Beschreibung
     */
	private String taskDescription;
    /**
     * Deadline
     */
	private Time taskDeadline;


    /**
     * @return taskID
     */
	public int getTaskId()
	{
		return taskId;
	}
	
    /**
     * sets taskID
     */
	public void setTaskId(int taskId)
	{
		this.taskId = taskId;
	}
	
    /**
     * @return taskName
     */
	public String getTaskName()
	{
		return taskName;
	}
	
	 /**
    * sets taskName
    */
	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
	}
	
    /**
     * @return taskDescription
     */
	public String getTaskDescription()
	{
		return taskDescription;
	}
	
	 /**
    * sets taskDescription
    */
	public void setTaskDescription(String taskDescription)
	{
		this.taskDescription = taskDescription;
	}
	
    /**
     * @return taskDeadline
     */
	public Time getTaskDeadline()
	{
		return taskDeadline;
	}
	
	/**
   * sets taskDeadline
   */
	public void setTaskDeadline(Time taskDeadline)
	{
		this.taskDeadline = taskDeadline;
	}

	/**
	 * creates Task
	 */
	public void createTask()
	{

	}

	/**
	 * ???
	 */
	public void editTask()
	{

	}
}
