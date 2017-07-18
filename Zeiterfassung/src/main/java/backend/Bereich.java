package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jndi.ldap.Ber;

import java.util.ArrayList;

/**
 * Verwaltung von Bereich
 *
 * @author sellmer
 */
public class Bereich extends Datei<Bereich>
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

	public Bereich() {

	}

	public Bereich(String name)
	{
		this.name = name;
	}


	public final static String path = "/bereiche.json";

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
