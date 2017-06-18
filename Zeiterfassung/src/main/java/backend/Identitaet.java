package backend;

/**
 * @author sellmer
 * Identität eines Arbeitenden
 */
public class Identitaet
{
	/**
	 * Name der Identität
	 */
	private String name;

	/**
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * sets name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	public Identitaet(String name)
	{
		setName(name);
	}
}
