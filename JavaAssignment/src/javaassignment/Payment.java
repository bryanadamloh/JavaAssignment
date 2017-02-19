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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Payment extends Frame implements ActionListener{
    
    public static void main(String[] args){
        Payment f4 = new Payment();   
    }
    
    TextField fullname, ID, membership, payment, ICNum, date, staff;
    Choice payType;
    Button record, search, cancel;
    public Payment(){
        setSize(390,400);
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
        Label type = new Label("Payment Type:");
        Label fees = new Label("Total fee:");
        Label paymentDate = new Label("Payment Date:");
        Label staffname = new Label ("Staff Name:");
        ID = new TextField("", 15);
        fullname = new TextField("", 15);
        ICNum = new TextField("", 15);
        membership = new TextField("", 15);
        payType = new Choice();
        payment = new TextField("", 15);
        date = new TextField("", 15);
        staff = new TextField("", 15);
        record = new Button("Record");
        search = new Button("Search");
        cancel = new Button("Cancel");

        payType.add("Registration");
        payType.add("Monthly");
        
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
        search.setBounds(60, 330, 80, 20);
        record.setBounds(150, 330, 80, 20);
        cancel.setBounds(240, 330, 80, 20);
        
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
        paymentForm.add(record);
        paymentForm.add(cancel);
        add(paymentForm, "Center");
        
        payType.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent i){
                if(payType.getSelectedItem().equals("Registration") && membership.getText().equals("Deluxe")){
                    payment.setText("RM500");
                }
                else if(payType.getSelectedItem().equals("Registration") && membership.getText().equals("Non-Deluxe")){
                    payment.setText("RM300");
                }
                else if(payType.getSelectedItem().equals("Registration") && membership.getText().equals("Week-Day")){
                    payment.setText("RM180");
                }
                else if(payType.getSelectedItem().equals("Monthly") && membership.getText().equals("Deluxe")){
                    payment.setText("RM120");
                }
                else if(payType.getSelectedItem().equals("Monthly") && membership.getText().equals("Non-Deluxe")){
                    payment.setText("RM100");
                }
                else if(payType.getSelectedItem().equals("Monthly") && membership.getText().equals("Week-Day")){
                    payment.setText("RM75");
                }
            }
    });
        
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
        
        else if(e.getSource() == record){
            try{
                BufferedReader br = new BufferedReader (new FileReader("payment.txt"));
                    if(br.readLine()==null){
                        paymentWrite();
                        ID.setText("");
                        ID.enable(true);
                        fullname.setText("");
                        ICNum.setText("");
                        membership.setText("");
                        payType.select("Registration");
                        payment.setText("");
                        date.setText("");
                }
                    else{
                        paymentAdd();
                        ID.setText("");
                        ID.enable(true);
                        fullname.setText("");
                        ICNum.setText("");
                        membership.setText("");
                        payType.select("Registration");
                        payment.setText("");
                        date.setText("");
                    }
                    JOptionPane.showMessageDialog(null, "Payment has been made successfully!", "Payment Info", JOptionPane.INFORMATION_MESSAGE);
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
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date todaydate = new Date();
        FileReader search = new FileReader("member.txt");
        
            Scanner scan = new Scanner(search);
            boolean found = false;
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
                    membership.setText(ship);
                    date.setText(df.format(todaydate));
                    staff.setText(login.staffuser);
                    ID.enable(false);
                    fullname.enable(true);
                    ICNum.enable(true);
                    membership.enable(true);
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
    
    public void paymentWrite() throws IOException{
        PrintWriter output = new PrintWriter("payment.txt");
        output.print(ID.getText() + ":" + fullname.getText() + ":" + ICNum.getText() + ":" + membership.getText() + ":" + payType.getSelectedItem() + ":" + payment.getText() + ":" + date.getText() + ":" + staff.getText());
        output.close();
    }
    
    public int readFile() throws IOException{
        File payment = new File("payment.txt");
        try{
            Scanner input = new Scanner(payment);
            int counter = 1;
            while (input.hasNext()){
                String pay = input.nextLine();
                String [] details = pay.split(":");
                
                if(counter==1){
                    counter = Integer.parseInt(details[0]);
                }
                else if (Integer.parseInt(details[0])>counter){
                    counter = Integer.parseInt(details[0]);
                }
            }
            input.close();
            return(counter);
        }
        catch(FileNotFoundException d){
            d.printStackTrace();
        }
        return -1;
    }
    
    public void paymentAdd() throws IOException{
        int count;
        count = readFile();
        BufferedWriter bw = new BufferedWriter (new FileWriter("payment.txt", true));
        if(count>0){
            bw.newLine();
        }
        
        bw.write(ID.getText() + ":" + fullname.getText() + ":" + ICNum.getText() + ":" + membership.getText() + ":" + payType.getSelectedItem() + ":" + payment.getText() + ":" + date.getText() + ":" + staff.getText());
        bw.close();
    }
   
}
