package frontend;

import backend.*;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by sellmer on 18.07.17.
 */
public class EditProjektWindow {
    private JTextField textFieldName;
    private JComboBox comboBoxBereich;
    private JComboBox comboBoxAuftraggeber;
    private JTextField textFieldStundensatz;
    private JButton speichernButton;
    private JButton löschenButton;
    public JPanel mainPanel;
    private JComboBox comboBoxProjekte;

    public EditProjektWindow() {
        ArrayList<Projekt> projekt = new ArrayList<>();
        ArrayList<Bereich> bereich = new ArrayList<>();
        ArrayList<Auftraggeber> auftraggeber = new ArrayList<>();

        try {
            projekt = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);
            bereich = Bereich.getObjectsFromJson(Bereich.read(Bereich.getPath()), Bereich[].class);
            auftraggeber = Auftraggeber.getObjectsFromJson(Auftraggeber.read(Auftraggeber.getPath()), Auftraggeber[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Hinzufügen der Bereiche in die CombosBox
        for (Projekt p : projekt) comboBoxProjekte.addItem(p);
        for (Bereich b : bereich) comboBoxBereich.addItem(b.getName());
        for (Auftraggeber a : auftraggeber) comboBoxAuftraggeber.addItem(a.getNachname());


        textFieldName.setText(comboBoxProjekte.getSelectedItem().toString());
        try {
            ArrayList<Projekt> projektArr = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);
            for (Projekt aProjektArr : projektArr) {
                if (Objects.equals(comboBoxProjekte.getSelectedItem().toString(), aProjektArr.getName())) {
                    textFieldStundensatz.setText(Float.toString(aProjektArr.getStundensatz()));
                    break;
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //Wartet auf Auswahl und zeigt diese dann im Namensfenster an
        comboBoxProjekte.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    textFieldName.setText(comboBoxProjekte.getSelectedItem().toString());

                    try {
                        ArrayList<Projekt> projektArr = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);
                        for (Projekt aProjektArr : projektArr) {
                            if (Objects.equals(comboBoxProjekte.getSelectedItem().toString(), aProjektArr.getName())) {
                                textFieldStundensatz.setText(Float.toString(aProjektArr.getStundensatz()));
                                comboBoxBereich.setSelectedItem(aProjektArr.getBereich().getName());
                                comboBoxAuftraggeber.setSelectedItem(aProjektArr.getAuftraggeber().getNachname());
                                break;
                            }
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }}});


                    //Bearbeiten des jeweiligen Projekts
                    speichernButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Projekt newProjekt = new Projekt();


                            try {
                                ArrayList<Projekt> projektArr = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);
                                ArrayList<Bereich> bereichArr = Bereich.getObjectsFromJson(Bereich.read(Bereich.getPath()), Bereich[].class);
                                ArrayList<Auftraggeber> auftraggeberArr = Auftraggeber.getObjectsFromJson(Auftraggeber.read(Auftraggeber.getPath()), Auftraggeber[].class);


                                for (int i = 0; i < projektArr.size(); i++) {
                                    if (Objects.equals(comboBoxProjekte.getSelectedItem().toString(), projektArr.get(i).getName())) {
                                        newProjekt.setName(textFieldName.getText());
                                        newProjekt.setStundensatz(Float.parseFloat(textFieldStundensatz.getText()));
                                        System.out.println("for loop if 01");


                                        for (Bereich b : bereichArr) {
                                            if (Objects.equals(comboBoxBereich.getSelectedItem().toString(), b.getName())) {
                                                newProjekt.setBereich(new Bereich(b.getName()));
                                                System.out.println("for loop if 02");

                                            }
                                        }

                                        for (Auftraggeber a : auftraggeberArr) {
                                            if (Objects.equals(comboBoxAuftraggeber.getSelectedItem().toString(), a.getNachname())) {
                                            	Auftraggeber auftraggeber = new Auftraggeber(a.getVorname(), a.getNachname());
                                            	auftraggeber.setAdresse(a.getAdresse());
                                                newProjekt.setAuftraggeber(auftraggeber);
                                                System.out.println("for loop if 03");

                                            }
                                        }

                                        projektArr.set(i, newProjekt);
                                        Projekt.write(Projekt.getPath(), Projekt.getJsonFromObjects(projektArr));
                                        break;
                                    }
                                }

                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        }
                    });

                    //Löschen des jeweiligen Projekts
                    löschenButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                ArrayList<Projekt> projektArr = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);

                                for (int i = 0; i < projektArr.size(); i++) {
                                    if (Objects.equals(comboBoxProjekte.getSelectedItem().toString(), projektArr.get(i).getName())) {
                                        projektArr.remove(i);
                                        Projekt.write(Projekt.getPath(), Projekt.getJsonFromObjects(projektArr));
                                        break;
                                    }
                                }

                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        }
                    });





    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 2, new Insets(0, 0, 0, 0), -1, -1));
        textFieldName = new JTextField();
        mainPanel.add(textFieldName, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBoxBereich = new JComboBox();
        mainPanel.add(comboBoxBereich, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxAuftraggeber = new JComboBox();
        mainPanel.add(comboBoxAuftraggeber, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldStundensatz = new JTextField();
        mainPanel.add(textFieldStundensatz, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Bereich");
        mainPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Auftraggeber");
        mainPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Stundensatz");
        mainPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        speichernButton = new JButton();
        speichernButton.setText("Speichern");
        mainPanel.add(speichernButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        löschenButton = new JButton();
        löschenButton.setText("Löschen");
        mainPanel.add(löschenButton, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Name");
        mainPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxProjekte = new JComboBox();
        mainPanel.add(comboBoxProjekte, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Projekt auswählen");
        mainPanel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
