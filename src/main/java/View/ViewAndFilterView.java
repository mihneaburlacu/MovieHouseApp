package View;

import Model.Movie;
import Presenter.PViewAndFilter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewAndFilterView extends JFrame implements IViewAndFilterView{

    private JPanel contentPane;
    private JTable table;
    private JButton viewButton;
    private JComboBox filterComboBox;
    private JTextField filterTextField;
    private JTextField textField;
    private JButton filterButton;
    private PViewAndFilter pViewAndFilter;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewAndFilterView frame = new ViewAndFilterView();
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
    public ViewAndFilterView() {
        setTitle("View and filter");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 890, 586);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("View and filter:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(300, 10, 173, 32);
        contentPane.add(lblNewLabel);

        JLabel viewLabel = new JLabel("View all movies sorted by type and by year:");
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 50, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton("View");
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(527, 57, 115, 29);
        contentPane.add(viewButton);

        JLabel lblFilterAllMovies = new JLabel("Filter all movies by:");
        lblFilterAllMovies.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblFilterAllMovies.setBounds(10, 124, 164, 22);
        contentPane.add(lblFilterAllMovies);

        String[] stringChoices = new String[]{"TYPE", "CATEGORY", "YEAR"};
        filterComboBox = new JComboBox<String>(stringChoices);
        filterComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterComboBox.setBounds(160, 126, 143, 21);
        contentPane.add(filterComboBox);

        filterButton = new JButton("Filter");
        filterButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        filterButton.setBounds(527, 121, 115, 29);
        contentPane.add(filterButton);

        filterTextField = new JTextField();
        filterTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterTextField.setBounds(328, 127, 161, 19);
        contentPane.add(filterTextField);
        filterTextField.setColumns(10);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"
                }
        ));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 192, 761, 347);
        contentPane.add(table);

        pViewAndFilter = new PViewAndFilter(this);

        addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTable();
                pViewAndFilter.viewAllMovies();
            }
        });

        addFilterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTable();
                pViewAndFilter.filterMovies();
            }
        });
    }

    public void resetTable() {
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"
                }
        ));
    }

    @Override
    public void setMovieInTable(int row, Movie movie) {
        this.table.getModel().setValueAt(movie.getID(), row, 0);
        this.table.getModel().setValueAt(movie.getName(), row, 1);
        this.table.getModel().setValueAt(movie.getType().toString(), row, 2);
        this.table.getModel().setValueAt(movie.getCategory(), row, 3);
        this.table.getModel().setValueAt(movie.getYear(), row, 4);
        this.table.getModel().setValueAt(movie.getIdCreator(), row, 5);
    }

    @Override
    public String getFilterFromComboBox() {
        return filterComboBox.getSelectedItem().toString();
    }

    @Override
    public String getFilterTextField() {
        return filterTextField.getText();
    }

    @Override
    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    @Override
    public void addFilterButton(ActionListener actionListener) {
        filterButton.addActionListener(actionListener);
    }

}
