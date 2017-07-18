package backend;

import java.util.ArrayList;

/**
 * Klasse zur Verwaltung von Projekt
 * @author sellmer
 */
public class Projekt extends Datei<Projekt>
{
	/**
	 * Name des Projekts
	 */
	private String name;

	/**
	 * Auftraggeber des Projekts
	 */
	private Auftraggeber auftraggeber;

	/**
	 * Unterprojekte
	 */
	private Projekt ueberprojekt = null;

	/**
	 * Bereich für welchen das Projekt ist
	 */
	private Bereich bereich;

	/**
	 * Getter für {@link #name name}
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Setter für {@link #name name}
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Getter für {@link #auftraggeber auftraggeber}
	 * @return
	 */
	public Auftraggeber getAuftraggeber()
	{
		return auftraggeber;
	}

	/**
	 * Setter für {@link #auftraggeber auftraggeber}
	 * @param auftraggeber
	 */
	public void setAuftraggeber(Auftraggeber auftraggeber)
	{
		this.auftraggeber = auftraggeber;
	}

	/**
	 * Getter für {@link #ueberprojekt ueberprojekt}
	 * @return
	 */
	public Projekt getUeberprojekt()
	{
		return ueberprojekt;
	}

	/**
	 * Setter für {@link #ueberprojekt ueberprojekt}
	 * @param ueberprojekt
	 */
	public void setUeberprojekt(Projekt ueberprojekt)
	{
		this.ueberprojekt = ueberprojekt;
	}

	/**
	 * Getter für {@link #bereich bereich}
	 * @return
	 */
	public Bereich getBereich()
	{
		return bereich;
	}

	/**
	 * Setter für {@link #bereich bereich}
	 * @param bereich
	 */
	public void setBereich(Bereich bereich)
	{
		this.bereich = bereich;
	}

	public  Projekt() {

	}


	public Projekt(String name, Auftraggeber auftraggeber, Bereich bereich)
	{
		this.setName(name);
		this.setAuftraggeber(auftraggeber);
		this.setBereich(bereich);
	}

	public final static String path = "/projekte.json";

	public static String getPath()
	{
		return path;
	}

	@Override
	public String toString()
	{
		return getName();
	}
}
