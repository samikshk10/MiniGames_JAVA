package Main;

import DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegisterPanel extends JFrame implements ActionListener {
    private JTextField player1_username;
    private JTextField player2_username;

    private JButton startButton;

    private JButton cancelButton;

    JLabel label = new JLabel();

    void userRegisterPanel() {
        setTitle("User Panel");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 32, 600, 500);
        mainPanel.setLayout(null);
        JLabel titleLabel = new JLabel("Set UserName");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(150, 20, 400, 50);
        mainPanel.add(titleLabel);
        JLabel player1label = new JLabel("Player1 Username");
        player1label.setFont(new Font("Arial", Font.BOLD, 20));
        player1label.setBounds(20, 100, 400, 50);
        mainPanel.add(player1label);

        JLabel player2label = new JLabel("Player2 Username");
        player2label.setFont(new Font("Arial", Font.BOLD, 20));
        player2label.setBounds(20, 180, 400, 50);
        mainPanel.add(player2label);
        player1_username = new JTextField();
        player1_username.setForeground(Color.BLACK);
        player1_username.setFont(new Font("Arial", Font.BOLD, 15));
        player1_username.setBounds(250, 100, 200, 50);
        player1_username.addActionListener(this);
        mainPanel.add(player1_username);

        player2_username = new JTextField();
        player2_username.setForeground(Color.BLACK);
        player2_username.setFont(new Font("Arial", Font.BOLD, 15));
        player2_username.setBounds(250, 180, 200, 50);
        player2_username.addActionListener(this);
        mainPanel.add(player2_username);

        startButton = new JButton("Start");
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Arial", Font.BOLD, 15));
        startButton.setBounds(20, 250, 200, 50);
        mainPanel.add(startButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(240, 250, 200, 50);
        mainPanel.add(cancelButton);

        startButton.addActionListener(this);
        cancelButton.addActionListener(this);

        label.setBounds(500, 25, this.getWidth(), this.getHeight());
        mainPanel.add(label);
        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            try {
                if (player1_username.getText().trim().isEmpty() || player2_username.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "the field cant be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    throw new Exception("the field cant be empty");
                }

                if (player1_username.getText().equalsIgnoreCase(player2_username.getText())) {
                    JOptionPane.showMessageDialog(this, "The username cannot match", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    throw new Exception("The username cannot match");
                }
                Main menu = new Main(player1_username.getText(), player2_username.getText());
                menu.setVisible(true);
                this.dispose();
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (e.getSource() == cancelButton) {
            GameMenu menu = new GameMenu();
            menu.GameMenu();
            this.dispose();
        }

    }
}
