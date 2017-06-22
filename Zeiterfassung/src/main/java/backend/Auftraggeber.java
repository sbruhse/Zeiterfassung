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
	private String vorname;

	/**
	 * Nachname des Auftraggebers
	 */
	private String nachname;

	/**
	 * Stadt, wo der Auftraggeber sitzt
	 */
	private String stadt;

	/**
	 * Postleitzahl der Stadt, wo der Auftraggeber sitzt
	 */
	private String plz;

	/**
	 * Straße, in der der Auftragger sitzt
	 */
	private String strasse;

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
		return stadt;
	}

	/**
	 * Setter für {@link #stadt stadt}
	 * @param stadt Stadt
	 */
	public void setStadt(String stadt)
	{
		this.stadt = stadt;
	}

	/**
	 * Getter für {@link #plz plz}
	 * @return Stadt
	 */
	public String getPlz()
	{
		return plz;
	}

	/**
	 * Setter für {@link #plz plz}
	 * @param plz plz
	 */
	public void setPlz(String plz)
	{
		this.plz = plz;
	}

	/**
	 * Getter für {@link #strasse strasse}
	 * @return strasse
	 */
	public String getStrasse()
	{
		return strasse;
	}

	/**
	 * Setter für {@link #strasse strasse}
	 * @param strasse strasse
	 */
	public void setStrasse(String strasse)
	{
		this.strasse = strasse;
	}

	/**
	 * Standardkonstrukor
	 */
	public Auftraggeber(String vorname)
	{
		setVorname(vorname);
	}
}
