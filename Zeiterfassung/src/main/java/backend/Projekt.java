package backend;

import java.util.ArrayList;

/**
 * Klasse zur Verwaltung von Projekt
 * @author sellmer
 */
public class Projekt
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
	private ArrayList<Projekt> unterprojekt;

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
	 * Getter für {@link #unterprojekt unterprojekt}
	 * @return
	 */
	public ArrayList<Projekt> getUnterprojekt()
	{
		return unterprojekt;
	}

	/**
	 * Setter für {@link #unterprojekt unterprojekt}
	 * @param unterprojekt
	 */
	public void setUnterprojekt(ArrayList<Projekt> unterprojekt)
	{
		this.unterprojekt = unterprojekt;
	}

	/**
	 * Ein Unterprojekt hinzufügen
	 * @param unterprojekt
	 */
	public void addUnterprojekt(Projekt unterprojekt)
	{
		getUnterprojekt().add(unterprojekt);
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

	/**
	 * Standardkonstruktor
	 */
	public Projekt()
	{
	}

	/**
	 * Erstellen eines Projekts
	 */
	void projektErstellen()
	{

	}

	/**
	 * Bearbeiten eines Projekts
	 */
	void projektBearbeiten()
	{

	}
}
