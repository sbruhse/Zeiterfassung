package backend;

import java.util.Date;

/**
 * Geschlossener Block in dem dokumentiert werden soll, wie lange und an was gearbeitet wurde
 *
 * @author lasse
 */
public class Arbeitsblock 
{

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

	/**
	 * Startet einen Arbeitsblock
	 */
	public void arbeitsblockStarten()
	{
		
	}

	/**
	 * Beendet einen Arbeitsblock
	 */
	public void arbeitsblockStoppen()
	{
		
	}

}
