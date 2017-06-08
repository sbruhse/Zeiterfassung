package backend;

/**
 * Created by sellmer on 08.06.17.
 */
public class Projekt {
    private String name;
    private Auftraggeber auftraggeber;
    private Projekt unterprojekt;
    private Bereich bereich;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Auftraggeber getAuftraggeber() {
        return auftraggeber;
    }

    public void setAuftraggeber(Auftraggeber auftraggeber) {
        this.auftraggeber = auftraggeber;
    }

    public Projekt getUnterprojekt() {
        return unterprojekt;
    }

    public void setUnterprojekt(Projekt unterprojekt) {
        this.unterprojekt = unterprojekt;
    }

    public Bereich getBereich() {
        return bereich;
    }

    public void setBereich(Bereich bereich) {
        this.bereich = bereich;
    }


    public Projekt() {
    }

    void projektErstellen() {

    }

    void projektBearbeiten() {

    }
}
