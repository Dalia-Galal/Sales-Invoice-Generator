/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Invoice.Controller;

import com.Invoice.model.Header;
import com.Invoice.model.Line;
import com.Invoice.model.LineTableModel;
import com.Invoice.veiw.InvFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Dalia
 */
public class TblSelListener implements ListSelectionListener
      
{ private InvFrame frame;

    public TblSelListener(InvFrame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
      int selectedInvIndex=frame.getInvHTable().getSelectedRow();
       System.out.println("THe Selected invoice:"+selectedInvIndex);
       Header selectedInvoice= frame.getInvsArray().get(selectedInvIndex);
       ArrayList<Line>line=selectedInvoice.getLines();
       LineTableModel lnTblModel=new LineTableModel(line);
       frame.getInvLTable().setModel(lnTblModel);
  
       
    }
    
}
