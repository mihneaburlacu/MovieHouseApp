package View;

import Model.Movie;
import Model.User;

public interface IAll {
    void setUserInTable(int row, User user);
    void setMovieInTable(int row, Movie movie);
}
