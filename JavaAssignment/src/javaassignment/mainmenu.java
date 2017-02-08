/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import java.awt.*;
import java.awt.event.*;
public class mainmenu extends Frame{
    
    public static void main(String[] args){
        mainmenu f2 = new mainmenu();
    }
    
    public mainmenu(){
        setSize(500,300);
        setLocation(900,300);
        setTitle("Main Menu");
        
        GridLayout layout = new GridLayout(2,2,10,10);
        setLayout(layout);
        
        Button button1 = new Button("Insert New Member");
        Button button2 = new Button("Modify Existing Records");
        Button button3 = new Button("Payment System");
        Button button4 = new Button("Exit");
        
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        
        setVisible(true);
    }
}
