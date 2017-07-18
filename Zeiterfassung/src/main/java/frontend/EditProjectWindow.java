package frontend;

import backend.Auftraggeber;
import backend.Bereich;
import backend.Projekt;
import com.google.gson.JsonPrimitive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by steven on 17.07.17.
 */
public class EditProjectWindow {
    public JPanel EditPrPanel;
    private JTextField textFieldName;
    private JComboBox comboBoxUeberProj;
    private JComboBox comboBoxBereich;
    private JComboBox comboBoxAuftraggeber;
    private JButton EditButton;


    public EditProjectWindow() {

        EditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String testString = "Modified";


                Projekt newProjekt = new Projekt();
                newProjekt.setName(textFieldName.getText());
                newProjekt.setBereich((Bereich) comboBoxBereich.getSelectedItem());
                newProjekt.setAuftraggeber((Auftraggeber) comboBoxAuftraggeber.getSelectedItem());
                ArrayList<Projekt> speicherprojekte = new ArrayList<>();
                if (comboBoxUeberProj.getSelectedItem() != null)
                    speicherprojekte.add((Projekt) comboBoxUeberProj.getSelectedItem());
                //newProjekt.setUnterprojekt(speicherprojekte);

                System.out.println("Original: " + speicherprojekte.get(0).getName());
                speicherprojekte.get(0).setName(testString);
                System.out.println("Modified: " + speicherprojekte.get(0).getName());

                try {
                    ArrayList<Projekt> projekte = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);
                    System.out.println(projekte.get(0).getName());
                    projekte.add(newProjekt);
                    Projekt.write(Projekt.getPath(), Projekt.getJsonFromObjects(projekte));

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //setVisible(false);
            }
        });


        ArrayList<Projekt> projekte = new ArrayList<>();
        ArrayList<Bereich> bereiche = new ArrayList<>();
        ArrayList<Auftraggeber> auftraggeber = new ArrayList<>();
        try {
            projekte = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);

            /*for (int i = 0; i < projekte.toArray().length; i++) {
                if(projekte.get(i).getName().equals(testString)) {
                    comboBoxAuftraggeber.setSelectedItem(projekte.get(i).getAuftraggeber().getNachname());
                }
            }*/


            bereiche = Bereich.getObjectsFromJson(Bereich.read(Bereich.getPath()), Bereich[].class);
            auftraggeber = Auftraggeber.getObjectsFromJson(Auftraggeber.read(Auftraggeber.getPath()), Auftraggeber[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Projekt p : projekte) comboBoxUeberProj.addItem(p);
        for (Bereich p : bereiche) comboBoxBereich.addItem(p);
        for (Auftraggeber p : auftraggeber) comboBoxAuftraggeber.addItem(p);

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
        EditPrPanel = new JPanel();
        EditPrPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 2, new Insets(10, 10, 10, 10), -1, -1));
        textFieldName = new JTextField();
        textFieldName.setText("");
        EditPrPanel.add(textFieldName, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBoxUeberProj = new JComboBox();
        EditPrPanel.add(comboBoxUeberProj, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxBereich = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        comboBoxBereich.setModel(defaultComboBoxModel1);
        EditPrPanel.add(comboBoxBereich, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxAuftraggeber = new JComboBox();
        EditPrPanel.add(comboBoxAuftraggeber, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Name");
        EditPrPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Übergeordnetes Proj.");
        EditPrPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Bereich");
        EditPrPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Auftraggeber");
        EditPrPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        EditPrPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        EditButton = new JButton();
        EditButton.setText("Bearbeiten");
        panel1.add(EditButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return EditPrPanel;
    }
}
