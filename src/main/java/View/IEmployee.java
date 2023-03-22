package View;

import Model.Movie;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface IEmployee {
    Movie getMovieFromCreateTable(int idCreator);
    String getNameFromReadTextField();
    String getIDFromReadTextField();
    void setMovieToReadTable(Movie movie);
    int getIDFromUpdateTextField();
    String getNameFromUpdateTable();
    String getTypeFromUpdateTable();
    String getCategoryFromUpdateTable();
    int getYearFromUpdateTable();
    String getNameFromDeleteTextField();
    String getIDFromDeleteTextField();
    String getFilterFromComboBox();
    String getFilterTextField();
    void addCreateButton(ActionListener actionListener);
    void addReadButton(ActionListener actionListener);
    void addUpdateButton(ActionListener actionListener);
    void addDeleteButton(ActionListener actionListener);
    void addViewButton(ActionListener actionListener);
    void addFilterButton(ActionListener actionListener);
    void setUsernameToInsertLabel(String username);
    void showMessage(String message);
    void filterFunction();
    void viewFunction();
}
