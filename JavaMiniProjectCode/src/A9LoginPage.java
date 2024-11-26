
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A9LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private A6UserController userController;

    public A9LoginPage() {
        userController = new A6UserController();
        setTitle("Login Page");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginAction());
        add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            dispose();
            new A10RegistrationPage().setVisible(true);
        });
        add(registerButton);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            A3User user = userController.loginUser(username, password);
            if (user != null) {
                JOptionPane.showMessageDialog(A9LoginPage.this, "Login Successful!");
                dispose();
                new A11FlightSearchPage(user).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(A9LoginPage.this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class A9LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private A6UserController userController;
    private BufferedImage backgroundImage;

    public A9LoginPage() {
        userController = new A6UserController();
        setTitle("Login Page");
        setSize(728, 485); // Smaller size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/aaral/Desktop/Javaprojects/Newproject2/src/images/f4.jpg")); // Update with your image path
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

        // Username Label with Background
        gbc.gridx = 0;
        gbc.gridy = 0;
        JPanel usernamePanel = new JPanel();
        usernamePanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
        usernamePanel.add(new JLabel("Username:"));
        panel.add(usernamePanel, gbc);

        // Username Text Field
        gbc.gridx = 1;
        usernameField = new JTextField(15); // Fixed size for the text field
        panel.add(usernameField, gbc);

        // Password Label with Background
        gbc.gridx = 0;
        gbc.gridy = 1;
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
        passwordPanel.add(new JLabel("Password:"));
        panel.add(passwordPanel, gbc);

        // Password Text Field
        gbc.gridx = 1;
        passwordField = new JPasswordField(15); // Fixed size for the password field
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginAction());
        panel.add(loginButton, gbc);

        gbc.gridx = 1;
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            dispose();
            new A10RegistrationPage().setVisible(true);
        });
        panel.add(registerButton, gbc);

        // Add the panel to the frame
        setContentPane(panel);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            A3User user = userController.loginUser(username, password);
            if (user != null) {
                JOptionPane.showMessageDialog(A9LoginPage.this, "Login Successful!");
                dispose();
                new A11FlightSearchPage(user).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(A9LoginPage.this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new A9LoginPage().setVisible(true));
    }
}