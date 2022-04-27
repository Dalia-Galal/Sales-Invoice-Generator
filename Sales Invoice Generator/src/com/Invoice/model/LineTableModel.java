/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Invoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dalia
 */
public class LineTableModel extends AbstractTableModel {
    private ArrayList<Line>linesArray;    
    private String[] columns = {"Item ","Price","Count","Line Total"};

    public LineTableModel(ArrayList<Line> linesArray) {
        this.linesArray = linesArray;
    }
    
    @Override
    public int getRowCount() {
        return linesArray.size();
      
    }

    @Override
    public int getColumnCount() {
        return columns.length;
       
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Line line=linesArray.get(rowIndex);
        switch (columnIndex){
            case 0: return line.getItem();
            case 1: return line.getPrice();
            case 2: return line.getCount();
            case 3: return line.getLineTotal();
            default : return "";
        
        
        }
    }
    
    @Override
    public String getColumnName(int column){
        return columns[column];
    }
}
