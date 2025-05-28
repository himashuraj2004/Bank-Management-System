
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

public class Withdrawl extends JFrame implements ActionListener{
    
    JButton back, withdrawl;
    JTextField amount;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField("");
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setFont(new Font("System", Font.BOLD, 16));
        withdrawl.setBounds(355, 485, 150, 30);
        withdrawl.setBackground(Color.green);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setBackground(Color.GRAY);
        back.setBounds(170, 485, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
            }
            else{
                try{
                    Conn conn = new Conn();
                    
                    String query1 = "select * from bank where pin = '"+pinnumber+"'";
                    ResultSet rs = conn.s.executeQuery(query1);
                    
                    int balance = 0;
                    while(rs.next()){
                        String type = rs.getString("type");
                        String amt = rs.getString("amount");
                        
                        if(type.equals("Deposit")){
                            balance+=Integer.parseInt(amt);
                        }
                        else if(type.equals("Withdrawl")){
                            balance-=Integer.parseInt(amt);
                        }
                    }
                    
                    int withdrawlAmount = Integer.parseInt(number);
                    if(withdrawlAmount > balance){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    String query2 = "insert into bank value('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" withdrawl succefully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Withdrawl("");
    }
}
