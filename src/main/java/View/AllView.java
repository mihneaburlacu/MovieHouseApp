package View;

import Model.Movie;
import Model.User;
import Presenter.PAdministrator;
import Presenter.PEmployee;
import Presenter.PManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllView extends JFrame implements IAll {

    private JPanel contentPane;
    private JTable table;
    private PAdministrator pAdministrator;
    private PEmployee pEmployee;
    private String whoOpens;
    private String whatToDo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AllView frame = new AllView(new PAdministrator());
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
    public AllView(PAdministrator pAdministrator) {
        setTitle("View all");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 795, 460);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("View all:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(300, 10, 173, 32);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "Name", "Username", "Password", "Role"},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "ID", "Name", "Username", "Password", "Role", ""
                }
        ));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 66, 761, 347);
        contentPane.add(table);

        this.pAdministrator = pAdministrator;
        this.pAdministrator.setiAllUsers(this);

        pAdministrator.viewAllUsers();
    }

    @Override
    public void setUserInTable(int row, User user) {
        this.table.getModel().setValueAt(user.getID(), row, 0);
        this.table.getModel().setValueAt(user.getName(), row, 1);
        this.table.getModel().setValueAt(user.getUsername(), row, 2);
        this.table.getModel().setValueAt(user.getPassword(), row, 3);
        this.table.getModel().setValueAt(user.getRole().toString(), row, 4);
    }
}
