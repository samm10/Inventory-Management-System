package com.example.demo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CityTableModel extends AbstractTableModel {
    private ArrayList<City> inventory;
    private String[] columnNames = {"ID", "Book Name", "Product Type", "Price", "Quantity", "PUBLISHED", "PRINTED", "BATCH"};

    public CityTableModel(ArrayList<City> inventory) {
        this.inventory = inventory;
    }

    public void setInventory(ArrayList<City> inventory) {
        this.inventory = inventory;
    }

    @Override
    public int getRowCount() {
        return inventory.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        City city = inventory.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return city.getId();
            case 1:
                return city.getName();
            case 2:
                return city.getMeasureType();
            case 3:
                return city.getMinPrice();
            case 4:
                return city.getMaxPrice();
            case 5:
                return city.getZipCode();
            case 6:
                return city.getState();
            case 7:
                return city.getSpace();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        City city = inventory.get(rowIndex);
        switch (columnIndex) {
            case 0:
                city.setId((int) value);
                break;
            case 1:
                city.setName((String) value);
                break;
            case 2:
                city.setMeasureType((String) value);
                break;
            case 3:
                city.setMinPrice((double) value);
                break;
            case 4:
                city.setMaxPrice((int) value);
            case 5:
                city.setZipCode((String) value);
            case 6:
                city.setState((String) value);
            case 7:
                city.setSpace((String) value);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
