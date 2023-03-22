package Presenter;

import Model.Comparators.MovieComparator;
import Model.DBContextMovie;
import Model.Movie;
import Model.User;
import View.IAll;
import View.IEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PEmployee {
    private User employee;
    private IEmployee iEmployee;
    private IAll iAll;
    private static final DBContextMovie dbContextMovie = new DBContextMovie();

    public PEmployee() {}

    public PEmployee(User employee, IEmployee iEmployee) {
        this.employee = employee;
        this.iEmployee = iEmployee;
    }

    public PEmployee(IEmployee iEmployee) {
        this.iEmployee = iEmployee;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public IEmployee getIEmployee() {
        return iEmployee;
    }

    public void setIEmployee(IEmployee iEmployee) {
        this.iEmployee = iEmployee;
    }

    public IAll getIAll() {
        return iAll;
    }

    public void setIAll(IAll iAll) {
        this.iAll = iAll;
    }

    public Movie createMovie() {
        Movie movie = iEmployee.getMovieFromCreateTable(this.employee.getID());
        dbContextMovie.insert(movie);

        return movie;
    }

    public void readMovie() {
        String name = iEmployee.getNameFromReadTextField();
        if(!name.equals("")) {
            iEmployee.setMovieToReadTable(dbContextMovie.findMovie(dbContextMovie.createFindQueryByName(name)));
        }
        else {
            String id = iEmployee.getIDFromReadTextField();
            if(!id.equals("")) {
                iEmployee.setMovieToReadTable(dbContextMovie.findMovie(dbContextMovie.createFindQueryByID(Integer.parseInt(id))));
            }
            else {
                iEmployee.showMessage("Please enter a valid name or id");
            }
        }
    }

    public void deleteMovie() {
        String name = iEmployee.getNameFromDeleteTextField();
        if(!name.equals("")) {
            dbContextMovie.deleteMovie(dbContextMovie.createDeleteQueryByName(name));
        }
        else {
            String id = iEmployee.getIDFromDeleteTextField();
            if (!id.equals("")) {
                dbContextMovie.deleteMovie(dbContextMovie.createDeleteQueryByID(Integer.parseInt(id)));
            }
            else {
                iEmployee.showMessage("Please enter a valid name or id");
            }
        }
    }

    public void updateMovie() {
        dbContextMovie.updateMovie(iEmployee.getIDFromUpdateTextField(), iEmployee.getNameFromUpdateTable(), iEmployee.getTypeFromUpdateTable(), iEmployee.getCategoryFromUpdateTable(), iEmployee.getYearFromUpdateTable());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PEmployee pEmployee = (PEmployee) o;
        return Objects.equals(employee, pEmployee.employee) && Objects.equals(iEmployee, pEmployee.iEmployee) && Objects.equals(iAll, pEmployee.iAll);
    }
}
