/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.File;
public class Registration extends Frame implements ActionListener {
    
    public static void main(String[] args){
        Registration f3 = new Registration();
    }
    
    TextField fullname, ICNum;
    Choice membership;
    Button create;
    public Registration(){
        setSize(340,300);
        setLocation(900,300);
        setTitle("Member Registration");
        
        setLayout(new BorderLayout());
        Panel registrationForm = new Panel();
        registrationForm.setBackground(Color.GRAY);
        registrationForm.setLayout(null);
        
        Label name = new Label("Full Name:");
        Label IC = new Label("IC Number:");
        Label member = new Label("Membership Option:");
        fullname = new TextField("", 15);
        ICNum = new TextField("", 15);
        membership = new Choice();
        create = new Button("Create");
                
        membership.add("Deluxe");
        membership.add("Non-Deluxe");
        membership.add("Week-Day");
        
        name.setBounds(65, 70, 70, 10);
        IC.setBounds(65, 105, 70, 10);
        member.setBounds(15, 140, 115, 15);
        fullname.setBounds(140, 65, 150, 20);
        ICNum.setBounds(140, 100, 150, 20);
        membership.setBounds(140, 135, 150, 20);
        create.setBounds(125, 180, 80, 20);
        
        registrationForm.add(name);
        registrationForm.add(IC);
        registrationForm.add(member);
        registrationForm.add(fullname);
        registrationForm.add(ICNum);
        registrationForm.add(membership);
        registrationForm.add(create);
        add(registrationForm, "Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        create.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == create){
                try{
                 BufferedReader Out= new BufferedReader(new FileReader("member.txt"));
                 if(Out.readLine()==null){
                     Write();
                     fullname.setText("");
                     ICNum.setText("");
                     membership.select("Deluxe");
                 }
                 else{
                     Append();
                     fullname.setText("");
                     ICNum.setText("");
                     membership.select("Deluxe");
                 }
                 
                 JOptionPane.showMessageDialog(null, "Registration has been made successfully!", "Registration Info", JOptionPane.INFORMATION_MESSAGE);
            }
                catch (IOException f){
                    f.printStackTrace();
                }
        }
    }
    
    public void Write() throws IOException {
        PrintWriter output = new PrintWriter("Member.txt");
        
        output.print(1 + ":" + fullname.getText() + ":" + ICNum.getText() + ":" + membership.getSelectedItem());
        
        output.close();
    }
    
    public void Append() throws IOException {
        
    }
}
