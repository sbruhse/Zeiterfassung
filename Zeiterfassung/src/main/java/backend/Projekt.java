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
	
	public float getStundensatz() {
		return stundensatz;
	}

	public void setStundensatz(float stundensatz) {
		this.stundensatz = stundensatz;
	}

	private float stundensatz;
	
	public void projektDrucken()
	{
		ArrayList<Aufgaben> projektaufgaben = Aufgaben.getAufgaben(this);
		float sum =  0;
		for(Aufgaben a:projektaufgaben)
		{
			ArrayList<Arbeitsblock> bloecke = Arbeitsblock.getAufgabenbloecke(a);
			for(Arbeitsblock ab:bloecke) sum += ab.getStunden();
			
		}
		
		
		if(auftraggeber==null)auftraggeber = new Auftraggeber();

		//Rechnung neueRechnung = new Rechnung(sum, stundensatz, auftraggeber.getNachname(), auftraggeber.getAdresse().getAdressString(), 7);
		Adresse adr1 = new Adresse();
		adr1.setOrt("Kiel");
		adr1.setPlz("123");
		adr1.setStrasse("Weg 5");
		Rechnung neueRechnung = new Rechnung(sum, stundensatz, auftraggeber.getNachname(), auftraggeber.getAdresse().getAdressString(), 7);
		neueRechnung.rechnungErstellen();
		neueRechnung.rechnungDrucken(getName());
		
	}

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

	public Projekt(String name) {
		this.setName(name);
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
