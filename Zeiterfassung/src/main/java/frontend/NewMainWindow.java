package frontend;

import backend.Arbeitsblock;
import backend.Aufgaben;
import backend.Bereich;
import backend.Projekt;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sbruhse on 17.07.2017.
 */
public class NewMainWindow extends JFrame {
    public JPanel mainPanel;
    public Arbeitsblock aktuellerBlock;
    private JButton auftraggeberHinzufuegen;
    private JButton identitätenNeuButton;
    private JPanel leftPanel;
    private JTree treeProjekte;
    private JPanel centerPanel;
    private JButton startButton;
    private JButton stopButton;
    private JTextArea textArea1;
    private JComboBox cBAufgabe;
    private JLabel labelStart;
    private JLabel labelZeit;
    private JButton druckenButton;
    private JButton bearbeitenButton;
    private JButton löschenButton;
    private JButton auftraggeberBearbeitenButton;
    private JButton identitätenBearbeitenButton;
    private JButton projektNeuButton;
    private JButton bereichNeuButton;
    private JButton aufgabeNeuButton;
    private JButton aufgabeBearbeitenButton;

    Projekt selectedProjekt = null;

    public NewMainWindow() {

        aktuellerBlock = new Arbeitsblock();

        loadProjektTree();
        loadAufgaben();
        //Combobox füllen
        ArrayList<Aufgaben> aufgabenliste = new ArrayList<>();
        try {
            aufgabenliste = Aufgaben.getObjectsFromJson(Aufgaben.read(Aufgaben.path), Aufgaben[].class);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        for (Aufgaben a : aufgabenliste) cBAufgabe.addItem(a);


        //Eventhandler
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aktuellerBlock.arbeitsblockStarten();
                datenSetzen();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aktuellerBlock.arbeitsblockStoppen();
                datenSetzen();

                try {
                    //Gespeicherte Blöcke laden und hinzufügen
                    ArrayList<Arbeitsblock> bloecke = Arbeitsblock.getObjectsFromJson(Arbeitsblock.read(Arbeitsblock.getPath()), Arbeitsblock[].class);
                    bloecke.add(aktuellerBlock);
                    Arbeitsblock.write(Arbeitsblock.getPath(), Arbeitsblock.getJsonFromObjects(bloecke));

                    //Block zurücksetzen
                    aktuellerBlock = new Arbeitsblock();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });

        cBAufgabe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        treeProjekte.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeProjekte.getLastSelectedPathComponent();
                if (node == null || node.getUserObject().getClass() == Bereich.class)
                    selectedProjekt = null;
                else
                    selectedProjekt = (Projekt) node.getUserObject();

                loadAufgaben();
            }
        });
        druckenButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        bearbeitenButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        löschenButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }


    public void datenSetzen() {
        aktuellerBlock.setBeschreibung(textArea1.getText());
        aktuellerBlock.setAufgabe((Aufgaben) cBAufgabe.getSelectedItem());
    }

    public void loadAufgaben() {
        if (selectedProjekt != null) {

            ArrayList<Aufgaben> aufgaben = Aufgaben.getAufgaben(selectedProjekt);

            cBAufgabe.removeAllItems();
            for(Aufgaben a:aufgaben)
                cBAufgabe.addItem(a);
        } else
            cBAufgabe.removeAllItems();
    }

    public void loadProjektTree() {

        TreeModel projektTreeModel;

        try {

            ArrayList<Bereich> bereiche = Bereich.getObjectsFromJson(Bereich.read(Bereich.getPath()), Bereich[].class);
            ArrayList<Projekt> projekte = Projekt.getObjectsFromJson(Projekt.read(Projekt.getPath()), Projekt[].class);

            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Projekte");

            for (Bereich b : bereiche) {
                DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(b);
                for (Projekt p : projekte) {
                    if (p.getBereich().getName().equals(b.getName())) {
                        defaultMutableTreeNode.add(new DefaultMutableTreeNode(p));
                    }

                }
                root.add(defaultMutableTreeNode);
            }

            treeProjekte.setModel(new DefaultTreeModel(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
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
        mainPanel.setLayout(new BorderLayout(0, 0));
        final JToolBar toolBar1 = new JToolBar();
        mainPanel.add(toolBar1, BorderLayout.NORTH);
        auftraggeberHinzufuegen = new JButton();
        auftraggeberHinzufuegen.setText("Auftraggeber");
        toolBar1.add(auftraggeberHinzufuegen);
        identitätenNeuButton = new JButton();
        identitätenNeuButton.setText("Identitäten");
        toolBar1.add(identitätenNeuButton);
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(leftPanel, BorderLayout.WEST);
        treeProjekte = new JTree();
        leftPanel.add(treeProjekte, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JToolBar toolBar2 = new JToolBar();
        leftPanel.add(toolBar2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
        druckenButton = new JButton();
        druckenButton.setText("Drucken");
        toolBar2.add(druckenButton);
        bearbeitenButton = new JButton();
        bearbeitenButton.setText("Bearbeiten");
        toolBar2.add(bearbeitenButton);
        löschenButton = new JButton();
        löschenButton.setText("Löschen");
        toolBar2.add(löschenButton);
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        centerPanel.setMinimumSize(new Dimension(400, 300));
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        centerPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spacer1, gbc);
        stopButton = new JButton();
        stopButton.setText("Stop");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(stopButton, gbc);
        startButton = new JButton();
        startButton.setText("Start");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(startButton, gbc);
        final Spacer spacer2 = new Spacer();
        centerPanel.add(spacer2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        centerPanel.add(panel2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Startzeit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label1, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(spacer3, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Vergangene Zeit");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label2, gbc);
        labelStart = new JLabel();
        labelStart.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(labelStart, gbc);
        labelZeit = new JLabel();
        labelZeit.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(labelZeit, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        centerPanel.add(panel3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        cBAufgabe = new JComboBox();
        panel3.add(cBAufgabe, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textArea1 = new JTextArea();
        panel3.add(textArea1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final Spacer spacer4 = new Spacer();
        centerPanel.add(spacer4, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
