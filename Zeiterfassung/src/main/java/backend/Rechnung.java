package backend;

import java.io.*;

public class Rechnung extends Dokument
{

    private float arbeitszeit = 0;
    private float preis;
    private float stundensatz = 79;
    private String reName = "Unknown";
    private String reAdresse = "deafault 00; 999999";
    private int reNr = 0;

    //Getter & Setter
    public float getAreitszeit(){ return arbeitszeit; }
    public void setAreitszeit(float zeit){ this.arbeitszeit = zeit; }
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
    public String getReName(){ return reName; }
    public void setReName(String name){ this.reName = name; }
    public String getReAdresse(){ return reAdresse; }
    public void setReAdresse(String adresse){ this.reAdresse = adresse; }
    public int getReNr() { return reNr; }
    public void setReNr(int reNr) { this.reNr = reNr; }


    //Konstruktoren
    //leere Konstruktorenhülle
    public Rechnung()
    {
        this.preis = this.preisBerechnen();
    }

    //übliches Konstrukt zur Rechnungserstellung
    public Rechnung(float arbeitszeit, float stundensatz, String reName, String reAdresse, int reNr){
        this.arbeitszeit = arbeitszeit;
        this.stundensatz = stundensatz;
        this.preis = this.preisBerechnen();
        this.reName = reName;
        this.reAdresse = reAdresse;
        this.reNr = reNr;
    }


    //Methoden
    //Rechnugnsbetrag berechnen
    private float preisBerechnen(){
        float p = this.getStundensatz() * this.arbeitszeit;
        this.setPreis(p);
        return this.getPreis();
    }

    //Rechnungsdatei erstellen
    public void rechnungErstellen(){

        String rechnung = this.reName + ".txt";
        File myRechnung = new File(rechnung);
        if(this.checkFile(myRechnung)){
            System.out.println(rechnung + " erzeugt");
        }
        if(this.writeFile(myRechnung)){
            System.out.println("Rechnung erfolgreich geschrieben");
        }
    }

    //Rechnungsinhalt in Datei schreiben
    private boolean writeFile(File file){

        PrintWriter pWriter = null;

        try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            pWriter.println("#####################################");
            pWriter.println("########------RECHNUNG-------########");
            pWriter.println("#####################################");
            pWriter.println();
            pWriter.println();
            pWriter.println("Rechnungsnummer: " + this.reNr);
            pWriter.println("Rechnungsname: " + this.reName);
            pWriter.println("Adresse: " + this.reAdresse);
            pWriter.println();
            pWriter.println("-------------------------------------");
            pWriter.println();
            pWriter.println("Stundensatz: " + this.stundensatz);
            pWriter.println("erbrachte Arbeitsleistung: " + this.arbeitszeit);
            pWriter.println();
            pWriter.println("-------------------------------------");
            pWriter.println();
            pWriter.println("Rechnungsbetrag in €: " + this.preis);
            pWriter.println("*zzgl 19 % MwSt.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
                return true;
            }
        }
        return false;
    }

    //Rechnung drucken; Zur Sinnbildichen Darstellung wird die Rechnung in der Konsole "ausgedruckt"
    public void rechnungDrucken(String name){
        String file = this.reName + ".txt";

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            fileReader.close();
            System.out.println(stringBuffer.toString());
        } catch (IOException e){
            System.out.println("Drucken fehlgeschlagen");
            e.printStackTrace();
        }
    }

    //Überprüfen der nötigen Rechte; Überprüfen ob Datei bereits vorhanden
    private boolean checkFile(File file) {
        if (file != null) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Fehler beim erstellen der Datei:  " + file.toString());
            }
            if (file.isFile() && file.canWrite() && file.canRead()) {
                return true;
            }
        }
        return false;
    }


}
