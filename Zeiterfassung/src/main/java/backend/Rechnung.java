package backend;

/**
 * Created by sellmer on 08.06.17.
 */
public class Rechnung extends Dokument
{
	private float preis;
	private float stundensatz;

	public float getPreis()
	{
		return preis;
	}

	public void setPreis(float preis)
	{
		this.preis = preis;
	}

	public float getStundensatz()
	{
		return stundensatz;
	}

	public void setStundensatz(float stundensatz)
	{
		this.stundensatz = stundensatz;
	}

	public Rechnung()
	{
	}
}
