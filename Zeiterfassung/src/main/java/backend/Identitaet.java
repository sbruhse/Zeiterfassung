package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

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

	public static ArrayList<Identitaet> getObjectsFromJson(String json)
	{
		Gson gson = new Gson();
		TypeToken<ArrayList<Identitaet>> token = new TypeToken<ArrayList<Identitaet>>(){};
		return gson.fromJson(json, token.getType());
	}
}
