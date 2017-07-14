package frontend;

import backend.Auftraggeber;
import backend.Bereich;
import backend.Identitaet;
import backend.Projekt;
import com.google.gson.Gson;
import sun.rmi.runtime.Log;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

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
        Simons Tests START
         */

        // Erstellt 2 Identitäts Objekte
        System.out.println(Identitaet.getObjectsFromJson("[{name:\"test1\"},{name:\"test2\"}]"));

        // Erstellt 1 Projekt Objekt, macht es zu einem JSON String und anschließend wieder zu einem Projekt Objekt
        Projekt projekt1 = new Projekt("Test", new Auftraggeber("hans"), new Bereich("FH"));
        Gson gson = new Gson();
        String jsonString = gson.toJson(projekt1);
        System.out.println(jsonString);


        /*
        Simons Tests ENDE
         */

    /*
    Swing test
     */
        this.setTitle("Zeiterfassung");
        this.setSize(600, 600);

        jPanel = new JPanel();
//        jPanel.setBackground(Color.blue);

        jLabel = new JLabel();
        jPanel.add(jLabel);

        jButton = new JButton("Klick mich");
        jPanel.add(jButton);
        jButton.addActionListener(this);



       /* ArrayList<Projekt> projektliste = new ArrayList<>();
        projektliste.add(new Projekt("test", new Auftraggeber("test"), new Bereich("test")));
        projektliste.add(new Projekt("test2", new Auftraggeber("test"), new Bereich("test")));


        jCProjekte = new JComboBox();
        jCProjekte.addItem(projektliste.get(0).getName());
        jCProjekte.addItem(projektliste.get(1).getName()); */


        //steven test
        Projekt projekt = new Projekt();
        projekt.setName("TestProjekt");

        Projekt projekt2 = new Projekt();
        projekt2.setName("Test2");

        Gson projektgson = new Gson();
        String projektjson = projektgson.toJson(projekt);
        String projektjson2 = projektgson.toJson(projekt2);
        try {
            Projekt.write("Projekt.json", projektjson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Projekt.write("Projekt.json", projektjson2);
        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
           String projektestring =  Projekt.read("Projekt.json");
            System.out.println(projektestring);
           //Projekt.getObjectsFromJson(projektestring);
        } catch (IOException e) {
            e.printStackTrace();
        }




        jCProjekte = new JComboBox();
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
                AddProjektWindow addProjektWindow = new AddProjektWindow();
                addProjektWindow.setVisible(true);
            }
        });




        this.add(jPanel);


        /*primaryStage.setTitle("Zeiterfassung");
        button = new Button();
        button.setText("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.jButton) {
            jLabel.setText(("Button wurde betätigt"));


        }
    }
}

