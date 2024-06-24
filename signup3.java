
package atm.stimulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signup3 extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JLabel label1,label2,label3,label4,label5,label6,label7,cardno,pin;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    Random ran=new Random();
    
       signup3(String formno){
           
           
        this.formno=formno;
        
        setSize(800,800);
        setVisible(true);
        setLayout(null);
        setLocation(350,10);
        
        label1=new JLabel("page3: Account Details");
        add(label1);
        label1.setBounds(260,50,350,28);
        label1.setFont(new Font("arial",Font.BOLD,30));
        
        label2=new JLabel("Account Type");
        add(label2);
        label2.setBounds(130,140,250,25);
        label2.setFont(new Font("Arial",Font.BOLD,25));
        
        r1=new JRadioButton("Saving Account");
        add(r1);
        r1.setBounds(130,170,200,20);
        
        r2=new JRadioButton("Fixed Diposite Account");
        add(r2);
        r2.setBounds(360,170,200,20);
        
        r3=new JRadioButton("current Account");
        add(r3);
        r3.setBounds(130,210,200,20);
        
        r4=new JRadioButton("Recurring Deposite Account");
        add(r4);
        r4.setBounds(360,210,200,20);
        
        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        
        
        label3=new JLabel("Card Number");
        add(label3);
        label3.setFont(new Font("Arial",Font.BOLD,25));
        label3.setBounds(130,270,250,20);
        
        label4=new JLabel("your 16 digit card number");
        add(label4);
        label4.setFont(new Font("Arial",Font.BOLD,12));
        label4.setBounds(130,290,250,20);
        
        cardno=new JLabel("XXXX-XXXX-XXXX-4148");
        add(cardno);
        cardno.setBounds(360,270,290,20);
        cardno.setFont(new Font("Arial",Font.BOLD,25));
        
        
        label5=new JLabel("PIN");
        add(label5);
        label5.setFont(new Font("Arial",Font.BOLD,25));
        label5.setBounds(130,350,250,20);
        
        label6=new JLabel("your 4 digit PIN");
        add(label6);
        label6.setFont(new Font("Arial",Font.BOLD,12));
        label6.setBounds(130,370,250,20);
        
        pin=new JLabel("XXXX");
        add(pin);
        pin.setBounds(360,350,250,20);
        pin.setFont(new Font("Arial",Font.BOLD,25));
        
       
        label7=new JLabel("Services Required");
        add(label7);
        label7.setFont(new Font("Arial",Font.BOLD,25));
        label7.setBounds(130,430,250,20);
        
        c1=new JCheckBox("ATM card");
        add(c1);
        c1.setBounds(130,460,200,20);
        
        c2=new JCheckBox("Mobile Banking");
        add(c2);
        c2.setBounds(130,500,200,20);
        
        
        c3=new JCheckBox("Cheque Book");
        add(c3);
        c3.setBounds(130,540,200,20);
        
        
        c4=new JCheckBox("Internet Banking");
        add(c4);
        c4.setBounds(360,460,250,20);
        
        
        c5=new JCheckBox("E-Mail & SMS Alert ");
        add(c5);
        c5.setBounds(360,500,250,20);
        
        
        c6=new JCheckBox("E-Statement");
        add(c6);
        c6.setBounds(360,540,250,20);
        
        c7=new JCheckBox("I hereby declares that the above entered Details are corrct to the best of my Knowledge");
        add(c7);
        c7.setBounds(130,600,550,20);
                
        submit=new JButton("Sumbit");
        submit.setBounds(190,650,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(340,650,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
          
        if(ae.getSource() == submit){
            
             String account_type="";
             if(r1.isSelected()){
                 account_type="Saving Account";
             }
             else if(r2.isSelected()){
                 account_type="Fixed Deposite Account";
             }
             else if(r3.isSelected()){
                 account_type="Current Account";
             }
             else if(r4.isSelected()){
                 account_type="Reccuring Deposite Account";
             }
             
             long random1=Math.abs((ran.nextLong()%90000000L)+5067912000000000L);
             String Cardno=""+random1;
             
             long random2=Math.abs((ran.nextLong()%9000L)+1000L);
             String pin=""+random2;
             
             String facality="";
             
             if(c1.isSelected()){
                 facality += "ATM Card ";
             }
             if(c2.isSelected()){
                 facality+= "Mobile Banking ";
             }
             if(c3.isSelected()){
                 facality+= "Cheque Book ";
             }
             if(c4.isSelected()){
                 facality+= "Internet Banking  ";
             }
             if(c5.isSelected()){
                 facality+= "E-Mail & SMS Alert ";
             }
             if(c6.isSelected()){
                 facality+= "E-Statement ";
             }
             
             try {
                 if(account_type.equals("")){
                     JOptionPane.showMessageDialog(null,"Account Type is Required");
                 }
                 else{
                     conn c=new conn();
                     String query="insert  into signup3 values('"+formno+"','"+account_type+"','"+Cardno+"','"+pin+"','"+facality+"')";
                     String query1="insert into login values('"+formno+"','"+Cardno+"','"+pin+"')";
                     c.s.executeUpdate(query);
                     c.s.executeUpdate(query1);
                 }
             } 
             catch(Exception e){
                 System.out.println(e);
             }
        }
        
        else if(ae.getSource()==cancel)
        {
            
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              new signup3("");
    }
    });
    }
}
