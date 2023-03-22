package View;

import Model.Enums.Role;
import Model.User;
import Presenter.PLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LogInView extends JFrame implements ILogIn{

    private JPanel contentPane;
    private JButton LogInButton;
    private JLabel welcomeLabel;
    private JLabel logInLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JLabel imageLabel;
    private PLogin pLogin;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogInView frame = new LogInView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public LogInView() {
        setTitle("MovieHouse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 710, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        LogInButton = new JButton("Log In");
        LogInButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        LogInButton.setBounds(250, 320, 157, 40);
        contentPane.add(LogInButton);

        welcomeLabel = new JLabel("Welcome to the Movie House Application!");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        welcomeLabel.setBounds(70, 10, 550, 65);
        contentPane.add(welcomeLabel);

        logInLabel = new JLabel("Please log in into your account!");
        logInLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        logInLabel.setBounds(155, 65, 360, 50);
        contentPane.add(logInLabel);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameLabel.setBounds(25, 160, 100, 30);
        contentPane.add(usernameLabel);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordLabel.setBounds(25, 230, 100, 30);
        contentPane.add(passwordLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(135, 160, 240, 30);
        contentPane.add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(135, 230, 240, 30);
        contentPane.add(passwordTextField);

        imageLabel = new JLabel("");
        ImageIcon img = new ImageIcon("src/Images/movie.png");
        imageLabel.setIcon(img);
        imageLabel.setBounds(454, 112, 166, 194);
        contentPane.add(imageLabel);

        pLogin = new PLogin(this);

        addLogInListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = pLogin.logIn();

                if(user != null) {
                    Role role = user.getRole();

                    if(role == Role.ADMINISTRATOR) {
                        AdministratorView administratorView = new AdministratorView(user);
                        administratorView.setVisible(true);
                    }
                    else if(role == Role.EMPLOYEE) {
                        EmployeeView employeeView = new EmployeeView(user);
                        employeeView.setVisible(true);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again!");
                }
            }
        });
    }

    @Override
    public void addLogInListener(ActionListener actionListener) {
        this.LogInButton.addActionListener(actionListener);
    }

    @Override
    public String getUsernameTextField() {
        return usernameTextField.getText();
    }

    @Override
    public String getPasswordTextField() {
        return passwordTextField.getText();
    }


}
