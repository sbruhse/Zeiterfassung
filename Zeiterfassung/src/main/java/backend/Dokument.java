package backend;

import java.awt.PageAttributes;
import java.util.ArrayList;

/**
 * Abstrakte Klasse für Dokumente
 *
 * @author sbruhse
 */
public abstract class Dokument
{

    /**
     * Header welcher über dem Objekt ausgegeben wird
     */
	private String header;

    /**
     * Projekt, zu welchem das Dokument ausgegeben wird
     */
	private Projekt projekt;

    /**
     * Identität, unter welcher das Dokument ausgegebenw wird
     */
	private Identitaet identitaet;

    /**
     * Seitenformat
     */
	private PageAttributes.MediaType format;

    /**
     * Arbeitsblöcke
     */
	private ArrayList<Arbeitsblock> arbeitsbloecke;



    /**
     * Getter für {@link #header header}
     * @return Header
     */
	public String getHeader()
	{
		return header;
	}

    /**
     * Setter für {@link #header header}
     * @param pHeader Header
     */
	public void setHeader(String pHeader)
	{
		this.header = pHeader;
	}

    /**
     * Getter für {@link #projekt projekt}
     * @return
     */
	public Projekt getProjekt()
	{
		return projekt;
	}

    /**
     * Setter für {@link #projekt projekt}
     * @param pProjekt
     */
	public void setProjekt(Projekt pProjekt)
	{
		this.projekt = pProjekt;
	}

    /**
     * Getter für {@link #identitaet identitaet}
     * @return
     */
	public Identitaet getIdentitaet()
	{
		return identitaet;
	}

    /**
     * Setter für {@link #identitaet identitaet}
     * @param pIdentitaet
     */
	public void setIdentitaet(Identitaet pIdentitaet)
	{
		this.identitaet = pIdentitaet;
	}

    /**
     * Setter für {@link #format format}
     * @return
     */
	public PageAttributes.MediaType getFormat()
	{
		return format;
	}

    /**
     * Getter für {@link #format format}
     * @param pFormat
     */
	public void setFormat(PageAttributes.MediaType pFormat)
	{
		this.format = pFormat;
	}

}
