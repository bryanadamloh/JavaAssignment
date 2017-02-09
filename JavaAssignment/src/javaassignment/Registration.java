/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import java.awt.*;
import java.awt.event.*;
public class Registration extends Frame {
    
    public static void main(String[] args){
        Registration f3 = new Registration();
    }
    
    TextField fullname;
    Choice membership;
    Button create;
    public Registration(){
        setSize(340,250);
        setLocation(900,300);
        setTitle("Member Registration");
        
        setLayout(new BorderLayout());
        Panel registrationForm = new Panel();
        registrationForm.setBackground(Color.GRAY);
        registrationForm.setLayout(null);
        
        Label name = new Label("Full Name:");
        Label member = new Label("Membership Option:");
        fullname = new TextField("", 15);
        membership = new Choice();
        create = new Button("Create");
                
        membership.add("Deluxe");
        membership.add("Non-Deluxe");
        membership.add("Week-Day");
        
        name.setBounds(65, 70, 70, 10);
        member.setBounds(15, 105, 115, 15);
        fullname.setBounds(140, 65, 150, 20);
        membership.setBounds(140, 100, 150, 20);
        create.setBounds(125, 150, 80, 20);
        
        registrationForm.add(name);
        registrationForm.add(member);
        registrationForm.add(fullname);
        registrationForm.add(membership);
        registrationForm.add(create);
        add(registrationForm, "Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setVisible(true);
    }
}
