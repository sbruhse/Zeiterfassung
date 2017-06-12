package backend;

/**
 * Verwaltung von Auftraggeber
 *
 * @auther sellmer
 */
public class Auftraggeber
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
	 * @return
	 */
	public String getVorname()
	{
		return vorname;
	}

	/**
	 * Setter für {@link #vorname vorname}
	 * @param vorname
	 */
	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}

	/**
	 * Getter für {@link #nachname nachname}
	 * @return
	 */
	public String getNachname()
	{
		return nachname;
	}

	/**
	 * Setter für {@link #nachname nachname}
	 * @param nachname
	 */
	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}

	/**
	 * Getter für {@link #stadt stadt}
	 * @return
	 */
	public String getStadt()
	{
		return stadt;
	}

	/**
	 * Setter für {@link #stadt stadt}
	 * @param stadt
	 */
	public void setStadt(String stadt)
	{
		this.stadt = stadt;
	}

	/**
	 * Getter für {@link #plz plz}
	 * @return
	 */
	public String getPlz()
	{
		return plz;
	}

	/**
	 * Setter für {@link #plz plz}
	 * @param plz
	 */
	public void setPlz(String plz)
	{
		this.plz = plz;
	}

	/**
	 * Getter für {@link #strasse strasse}
	 * @return
	 */
	public String getStrasse()
	{
		return strasse;
	}

	/**
	 * Setter für {@link #strasse strasse}
	 * @param strasse
	 */
	public void setStrasse(String strasse)
	{
		this.strasse = strasse;
	}

	/**
	 * Standardkonstrukor
	 */
	public Auftraggeber()
	{
	}

	/**
	 * Fügt einen Auftraggeber hinzu
	 */
	void auftraggeberHinzufuegen()
	{

	}
}
