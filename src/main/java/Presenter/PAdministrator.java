package Presenter;

import Model.DBContextUser;
import Model.Enums.Role;
import Model.User;
import View.IAdministrator;
import View.IAll;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class PAdministrator {
    protected static final Logger LOGGER = Logger.getLogger(PAdministrator.class.getName());
    private static final DBContextUser dbContext = new DBContextUser();
    private User administrator;
    private IAdministrator iAdministrator;
    private IAll iAllUsers;

    public PAdministrator() {}

    public PAdministrator(User administrator, IAdministrator interfaceAdministrator) {
        this.administrator = administrator;
        this.iAdministrator = interfaceAdministrator;
    }

    public PAdministrator(IAdministrator interfaceAdministrator) {
        this.iAdministrator = interfaceAdministrator;
    }

    public User getAdministrator() {
        return administrator;
    }

    public void setAdministrator(User administrator) {
        this.administrator = administrator;
    }

    public IAdministrator getIAdministrator() {
        return iAdministrator;
    }

    public void setIAdministrator(IAdministrator iAdministrator) {
        this.iAdministrator = iAdministrator;
    }

    public IAll getiAllUsers() {
        return iAllUsers;
    }

    public void setiAllUsers(IAll iAllUsers) {
        this.iAllUsers = iAllUsers;
    }

    public void createUser() {
        User user = this.iAdministrator.getUserFromCreateTable();
        dbContext.insert(user);
    }

    public void updateUser() {
        String name = iAdministrator.getNameFromUpdateTable(0);
        String username = iAdministrator.getUsernameFromUpdateTable(0);
        String password = iAdministrator.getPasswordFromUpdateTable(0);
        String role = iAdministrator.getRoleFromUpdateTable(0);

        int id = iAdministrator.getIDFromTextFieldUpdate();

        dbContext.updateUser(id, name, username, password, role);
    }

    public void deleteUser() {
        String username = iAdministrator.getUsernameFromDeleteTextField();

        if(!username.equals("")) {
            deleteUserByUsername(username);
        }
        else {
            String id = iAdministrator.getIDFromDeleteTextField();

            if (!id.equals("")) {
                deleteUserByID(Integer.parseInt(id));
            }
            else {
                iAdministrator.showMessage("Please enter a valid ID or username");
            }
        }
    }

    public void deleteUserByID(int id) {
        String query = dbContext.createDeleteQueryByID(id);
        dbContext.deleteUser(query);
    }

    public void deleteUserByUsername(String username) {
        String query = dbContext.createDeleteQueryByUsername(username);
        dbContext.deleteUser(query);
    }

    public void readUser() {
        String username = iAdministrator.getUsernameFromReadTextField();

        if(!username.equals("")) {
            iAdministrator.setReadTable(readUserByUsername(username));
        }
        else {
            String id = iAdministrator.getIDFromReadTextField();

            if(!id.equals("")) {
                iAdministrator.setReadTable(readUserByID(Integer.parseInt(id)));
            }
            else {
                iAdministrator.showMessage("Please enter a valid ID or username");
            }
        }
    }

    public User readUserByID(int id) {
        String query = dbContext.createFindQueryByID(id);
        User user = dbContext.findUser(query);

        System.out.println(user);

        return user;
    }

    public User readUserByUsername(String username) {
        String query = dbContext.createFindQueryByUsername(username);
        User user = dbContext.findUser(query);

        System.out.println(user);

        return user;
    }

    public User readUserByUsernameAndPassword(String username, String password) {
        String query = dbContext.createFindQueryByUsernameAndPassword(username, password);
        User user = dbContext.findUser(query);

        System.out.println(user);

        return user;
    }

    public List<User>  viewAllUsers() {
        List<User> list = dbContext.findAllUsers();

        System.out.println(list);

        int nr = 1;
        for(User u : list) {
            iAllUsers.setUserInTable(nr, u);
            nr++;
        }

        return list;
    }

    public void updateUser(int id, String name, String username, String password, Role role) {
        dbContext.updateUser(id, name, username, password, role.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PAdministrator that = (PAdministrator) o;
        return Objects.equals(administrator, that.administrator) && Objects.equals(iAdministrator, that.iAdministrator) && Objects.equals(iAllUsers, that.iAllUsers);
    }
}
