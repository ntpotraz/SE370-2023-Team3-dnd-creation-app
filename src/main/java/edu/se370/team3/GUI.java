package edu.se370.team3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GUI {

    private JFrame frame;
    private JPanel characterPanel, abilitiesPanel, proficiencyPanel, spellsPanel, equipmentPanel, summaryPanel;
    private JPanel[] panels;
    private int currentPanelIndex;
    private Stats stats; // Add this line to create a Stats instance
    Character character = new Character();
    private int rollCount = 0;
    private int[] selectedScores;

    private ArrayList<String> availableScores = new ArrayList<>(Arrays.asList());
    private ArrayList<JComboBox<String>> comboBoxes = new ArrayList<>();

    public GUI() throws IOException {
        frame = new JFrame(); // create initial panel

        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        characterPanel = createCharacterPanel();
        panels = new JPanel[6]; // Initialize the array but don't create all panels yet
        panels[0] = characterPanel; // Only add the first panel

        currentPanelIndex = 0;

        frame.add(panels[currentPanelIndex]); // add current panel to frame
        frame.setVisible(true); // display panel
    }

    private JPanel createCharacterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

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
                "Acolyte", "Charlatan", "Criminal", "Entertainer",
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

        JButton btnNext = new JButton("Next");
        btnNext.setPreferredSize(new Dimension(120, 30)); // Set larger size
        btnNext.setFont(new Font("Serif", Font.PLAIN, 16));
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.setName(txtName.getText());

                character.setJob((String) cbClass.getSelectedItem());
                character.addHealth(character.getJob().getBaseHP());

                character.setRace((String) cbRace.getSelectedItem());
                character.addHealth(character.getRace().getHealthModifer());

                character.setBackground((String) cbBackground.getSelectedItem());

                switchPanel();
            }
        });
        panel.add(btnNext, c);
        return panel;
    }

    private JPanel createAbilitiesPanel() {
        stats = new Stats();

        JPanel panel = new JPanel(new GridBagLayout()); // main panel
        JPanel abilitiesPanel = new JPanel(new GridBagLayout()); // abilities panel, will hold all the abilities with
                                                                 // their drop-down menus for results from rolling dices

        GridBagConstraints c = new GridBagConstraints(); // grid for main panel
        GridBagConstraints abi = new GridBagConstraints(); // grid for all abilities panels
        GridBagConstraints ind = new GridBagConstraints(); // grid for individual abilities

        // Center the title at the top of the panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(100, 0, 0, 0);
        c.anchor = GridBagConstraints.CENTER; // Center align
        JLabel lblTitle = new JLabel("Calculate Abilities Score");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        panel.add(lblTitle, c);

        c.gridy = 1;
        c.anchor = GridBagConstraints.SOUTH; // Center align
        JLabel lblInst = new JLabel("Roll the dices 6 times. Then, select the desire score for each ability");
        lblInst.setFont(new Font("Serif", Font.PLAIN, 18));
        panel.add(lblInst, c);
        c.anchor = GridBagConstraints.CENTER;

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
        c.insets = new Insets(100, 0, 0, 0); // Add padding
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 1;
        panel.add(abilitiesPanel, c);

        // Panel for dices and dice roll button
        JPanel dicesPanel = new JPanel(new GridBagLayout()); // dice panel
        GridBagConstraints d = new GridBagConstraints(); // grid for dice panels

        d.insets = new Insets(10, 10, 10, 10);
        JPanel[] dicePanels = new JPanel[4];
        JLabel[] diceLabels = new JLabel[4]; // Array to store labels for dice results

        // create a panel for each individual dice to hold the result of the dices
        for (int i = 0; i < dicePanels.length; i++) {
            dicePanels[i] = new JPanel(new GridBagLayout());
            dicePanels[i].setPreferredSize(new Dimension(100, 100));
            dicePanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Create and add a label to each dice panel
            diceLabels[i] = new JLabel("0"); // Initial value
            diceLabels[i].setFont(new Font("Serif", Font.BOLD, 24)); // Example styling
            dicePanels[i].add(diceLabels[i]);

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

        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stats.rollDice();
                Roll lastRoll = stats.getRolls().get(stats.getRolls().size() - 1); // Get the latest roll

                // Draw dice faces based on the roll results
                drawDiceFace(dicePanels[0], lastRoll.getFirstDice());
                drawDiceFace(dicePanels[1], lastRoll.getSecondDice());
                drawDiceFace(dicePanels[2], lastRoll.getThirdDice());
                drawDiceFace(dicePanels[3], lastRoll.getLowestDie());

                // Update the available scores
                availableScores.add(Integer.toString(lastRoll.getTotal()));
                updateAvailableScores();

                rollCount++;
                if (rollCount >= 6) {
                    roll.setEnabled(false); // Disables the button
                    roll.setOpaque(true); // Makes the button opaque
                }

            }
        });

        // add dice panel to main panel
        c.gridx = 3;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(100, 300, 0, 0);
        panel.add(dicesPanel, c);

        // add next button at the bottom of the panel
        c.insets = new Insets(0, 0, 100, 0);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Serif", Font.PLAIN, 16));
        nextButton.setPreferredSize(new Dimension(120, 30));

        selectedScores = new int[comboBoxes.size()];

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < comboBoxes.size(); i++) {
                    JComboBox<String> comboBox = comboBoxes.get(i);
                    selectedScores[i] = Integer.parseInt((String) comboBox.getSelectedItem());
                }
                // modify stats based on the selections
                try {
                    character.getStats().modifyStats(selectedScores);
                    character.getStats().modifyStats(character.getRace().getStatMods());
                    character.addHealth(character.getStats().getDexMod());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                switchPanel();
            }
        });
        panel.add(nextButton, c);

        return panel;
    }

    private JPanel createProficiencyPanel() {

        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        JPanel proficiency = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints p = new GridBagConstraints();

        character.getSkills().insertModifiers(character.getStats().getMods());
        character.getSkills().addProficiency(character.getJob().getSkills());
        character.getSkills().addProficiency(character.getBackground().getSkills());

        // Add the title of the panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(100, 0, 20, 0);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Proficiency");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        panel.add(lblTitle, c);

        c.gridy = 1;
        c.anchor = GridBagConstraints.SOUTH; // Center align
        JLabel lblInst = new JLabel("Choose those skills you want to be proficient in");
        lblInst.setFont(new Font("Serif", Font.PLAIN, 18));
        panel.add(lblInst, c);
        c.anchor = GridBagConstraints.CENTER;

        // Skills
        ArrayList<String> givenSkillsList = character.getGivenSkills();
        String[] skills = givenSkillsList.toArray(new String[0]);

        p.insets = new Insets(10, 10, 10, 10);

        int maxSkills = character.getJob().getSkillCount(); // Maximum number of skills to select
        AtomicInteger selectedSkillsCount = new AtomicInteger(0);

        for (int i = 0; i < skills.length; i++) {
            p.gridx = 2 * (i % 5); // Arrange in 5 columns, leaving space for text fields
            p.gridy = i / 5; // Increment rows after every 5 skills

            JCheckBox checkBox = new JCheckBox(skills[i]);
            checkBox.setFont(new Font("Serif", Font.PLAIN, 18)); // Set font for checkboxes
            proficiency.add(checkBox, p);

            JTextField textField = new JTextField(3);
            textField.setEditable(false);
            textField.setFont(new Font("Serif", Font.PLAIN, 18)); // Set font for text fields

            checkBox.addItemListener(e -> {
                if (checkBox.isSelected()) {
                    textField.setText("  +2");
                    character.getSkills().addProficiency(checkBox.getText());
                    if (selectedSkillsCount.incrementAndGet() == maxSkills) {
                        // Disable all unselected checkboxes
                        for (Component comp : proficiency.getComponents()) {
                            if (comp instanceof JCheckBox && !((JCheckBox) comp).isSelected()) {
                                comp.setEnabled(false);
                            }
                        }
                    }
                } else {
                    textField.setText("");
                    if (selectedSkillsCount.decrementAndGet() < maxSkills) {
                        // Re-enable all checkboxes
                        for (Component comp : proficiency.getComponents()) {
                            comp.setEnabled(true);
                        }
                    }
                }
            });

            p.gridx++;
            proficiency.add(textField, p);
        }

        // Add Next button
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(20, 0, 100, 0);
        c.anchor = GridBagConstraints.CENTER;
        createNextButton(panel, c);

        c.insets = new Insets(20, 0, 20, 0);
        c.gridy = 2;
        panel.add(proficiency, c);

        return panel;
    }

    private JPanel createSpellsPanel() throws IOException {
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

        c.gridy = 1;
        c.anchor = GridBagConstraints.SOUTH; // Center align
        JLabel lblInst = new JLabel("Choose your cantrips and spells");
        lblInst.setFont(new Font("Serif", Font.PLAIN, 18));
        panel.add(lblInst, c);
        c.anchor = GridBagConstraints.CENTER;

        // add next button
        c.insets = new Insets(0, 0, 100, 0);
        c.gridy = 3;
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

        character.getSpellbook().setJob(character.getJob().getJobTitle());
        character.getSpellbook().addSpells(character.getRace().getCantrips());

        List<String> cantripsD = character.getSpellbook().getAvailableCantrips();
        String cantripsDString = String.join(", ", cantripsD);
        // System.out.println(cantripsDString);

        // add dropdown menus for selecting spells and add them to the Spell panel
        // Dropdown menu for "Cantrips"
        s.gridx = 0;
        s.gridy = 0;
        s.insets = new Insets(5, 20, 5, 20);
        Spells.add(createDropdownMenu(new String[] { cantripsDString }, "Cantrips", cantripSB), s);

        // Dropdown menu for "Lvl 1 Spells"
        s.gridy = 1;
        Spells.add(createDropdownMenu(new String[] { "Spell 1", "Spell 2", "Spell 3" }, "Lvl 1 Spells", spellBook), s);

        // add Book and Spells panels to the main panel
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(20, 0, 0, 0);
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(Spells, c);
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 2;
        c.insets = new Insets(0, 0, 0, 0);
        panel.add(Book, c);

        return panel;
    }

    private JPanel createEquipmentPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        JPanel Equip = new JPanel(new GridBagLayout()); // Equipment panel

        GridBagConstraints c = new GridBagConstraints(); // Grid for main panel
        GridBagConstraints e = new GridBagConstraints(); // Grid for Equipment panel

        // Title setup
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(100, 0, 0, 50);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Weapons & Armor");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(lblTitle, c);

        // Next button setup
        c.insets = new Insets(0, 0, 100, 0);
        c.gridx = 0;
        c.gridy = 3;
        createNextButton(panel, c);

        // Equipment list setup
        ArrayList<Item> equipmentList = character.getJob().getEquipment();

        String prompt = character.getJob().getEquipmentString();
        c.gridy = 1;
        c.insets = new Insets(130, 0, 0, 0);
        JLabel promptLabel = new JLabel(prompt);
        promptLabel.setFont(new Font("Serif", Font.PLAIN, 19));
        panel.add(promptLabel, c);

        e.insets = new Insets(10, 10, 10, 10);
        int i = 0;
        for (Item item : equipmentList) {
            e.gridx = 2 * (i % 5); // Arrange in 5 columns
            e.gridy = i / 5; // Increment rows after every 5 skills

            JCheckBox checkBox = new JCheckBox(item.getName());
            checkBox.setFont(new Font("Serif", Font.PLAIN, 19));
            checkBox.addItemListener(event -> {
                if (checkBox.isSelected()) {
                    character.addItem(item);
                }
            });
            Equip.add(checkBox, e);
            i++;
            e.gridy++;
        }

        // Panel assembly
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 0, 0);
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(Equip, c);

        return panel;
    }

    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        GridBagConstraints c = new GridBagConstraints(); // Grid for main panel

        JPanel Lpanel = new JPanel(new GridBagLayout()); // Left panel
        JPanel Rpanel = new JPanel(new GridBagLayout()); // Right panel
        GridBagConstraints r = new GridBagConstraints(); // Grid for main panel
        GridBagConstraints l = new GridBagConstraints(); // Grid for main panel

        // Add the title of the panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(100, 0, 0, 0);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Summary");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        panel.add(lblTitle, c);

        // add done button
        c.insets = new Insets(0, 0, 100, 0);
        c.gridy = 3;
        JButton doneButton = new JButton("Done");
        doneButton.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(doneButton, c);

        // Add action listener to close the program
        doneButton.addActionListener(e -> System.exit(0));

        c.gridwidth = 1;

        // Font for labels
        Font labelFont = new Font("Serif", Font.PLAIN, 20);

        // Creating and setting up labels
        JLabel nameLabel = new JLabel("Name: " + character.getName());
        nameLabel.setFont(labelFont);
        JLabel classLabel = new JLabel("Class: " + character.getJob().getJobTitle());
        classLabel.setFont(labelFont);
        JLabel raceLabel = new JLabel("Race: " + character.getRace().getRace());
        raceLabel.setFont(labelFont);
        JLabel backgroundLabel = new JLabel("Background: " + character.getBackground().getBackgroundTitle());
        backgroundLabel.setFont(labelFont);
        JLabel hpLabel = new JLabel("HP: " + character.getHealth());
        hpLabel.setFont(labelFont);

        l.gridx = 0;
        l.insets = new Insets(15, 15, 15, 15);
        l.gridy = 0;
        l.anchor = GridBagConstraints.WEST;
        Lpanel.add(nameLabel, l);
        l.gridy++;
        Lpanel.add(classLabel, l);
        l.gridy++;
        Lpanel.add(raceLabel, l);
        l.gridy++;
        Lpanel.add(backgroundLabel, l);
        l.gridy++;
        Lpanel.add(hpLabel, l);

        // Additional panel for stats
        JPanel statsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints sp = new GridBagConstraints();

        sp.gridx = 0;
        sp.gridy = 0;
        sp.anchor = GridBagConstraints.WEST;
        sp.insets = new Insets(15, 15, 15, 15);

        String statsString = character.getStats().toString();
        String[] stats = statsString.split("\n"); // Splitting stats based on new lines
        Font statsFont = new Font("Serif", Font.PLAIN, 24);

        for (String stat : stats) {
            JLabel statLabel = new JLabel(stat);
            statLabel.setFont(statsFont);
            statsPanel.add(statLabel, sp);
            sp.gridx++;
            if (sp.gridx % 3 == 0) { // New row after every 3 stats
                sp.gridx = 0;
                sp.gridy++;
            }
        }
        l.gridy++;
        Lpanel.add(statsPanel, l);

        // items text area
        JTextArea itemsTextArea = new JTextArea(15, 20);
        itemsTextArea.setEditable(false);
        itemsTextArea.setFont(new Font("Serif", Font.PLAIN, 18));
        itemsTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ArrayList<String> itemsList = character.getItemList();
        if (itemsList.isEmpty()) {
            itemsTextArea.setText("No Items");
        } else {
            itemsTextArea.append("Equipment: \n\n");
            for (String item : itemsList) {
                itemsTextArea.append(item + "\n");
            }
        }

        // spells text area
        JTextArea spellsTextArea = new JTextArea(15, 20);
        spellsTextArea.setEditable(false);
        spellsTextArea.setFont(new Font("Serif", Font.PLAIN, 18));
        spellsTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        String spellsString = character.getSpellbook().getSpellbookAsString();
        String[] spells = spellsString.split("\n");

        if (spells.length == '0') {
            spellsTextArea.setText("No Spells");
        } else {
            spellsTextArea.append("Spellbook:\n\n");
            for (String spell : spells) {
                spellsTextArea.append(spell + "\n");
            }
        }

        // skills text area
        JTextArea skillsTextArea = new JTextArea(10, 40);
        skillsTextArea.setEditable(false);
        skillsTextArea.setFont(new Font("Serif", Font.PLAIN, 18));
        skillsTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        if (spells.length == '0') {
            spellsTextArea.setText("No Spells");
        } else {
            displayProficientSkills(character.getSkills().getSkills(), skillsTextArea);
        }

        r.fill = GridBagConstraints.BOTH;
        r.gridx = 0;
        r.gridy = 0;
        r.insets = new Insets(20, 20, 20, 20);
        Rpanel.add(itemsTextArea, r);
        r.gridx = 1;
        Rpanel.add(spellsTextArea, r);
        r.gridx = 0;
        r.gridy = 1;
        r.gridwidth = 2; // Span across two columns
        Rpanel.add(skillsTextArea, r);

        // Add Lpanel and Rpanel to main panel
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(Lpanel, c);

        c.gridx = 1;
        panel.add(Rpanel, c);

        return panel;
    }

    class DotPanel extends JPanel {
        private boolean dot;

        public DotPanel(boolean dot) {
            this.dot = dot;
            this.setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (dot) {
                int diameter = Math.min(getWidth(), getHeight()) - 10; // Calculate the diameter
                int x = (getWidth() - diameter) / 2;
                int y = (getHeight() - diameter) / 2;
                g.setColor(Color.BLACK); // Dot color
                g.fillOval(x, y, diameter, diameter); // Draw the circle
            }
        }

        public void setDot(boolean dot) {
            this.dot = dot;
        }
    }

    private void drawDiceFace(JPanel panel, int number) {
        panel.removeAll(); // Clear previous drawings or components
        panel.setLayout(new GridLayout(3, 3)); // Dice faces have 3x3 grid layout

        // Define positions for dots in a 3x3 grid, depending on the number
        boolean[] dots = new boolean[9];
        switch (number) {
            case 1:
                dots[4] = true;
                break;
            case 2:
                dots[0] = dots[8] = true;
                break;
            case 3:
                dots[0] = dots[4] = dots[8] = true;
                break;
            case 4:
                dots[0] = dots[2] = dots[6] = dots[8] = true;
                break;
            case 5:
                dots[0] = dots[2] = dots[4] = dots[6] = dots[8] = true;
                break;
            case 6:
                dots[0] = dots[2] = dots[3] = dots[5] = dots[6] = dots[8] = true;
                break;
        }

        // Add labels (dots) to the panel
        for (boolean dot : dots) {
            DotPanel dotPanel = new DotPanel(dot);
            panel.add(dotPanel);
        }

        panel.revalidate();
        panel.repaint();
    }

    private void updateAvailableScores() {
        HashMap<String, Integer> scoreOccurrences = new HashMap<>();
        for (JComboBox<String> comboBox : comboBoxes) {
            String selected = (String) comboBox.getSelectedItem(); // Explicit cast to String
            if (selected != null && !selected.isEmpty()) {
                scoreOccurrences.put(selected, scoreOccurrences.getOrDefault(selected, 0) + 1);
            }
        }

        // Create a new list of available scores
        ArrayList<String> newAvailableScores = new ArrayList<>(availableScores);
        for (String score : scoreOccurrences.keySet()) {
            int count = scoreOccurrences.get(score);
            for (int i = 0; i < count; i++) {
                newAvailableScores.remove(score); // Remove only the first occurrence each time
            }
        }

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

    // function that switches panels once the "next" button is clicked
    private void switchPanel() {
        frame.getContentPane().remove(panels[currentPanelIndex]);
        currentPanelIndex = (currentPanelIndex + 1) % panels.length;

        // Create the next panel if it doesn't exist
        if (panels[currentPanelIndex] == null) {
            switch (currentPanelIndex) {
                case 1:
                    panels[currentPanelIndex] = createAbilitiesPanel();
                    break;
                case 2:
                    panels[currentPanelIndex] = createProficiencyPanel();
                    break;
                case 3:
                    try {
                        panels[currentPanelIndex] = createSpellsPanel();
                    } catch (IOException e) {
                        e.printStackTrace(); // Handle IOException appropriately
                    }
                    break;
                case 4:
                    panels[currentPanelIndex] = createEquipmentPanel();
                    break;
                case 5:
                    panels[currentPanelIndex] = createSummaryPanel();
                    break;
            }
        }

        frame.getContentPane().add(panels[currentPanelIndex]);
        frame.revalidate();
        frame.repaint();
    }

    private void displayProficientSkills(ArrayList<Skill> skills, JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        sb.append("Skills List \n\n");

        for (Skill skill : skills) {
            if (skill.isProficient()) {
                sb.append(skill.getName())
                        .append(" | Mod: ")
                        .append(skill.getModifier())
                        .append("\n");
            }
        }

        textArea.setText(sb.toString());
    }

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new GUI();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
