/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Invoice.model;

import com.Invoice.veiw.InvFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dalia
 */
public class HeaderTableModel extends AbstractTableModel{
    private ArrayList<Header>invsArray;    
    private String[] columns = {"Invoice Number","Invoice Date","Costumer","Invoice Total"};
    public HeaderTableModel(ArrayList<Header>invsArray) {
        this.invsArray = invsArray;
    }

    @Override
    public int getRowCount() {
        return invsArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
      
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Header invHdrs=invsArray.get(rowIndex);
        switch (columnIndex){
            case 0:return invHdrs.getNum();
            case 1:return InvFrame.dateFormat.format(invHdrs.getInvDate());
            case 2:return invHdrs.getCostumer(); 
           
        }
        return "";
    }
    @Override
   public String getColumnName(int column){           
 
       return columns[column];
}
           
}