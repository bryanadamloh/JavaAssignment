/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

import java.awt.*;
import java.awt.event.*;
public class login extends Frame {
    
    public static void main(String[] args){
        login f1 = new login();
    }
    
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
        TextField user = new TextField("", 15);
        TextField pass = new TextField("", 15);
        Button login = new Button("Login");
        
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
        
        setVisible(true);
    }
}

