/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import java.awt.*;
import java.awt.event.*;
public class mainmenu extends Frame implements ActionListener{
    
    public static void main(String[] args){
        mainmenu f2 = new mainmenu();
    }
    
    Button buttonInsert, buttonModify, buttonPayment, buttonExit;
    public mainmenu(){
        setSize(500,300);
        setLocation(900,300);
        setTitle("Main Menu");
        
        GridLayout layout = new GridLayout(2,2,10,10);
        setLayout(layout);
        
        buttonInsert = new Button("Insert New Member");
        buttonModify = new Button("Modify Existing Records");
        buttonPayment = new Button("Payment System");
        buttonExit = new Button("Exit");
        
        add(buttonInsert);
        add(buttonModify);
        add(buttonPayment);
        add(buttonExit);
        
        buttonInsert.addActionListener(this);
        buttonModify.addActionListener(this);
        buttonPayment.addActionListener(this);
        buttonExit.addActionListener(this);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==buttonInsert){
            new Registration();
            setVisible(false);
        }
        else if (e.getSource()==buttonModify){
            new Modification();
            setVisible(false);
        }
        else if (e.getSource()==buttonPayment){
            new Payment();
            setVisible(false);
        }
        else{
            dispose();
        }
    }
}
