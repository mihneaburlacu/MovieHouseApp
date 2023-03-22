package View;

import Model.Movie;

import java.awt.event.ActionListener;

public interface IViewAndFilterView {
    void setMovieInTable(int row, Movie movie);
    String getFilterFromComboBox();
    String getFilterTextField();
    void addViewButton(ActionListener actionListener);
    void addFilterButton(ActionListener actionListener);
}
