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
public class Modification extends Frame implements ActionListener{
    
    public static void main(String[] args){
        Modification f3 = new Modification();
    }
    
    TextField fullname, ID, ICNum;
    Choice membership;
    Button search, cancel;
    public Modification(){
        setSize(340,250);
        setLocation(900,300);
        setTitle("Edit Member");
        
        setLayout(new BorderLayout());
        Panel modifyForm = new Panel();
        modifyForm.setBackground(Color.GRAY);
        modifyForm.setLayout(null);
        
        Label memberID = new Label("Enter ID:");
        Label name = new Label("Full Name:");
        Label IC = new Label("IC Number:");
        Label member = new Label("Membership Option:");
        ID = new TextField("", 15);
        fullname = new TextField("", 15);
        ICNum = new TextField("", 15);
        membership = new Choice();
        search = new Button("Search");
        cancel = new Button("Cancel");
                
        membership.add("Deluxe");
        membership.add("Non-Deluxe");
        membership.add("Week-Day");
        
        memberID.setBounds(78, 45, 60, 10);
        name.setBounds(65, 80, 70, 10);
        IC.setBounds(65, 115, 70, 10);
        member.setBounds(15, 150, 115, 15);
        ID.setBounds(140, 40, 150, 20);
        fullname.setBounds(140, 75, 150, 20);
        ICNum.setBounds(140, 110, 150, 20);
        membership.setBounds(140, 145, 150, 20);
        search.setBounds(70, 180, 80, 20);
        cancel.setBounds(180, 180, 80, 20);
        
        modifyForm.add(memberID);
        modifyForm.add(name);
        modifyForm.add(IC);
        modifyForm.add(member);
        modifyForm.add(ID);
        modifyForm.add(fullname);
        modifyForm.add(ICNum);
        modifyForm.add(membership);
        modifyForm.add(search);
        modifyForm.add(cancel);
        add(modifyForm, "Center");
        
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
        if(e.getSource() == search){
            try{
                searchMember();
            }
            catch(IOException i){
                i.printStackTrace();
            }
        }
        
        else if (e.getSource() == cancel){
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
