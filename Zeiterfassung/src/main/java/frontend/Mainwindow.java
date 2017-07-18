package frontend;

import backend.Auftraggeber;
import backend.Bereich;
import backend.Identitaet;
import backend.Projekt;
import com.google.gson.Gson;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by sellmer on 08.06.17.
 */
public class Mainwindow extends JFrame implements ActionListener {

    JButton jButton;
    JLabel jLabel;
    JPanel jPanel;
    JComboBox jCProjekte;

    public static void main(String[] args) {
        Mainwindow mw = new Mainwindow();
        mw.setVisible(true);
    }

    public Mainwindow() {

    /*
    Swing test
     */
        this.setTitle("Zeiterfassung");
        this.setSize(600, 600);

        jPanel = new JPanel();

        jLabel = new JLabel();
        jPanel.add(jLabel);

        jButton = new JButton("Klick mich");
        jPanel.add(jButton);
        jButton.addActionListener(this);

        ArrayList<Projekt> projekte = new ArrayList<>();
        try
        {
            projekte = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()),Projekt[].class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        jCProjekte = new JComboBox(projekte.toArray());
        jPanel.add(jCProjekte);

        /*
        Button zum Anlegen eines Projektes
         */
        JButton jBProjektAnlegen = new JButton("+");
        jPanel.add(jBProjektAnlegen);
        jBProjektAnlegen.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Bin hier");
                JFrame addProjektWindow = new JFrame("AddProjektWindow");
                addProjektWindow.setContentPane(new AddProjektWindow().mainPanel);
                addProjektWindow.pack();
                addProjektWindow.setVisible(true);
            }
        });

        /*
        Button zum Anlegen eines Bereiches
         */
        JButton jBBereichAnlegen = new JButton("Bereich hinzufügen");
        jPanel.add(jBBereichAnlegen);
        jBBereichAnlegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addBereichWindow = new JFrame("AddBereichWindow");
                addBereichWindow.setContentPane(new AddBereichWindow().mainPanel);
                addBereichWindow.pack();
                addBereichWindow.setVisible(true);
            }
        });

        /*
        Button zum Anlegen einer Aufgabe
         */
        JButton jBAufgabeAnlegen = new JButton("Aufgabe hinzufügen");
        jPanel.add(jBAufgabeAnlegen);
        jBAufgabeAnlegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addAufgabeWindow = new JFrame("AddAufgabeWindow");
                addAufgabeWindow.setContentPane(new AddAufgabeWindow().mainPanel);
                addAufgabeWindow.pack();
                addAufgabeWindow.setVisible(true);
            }
        });

        /*
        Button zum Anlegen eines Auftraggebers
         */
        JButton jBAuftraggeberAnlegen = new JButton("Auftraggeber hinzufügen");
        jPanel.add(jBAuftraggeberAnlegen);
        jBAuftraggeberAnlegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addAuftraggeberWindow = new JFrame("AddAuftraggeberWindow");
                addAuftraggeberWindow.setContentPane(new AddAuftraggeberWindow().mainPanel);
                addAuftraggeberWindow.pack();
                addAuftraggeberWindow.setVisible(true);
            }
        });

        this.add(jPanel);

        /*
        Button zum Anlegen einer Identität
         */
        JButton jBIdentitaetAnlegen = new JButton("Identität anlegen");
        jPanel.add(jBIdentitaetAnlegen);
        jBIdentitaetAnlegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addIdentitaetWindow = new JFrame("AddIdentitaetWindow");
                addIdentitaetWindow.setContentPane(new AddIdentitaetWindow().mainPanelIdentitaet);
                addIdentitaetWindow.pack();
                addIdentitaetWindow.setVisible(true);
            }
        });


        /*
        Button zum Editieren eines Bereiches
         */
        JButton jBEditBereich = new JButton("Bereiche bearbeiten");
        jPanel.add(jBEditBereich);
        jBEditBereich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame editBereichWindow = new JFrame("EditBereichWindow");
                editBereichWindow.setContentPane(new EditBereichWindow().editBereichePanel);
                editBereichWindow.pack();
                editBereichWindow.setVisible(true);
            }
        });

         /*
        Button zum Editieren einer Identität
         */
        JButton jBEditIdent = new JButton("Identitäten bearbeiten");
        jPanel.add(jBEditIdent);
        jBEditIdent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame editIdentWindow = new JFrame("EditIdentitaetWindow");
                editIdentWindow.setContentPane(new EditIdentitaetWindow().editIdentPanel);
                editIdentWindow.pack();
                editIdentWindow.setVisible(true);
            }
        });

        /*
        New Main Window
         */
        JButton jBNewMainWindow = new JButton("New Main Window");
        jPanel.add(jBNewMainWindow);
        jBNewMainWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newMainWindow = new JFrame("NewMainWindow");
                newMainWindow.setContentPane(new NewMainWindow().mainPanel);
                newMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newMainWindow.pack();
                newMainWindow.setVisible(true);
            }
        });

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.jButton) {
            jLabel.setText(("Button wurde betätigt"));


        }
    }
}

