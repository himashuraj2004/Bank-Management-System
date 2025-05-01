package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame{
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        setTitle("formno." + random);
        JLabel formno = new JLabel("Application No." + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(230, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(300, 141, 400, 30);
        nameTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        JTextField fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        fnameTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(300, 290, 90, 30);
        male.setBackground(Color.WHITE);
        add(male);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(450, 290, 90, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        JTextField mailTF = new JTextField();
        mailTF.setBounds(300, 340, 400, 30);
        mailTF.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(mailTF);
        
        JLabel mstatus = new JLabel("Marital Status:");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        mstatus.setBounds(100, 390, 200, 30);
        add(mstatus);
        
        JRadioButton married = new JRadioButton("Married");
        married.setBounds(300, 390, 90, 30);
        married.setBackground(Color.WHITE);
        add(married);
        JRadioButton unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 90, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        JRadioButton other = new JRadioButton("Other");
        other.setBounds(600, 390, 90, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup marital = new ButtonGroup();
        marital.add(married);
        marital.add(unmarried);
        marital.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        JTextField addressTextField = new JTextField();
        addressTextField.setBounds(300, 440, 400, 30);
        addressTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        JTextField cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 400, 30);
        cityTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        JTextField stateTextField = new JTextField();
        stateTextField.setBounds(300, 540, 400, 30);
        stateTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin-Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        JTextField pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300, 590, 400, 30);
        pincodeTextField.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(pincodeTextField);
        
        JButton text = new JButton("Next");
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setBounds(600, 640, 100, 30);
        add(text);
        
        getContentPane().setBackground(Color.WHITE); 
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    public static void main(String[] args){
        new SignupOne();
    }
}
