package frontend;

import backend.Auftraggeber;
import backend.Bereich;
import backend.Identitaet;
import backend.Projekt;
import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sellmer on 08.06.17.
 */
public class Mainwindow extends JFrame implements ActionListener {

    JButton jButton;
    JLabel jLabel;
    JPanel jPanel;
    JFrame jFrame;

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
        Projekt projekt = new Projekt("Test", new Auftraggeber("hans"), new Bereich("FH"));
        Gson gson = new Gson();
        String jsonString = gson.toJson(projekt);
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
        jPanel.setBackground(Color.blue);

        jLabel = new JLabel();
        jPanel.add(jLabel);

        jButton = new JButton("Klick mich");
        jPanel.add(jButton);
        jButton.addActionListener(this);

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

