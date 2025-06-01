package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JTextField opin, npin, rnpin;
    JButton back, submit;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(270, 300, 700, 35);
        image.add(text);
        
        JLabel oldpin = new JLabel("Enter your old PIN:");
        oldpin.setForeground(Color.GRAY);
        oldpin.setFont(new Font("System", Font.BOLD, 13));
        oldpin.setBounds(200, 340, 150, 30);
        image.add(oldpin);
        
        opin = new JTextField();
        opin.setForeground(Color.black);
        opin.setBounds(350, 345, 120, 20);
        opin.addActionListener(this);
        image.add(opin);
        
        
        JLabel newpin = new JLabel("Enter your new PIN:");
        newpin.setForeground(Color.GRAY);
        newpin.setFont(new Font("System", Font.BOLD, 13));
        newpin.setBounds(200, 380, 150, 30);
        image.add(newpin);
        
        npin = new JTextField();
        npin.setForeground(Color.black);
        npin.setBounds(350, 385, 120, 20);
        npin.addActionListener(this);
        image.add(npin);
        
        JLabel repin = new JLabel("Re-Enter your new PIN:");
        repin.setForeground(Color.GRAY);
        repin.setFont(new Font("System", Font.BOLD, 13));
        repin.setBounds(200, 420, 150, 30);
        image.add(repin);
        
        rnpin = new JTextField();
        rnpin.setForeground(Color.black);
        rnpin.setBounds(350, 425, 120, 20);
        rnpin.addActionListener(this);
        image.add(rnpin);
        
        back = new JButton("BACK");
        back.setForeground(Color.gray);
        back.setFont(new Font("System", Font.BOLD, 13));
        back.setBounds(200, 485, 100, 20);
        back.addActionListener(this);
        image.add(back);
        
        submit = new JButton("SUBMIT");
        submit.setForeground(Color.gray);
        submit.setFont(new Font("System", Font.BOLD, 13));
        submit.setBounds(370, 485, 100, 20);
        submit.addActionListener(this);
        image.add(submit);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            if(opin.getText().equals("") || npin.getText().equals("") || rnpin.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Text Field can't be empty.");
                return;
            }
            else if(!opin.getText().equals(pinnumber)){
                JOptionPane.showMessageDialog(null, "Incorrect Old-PIN!");
                return;
            }
            else if(!rnpin.getText().equals(npin.getText())){
                JOptionPane.showMessageDialog(null, "New PIN does no match. Please check and re-enter");
                return;
            }
            else if(!rnpin.getText().matches("\\d{4}")) {
            JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits.");
            return;
    }
            else{
                try{
                    Conn c = new Conn();
                    String newpinText = rnpin.getText();
                    String query1 = "update bank set pin = '"+newpinText+"' where pin = '"+pinnumber+"'";
                    String query2 = "update login set pin = '"+newpinText+"' where pin = '"+pinnumber+"'";
                    String query3 = "update signupthree set pin= '"+newpinText+"' where pin = '"+pinnumber+"'";
                    
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    
                    new Transactions(newpinText).setVisible(true);
                } catch(Exception  e){
                    System.out.println(e);
                }
            }
        }
    }  
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
