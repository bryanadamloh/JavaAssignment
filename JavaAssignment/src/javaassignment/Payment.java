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
public class Payment extends Frame implements ActionListener{
    
    public static void main(String[] args){
        Payment f4 = new Payment();   
    }
    
    TextField fullname, ID, payment, ICNum, date;
    Choice membership;
    Button record, search, cancel;
    public Payment(){
        setSize(390,350);
        setLocation(900,300);
        setTitle("Payment System");
        
        setLayout(new BorderLayout());
        Panel paymentForm = new Panel();
        paymentForm.setBackground(Color.GRAY);
        paymentForm.setLayout(null);
        
        Label memberID = new Label("Enter ID:");
        Label name = new Label("Full Name:");
        Label IC = new Label("IC Number:");
        Label member = new Label("Membership Option:");
        Label fees = new Label("Total fee:");
        Label paymentDate = new Label("Payment Date:");
        ID = new TextField("", 15);
        fullname = new TextField("", 15);
        ICNum = new TextField("", 15);
        membership = new Choice();
        payment = new TextField("", 15);
        date = new TextField("", 15);
        record = new Button("Record");
        search = new Button("Search");
        cancel = new Button("Cancel");
        
        membership.add("Deluxe");
        membership.add("Non-Deluxe");
        membership.add("Week-Day");
        
        memberID.setBounds(78, 45, 60, 10);
        name.setBounds(65, 80, 70, 10);
        IC.setBounds(65, 115, 70, 10);
        member.setBounds(15, 150, 115, 15);
        fees.setBounds(76, 185, 60, 10);
        paymentDate.setBounds(46, 220, 90, 15);
        ID.setBounds(140, 40, 150, 20);
        fullname.setBounds(140, 75, 150, 20);
        ICNum.setBounds(140, 110, 150, 20);
        membership.setBounds(140, 145, 150, 20);
        payment.setBounds(140, 180, 150, 20);
        date.setBounds(140, 215, 150, 20);
        search.setBounds(60, 250, 80, 20);
        record.setBounds(150, 250, 80, 20);
        cancel.setBounds(240, 250, 80, 20);
        
        paymentForm.add(memberID);
        paymentForm.add(name);
        paymentForm.add(IC);
        paymentForm.add(member);
        paymentForm.add(fees);
        paymentForm.add(paymentDate);
        paymentForm.add(ID);
        paymentForm.add(fullname);
        paymentForm.add(ICNum);
        paymentForm.add(membership);
        paymentForm.add(payment);
        paymentForm.add(date);
        paymentForm.add(search);
        paymentForm.add(record);
        paymentForm.add(cancel);
        add(paymentForm, "Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        search.addActionListener(this);
        record.addActionListener(this);
        cancel.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource()== search){
            try{
                searchMember();
            }
            catch (IOException f){
                f.printStackTrace();
            }
        }
        else if(e.getSource() == cancel){
            new mainmenu();
            setVisible(false);
        }
    }
    
    public void searchMember() throws IOException{
        File modify = new File("member.txt");
        try{
            Scanner scan = new Scanner(modify);
            while(scan.hasNext()){
                String member = scan.nextLine();
                String[] details = member.split(":");
                String memberID = details[0];
                String name = details[1];
                String Number = details[2];
                String ship = details[3];

                if(ID.getText().equals(memberID)){
                    fullname.setText(name);
                    ICNum.setText(Number);
                    membership.select(ship);
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Member ID!", "Search Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch (IOException f){
            f.printStackTrace();
        }
    }
}
