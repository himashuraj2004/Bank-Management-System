package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, dobTextField, mailTF, addressTextField, stateTextField, cityTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    SignupTwo(){
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religion1 = new JLabel("Religion:");
        religion1.setFont(new Font("Raleway", Font.BOLD, 20));
        religion1.setBounds(100, 140, 100, 30);
        add(religion1);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        JComboBox religion = new JComboBox(valReligion);
        religion.setBounds(300, 141, 400, 30);
        add(religion);
        
        JLabel category1 = new JLabel("Category:");
        category1.setFont(new Font("Raleway", Font.BOLD, 20));
        category1.setBounds(100, 190, 200, 30);
        add(category1);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        JComboBox category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel income1 = new JLabel("Income:");
        income1.setFont(new Font("Raleway", Font.BOLD, 20));
        income1.setBounds(100, 240, 200, 30);
        add(income1);
        
        String incomecategory[] = {"Null", "< 150000", "<250000", "< 500000", "Upto 1000000"};
        JComboBox income = new JComboBox(incomecategory);
        income.setBounds(300, 190, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel education = new JLabel("Educational:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 90, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 90, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        mailTF = new JTextField();
        mailTF.setBounds(300, 340, 400, 30);
        mailTF.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(mailTF);
        
        JLabel mstatus = new JLabel("Occupation:");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        mstatus.setBounds(100, 390, 200, 30);
        add(mstatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 90, 30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 90, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(600, 390, 90, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup marital = new ButtonGroup();
        marital.add(married);
        marital.add(unmarried);
        marital.add(other);
        
        JLabel address = new JLabel("Pan Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setBounds(300, 440, 400, 30);
        addressTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(addressTextField);
        
        JLabel city = new JLabel("Aadhaar No.:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 400, 30);
        cityTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(cityTextField);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 540, 400, 30);
        stateTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(stateTextField);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300, 590, 400, 30);
        pincodeTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 640, 100, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE); 
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; //long
        String name = nameTextField.getText(); //setText
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }
        
        String email = mailTF.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()) marital = "Unamrried";
        else if (other.isSelected()) marital = "Other";
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno+"', '" + name+"', '" + fname+"', '" + dob+"', '" + gender+"', '" + email+"', '" + marital+"', '" + address+"', '" + city+"', '" + pin+"', '" + state+"')" ;
                c.s.executeUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new SignupTwo();
    }
}
