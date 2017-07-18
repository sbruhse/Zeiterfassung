package frontend;

import backend.Auftraggeber;
import backend.Bereich;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import sun.security.util.AuthResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by sellmer on 18.07.17.
 */
public class EditAuftraggeberWindow {
    public JPanel editAuftraggeberPanel;
    private JComboBox auftraggeberAll;
    private JTextField auftraggeberVorname;
    private JTextField auftraggeberNachname;
    private JTextField auftraggeberStadt;
    private JTextField auftraggeberPostleitzahl;
    private JTextField auftraggeberStrasse;
    private JButton speichernButton;
    private JButton löschenButton;

    public EditAuftraggeberWindow() {
       ArrayList<Auftraggeber> auftraggeber = new ArrayList<>();

        try {
            auftraggeber = Auftraggeber.getObjectsFromJson(Auftraggeber.read(Auftraggeber.getPath()), Auftraggeber[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Hinzufügen der Auftraggeber in die ComboBox
        for (Auftraggeber p : auftraggeber) auftraggeberAll.addItem(p);

        //Wartet auf Auswahl und zeigt diese dann im Namensfenster an
        auftraggeberAll.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        ArrayList<Auftraggeber> AuftraggeberArr = Auftraggeber.getObjectsFromJson(Auftraggeber.read(Auftraggeber.getPath()), Auftraggeber[].class);
                        for (Auftraggeber aAuftraggeberArr : AuftraggeberArr) {
                            if (Objects.equals(auftraggeberAll.getSelectedItem().toString(), aAuftraggeberArr.getNachname())) {
                                auftraggeberVorname.setText(aAuftraggeberArr.getVorname());
                                auftraggeberNachname.setText(aAuftraggeberArr.getNachname());
                                auftraggeberStadt.setText(aAuftraggeberArr.getStadt());
                                auftraggeberPostleitzahl.setText(aAuftraggeberArr.getPlz());
                                auftraggeberStrasse.setText(aAuftraggeberArr.getStrasse());
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
                Auftraggeber newAuftraggeber = new Auftraggeber();

                try {
                    ArrayList<Auftraggeber> AuftraggeberArr = Auftraggeber.getObjectsFromJson(Auftraggeber.read(Auftraggeber.getPath()), Auftraggeber[].class);

                    for (int i = 0; i < AuftraggeberArr.size(); i++) {
                        if (Objects.equals(auftraggeberAll.getSelectedItem().toString(), AuftraggeberArr.get(i).getNachname())) {
                            newAuftraggeber.setVorname((auftraggeberVorname.getText()));
                            newAuftraggeber.setNachname((auftraggeberNachname.getText()));
                            newAuftraggeber.setStadt((auftraggeberStadt.getText()));
                            newAuftraggeber.setPlz((auftraggeberPostleitzahl.getText()));
                            newAuftraggeber.setStrasse((auftraggeberStrasse.getText()));
                            AuftraggeberArr.set(i, newAuftraggeber);
                            Auftraggeber.write(Auftraggeber.getPath(), Auftraggeber.getJsonFromObjects(AuftraggeberArr));
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

                try {
                    ArrayList<Auftraggeber> auftraggeberArr = Auftraggeber.getObjectsFromJson(Auftraggeber.read(Auftraggeber.getPath()), Auftraggeber[].class);

                    for (int i = 0; i < auftraggeberArr.size(); i++) {
                        if (Objects.equals(auftraggeberAll.getSelectedItem().toString(), auftraggeberArr.get(i).getNachname())) {
                            auftraggeberArr.remove(i);
                            Auftraggeber.write(Auftraggeber.getPath(), Auftraggeber.getJsonFromObjects(auftraggeberArr));
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
        editAuftraggeberPanel = new JPanel();
        editAuftraggeberPanel.setLayout(new GridLayoutManager(8, 2, new Insets(0, 0, 0, 0), -1, -1));
        auftraggeberAll = new JComboBox();
        editAuftraggeberPanel.add(auftraggeberAll, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Auftraggeber");
        editAuftraggeberPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        auftraggeberVorname = new JTextField();
        editAuftraggeberPanel.add(auftraggeberVorname, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Vorname");
        editAuftraggeberPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        auftraggeberNachname = new JTextField();
        editAuftraggeberPanel.add(auftraggeberNachname, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Nachname");
        editAuftraggeberPanel.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        auftraggeberStadt = new JTextField();
        editAuftraggeberPanel.add(auftraggeberStadt, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Stadt");
        editAuftraggeberPanel.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        auftraggeberPostleitzahl = new JTextField();
        editAuftraggeberPanel.add(auftraggeberPostleitzahl, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Postleitzahl");
        editAuftraggeberPanel.add(label5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        auftraggeberStrasse = new JTextField();
        editAuftraggeberPanel.add(auftraggeberStrasse, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Straße");
        editAuftraggeberPanel.add(label6, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        speichernButton = new JButton();
        speichernButton.setText("Speichern");
        editAuftraggeberPanel.add(speichernButton, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        löschenButton = new JButton();
        löschenButton.setText("Löschen");
        editAuftraggeberPanel.add(löschenButton, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return editAuftraggeberPanel;
    }
}
