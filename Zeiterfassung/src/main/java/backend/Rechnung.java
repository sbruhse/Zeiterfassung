package backend;

/**
 *@author sellmer
 */
public class Rechnung extends Dokument
{
	/**
	 * Dokument mit zusätzlichem Preis und Stundensatz
	 */
	private float preis;
	private float stundensatz;

	/**
	 * 
	 * @return preis
	 */
	public float getPreis()
	{
		return preis;
	}

	/**
	 * 
	 * @param preis
	 */
	public void setPreis(float preis)
	{
		this.preis = preis;
	}

	/**
	 * 
	 * @return stundensatz
	 */
	public float getStundensatz()
	{
		return stundensatz;
	}

	/**
	 * 
	 * @param stundensatz
	 */
	public void setStundensatz(float stundensatz)
	{
		this.stundensatz = stundensatz;
	}

	public Rechnung()
	{
	}
}
