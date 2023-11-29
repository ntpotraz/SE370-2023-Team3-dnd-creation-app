import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;

public class GUI {

    private JFrame frame;
    private JPanel characterPanel, abilitiesPanel, spellsPanel,  equipmentPanel;
    private JPanel[] panels;
    private int currentPanelIndex;
    public GUI() {
        frame = new JFrame(); //create initial panel

        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //declare all panel to be used
        characterPanel = createCharacterPanel();
        abilitiesPanel = createAbilitiesPanel();
        spellsPanel = createSpellsPanel();
        equipmentPanel = createEquipmentPanel();

        panels = new JPanel[] { characterPanel, abilitiesPanel, spellsPanel, equipmentPanel}; //array to switch panels
        currentPanelIndex = 0;

        frame.add(panels[currentPanelIndex]); //add current panel to initial panel
        frame.setVisible(true); //display panel
    }

    private JPanel createCharacterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Create components
        JLabel lblTitle = new JLabel("D&D Character Creator");
        JTextField txtName = new JTextField(15);
        JComboBox<String> cbClass = new JComboBox<>(new String[]{"Warrior", "Mage", "Rogue"});
        JComboBox<String> cbRace = new JComboBox<>(new String[]{"Human", "Elf", "Dwarf"});
        JComboBox<String> cbBackground = new JComboBox<>(new String[]{"Noble", "Commoner", "Thief"});

        // Add components with GridBagConstraints for positioning
        c.gridx = 1; c.gridy = 0; c.gridwidth = 2;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(lblTitle, c);

        c.gridy = 1; c.gridwidth = 1;
        panel.add(new JLabel("Enter Name:"), c);
        c.gridx = 2;
        panel.add(txtName, c);

        c.gridx = 1; c.gridy = 2;
        panel.add(new JLabel("Character Class:"), c);
        c.gridx = 2;
        panel.add(cbClass, c);

        c.gridx = 1; c.gridy = 3;
        panel.add(new JLabel("Character Race:"), c);
        c.gridx = 2;
        panel.add(cbRace, c);

        c.gridx = 1; c.gridy = 4;
        panel.add(new JLabel("Character Background:"), c);
        c.gridx = 2;
        panel.add(cbBackground, c);

        c.gridx = 1; c.gridy = 5; c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;

        createNextButton(panel, c);
        return panel;
    }

    private JPanel createAbilitiesPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // main panel
        JPanel abilitiesPanel = new JPanel(new GridBagLayout()); // abilities panel, will hold all the abilities with their drop-down menus for results from rolling dices

        GridBagConstraints c = new GridBagConstraints(); //grid for main panel
        GridBagConstraints abi = new GridBagConstraints(); //grid for all abilities panels
        GridBagConstraints ind = new GridBagConstraints();  //grid for individual abilities

        // add the title at the top the panel
        c.gridx = 1; c.gridy = 0; c.gridwidth = 3;
        c.insets = new Insets(100, 0, 0, 750);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Calculate Abilities Score");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(lblTitle, c);

        //add next button at the bottom of the panel
        c.insets = new Insets(0, 0, 50, 750);
        c.gridx = 1; c.gridy = 2;
        createNextButton(panel, c);

        // List of abilities
        String[] abilities = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        String[] rollDiceResult = {"1", "2", "3", "4", "5", "6"};

        abi.insets = new Insets(10, 10, 10, 10); // Add padding

        //create all the abilities panels with their drop-down menus
        for (int i = 0; i < abilities.length; i++) {
            JPanel abilityPanel = new JPanel(new GridBagLayout());
            ind.gridx = 0; ind.gridy = 0;

            JLabel label = new JLabel(abilities[i]);
            label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 16)); // Set font size to 16, for example

            abilityPanel.add(label, ind); // Add the label to the panel

            JComboBox<String> comboBox = new JComboBox<>(rollDiceResult); // Create a new combo box with shared model
            comboBox.setPreferredSize(new Dimension(150, 30));
            ind.gridy = 1;
            abilityPanel.add(comboBox, ind); // Add the combo box

            abi.gridx = i % 3; abi.gridy = i / 3; // Arrange in a grid
            abilitiesPanel.add(abilityPanel, abi);
        }

        //add abilities panel to main panel
        c.insets = new Insets(0, 0, 0, 0); //Add padding
        c.gridx = 0;c.gridy = 1;
        c.weightx = 1.0; c.weighty = 1.0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH; // Fill behavior
        panel.add(abilitiesPanel, c);

        // Panel for dices and dice roll button
        JPanel dicesPanel = new JPanel(new GridBagLayout()); // dice panel
        GridBagConstraints d = new GridBagConstraints(); //grid for dice panels

        d.insets = new Insets(5, 5, 5, 5);
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

        //adding dice panel to the main panel
        d.gridx = 0; d.gridy = 2;
        d.gridwidth = 2;
        createRollButton(dicesPanel, d);

        //add dice panel to main panel
        c.gridx = 3; c.gridy = 1;
        c.weightx = 1.0; c.weighty = 1.0;
        c.insets = new Insets(0, 300, 0, 0);
        c.fill = GridBagConstraints.BOTH; // Fill behavior
        panel.add(dicesPanel, c);

        return panel;
    }

    private JPanel createSpellsPanel() {
        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        JPanel Book = new JPanel(new GridBagLayout());  // Book panel (Used for spellbook)
        JPanel Spells = new JPanel(new GridBagLayout()); // Spells panel

        GridBagConstraints c = new GridBagConstraints(); // Grid for main panel
        GridBagConstraints s = new GridBagConstraints(); // grid for spellBook panel and spells panel

        // Add the title of the panel
        c.gridx = 1; c.gridy = 0; c.gridwidth = 1;
        c.insets = new Insets(100, 0, 0, 50);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Spells");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(lblTitle, c);
        c.insets = new Insets(0, 0, 0, 0);

        // add next button
        c.insets = new Insets(0, 0, 50, 0);
        c.gridx = 1; c.gridy = 2;
        createNextButton(panel, c);

        // JTextArea to display selected options
        JTextArea spellBook = new JTextArea(5, 20);
        spellBook.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        spellBook.setBorder(border);

        // add spellbook (text area) and subtitle ("Spellbook") to Book panel to main panel
        s.gridx = 0; s.gridy = 0;
        Book.add(new JLabel("Spellbook"),s);
        s.gridy = 1;
        Book.add(spellBook, s);

        // add dropdown menus for selecting spells and add them to the Spell panel
        //Dropdown menu for "Other"
        s.gridx = 0; s.gridy = 0;
        s.insets = new Insets(5, 5, 5, 5);
        Spells.add(createDropdownMenu(new String[]{"Option 1", "Option 2", "Option 3"}, "Other", spellBook), s);

        //Dropdown menu for "Lvl 1 Spells"
        s.gridy = 1;
        Spells.add(createDropdownMenu(new String[]{"Spell 1", "Spell 2", "Spell 3"}, "Lvl 1 Spells", spellBook), s);

        //add Book and Spells panels to the main panel
        c.gridx = 0; c.gridy = 1;
        c.weightx = 1.0; c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(Spells, c);
        c.gridx = 2; c.gridy = 1; c.gridheight = 2;
        panel.add(Book,c);

        return panel;
    }

    private JPanel createEquipmentPanel(){
        JPanel panel = new JPanel(new GridBagLayout()); // Main panel
        JPanel Equip = new JPanel(new GridBagLayout());  // Equipment panel -- used for weapons and armor
        JPanel Inventory = new JPanel(new GridBagLayout()); // Inventory panel -- used for displaying selected weapons and armor

        GridBagConstraints c = new GridBagConstraints(); // Grid for main panel
        GridBagConstraints e = new GridBagConstraints(); // grid for Equipment panel and Weapons panels

        // Add the title of the panel
        c.gridx = 1; c.gridy = 0; c.gridwidth = 1;
        c.insets = new Insets(100, 0, 0, 50);
        c.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Weapons & Armor");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(lblTitle, c);
        c.insets = new Insets(0, 0, 0, 0);

        // add next button
        c.insets = new Insets(0, 0, 50, 0);
        c.gridx = 1; c.gridy = 2;
        createNextButton(panel, c);

        //JTextArea to display selected options
        JTextArea inv = new JTextArea(5, 20); //inv (inventory) will display all the armor and weapons selected
        inv.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        inv.setBorder(border);

        //add Inventory (text area) and subtitle ("Inventory") to Inventory panel
        e.gridx = 0; e.gridy = 0;
        Inventory.add(new JLabel("Inventory"),e);
        e.gridy = 1;
        Inventory.add(inv, e);

        // add dropdown menus for selecting weapons and add them to the Equip panel
        //Dropdown menu for "Weapons"
        e.gridx = 0; e.gridy = 0;
        e.insets = new Insets(5, 5, 5, 5);
        Equip.add(createDropdownMenu(new String[]{"Weapon 1", "Weapon 2", "Weapon 3"}, "Weapons", inv), e);

        //Dropdown menu for "Armor"
        e.gridy = 1;
        Equip.add(createDropdownMenu(new String[]{"Armor 1", "Armor 2", "Armor 3"}, "Armor", inv), e);

        //add Equip and Inventory panels to the main panel
        c.gridx = 0; c.gridy = 1;
        c.weightx = 1.0; c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(Equip, c);
        c.gridx = 2; c.gridy = 1; c.gridheight = 2;
        panel.add(Inventory,c);

        return panel;
    }

    //function to create the drop-down menus with the check marks for selecting spells and equipment. It adds the selected element to the "spellbook" and removes it if unchecked
    private JPanel createDropdownMenu(String[] options, String label, JTextArea textArea) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl = new JLabel(label);
        JButton button = new JButton("Select");
        JPopupMenu menu = new JPopupMenu();

        for (String option : options) {
            JCheckBoxMenuItem item = new JCheckBoxMenuItem(option);
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


    //This function creates the "next button" that is used on every panel to switch to the next
    private void createNextButton(JPanel panel, GridBagConstraints constraints) {
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel();
            }
        });
        panel.add(nextButton, constraints);
    }

    //function for the dice roll -- needs to be implemented if we decide to do it in here instead of the back-end
    private void createRollButton(JPanel panel, GridBagConstraints constraints ) {
        JButton roll = new JButton("Roll Dices");
        panel.add(roll, constraints);
    }

    //function that switches panels once the "next" button is clicked
    private void switchPanel() {
        frame.getContentPane().remove(panels[currentPanelIndex]);
        currentPanelIndex = (currentPanelIndex + 1) % panels.length;
        frame.getContentPane().add(panels[currentPanelIndex]);
        frame.revalidate();
        frame.repaint();
    }

    //main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
