package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField  pan, aadhar;
    JButton next;
    JRadioButton snes, snesn, enes, enesn;
    JComboBox religion, category, income, educational, occupation;
    String formno;
    
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");   
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religion1 = new JLabel("Religion:");
        religion1.setFont(new Font("Raleway", Font.BOLD, 20));
        religion1.setBounds(100, 140, 100, 30);
        add(religion1);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 141, 400, 30);
        add(religion);
        
        JLabel category1 = new JLabel("Category:");
        category1.setFont(new Font("Raleway", Font.BOLD, 20));
        category1.setBounds(100, 190, 200, 30);
        add(category1);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel income1 = new JLabel("Income:");
        income1.setFont(new Font("Raleway", Font.BOLD, 20));
        income1.setBounds(100, 240, 200, 30);
        add(income1);
        
        String incomecategory[] = {"Null", "< 150,000", "< 250,000", "< 500,000", "Upto 1,000,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 310, 200, 30);
        add(qualification);
        
        String educategory[] = {"Non-Graduate", "Graduation", "Post-Graduation", "Doctorate", "Others"};
        educational = new JComboBox(educategory);
        educational.setBounds(300, 315, 400, 30);
        educational.setBackground(Color.WHITE);
        add(educational);
        
        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100, 390, 200, 30);
        add(occ);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panno = new JLabel("Pan Number:");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 440, 200, 30);
        add(panno);
        
        pan = new JTextField();
        pan.setBounds(300, 440, 400, 30);
        pan.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(pan);
        
        JLabel adhar = new JLabel("Aadhaar No.:");
        adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhar.setBounds(100, 490, 200, 30);
        add(adhar);
        
        aadhar = new JTextField();
        aadhar.setBounds(300, 490, 400, 30);
        aadhar.setFont(new Font ("Raleway", Font.BOLD, 20));
        add(aadhar);
        
        JLabel sc = new JLabel("Senior Citizen:");
        sc.setFont(new Font("Raleway", Font.BOLD, 20));
        sc.setBounds(100, 540, 200, 30);
        add(sc);
        
        snes = new JRadioButton("Yes");
        snes.setBounds(300, 540, 100, 30);
        snes.setBackground(Color.WHITE);
        add(snes);
        
        snesn = new JRadioButton("No");
        snesn.setBounds(450, 540, 100, 30);
        snesn.setBackground(Color.WHITE);
        add(snesn);
        
        
        ButtonGroup snesgroup = new ButtonGroup();
        snesgroup.add(snes);
        snesgroup.add(snesn);
        
        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);
        
        enes = new JRadioButton("Yes");
        enes.setBounds(300, 590, 100, 30);
        enes.setBackground(Color.WHITE);
        add(enes);
        
        enesn = new JRadioButton("No");
        enesn.setBounds(450, 590, 100, 30);
        enesn.setBackground(Color.WHITE);
        add(enesn);
        
        ButtonGroup enesgroup = new ButtonGroup();
        enesgroup.add(enes);
        enesgroup.add(enesn);
        
        
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
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) educational.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        String seniorcitizen = null;
        if(snes.isSelected()){
            seniorcitizen = "Yes";
        }else if (snesn.isSelected()){
            seniorcitizen = "No";
        }
         
        String existingaccount = null;
        if(enes.isSelected()){
            existingaccount = "Yes";
        }
        else if(enesn.isSelected()) 
            existingaccount = "No";
        
        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno+"', '" + sreligion+"', '" + scategory+"', '" + sincome+"', '" + seducation+"', '" + soccupation+"', '" + span+"', '" + saadhar+"', '" + seniorcitizen+"', '" + existingaccount+"')" ;
                c.s.executeUpdate(query);
                
                //signup Object;
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new SignupTwo("");
    }
}
