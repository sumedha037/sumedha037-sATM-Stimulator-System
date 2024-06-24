
package atm.stimulator.system;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener {
    long random1;
    JTextField label3textfield,label4textfield,label7textfield,label8textfield,label9textfield,label10textfield,label11textfield;
    JDateChooser datechooser;
    JRadioButton male,female;
    JButton next;
    String formno;
    
    signup(){
       
       
      getContentPane().setBackground(Color.WHITE);
      setSize(800,800);
      setLocation(350,10);
      setVisible(true);
      setLayout(null);
      setTitle("Application form for atm page-2");
      
      
      Random ran=new Random();
      random1=(Math.abs(ran.nextLong()%9000)+1000);
       formno=""+random1;
      
      JLabel label1=new JLabel("Appliction Form No. "+random1);
      add(label1);
      label1.setFont(new Font("arial",Font.BOLD,38));
      label1.setBounds(150,20,600,40);
      
      
      JLabel label2=new JLabel("Personal Details: page1");
      add(label2);
      label2.setFont(new Font("arial",Font.BOLD,22));
      label2.setBounds(250,90,400,30);
      
      JLabel label3=new JLabel("Name:");
      add(label3);
      label3.setFont(new Font("arial",Font.BOLD,20));
      label3.setBounds(100,160,200,25);
      
       label3textfield=new JTextField();
      add(label3textfield);
      label3textfield.setBounds(320,160,250,25);
      
      JLabel label4=new JLabel("Father's Name:");
      add(label4);
      label4.setFont(new Font("arial",Font.BOLD,20));
      label4.setBounds(100,200,200,25);
      
      label4textfield=new JTextField();
      add(label4textfield);
      label4textfield.setBounds(320,200,250,25);
      
      JLabel label5=new JLabel("Date Of Birth");
      add(label5);
      label5.setFont(new Font("arial",Font.BOLD,20));
      label5.setBounds(100,240,200,25);
      
      datechooser=new JDateChooser();
      add(datechooser);
      datechooser.setBounds(320,240,250,25);
      
      JLabel label6=new JLabel("Gender:");
      add(label6);
      label6.setFont(new Font("arial",Font.BOLD,20));
      label6.setBounds(100,280,200,25);
      
      male=new JRadioButton("Male");
      male.setBounds(320,280,150,25);
      male.setBackground(Color.WHITE);
      add(male);
      
      female=new JRadioButton("Female");
      female.setBounds(500,280,150,25);
      female.setBackground(Color.WHITE);
      add(female);
      
     ButtonGroup group=new ButtonGroup();
     group.add(male);
     group.add(female);
      
      
      JLabel label7=new JLabel("Email Address:");
      add(label7);
      label7.setFont(new Font("arial",Font.BOLD,20));
      label7.setBounds(100,320,200,25);
      
      label7textfield=new JTextField();
      add(label7textfield);
      label7textfield.setBounds(320,320,250,25);
      
      JLabel label8=new JLabel("Address:");
      add(label8);
      label8.setFont(new Font("arial",Font.BOLD,20));
      label8.setBounds(100,360,200,25);
      
      label8textfield=new JTextField();
      add(label8textfield);
      label8textfield.setBounds(320,360,250,25);
      
      JLabel label9=new JLabel("City:");
      add(label9);
      label9.setFont(new Font("arial",Font.BOLD,20));
      label9.setBounds(100,400,200,25);
      
      label9textfield=new JTextField();
      add(label9textfield);
      label9textfield.setBounds(320,400,250,25);
      
      JLabel label10=new JLabel("State:");
      add(label10);
      label10.setFont(new Font("arial",Font.BOLD,20));
      label10.setBounds(100,440,200,25);
      
      label10textfield=new JTextField();
      add(label10textfield);
      label10textfield.setBounds(320,440,250,25);
      
       JLabel label11=new JLabel("PinCode:");
      add(label11);
      label11.setFont(new Font("arial",Font.BOLD,20));
      label11.setBounds(100,480,200,25);
      
      label11textfield=new JTextField();
      add(label11textfield);
      label11textfield.setBounds(320,480,250,25);
      
      next=new JButton("Next");
      add(next);
      next.setBounds(400,550,80,40);
      next.addActionListener(this);
     
   }
    
    @Override 
    public void actionPerformed(ActionEvent ae){
  
        String formno1=formno;
        String name=label3textfield.getText();
        String fname=label4textfield.getText();
        String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }
        else{
            gender="female";
        }
        String email=label7textfield.getText();
        String address=label8textfield.getText();
        String city=label9textfield.getText();
        String state=label10textfield.getText();
        String pin=label11textfield.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"name is required");
              }
            else{
                conn c=new conn();
                String query="insert into signup1(formno,name,fname,dob,gender,email,address,city,state,pin) values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Sign up successful!");
                
                setVisible(false);
                new signup2(formno1).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new signup();
                
            }
        });
    }
}
