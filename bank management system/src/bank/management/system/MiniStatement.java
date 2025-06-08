package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setVerticalAlignment(SwingConstants.TOP);
        JScrollPane scrollPane = new JScrollPane(mini);
        scrollPane.setBounds(20, 140, 360, 600);
        add(scrollPane);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                String cardNumber = rs.getString("cardnumber");
                card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            StringBuilder sb = new StringBuilder("<html>");
            while (rs.next()) {
                sb.append(rs.getString("data")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                  .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                  .append(rs.getString("amount")).append("<br><br>");
            }
            sb.append("</html>");
            mini.setText(sb.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 900);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
