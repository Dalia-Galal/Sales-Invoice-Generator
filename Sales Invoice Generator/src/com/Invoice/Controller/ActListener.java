/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Invoice.Controller;

import com.Invoice.model.Header;
import com.Invoice.model.HeaderTableModel;
import com.Invoice.model.Line;
import com.Invoice.veiw.InvFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Dalia
 */
public class ActListener implements ActionListener {
    
    private InvFrame frame;
    public ActListener (InvFrame frame){
    this.frame=frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    { switch
            ( e.getActionCommand()){
          case "load files":
            loadFiles();
              break;
          case "save files":
              saveFiles();
              break;
          case "Create New Invoice ":
              createNewInv();
              break;
           case "Delete Invoice":
               delInv();
              break;
          case "Save ":
              createNewLine();
              break;
          case "Cancel ":
              delLine();
              break;    
      }
     
    }

    private void loadFiles() {
        JFileChooser fileChooser=new JFileChooser();
        try {
            
             int result= fileChooser.showOpenDialog(frame);
              if  (result==JFileChooser.APPROVE_OPTION) {
                  File hdrFile = fileChooser.getSelectedFile();
                  Path hdrPath = Paths.get(hdrFile.getAbsolutePath());
                  List<String>hdrLns =Files.readAllLines(hdrPath);
                  ArrayList<Header>invHdrs=new ArrayList<>();
                  for(String hdrLn:hdrLns)
            {
                String arry[]=hdrLn.split(",");
                String strng1=arry[0];
                String strng2=arry[1];
                String strng3=arry[2];
                int num=Integer.parseInt(strng1);
                Date invDate=InvFrame.dateFormat.parse(strng2); 
                Header hdr=new Header(num,strng3,invDate);
                invHdrs.add(hdr);
            }
               frame.setInvsArray(invHdrs);
               result=fileChooser.showOpenDialog(frame);
               if (result==JFileChooser.APPROVE_OPTION) {
                  File lnFile=fileChooser.getSelectedFile();
                  Path lnPath=Paths.get(lnFile.getAbsolutePath());
                  List<String>lnLines=Files.readAllLines(lnPath);
               
                  for(String lnLine:lnLines){
                     String[]arry=lnLine.split(",");
                     String strng1=arry[0];
                     String strng2=arry[1];
                     String strng3=arry[2];
                     String strng4=arry[3];
                     int num=Integer.parseInt(strng1);
                     double price=Double.parseDouble(strng3);
                     int count=Integer.parseInt(strng4);
                     Header inv=frame.getInvObject(num);
                     Line line=new Line(strng2,price,count,inv);
                     inv.getLines().add(line);
                          }
        
        }
               HeaderTableModel hdrTblModel=new HeaderTableModel(invHdrs);
               frame.setHdrTblModel(hdrTblModel);
               frame.getInvHTable().setModel(hdrTblModel);
               
              }
        
        }catch(IOException ex){
            JOptionPane.showMessageDialog(frame,ex.getMessage() ,"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(ParseException ex){
             JOptionPane.showMessageDialog(frame,ex.getMessage() ,"Error",JOptionPane.ERROR_MESSAGE);
                
                
                }
                }
    
    private void saveFiles() {
       
    }

    private void createNewInv() {
       
    }

    private void delInv() {
       
    }

    private void createNewLine() {
        
    }

    private void delLine() {
        
    }
    
}
