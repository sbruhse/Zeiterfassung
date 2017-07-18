package backend;

import java.util.Date;

/**
 * Verwaltung von Auftraggeber
 *
 * @auther sellmer
 */
public class Auftraggeber extends Datei<Auftraggeber>
{
	/**
	 * Vorname des Auftraggebers
	 */
	private String vorname="";

	/**
	 * Nachname des Auftraggebers
	 */
	private String nachname="";

	private Adresse adresse;
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter für {@link #vorname vorname}
	 * @return Vorname
	 */
	public String getVorname()
	{
		return vorname;
	}

	/**
	 * Setter für {@link #vorname vorname}
	 * @param vorname Vorname
	 */
	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}

	/**
	 * Getter für {@link #nachname nachname}
	 * @return Nachname
	 */
	public String getNachname()
	{
		return nachname;
	}

	/**
	 * Setter für {@link #nachname nachname}
	 * @param nachname Nachname
	 */
	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}

	/**
	 * Getter für {@link #stadt stadt}
	 * @return Stadt
	 */
	public String getStadt()
	{
		return adresse.getOrt();
	}

	/**
	 * Setter für {@link #stadt stadt}
	 * @param stadt Stadt
	 */
	public void setStadt(String stadt)
	{
		adresse.setOrt(stadt);
	}

	/**
	 * Getter für {@link #plz plz}
	 * @return Stadt
	 */
	public String getPlz()
	{
		return adresse.getPlz();
	}

	/**
	 * Setter für {@link #plz plz}
	 * @param plz plz
	 */
	public void setPlz(String plz)
	{
		adresse.setPlz(plz);
	}

	/**
	 * Getter für {@link #strasse strasse}
	 * @return strasse
	 */
	public String getStrasse()
	{
		return adresse.getStrasse();
	}

	/**
	 * Setter für {@link #strasse strasse}
	 * @param strasse strasse
	 */
	public void setStrasse(String strasse)
	{
		adresse.setStrasse(strasse);
	}

	/**
	 * Standardkonstrukor
	 */
	public Auftraggeber(String vorname)
	{
		setVorname(vorname);
		adresse = new Adresse();
	}

	public Auftraggeber(){adresse = new Adresse();};


	public final static String path = "/auftraggeber.json";

	public static String getPath()
	{
		return path;
	}
	
	@Override
	public String toString()
	{
		return getNachname();
	}
}
