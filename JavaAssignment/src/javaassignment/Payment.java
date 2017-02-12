/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import java.awt.*;
import java.awt.event.*;
public class Payment extends Frame {
    
    public static void main(String[] args){
        Payment f4 = new Payment();
    
}
    TextField fullname, ID, payment;
    Choice membership;
    Button record;
    public Payment(){
        setSize(340,250);
        setLocation(900,300);
        setTitle("Payment System");
        
        setLayout(new BorderLayout());
        Panel registrationForm = new Panel();
        registrationForm.setBackground(Color.GRAY);
        registrationForm.setLayout(null);
        
        Label memberID = new Label("Enter ID:");
        Label name = new Label("Full Name:");
        Label member = new Label("Membership Option:");
        Label fees = new Label("Total fee:");
        ID = new TextField("", 15);
        fullname = new TextField("", 15);
        membership = new Choice();
        payment = new TextField("", 15);
        record = new Button("Record");
        
        membership.add("Deluxe");
        membership.add("Non-Deluxe");
        membership.add("Week-Day");
        
        memberID.setBounds(78, 45, 60, 10);
        name.setBounds(65, 80, 70, 10);
        member.setBounds(15, 115, 115, 15);
        fees.setBounds(76, 150, 60, 10);
        ID.setBounds(140, 40, 150, 20);
        fullname.setBounds(140, 75, 150, 20);
        membership.setBounds(140, 110, 150, 20);
        payment.setBounds(140, 145, 150, 20);
        record.setBounds(125, 180, 80, 20);
        
        registrationForm.add(memberID);
        registrationForm.add(name);
        registrationForm.add(member);
        registrationForm.add(fees);
        registrationForm.add(ID);
        registrationForm.add(fullname);
        registrationForm.add(membership);
        registrationForm.add(payment);
        registrationForm.add(record);
        add(registrationForm, "Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setVisible(true);
    }
}
