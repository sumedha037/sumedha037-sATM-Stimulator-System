
package atm.stimulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Deposite extends JFrame implements ActionListener {
    
    Deposite(){
        setSize(800,800);
        setVisible(true);
        setLayout(null);
        setLocation(300,10);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("imagesforatm/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel label=new JLabel(i3);
        add(label);
        label.setBounds(0,0,800,800);
        
        JLabel label1=new JLabel("Enter the amount you want to deposite:");
        label.add(label1);
        label1.setBounds(160,270,400,30);
        label1.setForeground(Color.WHITE);
        
        JTextField textfield1=new JTextField();
        label.add(textfield1);
        textfield1.setBounds(160,300,200,30);
        textfield1.setFont(new Font("Arial",Font.BOLD,20));
        JButton button1=new JButton("Deposite");
        label.add(button1);
        button1.setBounds(300,430,150,25);
        
        JButton button2=new JButton("Back");
        label.add(button2);
        button2.setBounds(300,460,150,25);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
    }
    
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable(){
         public void run(){
             new Deposite();
         }
        });
    }
}
