package backend;

import java.util.Date;

/**
 * Created by lasse on 08.06.17.
 */

public class Arbeitsblock 
{
	
	private Date startzeit;
	private Date endzeit;
	private Bereich bereich;
	private Aufgaben aufgabe;
	private String beschreibung;
	
	public Date getStartzeit() 
	{
		return startzeit;
	}
	public void setStartzeit(Date startzeit) 
	{
		this.startzeit = startzeit;
	}
	public Date getEndzeit() 
	{
		return endzeit;
	}
	public void setEndzeit(Date endzeit) 
	{
		this.endzeit = endzeit;
	}
	public Bereich getBereich() 
	{
		return bereich;
	}
	public void setBereich(Bereich bereich) 
	{
		this.bereich = bereich;
	}
	public Aufgaben getAufgabe() 
	{
		return aufgabe;
	}
	public void setAufgabe(Aufgaben aufgabe) 
	{
		this.aufgabe = aufgabe;
	}
	public String getBeschreibung() 
	{
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) 
	{
		this.beschreibung = beschreibung;
	}
	
	public void arbeitsblockStarten()
	{
		
	}
	
	public void arbeitsblockStoppen()
	{
		
	}

}
