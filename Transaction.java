
package atm.stimulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    
    JLabel label,label1;
    JButton button1,button2,button3,button4,button5,button6,button7;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setSize(800,800);
        setUndecorated(true);
        setVisible(true);
        setLocation(300,10);
        setLayout(null);
        
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("imagesforatm/atm.jpg"));
        Image image2=image1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);
        
        label=new JLabel(image3);
        add(label);
        label.setBounds(0,0,800,800);
        
        label1=new JLabel("Please Select Your Transaction");
        label.add(label1);
        label1.setBounds(200,250,400,30);
        label1.setForeground(Color.WHITE);
        
        button1=new JButton("Deposite");
        button1.setBounds(145,370,150,25);
        label.add(button1);
        button1.addActionListener(this);
        
        button2=new JButton("Cash Withdrawl");
        button2.setBounds(300,370,150,25);
        label.add(button2);
        button2.addActionListener(this);
        
        button3=new JButton("Fast Cash");
        button3.setBounds(145,400,150,25);
        label.add(button3);
        button3.addActionListener(this);
        
        button4=new JButton("mini Statement");
        button4.setBounds(300,400,150,25);
        label.add(button4);
        button4.addActionListener(this);
        
        button5=new JButton("PIN change");
        button5.setBounds(145,430,150,25);
        label.add(button5);
        button5.addActionListener(this);
        
        button6=new JButton("Balance enquiry");
        button6.setBounds(300,430,150,25);
        label.add(button6);
        button6.addActionListener(this);
        
        button7=new JButton("EXIT");
        label.add(button7);
        button7.setBounds(300,460,150,22);
        button7.addActionListener(this);
        
        }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==button7){
            System.exit(0);
        }
        
        
    }

    public static void main(String args[]) {
          SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Transaction("");
            }    
         });
    }
}
