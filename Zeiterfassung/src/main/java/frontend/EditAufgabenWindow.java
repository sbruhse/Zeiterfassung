package frontend;


import backend.Aufgaben;
import backend.Projekt;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

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
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by steven on 18.07.17.
 */
public class EditAufgabenWindow {
    public JPanel editAufgabenPanel;
    private JComboBox aufgabenAll;
    private JTextField aufgabenName;
    private JTextField aufgabenBeschreibung;
    private JTextField deadline;
    private JComboBox zugProjekt;
    private JButton speichernButton;
    private JButton löschenButton;

    public EditAufgabenWindow() {
        ArrayList<Aufgaben> aufgaben = new ArrayList<>();
        ArrayList<Projekt> projekte = new ArrayList<>();

        try {
            aufgaben = Aufgaben.getObjectsFromJson(Aufgaben.read(Aufgaben.getPath()), Aufgaben[].class);
            projekte = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Hinzufügen der Bereiche in die CombosBox
        for (Aufgaben p : aufgaben) aufgabenAll.addItem(p);
        for (Projekt a : projekte) zugProjekt.addItem(a);
        //for (Aufgaben o : aufgaben) zugProjekt.addItem(o.getProjekt());


        for (Aufgaben aAufgabenArr : aufgaben) {
            if (Objects.equals(aufgabenAll.getSelectedItem().toString(), aAufgabenArr.getTaskName())) {
                aufgabenName.setText(aAufgabenArr.getTaskName());
                aufgabenBeschreibung.setText(aAufgabenArr.getTaskDescription());

                DateFormat date = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
                String dateString = date.format(aAufgabenArr.getTaskDeadline());

                deadline.setText(dateString);

                zugProjekt.setSelectedItem(aAufgabenArr.getProjekt().getName());

                break;
            }
        }


        //Wartet auf Auswahl und zeigt diese dann im Namensfenster an
        aufgabenAll.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    try {
                        ArrayList<Aufgaben> AufgabenArr = Aufgaben.getObjectsFromJson(Aufgaben.read(Aufgaben.getPath()), Aufgaben[].class);
                        for (Aufgaben aAufgabenArr : AufgabenArr) {
                            if (Objects.equals(aufgabenAll.getSelectedItem().toString(), aAufgabenArr.getTaskName())) {
                                aufgabenName.setText(aAufgabenArr.getTaskName());
                                aufgabenBeschreibung.setText(aAufgabenArr.getTaskDescription());

                                DateFormat date = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
                                String dateString = date.format(aAufgabenArr.getTaskDeadline());

                                deadline.setText(dateString);

                                //for (Aufgaben o : AufgabenArr) zugProjekt.addItem(o.getProjekt());
                                //zugProjekt.addItem(aAufgabenArr.getProjekt());
                                zugProjekt.setSelectedItem(aAufgabenArr.getProjekt().getName());


                                break;
                            }
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });

        //Bearbeiten des jeweiligen Bereiches
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aufgaben newAufgaben = new Aufgaben();

                try {
                    ArrayList<Aufgaben> aufgabenArr = Aufgaben.getObjectsFromJson(Aufgaben.read(Aufgaben.getPath()), Aufgaben[].class);

                    for (int i = 0; i < aufgabenArr.size(); i++) {
                        if (Objects.equals(aufgabenAll.getSelectedItem().toString(), aufgabenArr.get(i).getTaskName())) {
                            newAufgaben.setTaskName(aufgabenName.getText());
                            newAufgaben.setTaskDescription(aufgabenBeschreibung.getText());
                            newAufgaben.setTaskDeadline(deadline.getText());

                            aufgabenArr.set(i, newAufgaben);
                            Aufgaben.write(Aufgaben.getPath(), Aufgaben.getJsonFromObjects(aufgabenArr));
                            break;
                        }
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

        //Löschen des jeweiligen Bereiches
        löschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aufgaben newBereich = new Aufgaben();

                try {
                    ArrayList<Aufgaben> bereicheArr = Aufgaben.getObjectsFromJson(Aufgaben.read(Aufgaben.getPath()), Aufgaben[].class);

                    for (int i = 0; i < bereicheArr.size(); i++) {
                        if (Objects.equals(aufgabenAll.getSelectedItem().toString(), bereicheArr.get(i).getTaskName())) {
                            bereicheArr.remove(i);
                            Aufgaben.write(Aufgaben.getPath(), Aufgaben.getJsonFromObjects(bereicheArr));
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
        editAufgabenPanel = new JPanel();
        editAufgabenPanel.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        aufgabenAll = new JComboBox();
        editAufgabenPanel.add(aufgabenAll, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Aufgaben: ");
        editAufgabenPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aufgabenName = new JTextField();
        editAufgabenPanel.add(aufgabenName, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Aufgabenname: ");
        editAufgabenPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Beschreibung: ");
        editAufgabenPanel.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aufgabenBeschreibung = new JTextField();
        aufgabenBeschreibung.setText("");
        editAufgabenPanel.add(aufgabenBeschreibung, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Fälligkeit: ");
        editAufgabenPanel.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deadline = new JTextField();
        editAufgabenPanel.add(deadline, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        zugProjekt = new JComboBox();
        editAufgabenPanel.add(zugProjekt, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        editAufgabenPanel.add(panel1, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        speichernButton = new JButton();
        speichernButton.setText("Speichern");
        panel1.add(speichernButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        löschenButton = new JButton();
        löschenButton.setText("Löschen");
        panel1.add(löschenButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("zugeordnetes Projekt: ");
        editAufgabenPanel.add(label5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return editAufgabenPanel;
    }
}
