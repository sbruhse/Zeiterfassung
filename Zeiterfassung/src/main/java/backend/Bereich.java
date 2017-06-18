package backend;

/**
 * Verwaltung von Bereich
 *
 * @author sellmer
 */
public class Bereich
{
	/**
	 * Name des Bereichs
	 */
	private String name;

	/**
	 * Getter für {@link #name name}
	 * @return Name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Setter für {@link #name name}
	 * @param name name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	public Bereich(String name)
	{
		this.name = name;
	}
}
