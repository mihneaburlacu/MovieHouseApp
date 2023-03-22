package View;

import Model.Enums.Type;
import Model.Movie;
import Model.User;
import Presenter.PAdministrator;
import Presenter.PEmployee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EmployeeView extends JFrame implements IEmployee{

    private JPanel contentPane;
    private JLabel welcomeLabel;
    private JTable createTable;
    private JLabel insertUsernameLabel;
    private JButton createButton;
    private JTextField nameReadTextField;
    private JTextField idReadTextField;
    private JButton readButton;
    private JTable readTable;
    private JTable updateTable;
    private JTextField updateIDTextField;
    private JTextField nameDeleteTextField;
    private JTextField idDeleteTextField;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton filterButton;
    private JComboBox filterComboBox;
    private JTextField filterTextField;
    private PEmployee pEmployee;
    private User employee;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmployeeView frame = new EmployeeView(new User());
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
    public EmployeeView(User employee) {
        setTitle("MovieHouse - Employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 785, 575);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel("Welcome, ");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(250, 10, 108, 29);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(356, 10, 130, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        JLabel createLabel = new JLabel("Create movie:");
        createLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createLabel.setBounds(10, 36, 108, 22);
        contentPane.add(createLabel);

        createTable = new JTable();
        createTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column"
                }
        ));
        createTable.setBounds(20, 90, 433, 16);
        contentPane.add(createTable);

        createButton = new JButton("Create");
        createButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createButton.setBounds(485, 82, 115, 29);
        contentPane.add(createButton);

        JLabel idInsertLabel = new JLabel("ID");
        idInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idInsertLabel.setBounds(36, 69, 45, 13);
        contentPane.add(idInsertLabel);

        JLabel nameInsertLabel = new JLabel("Name");
        nameInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel.setBounds(124, 69, 45, 13);
        contentPane.add(nameInsertLabel);

        JLabel typeInsertLabel = new JLabel("Type");
        typeInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        typeInsertLabel.setBounds(188, 69, 74, 13);
        contentPane.add(typeInsertLabel);

        JLabel categoryInsertLabel = new JLabel("Category");
        categoryInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        categoryInsertLabel.setBounds(282, 69, 76, 13);
        contentPane.add(categoryInsertLabel);

        JLabel lblYear = new JLabel("Year");
        lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblYear.setBounds(368, 69, 45, 13);
        contentPane.add(lblYear);

        JLabel readLabel = new JLabel("Read movie:");
        readLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readLabel.setBounds(10, 116, 108, 22);
        contentPane.add(readLabel);

        JLabel readNameLabel = new JLabel("Enter the name: ");
        readNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readNameLabel.setBounds(36, 148, 152, 22);
        contentPane.add(readNameLabel);

        nameReadTextField = new JTextField();
        nameReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nameReadTextField.setBounds(215, 150, 143, 19);
        contentPane.add(nameReadTextField);
        nameReadTextField.setColumns(10);

        JLabel readIDLabel = new JLabel("Enter ID: ");
        readIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel.setBounds(36, 180, 152, 22);
        contentPane.add(readIDLabel);

        idReadTextField = new JTextField();
        idReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idReadTextField.setColumns(10);
        idReadTextField.setBounds(215, 182, 143, 19);
        contentPane.add(idReadTextField);

        readButton = new JButton("Read");
        readButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readButton.setBounds(485, 155, 115, 29);
        contentPane.add(readButton);

        JLabel updateLabel = new JLabel("Update movie:");
        updateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateLabel.setBounds(10, 238, 108, 22);
        contentPane.add(updateLabel);

        readTable = new JTable();
        readTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column", "New column"
                }
        ));
        readTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        readTable.setBounds(20, 212, 433, 16);
        contentPane.add(readTable);

        updateTable = new JTable();
        updateTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column"
                }
        ));
        updateTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateTable.setBounds(20, 325, 433, 16);
        contentPane.add(updateTable);

        JLabel readIDLabel_1 = new JLabel("Enter ID: ");
        readIDLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_1.setBounds(36, 270, 152, 22);
        contentPane.add(readIDLabel_1);

        updateIDTextField = new JTextField();
        updateIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateIDTextField.setColumns(10);
        updateIDTextField.setBounds(215, 272, 143, 19);
        contentPane.add(updateIDTextField);

        JLabel nameInsertLabel_1 = new JLabel("Name");
        nameInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel_1.setBounds(46, 302, 45, 13);
        contentPane.add(nameInsertLabel_1);

        JLabel typeInsertLabel_1 = new JLabel("Type");
        typeInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        typeInsertLabel_1.setBounds(136, 302, 74, 13);
        contentPane.add(typeInsertLabel_1);

        JLabel categoryInsertLabel_1 = new JLabel("Category");
        categoryInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        categoryInsertLabel_1.setBounds(235, 301, 76, 13);
        contentPane.add(categoryInsertLabel_1);

        JLabel lblYear_1 = new JLabel("Year");
        lblYear_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblYear_1.setBounds(356, 301, 45, 13);
        contentPane.add(lblYear_1);

        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateButton.setBounds(485, 272, 115, 29);
        contentPane.add(updateButton);

        JLabel deleteLabel = new JLabel("Delete movie:");
        deleteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteLabel.setBounds(10, 351, 108, 22);
        contentPane.add(deleteLabel);

        JLabel readNameLabel_1 = new JLabel("Enter the name: ");
        readNameLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readNameLabel_1.setBounds(36, 383, 152, 22);
        contentPane.add(readNameLabel_1);

        JLabel readIDLabel_2 = new JLabel("Enter ID: ");
        readIDLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_2.setBounds(36, 415, 152, 22);
        contentPane.add(readIDLabel_2);

        nameDeleteTextField = new JTextField();
        nameDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nameDeleteTextField.setColumns(10);
        nameDeleteTextField.setBounds(215, 385, 143, 19);
        contentPane.add(nameDeleteTextField);

        idDeleteTextField = new JTextField();
        idDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idDeleteTextField.setColumns(10);
        idDeleteTextField.setBounds(215, 417, 143, 19);
        contentPane.add(idDeleteTextField);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteButton.setBounds(485, 365, 115, 29);
        contentPane.add(deleteButton);

        JLabel viewLabel = new JLabel("View all movies sorted by type and by year:");
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 447, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton("View");
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(485, 444, 115, 29);
        contentPane.add(viewButton);

        JLabel lblFilterAllMovies = new JLabel("Filter all movies by:");
        lblFilterAllMovies.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblFilterAllMovies.setBounds(10, 494, 164, 22);
        contentPane.add(lblFilterAllMovies);

        String[] stringChoices = new String[]{"TYPE", "CATEGORY", "YEAR"};
        filterComboBox = new JComboBox<String>(stringChoices);
        filterComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterComboBox.setBounds(215, 497, 143, 21);
        contentPane.add(filterComboBox);

        filterButton = new JButton("Filter");
        filterButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        filterButton.setBounds(485, 497, 115, 29);
        contentPane.add(filterButton);

        filterTextField = new JTextField();
        filterTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterTextField.setBounds(368, 498, 107, 19);
        contentPane.add(filterTextField);
        filterTextField.setColumns(10);

        this.employee = employee;
        setUsernameToInsertLabel(employee.getUsername());
        pEmployee = new PEmployee(employee, this);

        addCreateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pEmployee.createMovie();
                }catch(Error error) {
                    System.out.println("Error while creating movie");
                    JOptionPane.showMessageDialog(null, "Error while creating movie");
                }
            }
        });

        addReadButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    pEmployee.readMovie();
            }
        });

        addDeleteButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pEmployee.deleteMovie();
            }
        });

        addUpdateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    pEmployee.updateMovie();
                }catch (Error error) {
                    System.out.println("Error while updating the movie");
                    showMessage("Error while updating the movie");
                }
            }
        });

        viewFunction();

        filterFunction();
    }

    @Override
    public Movie getMovieFromCreateTable(int idCreator) {
        int ID = Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString());
        String name = createTable.getModel().getValueAt(0, 1).toString();
        String type = createTable.getModel().getValueAt(0, 2).toString();
        String category = createTable.getModel().getValueAt(0, 3).toString();
        int year = Integer.parseInt(createTable.getModel().getValueAt(0, 4).toString());
        int id_creator = idCreator;

        if(type.equals("SERIES")) {
            return new Movie(ID, name, Model.Enums.Type.SERIES, category, year, id_creator);
        }
        else {
            return new Movie(ID, name, Model.Enums.Type.ARTISTIC, category, year, id_creator);
        }
    }

    @Override
    public String getNameFromReadTextField() {
        return nameReadTextField.getText();
    }

    @Override
    public String getIDFromReadTextField() {
        return idReadTextField.getText();
    }

    @Override
    public void setMovieToReadTable(Movie movie) {
        readTable.getModel().setValueAt(movie.getID(), 0, 0);
        readTable.getModel().setValueAt(movie.getName(), 0, 1);
        readTable.getModel().setValueAt(movie.getType().toString(), 0, 2);
        readTable.getModel().setValueAt(movie.getCategory(), 0, 3);
        readTable.getModel().setValueAt(movie.getYear(), 0, 4);
        readTable.getModel().setValueAt(movie.getIdCreator(), 0 , 5);
    }

    @Override
    public int getIDFromUpdateTextField() {
        return Integer.parseInt(updateIDTextField.getText());
    }

    @Override
    public String getNameFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 0).toString();
    }

    @Override
    public String getTypeFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 1).toString();
    }

    @Override
    public String getCategoryFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 2).toString();
    }

    @Override
    public int getYearFromUpdateTable() {
        return Integer.parseInt(updateTable.getModel().getValueAt(0, 3).toString());
    }

    @Override
    public String getNameFromDeleteTextField() {
        return nameDeleteTextField.getText();
    }

    @Override
    public String getIDFromDeleteTextField() {
        return idDeleteTextField.getText();
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
    public void addCreateButton(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    @Override
    public void addReadButton(ActionListener actionListener) {
        readButton.addActionListener(actionListener);
    }

    @Override
    public void addUpdateButton(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }

    @Override
    public void addDeleteButton(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }

    @Override
    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    @Override
    public void addFilterButton(ActionListener actionListener) {
        filterButton.addActionListener(actionListener);
    }

    @Override
    public void setUsernameToInsertLabel(String username) {
        insertUsernameLabel.setText(username);
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void filterFunction() {
        addFilterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllView allMoviesView = new AllView(new PAdministrator(), pEmployee, "EMPLOYEE", "FILTER");
                allMoviesView.setVisible(true);
            }
        });
    }

    @Override
    public void viewFunction() {
        addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllView allMoviesView = new AllView(new PAdministrator(), pEmployee, "EMPLOYEE", "VIEW");
                allMoviesView.setVisible(true);
            }
        });
    }
}