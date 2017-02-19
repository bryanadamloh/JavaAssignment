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
public class Modification extends Frame implements ActionListener{
    
    public static void main(String[] args){
        Modification f3 = new Modification();
    }
    
    TextField fullname, ID, ICNum;
    Choice membership;
    Button search, modify, cancel;
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
        modify = new Button("Modify");
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
        search.setBounds(30, 180, 80, 20);
        modify.setBounds(120, 180, 80, 20);
        cancel.setBounds(210, 180, 80, 20);
        
        modifyForm.add(memberID);
        modifyForm.add(name);
        modifyForm.add(IC);
        modifyForm.add(member);
        modifyForm.add(ID);
        modifyForm.add(fullname);
        modifyForm.add(ICNum);
        modifyForm.add(membership);
        modifyForm.add(search);
        modifyForm.add(modify);
        modifyForm.add(cancel);
        add(modifyForm, "Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        search.addActionListener(this);
        modify.addActionListener(this);
        cancel.addActionListener(this);
        
        fullname.enable(false);
        ICNum.enable(false);
        membership.enable(false);
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
        else if(e.getSource() == modify){
            try{
                modifyMember();
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
        FileReader modify = new FileReader("member.txt");
        
            Scanner scan = new Scanner(modify);
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
                    membership.select(ship);
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
        modify.close();  
    }
  
    public void modifyMember() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("member.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));
            
            String data;
            while((data = br.readLine()) != null){
                String[] details = data.split(":");
                String memberID = details[0];
                String name = details[1];
                String number = details[2];
                String member = details[3];
                
                if(memberID.equals(ID.getText())){
                    data = data.replace(name,fullname.getText());
                    data = data.replace(number, ICNum.getText());
                    data = data.replace(member, membership.getSelectedItem());             
                }
                bw.write(data + "\n");
            }
        
                if(br != null){
                    br.close();
                }
            
                if(bw != null){
                    bw.close();
                }       
        
        File memberfile = new File("member.txt");
        memberfile.delete();
        
        File temp = new File("temp.txt");
        temp.renameTo(memberfile);
        
        JOptionPane.showMessageDialog(null, "Data has been modified!", "Modify Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
