/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import java.awt.*;
import java.awt.event.*;
public class Modification extends Frame{
    
    public static void main(String[] args){
        Modification f3 = new Modification();
    }
    
    TextField fullname, ID;
    Choice membership;
    Button modify;
    public Modification(){
        setSize(340,250);
        setLocation(900,300);
        setTitle("Edit Member");
        
        setLayout(new BorderLayout());
        Panel registrationForm = new Panel();
        registrationForm.setBackground(Color.GRAY);
        registrationForm.setLayout(null);
        
        Label memberID = new Label("Enter ID:");
        Label name = new Label("Full Name:");
        Label member = new Label("Membership Option:");
        ID = new TextField("", 15);
        fullname = new TextField("", 15);
        membership = new Choice();
        modify = new Button("Modify");
                
        membership.add("Deluxe");
        membership.add("Non-Deluxe");
        membership.add("Week-Day");
        
        memberID.setBounds(78, 45, 60, 10);
        name.setBounds(65, 80, 70, 10);
        member.setBounds(15, 115, 115, 15);
        ID.setBounds(140, 40, 150, 20);
        fullname.setBounds(140, 75, 150, 20);
        membership.setBounds(140, 110, 150, 20);
        modify.setBounds(125, 160, 80, 20);
        
        registrationForm.add(memberID);
        registrationForm.add(name);
        registrationForm.add(member);
        registrationForm.add(ID);
        registrationForm.add(fullname);
        registrationForm.add(membership);
        registrationForm.add(modify);
        add(registrationForm, "Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setVisible(true);
    }
  
}
