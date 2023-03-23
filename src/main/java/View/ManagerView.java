package View;

import Model.User;
import Presenter.PManager;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ManagerView extends JFrame implements IManager {

    private JPanel contentPane;
    private JLabel welcomeLabel;
    private JLabel insertUsernameLabel;
    private JButton viewButton;
    private PManager pManager;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerView frame = new ManagerView(new User());
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ManagerView(User user) {
        setName("MovieHouse - Manager");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 560, 410);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel("Welcome, ");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(159, 10, 108, 29);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(263, 10, 130, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        JLabel viewLabel = new JLabel("View all movies sorted by type and by year");
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 96, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton("View or filter");
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(159, 202, 156, 29);
        contentPane.add(viewButton);

        JLabel lblOrFilter = new JLabel("Or filter all movies by type, category or year");
        lblOrFilter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblOrFilter.setBounds(10, 130, 332, 22);
        contentPane.add(lblOrFilter);

        pManager = new PManager(this);
        pManager.openViewAndFilter();

        insertUsernameLabel.setText(user.getUsername());

    }

    @Override
    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }
}
