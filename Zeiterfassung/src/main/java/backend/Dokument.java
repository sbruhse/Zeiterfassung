package backend;

import java.awt.PageAttributes;
import java.util.ArrayList;

/**
 *
 * @author sbruhse
 */
public class Dokument
{

    private String header;
    private Projekt projekt;
    private Identitaet identitaet;
    private PageAttributes.MediaType format;
    private ArrayList<Arbeitsblock> arbeitsbloecke;

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String pHeader)
    {
        this.header = pHeader;
    }

    public Projekt getProjekt()
    {
        return projekt;
    }

    public void setProjekt(Projekt pProjekt)
    {
        this.projekt = pProjekt;
    }

    public Identitaet getIdentitaet()
    {
        return identitaet;
    }

    public void setIdentitaet(Identitaet pIdentitaet)
    {
        this.identitaet = pIdentitaet;
    }

    public PageAttributes.MediaType getFormat()
    {
        return format;
    }

    public void setFormat(PageAttributes.MediaType pFormat)
    {
        this.format = pFormat;
    }

}
