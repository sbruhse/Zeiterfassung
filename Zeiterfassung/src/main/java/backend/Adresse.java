package backend;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Adresse 
{
	private String strasse;
	private String ort;
	private String plz;

	public String getAdressString()
	{
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter, true);
		writer.println(strasse);
		writer.println(plz + " " + ort);
		return stringWriter.toString();
	}
	
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
}
