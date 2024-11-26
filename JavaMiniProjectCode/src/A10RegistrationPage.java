
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A10RegistrationPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private A6UserController userController;

    public A10RegistrationPage() {
        userController = new A6UserController();
        setTitle("Registration Page");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegisterAction());
        add(registerButton);

        JButton backButton = new JButton("Back to Login");
        backButton.addActionListener(e -> {
            dispose();
            new A9LoginPage().setVisible(true);
        });
        add(backButton);
    }

    private class RegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            A3User user = new A3User();
            user.setUsername(usernameField.getText());
            user.setPassword(new String(passwordField.getPassword()));
            user.setEmail(emailField.getText());

            if (userController.registerUser(user)) {
                JOptionPane.showMessageDialog(A10RegistrationPage.this, "Registration successful!");
                dispose();
                new A9LoginPage().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(A10RegistrationPage.this, "Registration failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class A10RegistrationPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private A6UserController userController;
    private BufferedImage backgroundImage;

    public A10RegistrationPage() {
        userController = new A6UserController();
        setTitle("Registration Page");
        setSize(728, 485);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/aaral/Desktop/Javaprojects/Newproject2/src/images/f3.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a custom panel for the background image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false); // Allow transparency

        // Create layout constraints for centering components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Add components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Create a panel for the Username label
        JPanel usernamePanel = new JPanel();
        usernamePanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
        usernamePanel.add(new JLabel("Username:"));
        panel.add(usernamePanel, gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(15); // Fixed size for the text field
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        // Create a panel for the Password label
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
        passwordPanel.add(new JLabel("Password:"));
        panel.add(passwordPanel, gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15); // Fixed size for the password field
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        // Create a panel for the Email label
        JPanel emailPanel = new JPanel();
        emailPanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
        emailPanel.add(new JLabel("Email:"));
        panel.add(emailPanel, gbc);

        gbc.gridx = 1;
        emailField = new JTextField(15); // Fixed size for the email field
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegisterAction());
        panel.add(registerButton, gbc);

        gbc.gridx = 1;
        JButton backButton = new JButton("Back to Login");
        backButton.addActionListener(e -> {
            dispose();
            new A9LoginPage().setVisible(true);
        });
        panel.add(backButton, gbc);

        // Add the panel to the frame
        setContentPane(panel);
    }

    private class RegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            A3User user = new A3User();
            user.setUsername(usernameField.getText());
            user.setPassword(new String(passwordField.getPassword()));
            user.setEmail(emailField.getText());

            if (userController.registerUser(user)) {
                JOptionPane.showMessageDialog(A10RegistrationPage.this, "Registration successful!");
                dispose();
                new A9LoginPage().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(A10RegistrationPage.this, "Registration failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new A10RegistrationPage().setVisible(true));
    }
}