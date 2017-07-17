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
	 * Bereich, für den die Arbeit verrichtet wurde
	 */
	private Bereich bereich;

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
	 * Getter für {@link #bereich bereich}
	 * @return Bereich
	 */
	public Bereich getBereich() 
	{
		return bereich;
	}

	/**
	 * Setter für {@link #bereich bereich}
	 * @param bereich Bereich
	 */
	public void setBereich(Bereich bereich) 
	{
		this.bereich = bereich;
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

	public Arbeitsblock(Aufgaben aufgabe)
	{
		setAufgabe(aufgabe);
	}

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
