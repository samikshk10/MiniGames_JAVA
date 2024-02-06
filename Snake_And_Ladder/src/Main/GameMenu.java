package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMenu extends JFrame implements ActionListener {
    private JButton startButton;
    private JButton settingsButton;
    private JButton exitButton;

    JLabel label = new JLabel();

    void GameMenu() {
        setTitle("Snake and Ladder");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        // mainPanel.setBackground(Color.BLUE);
        mainPanel.setBounds(0, 32, 500, 500);
        mainPanel.setLayout(null);
        // mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel titleLabel = new JLabel("Snake and Ladder ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(300, 20, 400, 50);
        mainPanel.add(titleLabel);
        // titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        startButton = new JButton("Start Game");
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Arial", Font.BOLD, 15));
        startButton.setBounds(100, 100, 200, 50);
        startButton.setFocusable(false);

        settingsButton = new JButton("Game History");
        settingsButton.setBounds(100, 200, 200, 50);
        settingsButton.setFocusable(false);

        exitButton = new JButton("Exit Game");
        exitButton.setBounds(100, 300, 200, 50);
        exitButton.setFocusable(false);

        startButton.addActionListener(this);
        settingsButton.addActionListener(this);
        exitButton.addActionListener(this);

        mainPanel.add(startButton);
        mainPanel.add(settingsButton);
        mainPanel.add(exitButton);
        ImageIcon image = new ImageIcon();
        label.setIcon(loadImage("/Image/Snake0.png"));
        label.setBounds(500, 25, this.getWidth(), this.getHeight());
        mainPanel.add(label);
        getContentPane().add(mainPanel);
        setVisible(true);
    }

    private ImageIcon loadImage(String path) {
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaled = image.getScaledInstance(400, 375, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            UserRegisterPanel urpanel = new UserRegisterPanel();
            urpanel.userRegisterPanel();

            this.dispose();

        } else if (e.getSource() == settingsButton) {
            try {
                GameHistory gh = new GameHistory();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();

        } else if (e.getSource() == exitButton) {
            int confirmExit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit",
                    JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

}
