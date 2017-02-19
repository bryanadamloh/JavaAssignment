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
public class SearchPayment extends Frame implements ActionListener{
    
    public static void main(String[] args){
        SearchPayment f5 = new SearchPayment();   
    }
    
    TextField fullname, ID, membership, payment, ICNum, date, staff, payType;
    Button search, cancel;
    public SearchPayment(){
        setSize(390,400);
        setLocation(900,300);
        setTitle("Search Payment Details");
        
        setLayout(new BorderLayout());
        Panel paymentForm = new Panel();
        paymentForm.setBackground(Color.GRAY);
        paymentForm.setLayout(null);
        
        Label memberID = new Label("Enter ID:");
        Label name = new Label("Full Name:");
        Label IC = new Label("IC Number:");
        Label member = new Label("Membership Option:");
        Label type = new Label("Payment Type:");
        Label fees = new Label("Total fee:");
        Label paymentDate = new Label("Payment Date:");
        Label staffname = new Label ("Staff Name:");
        ID = new TextField("", 15);
        fullname = new TextField("", 15);
        ICNum = new TextField("", 15);
        membership = new TextField("", 15);
        payType = new TextField("", 15);
        payment = new TextField("", 15);
        date = new TextField("", 15);
        staff = new TextField("", 15);
        search = new Button("Search");
        cancel = new Button("Cancel");
        
        memberID.setBounds(78, 45, 60, 10);
        name.setBounds(65, 80, 70, 10);
        IC.setBounds(65, 115, 70, 10);
        member.setBounds(15, 150, 115, 15);
        type.setBounds(46, 184, 85, 15);
        fees.setBounds(76, 220, 60, 10);
        paymentDate.setBounds(46, 255, 90, 15);
        staffname.setBounds(62, 290, 70, 15);
        ID.setBounds(140, 40, 150, 20);
        fullname.setBounds(140, 75, 150, 20);
        ICNum.setBounds(140, 110, 150, 20);
        membership.setBounds(140, 145, 150, 20);
        payType.setBounds(140, 180, 150, 20);
        payment.setBounds(140, 215, 150, 20);
        date.setBounds(140, 250, 150, 20);
        staff.setBounds(140, 285, 150, 20);
        search.setBounds(90, 330, 80, 20);
        cancel.setBounds(200, 330, 80, 20);
        
        paymentForm.add(memberID);
        paymentForm.add(name);
        paymentForm.add(IC);
        paymentForm.add(member);
        paymentForm.add(type);
        paymentForm.add(fees);
        paymentForm.add(paymentDate);
        paymentForm.add(staffname);
        paymentForm.add(ID);
        paymentForm.add(fullname);
        paymentForm.add(ICNum);
        paymentForm.add(membership);
        paymentForm.add(payType);
        paymentForm.add(payment);
        paymentForm.add(date);
        paymentForm.add(staff);
        paymentForm.add(search);
        paymentForm.add(cancel);
        add(paymentForm, "Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        search.addActionListener(this);
        cancel.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource()== search){
            try{
                searchPayment();
            }
            catch (IOException f){
                f.printStackTrace();
            }
        }
        
        else if (e.getSource()== cancel){
            new mainmenu();
            setVisible(false);
        }
    }
    
    public void searchPayment() throws IOException{
        FileReader search = new FileReader("payment.txt");
        
        Scanner scan = new Scanner (search);
        boolean found = false;
        while(scan.hasNext()){
            String paymentsearch = scan.nextLine();
            String[] details = paymentsearch.split(":");
            String memberID = details[0];
            String name = details[1];
            String Number = details[2];
            String ship = details[3];
            String paymentType = details[4];
            String fees = details[5];
            String Date = details[6];
            String username = details[7];
            
            if(ID.getText().equals(memberID)){
                fullname.setText(name);
                ICNum.setText(Number);
                membership.setText(ship);
                payType.setText(paymentType);
                payment.setText(fees);
                date.setText(Date);
                staff.setText(username);
                ID.enable(true);
                found = true;
                break;
        }
            else{
                found = false;
            }
        }
        if(!found){
                JOptionPane.showMessageDialog(null, "Invalid Member ID!", "Search Info", JOptionPane.INFORMATION_MESSAGE);
            }
        search.close();
    }
    
}
