package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CityManagementGUI extends JFrame {

    // GUI components
    private JTabbedPane tabbedPane;
    private JPanel addPanel, removePanel, updatePanel, viewPanel,logOutPanel;
    private JLabel nameLabel, measureType, priceLabel, maxPrice, IDLabel, State, Zip, Space;
    JTextField nameField, priceField, maxField, removeID, stateField, zipField, spaceField, UpdateName, UpdatePrice, UpdateMaxPrice, UpdateId, UpdateState, UpdateZip, UpdateSpace;
    private JComboBox<String> typeCombo, typeCombo2, typeCombo3;
    private JButton addButton, removeButton, updateButton, viewButton, logOutButton;
    private JTable CityTable;
    private JScrollPane scrollPane;
    static LoginWindow loginWindow;

    // Inventory list
    private ArrayList<City> inventory; //Stores the cities

    public CityManagementGUI() {

        inventory = new ArrayList<>(); // Initialize inventory list


        City city1 = new City(1,"City1","SqFt",20.0,29,"England","Plymouth","4596");
        City city2 = new City(2,"City2","Yards",30.0,35,"Scotland","Edinburgh","896");
        City city3 = new City(3,"City3","Yards",50.0,59,"Wales","Bangor","796");
        City city4 = new City(4,"City4","SqFt",70.0,83,"Northern Ireland","Armagh","5894");

        inventory.add(city1);
        inventory.add(city2);
        inventory.add(city3);
        inventory.add(city4);

        // Set up main window
        // Set up main window

        //int id, String name, String type, double price, int quantity, String PUBLISH, String PRINTED, String batchNumber


        setTitle("Library Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create tabs
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 18));

        // Create panels for each tab
        addPanel = new JPanel(new GridBagLayout());
        removePanel = new JPanel(new GridBagLayout());
        updatePanel = new JPanel(new GridBagLayout());
        viewPanel = new JPanel(new BorderLayout());
        logOutPanel = new JPanel(new BorderLayout());

        // Add tabbed pane to main window
        add(tabbedPane);

        // Add panels to tabs
        tabbedPane.addTab("Add City", addPanel);
        tabbedPane.addTab("Remove City", removePanel);
        tabbedPane.addTab("Update City", updatePanel);
        tabbedPane.addTab("View City Added", viewPanel);
        tabbedPane.addTab("Search City", viewPanel);
        tabbedPane.addTab("Log Out", logOutPanel);
        tabbedPane.addTab("View City Added", viewPanel);


        /**
         * Add items TAB and PANEL
         * */

        // Create components for "Add Book" panel
        nameLabel = new JLabel("City Name:");
        measureType = new JLabel("Measure Type");
        priceLabel = new JLabel("Min Price:");
        maxPrice = new JLabel("Max Price:");

        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        measureType.setFont(new Font("Arial", Font.PLAIN, 20));
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        maxPrice.setFont(new Font("Arial", Font.PLAIN, 20));

        State = new JLabel("State");
        Zip = new JLabel("Zip code:");
        Space = new JLabel("Space:");
        State.setFont(new Font("Arial", Font.PLAIN, 20));
        Zip.setFont(new Font("Arial", Font.PLAIN, 20));
        Space.setFont(new Font("Arial", Font.PLAIN, 20));

        nameField = new JTextField(20);
        priceField = new JTextField(10);
        maxField = new JTextField(5);
        typeCombo = new JComboBox<>(new String[] {"SqFt", "Yards"});
        stateField = new JTextField(20);
        zipField = new JTextField(20);
        spaceField = new JTextField(20);

        addButton = new JButton("Add City");
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        addButton.setBackground(Color.decode("#77C1B1"));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add components to "Add Book" panel
        addPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        addPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        addPanel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        addPanel.add(measureType, gbc);
        gbc.gridx = 1;
        addPanel.add(typeCombo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        addPanel.add(priceLabel, gbc);
        gbc.gridx = 1;
        addPanel.add(priceField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        addPanel.add(maxPrice, gbc);
        gbc.gridx = 1;
        addPanel.add(maxField, gbc);

        // Add MFD Label and Field
        gbc.gridx = 0;
        gbc.gridy = 4;
        addPanel.add(State, gbc);
        gbc.gridx = 1;
        addPanel.add(stateField, gbc);

        // Add EXD Label and Field
        gbc.gridx = 0;
        gbc.gridy = 5;
        addPanel.add(Zip, gbc);
        gbc.gridx = 1;
        addPanel.add(zipField, gbc);

        // Add Batch Label and Field
        gbc.gridx = 0;
        gbc.gridy = 6;
        addPanel.add(Space, gbc);
        gbc.gridx = 1;
        addPanel.add(spaceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        addPanel.add(addButton, gbc);


        /**
         * Remove Items TAB and PANEL
         * */
        // Create components for "Remove Book" panel
        // Create components for "Remove Book" panel
        nameLabel = new JLabel("City ID:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        removeID = new JTextField(20);
        removeButton = new JButton("Remove City");
        removeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        removeButton.setBackground(Color.decode("#77C1B1"));
        removeButton.setForeground(Color.WHITE);
        removeButton.setFocusPainted(false);
        removeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add components to "Remove Book" panel
        removePanel.setBackground(Color.WHITE);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(10, 10, 10, 10);
        gbc2.anchor = GridBagConstraints.WEST;
        removePanel.add(nameLabel, gbc2);
        gbc2.gridx = 1;
        removePanel.add(removeID, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 2;
        removePanel.add(removeButton, gbc2);

        /**
         * Update TAB and PANEL
         * */

        // Create components for "Update Book" panel
        IDLabel = new JLabel("City ID:");
        IDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel = new JLabel("City Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        measureType = new JLabel("Measure Type:");
        measureType.setFont(new Font("Arial", Font.PLAIN, 20));
        priceLabel = new JLabel("Min Price:");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        maxPrice = new JLabel("Max Price:");
        maxPrice.setFont(new Font("Arial", Font.PLAIN, 20));

        State = new JLabel("State:");
        Zip = new JLabel("Zip code:");
        Space = new JLabel("Space:");
        State.setFont(new Font("Arial", Font.PLAIN, 20));
        Zip.setFont(new Font("Arial", Font.PLAIN, 20));
        Space.setFont(new Font("Arial", Font.PLAIN, 20));

        UpdateId = new JTextField(20);
        UpdateName = new JTextField(20);
        UpdatePrice = new JTextField(10);
        UpdateMaxPrice = new JTextField(5);
        typeCombo2 = new JComboBox<>(new String[] {"SqFt", "Yards"});
        UpdateState = new JTextField(20);
        UpdateZip = new JTextField(20);
        UpdateSpace = new JTextField(20);


        updateButton = new JButton("Update City");
        updateButton.setFont(new Font("Arial", Font.PLAIN, 20));
        updateButton.setBackground(Color.decode("#77C1B1"));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updateButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add components to "Update Book" panel
        updatePanel.setBackground(Color.WHITE);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.insets = new Insets(10, 10, 10, 10);
        gbc3.anchor = GridBagConstraints.WEST;
        updatePanel.add(IDLabel, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(UpdateId, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 1;
        updatePanel.add(nameLabel, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(UpdateName, gbc3);


        gbc3.gridx = 0;
        gbc3.gridy = 2;
        updatePanel.add(measureType, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(typeCombo2, gbc3);
        gbc3.gridx = 0;
        gbc3.gridy = 3;
        updatePanel.add(priceLabel, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(UpdatePrice, gbc3);
        gbc3.gridx = 0;
        gbc3.gridy = 4;
        updatePanel.add(maxPrice, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(UpdateMaxPrice, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 5;
        updatePanel.add(State, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(UpdateState, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 6;
        updatePanel.add(Zip, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(UpdateZip, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 7;
        updatePanel.add(Space, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(UpdateSpace, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 8;
        gbc3.gridwidth = 2;
        updatePanel.add(updateButton, gbc3);


        /**
         * ViewInventory TABS and PANEL
         * */


        // Create components for "View Inventory" panel
        viewButton = new JButton("Generate Report");
        viewButton.setFont(new Font("Arial", Font.PLAIN, 20));
        viewButton.setBackground(Color.decode("#247BA0"));


        CityTable = new JTable(new CityTableModel(inventory));
        scrollPane = new JScrollPane(CityTable);

        // Add components to "View Inventory" panel
        viewPanel.add(scrollPane, BorderLayout.CENTER);
        viewPanel.add(viewButton, BorderLayout.SOUTH);

        // Customize "View Inventory" panel
        viewPanel.setBackground(Color.WHITE);
        viewPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));



        /**
         * SEARCH TABS and PANEL
         * */

        // Create header panel
        JPanel headerPanel = new JPanel(new BorderLayout());

        // Create search panel
        JPanel searchPanel = new JPanel(new GridBagLayout());
        typeCombo3 = new JComboBox<>(new String[]{"ID", "Name", "Measure Type", "Min Price", "State", "Zip code", "Space"});
        typeCombo3.setFont(new Font("Arial", Font.PLAIN, 18));

        JTextField inputField = new JTextField(20);
        JLabel searchLabel = new JLabel("Search by:");
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.setFont(new Font("Arial", Font.PLAIN, 18));
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 18));
        searchButton.setBackground(Color.decode("#77C1B1"));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add search components to search panel
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 0;
        gbc5.insets = new Insets(10, 10, 10, 10);
        gbc5.anchor = GridBagConstraints.WEST;
        searchPanel.add(searchLabel, gbc5);
        gbc5.gridx = 1;
        searchPanel.add(inputField, gbc5);
        gbc5.gridx = 2;
        searchPanel.add(typeCombo3,gbc5);
        gbc5.gridx = 3;
        searchPanel.add(searchButton, gbc5);

        // Add search panel to header panel
        headerPanel.add(searchPanel, BorderLayout.NORTH);

        // Add header panel to main window
        add(headerPanel, BorderLayout.NORTH);

        // Add panels to tabs
        tabbedPane.addTab("Search", headerPanel);

        // Log out tab and panel
        logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(loginWindow.isLoggedIn());
                loginWindow.setLoggedIn(false);
                loginWindow.closeGUI();
            }
        });
        logOutButton.setFont(new Font("Arial", Font.PLAIN, 20));
        logOutButton.setBackground(Color.WHITE);
        logOutButton.setForeground(Color.BLACK);
        logOutButton.setFocusPainted(false);
        logOutButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        logOutPanel.setBackground(Color.WHITE);
        logOutPanel.add(logOutButton, BorderLayout.CENTER);

        // Add tabbed pane to main window
        add(tabbedPane);


        setVisible(true);

        // --------- Action Listeners for button ------------

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String name = nameField.getText();
                String measureType = typeCombo.getSelectedItem().toString();
                double minPrice = 0;
                int maxPrice = 0;
                String priceStr = priceField.getText();
                String max = maxField.getText();
                String State = stateField.getText();
                String Zip = zipField.getText();
                String Space = spaceField.getText();

                // Check if fields are empty
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (!priceStr.isEmpty()) {
                    minPrice = Double.parseDouble(priceStr);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter Min Price.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!max.isEmpty()) {
                    maxPrice = Integer.parseInt(max);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter Max Price.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Create new Book object with a generated ID
                int id = inventory.size() + 1;
                City city = new City(id, name, measureType, minPrice, maxPrice,Zip, State, Space);

                // Add Book to inventory
                inventory.add(city);

                // Update table
                CityTable.setModel(new CityTableModel(inventory));

                // Clear input fields
                nameField.setText("");
                priceField.setText("");
                maxField.setText("");
                stateField.setText("");
                zipField.setText("");
                spaceField.setText("");

                // Show success message
                JOptionPane.showMessageDialog(null, "City Added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

            }
        });



        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get Book ID
                int id = Integer.parseInt(removeID.getText());

                // Find Book with the given ID in inventory
                int index = -1;
                for (int i = 0; i < inventory.size(); i++) {
                    if (inventory.get(i).getId() == id) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "City not found in list.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Remove City from inventory
                inventory.remove(index);

                // Clear input field
                removeID.setText("");

                // Update table
                CityTable.setModel(new CityTableModel(inventory));

                // Show success message
                JOptionPane.showMessageDialog(null, "City removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });



        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any items are present in the inventory
                if (inventory.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Inventory is empty. Please add city before updating.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Get selected row
                int row = CityTable.getSelectedRow();

                // Validate input values
                String idString = UpdateId.getText().trim();
                String name = UpdateName.getText().trim();
                String measureType = typeCombo2.getSelectedItem().toString();
                String minPrice = UpdatePrice.getText().trim();
                String maxPrice = UpdateMaxPrice.getText().trim();
                String State = UpdateState.getText().trim();
                String Zip = UpdateZip.getText().trim();
                String Space = UpdateSpace.getText().trim();

                int id;
                try {
                    id = Integer.parseInt(idString);
                    if (id < 0) {
                        JOptionPane.showMessageDialog(null, "ID cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int index = -1;
                for (int i = 0; i < inventory.size(); i++) {
                    if (inventory.get(i).getId() == id) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "City with ID " + id + " not found in inventory.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (minPrice.isEmpty() || maxPrice.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double price;
                try {
                    price = Double.parseDouble(minPrice);
                    if (price < 0) {
                        JOptionPane.showMessageDialog(null, "Price cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid price value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int max;
                try {
                    max = Integer.parseInt(maxPrice);
                    if (max < 0) {
                        JOptionPane.showMessageDialog(null, "Max Price cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Price value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Update Book object
                City city = inventory.get(index);
                city.setName(name);
                city.setMeasureType(measureType);
                city.setMinPrice(price);
                city.setMaxPrice(max);
                city.setZipCode(State);
                city.setState(Zip);
                city.setSpace(Space);

                // Clear input fields
                UpdateId.setText("");
                UpdateName.setText("");
                UpdatePrice.setText("");
                UpdateMaxPrice.setText("");
                UpdateState.setText("");
                UpdateZip.setText("");
                UpdateSpace.setText("");

                // Update table
                CityTable.setModel(new CityTableModel(inventory));
                // Show success message
                JOptionPane.showMessageDialog(null, "City Updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generate report
                String report = "Current Inventory Report:\n\n";
                report += "City Name\tCity Type\tPrice\tQuantity\n";
                for (City city : inventory) {
                    report += city.getName() + "\t" + city.getMeasureType() + "\t" + city.getMinPrice() + "\t" + city.getMaxPrice() + "\n";
                }

                // Display report in message dialog
                JOptionPane.showMessageDialog(null, report);
            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inventory.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Inventory is empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String input = inputField.getText();
                String category = (String) typeCombo3.getSelectedItem();
                ArrayList<City> searchResults = new ArrayList<>();

                System.out.println(input+"  "+category);
                // Search for Book matching the input in the selected category
                for (City city : inventory) {
                    if (category.equals("ID") && String.valueOf(city.getId()).equals(input)) {
                        searchResults.add(city);
                    } else if (category.equals("Name") && city.getName().equals(input)) {
                        searchResults.add(city);
                    } else if (category.equals("Measure Type") && city.getMeasureType().equals(input)) {
                        searchResults.add(city);
                    } else if (category.equals("Min Price") && Double.toString(city.getMinPrice()).equals(input)) {
                        searchResults.add(city);
                    } else if (category.equals("Zip Code") && city.getZipCode().equals(input)) {
                        searchResults.add(city);
                    } else if (category.equals("State") && city.getState().equals(input)) {
                        searchResults.add(city);
                    } else if (category.equals("SPACE") && city.getSpace().equals(input)) {
                        searchResults.add(city);
                    }
                }

                if (searchResults.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No items found.");
                    return;
                }

                // Create a table to display the search results
                String[] columnNames = {"ID", "Name", "Measure Type", "Min Price", "State", "Zip Code", "Space"};
                Object[][] rowData = new Object[searchResults.size()][7];
                int i = 0;
                for (City city : searchResults) {
                    rowData[i][0] = city.getId();
                    rowData[i][1] = city.getName();
                    rowData[i][2] = city.getMeasureType();
                    rowData[i][3] = city.getMinPrice();
                    rowData[i][4] = city.getZipCode();
                    rowData[i][5] = city.getState();
                    rowData[i][6] = city.getSpace();
                    i++;
                }

                JTable searchTable = new JTable(rowData, columnNames);
                JScrollPane scrollPane = new JScrollPane(searchTable);
                JOptionPane.showMessageDialog(null, scrollPane, "Search Results", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {

        //Create login window object
        loginWindow = new LoginWindow();

        // Show login window
        loginWindow.setVisible(true);
//
//        InventoryManagementGUI gui = new InventoryManagementGUI();
//        gui.setVisible(true);

    }
}



