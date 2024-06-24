/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package atm.stimulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup2 extends JFrame implements ActionListener {
    
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
    JComboBox combobox1,combobox2,combobox3,combobox4,combobox5;
    JTextField textfield1,textfield2;
    JRadioButton yes,no,yes1,no1;
    String formno;
    JButton next;
    
      signup2(String formno){
           this.formno=formno;
          
          
      getContentPane().setBackground(Color.WHITE);
      setSize(800,800);
      setVisible(true);
      setLayout(null);
      setLocation(350,10);
      
      label1=new JLabel("Page 2: Additional Details");
      add(label1);
      label1.setBounds(260,50,300,30);
      label1.setFont(new Font("arial",Font.BOLD,25));
      
      label2 = new JLabel("Religion:");
      add(label2);
      label2.setBounds(130,140,150,25);
      label2.setFont(new Font("arial",Font.PLAIN,22));
      
      String religion[]={"Hindu","Muslim","Sikh","Christian","Jain","Other"};
      combobox1=new JComboBox(religion);
      add(combobox1);
      combobox1.setBounds(350,140,300,30);
      combobox1.setBackground(Color.WHITE);
      
      label3 = new JLabel("Category:");
      add(label3);
      label3.setBounds(130,180,150,25);
      label3.setFont(new Font("arial",Font.PLAIN,22));
      
       String category[]={"General","OBC","ST","SC","EWS","PWD"};
      combobox2=new JComboBox(category);
      add(combobox2);
      combobox2.setBounds(350,180,300,30);
      combobox2.setBackground(Color.WHITE);
     
      
      label4 = new JLabel("Income:");
      add(label4);
      label4.setBounds(130,220,150,25);
      label4.setFont(new Font("arial",Font.PLAIN,22));
      
      String Income[]={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
      combobox3=new JComboBox(Income);
      add(combobox3);
      combobox3.setBounds(350,220,300,30);
      combobox3.setBackground(Color.WHITE);
     
      
      label5 = new JLabel("<html>Educational<br>Qualification:</html>");
      add(label5);
      label5.setBounds(130,260,150,50);
      label5.setFont(new Font("arial",Font.PLAIN,22));
      
      String education[]={"Non-Graduation","Graduate","Post-Graduate","Doctrate","up to 10"};
      combobox4=new JComboBox(education);
      add(combobox4);
      combobox4.setBounds(350,260,300,30);
      combobox4.setBackground(Color.WHITE);
     
      
      label6=new JLabel("Occupation:");
      add(label6);
      label6.setBounds(130,340,150,25);
      label6.setFont(new Font("arial",Font.PLAIN,22));
      
      String occupation[]={"Salaried","Self-Employed","Buisnessman","Student","Retired"};
      combobox5=new JComboBox(occupation);
      add(combobox5);
      combobox5.setBounds(350,340,300,30);
      combobox5.setBackground(Color.WHITE);
     
      
      label7 = new JLabel("PAN Number:");
      add(label7);
      label7.setBounds(130,380,150,25);
      label7.setFont(new Font("arial",Font.PLAIN,22));
      
      textfield1=new JTextField();
      add(textfield1);
      textfield1.setBounds(350,380,300,30);
      
      label8=new JLabel("Adhar Number:");
      add(label8);
      label8.setBounds(130,420,200,25);
      label8.setFont(new Font("arial",Font.PLAIN,22));
      
      textfield2=new JTextField();
      add(textfield2);
      textfield2.setBounds(350,420,300,30);
      
      label9= new JLabel("Senior Citizen:");
      add(label9);
      label9.setBounds(130,460,300,30);
      label9.setFont(new Font("arial",Font.PLAIN,22));
      
      yes=new JRadioButton("YES");
      add(yes);
      yes.setBackground(Color.WHITE);
      yes.setBounds(350,460,100,25);
      
      no=new JRadioButton("NO");
      add(no);
      no.setBackground(Color.WHITE);
      no.setBounds(500,460,100,25);
      
      ButtonGroup group=new ButtonGroup();
      group.add(yes);
      group.add(no);
      
      
      label10 = new JLabel("Existing Account:");
      add(label10);
      label10.setBounds(130,500,200,25);
      label10.setFont(new Font("arial",Font.PLAIN,22));
      
      yes1=new JRadioButton("YES");
      add(yes1);
      yes1.setBackground(Color.WHITE);
      yes1.setBounds(350,500,100,25);
      
      no1=new JRadioButton("NO");
      add(no1);
      no1.setBackground(Color.WHITE);
      no1.setBounds(500,500,100,25);
      
      ButtonGroup group1=new ButtonGroup();
      group1.add(yes1);
      group1.add(no1);
      
      next=new JButton("Next");
      add(next);
      next.setBounds(600,600,100,30);
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.addActionListener(this);
      
      
      }
      
      @Override
      public void actionPerformed(ActionEvent ae){ 
          
          String religion=(String)combobox1.getSelectedItem();
          String category=(String)combobox2.getSelectedItem();
          String Income=(String)combobox3.getSelectedItem();
          String education=(String)combobox4.getSelectedItem();
          String occupation=(String)combobox5.getSelectedItem();
          String Aadhar_number=(String)textfield1.getText();
          String Pan_number=(String)textfield2.getText();
          String Senior_citizen=null;
          if(yes.isSelected()){
             Senior_citizen="YES";
             }
          else{
              Senior_citizen="NO";
          }
          String Existing_Account=null;
          if(yes1.isSelected()){
              Existing_Account="YES";
          }
          else{
              Existing_Account="NO";
          }
          
          
          
          try{
              if(textfield1.getText().equals("")||textfield2.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "fill all the required information");
              }
              else{
                  conn c=new conn();
                  String query="insert into signup2(formno,religion,category,Income,education,occupation,Aadhar_number,Pan_number,Senior_citizen,Existing_Account) values ('"+formno+"','"+religion+"','"+category+"','"+Income+"','"+education+"','"+occupation+"','"+Aadhar_number+"','"+Pan_number+"','"+Senior_citizen+"','"+Existing_Account+"')";
                  c.s.executeUpdate(query);
                  
                  setVisible(false);
                  new signup3(formno).setVisible(true);
              }
          }
          catch(Exception e){
           System.out.println(e);
          }
          
      }
      
     public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              new signup2("");
    }
    });
   }
}

