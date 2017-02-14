/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class login extends Frame implements ActionListener {
    
    public static void main(String[] args){
        login f1 = new login();
    }
    
    TextField user, pass;
    Button login;
    public login(){
        setSize(340,250);
        setLocation(900,300);
        setTitle("Login Page");
        
        setLayout(new BorderLayout());
        Panel form = new Panel();        
        form.setBackground(Color.GRAY);
        form.setLayout(null);
        
        Label username = new Label("Username");
        Label password = new Label("Password");
        user = new TextField("", 15);
        pass = new TextField("", 15);
        login = new Button("Login");
        
        username.setBounds(35, 70, 60, 10);
        password.setBounds(35, 105, 60, 10);
        user.setBounds(120, 65, 150, 20);
        pass.setBounds(120, 100, 150, 20);
        login.setBounds(125, 150, 80, 20);
        
        
        form.add(username);
        form.add(password);
        form.add(user);
        form.add(pass);
        form.add(login);
        add(form,"Center");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        login.addActionListener(this);
        setVisible(true);
    }
    
        public void actionPerformed (ActionEvent e){
        if (e.getSource()==login){
            
            int findID = 1;
            findID = search(user.getText(), pass.getText());
            if (findID >= 0){
                dispose();
                new mainmenu();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Username and Password", "InfoBox: Login Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
        
        public static int search(String user, String pass){
            java.lang.String log;
            log = "login.txt";
            File login = new File(log);
            try{
                Scanner scan = new Scanner(login);
                while (scan.hasNext()){
                    String username = scan.nextLine();
                    String[] details = username.split(":");
                    String name = details[0];
                    String password = details[1];
                    
                    if(name.equals(user)&&password.equals(pass)){
                        return 0;
                    }
                }
            }
            catch(FileNotFoundException s){
 
            }
            return -1;
        }
}


