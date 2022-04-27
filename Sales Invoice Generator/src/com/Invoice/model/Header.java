

package com.Invoice.model;

import java.util.ArrayList;
import java.util.Date;


public class Header {
    
   private int num;
   private String costumer;
   private Date invDate;
   private ArrayList<Line>lines;

    public Header() {
    }

    public Header(int num, String costumer, Date invDate) {
        this.num = num;
        this.costumer = costumer;
        this.invDate = invDate;
    }

    public Header(int num, Date invDate, String srtng3) {
       
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCostumer() {
        return costumer;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }

    public ArrayList<Line> getLines() {
        if(lines==null){
        return lines=new ArrayList<>();
    }
        return lines;
    }
    public void setLines(ArrayList<Line>lines) {
        this.lines = lines;
    } 
    
   public double getInvoiceTotal(){
    double total=0.0;
     
    for (int i=0 ;i <lines.size();i++)
    {total+=lines.get(i).getLineTotal(); }
         return total;
   }

    @Override
    public String toString() {
        return "Header{" + "num=" + num + ", costumer=" + costumer + ", invDate=" + invDate + '}';
    }

   
   
    }
