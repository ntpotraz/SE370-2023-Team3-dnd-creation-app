package edu.se370.team3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class GUI {

    private JFrame frame;
    private JPanel characterPanel, abilitiesPanel, proficiencyPanel, spellsPanel, equipmentPanel, summaryPanel;
    private JPanel[] panels;
    private int currentPanelIndex;

    private ArrayList<String> availableScores = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
    private ArrayList<JComboBox<String>> comboBoxes = new ArrayList<>();

    public GUI() {
        frame = new JFrame(); // create initial panel

        // comboBoxes = new JComboBox[6]; // Initialize the array for 6 abilities

        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // declare all panel to be used
        characterPanel = createCharacterPanel();
        abilitiesPanel = createAbilitiesPanel();
        proficiencyPanel = createProficiencyPanel();
        spellsPanel = createSpellsPanel();
        equipmentPanel = createEquipmentPanel();
        summaryPanel = createSummaryPanel();

        panels = new JPanel[] { characterPanel, abilitiesPanel, proficiencyPanel, spellsPanel, equipmentPanel,
                summaryPanel }; // array to switch panels
        currentPanelIndex = 0;

        frame.add(panels[currentPanelIndex]); // add current panel to initial panel
        frame.setVisible(true); // display panel
    }

    private JPanel createCharacterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // JPanel panel = new JPanel(new GridBagLayout());
        // GridBagConstraints c = new GridBagConstraints();

        // Increased font sizes
        Font labelFont = new Font("Serif", Font.PLAIN, 18); // Larger font for labels
        Font comboBoxFont = new Font("Serif", Font.PLAIN, 16); // Larger font for combo boxes

        // Create components
        JLabel lblTitle = new JLabel("D&D Character Creator");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        JTextField txtName = new JTextField(15);
        txtName.setFont(comboBoxFont); // Set font for text field
        JComboBox<String> cbClass = new JComboBox<>(new String[] {
                "Barbarian", "Bard", "Cleric", "Druid",
                "Fighter", "Monk", "Paladin", "Ranger",
                "Rogue", "Sorcerer", "Warlock", "Wizard"
        });
        cbClass.setPreferredSize(new Dimension(170, 30));
        cbClass.setFont(comboBoxFont); // Set font for combo box

        JComboBox<String> cbRace = new JComboBox<>(new String[] {
                "Hill Dwarf", "Mountain Dwarf", "High Elf", "Wood Elf", "Dark Elf",
                "Lightfoot", "Stout", "Human", "Dragonborn", "Forest Gnome", "Rock Gnome",
                "Half Elf", "Half Orc", "Tiefling"
        });
        cbRace.setPreferredSize(new Dimension(170, 30));
        cbRace.setFont(comboBoxFont); // Set font for combo box

        JComboBox<String> cbBackground = new JComboBox<>(new String[] {
                "Acolyte", "Charlatan", "Criminal/Spy", "Entertainer",
                "Folk Hero", "Guild Artisan", "Hermit", "Noble",
                "Outlander", "Sage", "Sailor", "Soldier", "Urchin"
        });
        cbBackground.setPreferredSize(new Dimension(170, 30));
        cbBackground.setFont(comboBoxFont); // Set font for combo box

        // Add components with GridBagConstraints for positioning
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 200, 0);
        panel.add(lblTitle, c);

        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setFont(labelFont); // Set font for label
        panel.add(nameLabel, c);
        c.gridx = 2;
        panel.add(txtName, c);

        c.gridx = 1;
        c.gridy = 2;
        JLabel classLabel = new JLabel("Character Class:");
        classLabel.setFont(labelFont); // Set font for label
        panel.add(classLabel, c);
        c.gridx = 2;
        panel.add(cbClass, c);

        c.gridx = 1;
        c.gridy = 3;
        JLabel raceLabel = new JLabel("Character Race:");
        raceLabel.setFont(labelFont); // Set font for label
        panel.add(raceLabel, c);
        c.gridx = 2;
        panel.add(cbRace, c);

        c.gridx = 1;
        c.gridy = 4;
        JLabel backgroundLabel = new JLabel("Character Background:");
        backgroundLabel.setFont(labelFont); // Set font for label
        panel.add(backgroundLabel, c);
        c.gridx = 2;
        panel.add(cbBackground, c);

        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(200, 0, 0, 0);

        createNextButton(panel, c);
        return panel;
    }

    private JPanel createAbilitiesPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // main panel
        JPanel abilitiesPanel = new JPanel(new GridBagLayout()); // abilities panel, will hold all the abilities with
                                                                 // their drop-down menus for results from rolling dices

        GridBagConstraints c = new GridBagConstraints(); // grid for main panel
        GridBagConstraints abi = new GridBagConstraints(); // grid for all abilities panels
        GridBagConstraints ind = new GridBagConstraints(); // grid for individual abilities

        // Center the title at the top of the panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER; // This will span the title across all columns
        c.insets = new Insets(100, 0, 0, 0);
        c.anchor = GridBagConstraints.CENTER; // Center align
        JLabel lblTitle = new JLabel("Calculate Abilities Score");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        panel.add(lblTitle, c);

        // add next button at the bottom of the panel
        c.insets = new Insets(0, 0, 100, 0);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = GridBagConstraints.REMAINDER; // This will span the title across all columns
        c.anchor = GridBagConstraints.CENTER; // Center align
        createNextButton(panel, c);

        // List of abilities
        String[] abilities = { "Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma" };

        abi.insets = new Insets(10, 10, 10, 10); // Add padding

        // create all the abilities panels with their drop-down menus
        for (int i = 0; i < abilities.length; i++) {
            JPanel abilityPanel = new JPanel(new GridBagLayout());
            ind.gridx = 0;
            ind.gridy = 0;

            JLabel label = new JLabel(abilities[i]);
            label.setFont(new Font("Serif", Font.PLAIN, 18));
            abilityPanel.add(label, ind);

            JComboBox<String> comboBox = new JComboBox<>(availableScores.toArray(new String[0]));
            comboBox.setPreferredSize(new Dimension(150, 30));
            comboBox.setFont(new Font("Serif", Font.PLAIN, 16));
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateAvailableScores();
                }
            });
            comboBoxes.add(comboBox); // Add the comboBox to the ArrayList

            ind.gridy = 1;
            abilityPanel.add(comboBox, ind);

            abi.gridx = i % 3;
            abi.gridy = i / 3;
            abilitiesPanel.add(abilityPanel, abi);
        }

        // Create button to clear selections in abilities scores
        JButton clearButton = new JButton("Clear Selections");
        clearButton.setFont(new Font("Serif", Font.PLAIN, 16)); // Set larger font
        clearButton.setPreferredSize(new Dimension(150, 30)); // Set larger size
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelections();
            }
        });

        // Add the button to the abilities panel
        abi.gridx = 1;
        abi.gridy = 3;
        abi.gridwidth = 1;
        abi.insets = new Insets(30, 0, 0, 0);
        abi.anchor = GridBagConstraints.CENTER;
        abilitiesPanel.add(clearButton, abi);

        // add abilities panel to main panel
        c.insets = new Insets(0, 0, 0, 0); // Add padding
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH; // Fill behavior
        panel.add(abilitiesPanel, c);

        // Panel for dices and dice roll button
        JPanel dicesPanel = new JPanel(new GridBagLayout()); // dice panel
        GridBagConstraints d = new GridBagConstraints(); // grid for dice panels

        d.insets = new Insets(10, 10, 10, 10);
        JPanel[] dicePanels = new JPanel[4];

        // create a panel for each individual dice to hold the result of the dices
        for (int i = 0; i < dicePanels.length; i++) {
            dicePanels[i] = new JPanel(new GridBagLayout());
            dicePanels[i].setPreferredSize(new Dimension(100, 100));
            dicePanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Position each panel in a 2x2 grid
            d.gridx = i % 2;
            d.gridy = i / 2;
            dicesPanel.add(dicePanels[i], d);
        }

        // adding dice panel to the main panel
        d.gridx = 0;
        d.gridy = 2;
        d.gridwidth = 2;
        JButton roll = new JButton("Roll Dices");
        roll.setFont(new Font("Serif", Font.PLAIN, 16)); // Set larger font
        roll.setPreferredSize(new Dimension(150, 30)); // Set larger size
        dicesPanel.add(roll, d);

        // add dice panel to main panel
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(0, 300, 0, 0);
        c.fill = GridBagConstraints.BOTH; // Fill behavior
        panel.add(dicesPanel, c);

        return panel;
    }

    private JPanel createProficiencyPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        JPanel proficiency = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); // Grid for main panel
        GridBagConstraints p = new GridBagConstraints();

        // Add the title of the panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(100, 0, 20, 0);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Proficiency");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        panel.add(lblTitle, c);

        // Skills
        String[] skills = { "Athletics", "Acrobatics", "Sleight of Hand", "Stealth",
                "Arcana", "History", "Investigation", "Nature", "Religion",
                "Animal Handling", "Insight", "Medicine", "Perception",
                "Survival", "Deception", "Intimidation", "Performance", "Persuasion" };

        p.insets = new Insets(10, 10, 10, 10);

        for (int i = 0; i < skills.length; i++) {
            p.gridx = 2 * (i % 5); // Arrange in 5 columns, leaving space for text fields
            p.gridy = i / 5; // Increment rows after every 5 skills

            JCheckBox checkBox = new JCheckBox(skills[i]);
            checkBox.setFont(new Font("Serif", Font.PLAIN, 18)); // Set font for checkboxes
            proficiency.add(checkBox, p);

            JTextField textField = new JTextField(3);
            textField.setEditable(false);
            textField.setFont(new Font("Serif", Font.PLAIN, 18)); // Set font for text fields

            // Add listener to checkbox
            checkBox.addItemListener(e -> {
                if (checkBox.isSelected()) {
                    textField.setText("  +2");
                } else {
                    textField.setText("");
                }
            });

            // Increment gridx for text field
            p.gridx++;
            proficiency.add(textField, p);
        }

        // Add Next button
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(20, 0, 100, 0); // Adjust the inset for the button
        c.anchor = GridBagConstraints.CENTER;
        createNextButton(panel, c);

        c.insets = new Insets(20, 0, 20, 0); // Adjust the inset for the button
        c.gridy = 1;
        panel.add(proficiency, c);

        return panel;
    }

    private JPanel createSpellsPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        JPanel Book = new JPanel(new GridBagLayout()); // Book panel (Used for spellbook)
        JPanel Spells = new JPanel(new GridBagLayout()); // Spells panel

        GridBagConstraints c = new GridBagConstraints(); // Grid for main panel
        GridBagConstraints s = new GridBagConstraints(); // grid for spellBook panel and spells panel

        // Add the title of the panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(100, 0, 0, 0);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Spells");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        panel.add(lblTitle, c);

        // add next button
        c.insets = new Insets(0, 0, 100, 0);
        c.gridy = 2;
        createNextButton(panel, c);

        c.gridwidth = 1;

        // JTextArea to display selected cantrips
        JTextArea cantripSB = new JTextArea(12, 25); // selected SB
        cantripSB.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        cantripSB.setBorder(border);

        // JTextArea to display selected lvl 1 spells
        JTextArea spellBook = new JTextArea(12, 25);
        spellBook.setEditable(false);
        spellBook.setBorder(border);

        // add spellbook (text area) and subtitle ("Spellbook") to Book panel to main
        // panel
        s.gridx = 0;
        s.gridy = 0;
        JLabel txtTitle = new JLabel("Spellbook");
        txtTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        Book.add(txtTitle, s);
        s.gridy = 1;
        Book.add(cantripSB, s);
        s.gridy = 2;
        Book.add(spellBook, s);

        // add dropdown menus for selecting spells and add them to the Spell panel
        // Dropdown menu for "Cantrips"
        s.gridx = 0;
        s.gridy = 0;
        s.insets = new Insets(5, 20, 5, 20);
        Spells.add(createDropdownMenu(new String[] { "Option 1", "Option 2", "Option 3" }, "Cantrips", cantripSB), s);

        // Dropdown menu for "Lvl 1 Spells"
        s.gridy = 1;
        Spells.add(createDropdownMenu(new String[] { "Spell 1", "Spell 2", "Spell 3" }, "Lvl 1 Spells", spellBook), s);

        // add Book and Spells panels to the main panel
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, 0, 0, 0);
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(Spells, c);
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 2;
        c.insets = new Insets(0, 0, 0, 0);
        panel.add(Book, c);

        return panel;
    }

    private JPanel createEquipmentPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        JPanel Equip = new JPanel(new GridBagLayout()); // Equipment panel -- used for weapons and armor
        JPanel Inventory = new JPanel(new GridBagLayout()); // Inventory panel -- used for displaying selected weapons
                                                            // and armor

        GridBagConstraints c = new GridBagConstraints(); // Grid for main panel
        GridBagConstraints e = new GridBagConstraints(); // grid for Equipment panel and Weapons panels

        // Add the title of the panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(100, 0, 0, 50);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Weapons & Armor");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(lblTitle, c);

        // add next button
        c.insets = new Insets(0, 0, 100, 0);
        c.gridx = 0;
        c.gridy = 2;
        createNextButton(panel, c);

        c.gridwidth = 1;

        // JTextArea to display selected options
        JTextArea weapInv = new JTextArea(12, 25); // inv (inventory) will display all the armor and weapons selected
        weapInv.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        weapInv.setBorder(border);

        JTextArea equipInv = new JTextArea(12, 25); // inv (inventory) will display all the armor and weapons selected
        equipInv.setEditable(false);
        equipInv.setBorder(border);

        // add Inventory (text area) and subtitle ("Inventory") to Inventory panel
        e.gridx = 0;
        e.gridy = 0;
        JLabel txtTitle = new JLabel("Inventory");
        txtTitle.setFont(new Font("Serif", Font.PLAIN, 26));
        Inventory.add(txtTitle, e);

        e.gridy = 1;
        Inventory.add(weapInv, e);
        e.gridy = 2;
        Inventory.add(equipInv, e);

        // add dropdown menus for selecting weapons and add them to the Equip panel
        // Dropdown menu for "Weapons"
        e.gridx = 0;
        e.gridy = 0;
        e.insets = new Insets(5, 5, 5, 5);
        Equip.add(createDropdownMenu(new String[] { "Weapon 1", "Weapon 2", "Weapon 3" }, "Weapons", weapInv), e);

        // Dropdown menu for "Armor"
        e.gridy = 1;
        Equip.add(createDropdownMenu(new String[] { "Armor 1", "Armor 2", "Armor 3" }, "Armor", equipInv), e);

        // add Equip and Inventory panels to the main panel
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(Equip, c);
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 2;
        panel.add(Inventory, c);

        return panel;
    }

    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        GridBagConstraints c = new GridBagConstraints(); // Grid for main panel

        // Add the title of the panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(100, 0, 0, 0);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Summary");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        panel.add(lblTitle, c);

        // add next button
        c.insets = new Insets(0, 0, 100, 0);
        c.gridy = 2;
        createNextButton(panel, c);

        return panel;
    }

    private void updateAvailableScores() {
        HashSet<String> selectedScores = new HashSet<>();
        for (JComboBox<String> comboBox : comboBoxes) {
            String selected = (String) comboBox.getSelectedItem(); // Explicit cast to String
            if (selected != null && !selected.isEmpty()) {
                selectedScores.add(selected);
            }
        }

        // Create a new list of available scores
        ArrayList<String> newAvailableScores = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        newAvailableScores.removeAll(selectedScores);

        for (JComboBox<String> comboBox : comboBoxes) {
            String currentSelection = (String) comboBox.getSelectedItem();

            // Temporarily remove the action listener to prevent unnecessary events
            ActionListener[] listeners = comboBox.getActionListeners();
            for (ActionListener listener : listeners) {
                comboBox.removeActionListener(listener);
            }

            // Update the items of the comboBox
            comboBox.setModel(new DefaultComboBoxModel<>(newAvailableScores.toArray(new String[0])));
            if (currentSelection != null && !currentSelection.isEmpty()) {
                comboBox.addItem(currentSelection);
            }
            comboBox.setSelectedItem(currentSelection);

            // Re-add the action listeners
            for (ActionListener listener : listeners) {
                comboBox.addActionListener(listener);
            }
        }
    }

    private void clearSelections() {
        for (JComboBox<String> comboBox : comboBoxes) {
            comboBox.setSelectedIndex(-1); // Clear selection
        }
        updateAvailableScores(); // Update available scores after clearing selections
    }

    // function to create the drop-down menus with the check marks for selecting
    // spells and equipment. It adds the selected element to the "spellbook" and
    // removes it if unchecked
    private JPanel createDropdownMenu(String[] options, String label, JTextArea textArea) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Serif", Font.PLAIN, 18)); // Larger font for label

        JButton button = new JButton("Select");
        button.setFont(new Font("Serif", Font.PLAIN, 18)); // Larger font for button
        button.setPreferredSize(new Dimension(120, 30)); // Larger size for button

        JPopupMenu menu = new JPopupMenu();
        menu.setPreferredSize(new Dimension(200, 30 * options.length)); // Set larger size for menu

        Font menuItemFont = new Font("Serif", Font.PLAIN, 16); // Larger font for menu items
        Font textAreaFont = new Font("Serif", Font.PLAIN, 18); // Larger font for text area
        textArea.setFont(textAreaFont); // Set the larger font for the text area

        for (String option : options) {
            JCheckBoxMenuItem item = new JCheckBoxMenuItem(option);
            item.setFont(menuItemFont); // Set larger font for menu item
            menu.add(item);

            // Listener to update the JTextArea on item state change
            item.addItemListener(e -> {
                StringBuilder selectedText = new StringBuilder();

                for (Component component : menu.getComponents()) {
                    if (component instanceof JCheckBoxMenuItem) {
                        JCheckBoxMenuItem checkBox = (JCheckBoxMenuItem) component;
                        if (checkBox.isSelected()) {
                            selectedText.append(checkBox.getText()).append("\n");
                        }
                    }
                }

                textArea.setText(selectedText.toString());
            });
        }

        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menu.show(button, 0, button.getHeight());
            }
        });

        panel.add(lbl);
        panel.add(button);

        return panel;
    }

    // This function creates the "next button" that is used on every panel to switch
    // to the next
    private void createNextButton(JPanel panel, GridBagConstraints constraints) {
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Serif", Font.PLAIN, 16)); // Set larger font
        nextButton.setPreferredSize(new Dimension(120, 30)); // Set larger size

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel();
            }
        });
        panel.add(nextButton, constraints);
    }

    // function for the dice roll -- needs to be implemented if we decide to do it
    // in here instead of the back-end

    // function that switches panels once the "next" button is clicked
    private void switchPanel() {
        frame.getContentPane().remove(panels[currentPanelIndex]);
        currentPanelIndex = (currentPanelIndex + 1) % panels.length;
        frame.getContentPane().add(panels[currentPanelIndex]);
        frame.revalidate();
        frame.repaint();
    }

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
