package View;

import Model.User;

import java.awt.event.ActionListener;

public interface IAdministrator {
    User getUserFromCreateTable();
    String getUsernameFromReadTextField();
    String getIDFromReadTextField();
    void setReadTable(User user);
    int getIDFromTextFieldUpdate();
    String getNameFromUpdateTable(int row);
    String getUsernameFromUpdateTable(int row);
    String getPasswordFromUpdateTable(int row);
    String getRoleFromUpdateTable(int row);
    String getUsernameFromDeleteTextField();
    String getIDFromDeleteTextField();
    void addCreateListener(ActionListener actionListener);
    void addReadListener(ActionListener actionListener);
    void addUpdateListener(ActionListener actionListener);
    void addDeleteListener(ActionListener actionListener);
    void addViewAllListener(ActionListener actionListener);
    void setUsernameOnLabel(String username);
    void showMessage(String string);
}
