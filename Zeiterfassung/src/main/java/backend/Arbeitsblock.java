package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Geschlossener Block in dem dokumentiert werden soll, wie lange und an was gearbeitet wurde
 *
 * @author lasse
 */
public class Arbeitsblock extends Datei<Arbeitsblock>
{

	public final static String path = "/arbeitsblock.json";
	/**
	 * Startzeit des Arbeitsblocks
	 */
	private Date startzeit;

	/**
	 * Endzeit des Arbeitsblocks
	 */
	private Date endzeit;


	/**
	 * Aufgabe, die erledigt wurde
	 */
	private Aufgaben aufgabe;

	/**
	 * Beschreibung der Tätigkeit
	 */
	private String beschreibung;

	/**
	 * Getter für {@link #startzeit startzeit}
	 * @return Startzeit
	 */
	public Date getStartzeit() 
	{
		return startzeit;
	}

	/**
	 * Setter für {@link #startzeit startzeit}
	 * @param startzeit Startzeit
	 */
	public void setStartzeit(Date startzeit) 
	{
		this.startzeit = startzeit;
	}

	/**
	 * Getter für {@link #endzeit endzeit}
	 * @return Endzeit
	 */
	public Date getEndzeit() 
	{
		return endzeit;
	}

	/**
	 * Setter für {@link #endzeit endzeit}
	 * @param endzeit Endzeit
	 */
	public void setEndzeit(Date endzeit) 
	{
		this.endzeit = endzeit;
	}

	
	/**
	 * 
	 * @return Differenz zwischen Start und Ende in Stunden
	 */
	public double getStunden()
	{
		return (endzeit.getTime() - startzeit.getTime()) / 1000 / 60 / 60;
	}

	/**
	 * Getter für {@link #aufgabe aufgabe}
	 * @return Aufgabe
	 */
	public Aufgaben getAufgabe() 
	{
		return aufgabe;
	}

	/**
	 * Setter für {@link #aufgabe aufgabe}
	 * @param aufgabe Aufgabe
	 */
	public void setAufgabe(Aufgaben aufgabe) 
	{
		this.aufgabe = aufgabe;
	}

	/**
	 * Getter für {@link #beschreibung beschreibung}
	 * @return Beschreibung
	 */
	public String getBeschreibung() 
	{
		return beschreibung;
	}

	/**
	 * Setter für {@link #beschreibung beschreibung}
	 * @param beschreibung Beschreibung
	 */
	public void setBeschreibung(String beschreibung) 
	{
		this.beschreibung = beschreibung;
	}

	/**
	 * 
	 * @param aufgabe Zugeordnete Aufgabe
	 */
	public Arbeitsblock(Aufgaben aufgabe)
	{
		setAufgabe(aufgabe);
	}
	
	//Leerer Konstruktor
	public Arbeitsblock() {}

	/**
	 * Startet einen Arbeitsblock
	 */
	public void arbeitsblockStarten()
	{
		setStartzeit(new Date());
	}

	/**
	 * Beendet einen Arbeitsblock
	 */
	public void arbeitsblockStoppen()
	{
		setEndzeit(new Date());
	}
	
	/**
	 * Gibt Arbeitsbloecke zurück, die zu einer bestimmten Aufgabe gehören
	 * @param a Aufgabe deren Bloecke gefunden werden sollen
	 * @return
	 */
	public static ArrayList<Arbeitsblock> getAufgabenbloecke(Aufgaben a)
	{
		ArrayList<Arbeitsblock> alleBloecke = new ArrayList<>(), sortierteBloecke = new ArrayList<>();
		
		try 
		{
			alleBloecke = getObjectsFromJson(read(getPath()), Arbeitsblock[].class);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return new ArrayList<>();
		}
		
		for(Arbeitsblock ab : alleBloecke)
		{
			if(a.getTaskName().equals(ab.getAufgabe().getTaskName()))
				sortierteBloecke.add(ab);
		}
		
		return sortierteBloecke;
	}



	public static String getPath()
	{
		return path;
	}

}
