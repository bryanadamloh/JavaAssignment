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
import java.io.FileNotFoundException;
public class Registration extends Frame implements ActionListener {
    
    public static void main(String[] args){
        Registration f2 = new Registration();
    }
    
    TextField fullname, ICNum;
    Choice membership;
    Button create, cancel;
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
        cancel = new Button("Cancel");
                
        membership.add("Deluxe");
        membership.add("Non-Deluxe");
        membership.add("Week-Day");
        
        name.setBounds(65, 70, 70, 10);
        IC.setBounds(65, 105, 70, 10);
        member.setBounds(15, 140, 115, 15);
        fullname.setBounds(140, 65, 150, 20);
        ICNum.setBounds(140, 100, 150, 20);
        membership.setBounds(140, 135, 150, 20);
        create.setBounds(70, 180, 80, 20);
        cancel.setBounds(180, 180, 80, 20);
        
        registrationForm.add(name);
        registrationForm.add(IC);
        registrationForm.add(member);
        registrationForm.add(fullname);
        registrationForm.add(ICNum);
        registrationForm.add(membership);
        registrationForm.add(create);
        registrationForm.add(cancel);
        add(registrationForm, "Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        create.addActionListener(this);
        cancel.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == create){
                try{
                 BufferedReader br= new BufferedReader(new FileReader("member.txt"));
                 if(br.readLine()==null){
                     MemberWrite();
                     fullname.setText("");
                     ICNum.setText("");
                     membership.select("Deluxe");
                 }
                 else{
                     MemberAdd();
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
        else if(e.getSource()== cancel){
            new mainmenu();
            setVisible(false);
        }
    }
    
    public void MemberWrite() throws IOException {
        PrintWriter output = new PrintWriter("Member.txt");       
        output.print(1 + ":" + fullname.getText() + ":" + ICNum.getText() + ":" + membership.getSelectedItem());       
        output.close();
    }
    
    public int readFile() throws IOException { 
        File Register = new File ("member.txt");
        try{
            Scanner input = new Scanner(Register);
            int counter = 1;
            while(input.hasNext()){
                String member = input.nextLine();
                String[] details = member.split(":");

                if(counter==1){
                    counter = Integer.parseInt(details[0]);
                }
                else if(Integer.parseInt(details[0])>counter){
                    counter = Integer.parseInt(details[0]);
                }

            }
            input.close();
            return(counter);
        }
        catch(FileNotFoundException n){
            n.printStackTrace();
        }
        return -1;
    }
    
    public void MemberAdd() throws IOException {
        int count;
        count = readFile();
        BufferedWriter bw = new BufferedWriter (new FileWriter("member.txt",true));
        if (count>0){
            bw.newLine();
        }
        
        bw.write(count+1 + ":" + fullname.getText() + ":" + ICNum.getText() + ":" + membership.getSelectedItem());
        bw.close();
    }
    
}
