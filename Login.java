
package atm.stimulator.system;

import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
       JButton signin,signup,clear;
       JTextField cardnotextfield;
       JPasswordField pintextfield;
       
         Login(){
             setLayout(null);
             setSize(800,500);
             setVisible(true);
             setLocation(380,200);
             ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("imagesforatm/logo.png"));
             Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
             ImageIcon i3=new ImageIcon(i2);
             JLabel label=new JLabel(i3);
             label.setBounds(70,10,100,100);
             getContentPane().setBackground(Color.WHITE);
             
             JLabel text=new JLabel("Welcome to ATM");
             add(text);
             text.setBounds(200, 40, 400, 40);
             text.setFont(new Font("Osward",Font.BOLD,30));
             add(label);
             
             
              JLabel cardno=new JLabel("Card No:");
             cardno.setBounds(130, 130, 150, 90);
             cardno.setFont(new Font("Osward",Font.BOLD,30));
             add(cardno);
             
             
             cardnotextfield=new JTextField();
             add(cardnotextfield);
             cardnotextfield.setBounds(300,150,200,40);
             cardnotextfield.setFont(new Font("Arial",Font.PLAIN,25));
             
             
             JLabel pin=new JLabel("PIN:");
             add(pin);
             pin.setBounds(130,200,150,90);
             pin.setFont(new Font("osward",Font.BOLD,30));
             
             pintextfield=new JPasswordField();
             add(pintextfield);
             pintextfield.setBounds(300,220,200,40);
             
             signin=new JButton("Sign In");
             add(signin);
             signin.setBounds(280,300,120,40);
             signin.addActionListener(this);
             
             clear =new JButton("Clear");
             add(clear);
             clear.setBounds(420,300,120,40);
             clear.addActionListener(this);
             
             signup=new JButton("Sign Up");
             add(signup);
             signup.setBounds(350,380,120,40);
             signup.addActionListener(this);
             revalidate();
             repaint();
             
             setVisible(true);
         }
         @Override
         public void actionPerformed(ActionEvent ae){
             if(ae.getSource()==signin){
              conn c=new conn();
              String cardnumber=cardnotextfield.getText();
              String pinnumber=pintextfield.getText();
              String query1="select*from login where cardno='"+cardnumber+"' and pin='"+pinnumber+"'";
              try{
                  ResultSet rs=c.s.executeQuery(query1);
                  if(rs.next()){
                      setVisible(false);
                      new Transaction(pinnumber).setVisible(true);
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"invalid cardno or PIN");
                  }
              }
              catch(Exception e){
                  System.out.println(e);
              }
             }
             else if(ae.getSource()==signup){
                 setVisible(false);
                new signup().setVisible(true);
                         
             }
             else if(ae.getSource()==clear){
                 cardnotextfield.setText("");
                 pintextfield.setText("");
             }
         }
    public static void main(String args[]) {
      Login l= new Login();
    }
}
