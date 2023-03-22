package Presenter;

import Model.Comparators.MovieComparator;
import Model.DBContextMovie;
import Model.Movie;
import View.IViewAndFilterView;

import java.util.ArrayList;
import java.util.List;

public class PViewAndFilter {
    private static final DBContextMovie dbContextMovie = new DBContextMovie();
    private IViewAndFilterView iViewAndFilterView;

    public PViewAndFilter(){}

    public PViewAndFilter(IViewAndFilterView iViewAndFilterView) {
        this.iViewAndFilterView = iViewAndFilterView;
    }

    public IViewAndFilterView getIViewAndFilterView() {
        return iViewAndFilterView;
    }

    public void setIViewAndFilterView(IViewAndFilterView iViewAndFilterView) {
        this.iViewAndFilterView = iViewAndFilterView;
    }

    public List<Movie> viewAllMovies() {
        List<Movie> list = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

        System.out.println(list);

        list.sort(new MovieComparator());

        int nr = 1;
        for(Movie m : list) {
            iViewAndFilterView.setMovieInTable(nr, m);
            nr++;
        }

        return list;
    }

    public List<Movie> filterMovies() {
        String select = iViewAndFilterView.getFilterFromComboBox();
        String got = iViewAndFilterView.getFilterTextField();
        List<Movie> list = new ArrayList<>();

        if(select == "TYPE") {
            list = dbContextMovie.findAllMovies(dbContextMovie.createFindByTypeQuery(got));
        }
        else if(select == "CATEGORY"){
            list = dbContextMovie.findAllMovies(dbContextMovie.createFindByCategoryQuery(got));
        }
        else {
            list = dbContextMovie.findAllMovies(dbContextMovie.createFindByYearQuery(Integer.parseInt(got)));
        }

        int nr = 1;
        for(Movie m : list) {
            iViewAndFilterView.setMovieInTable(nr, m);
            nr++;
        }

        return list;
    }
}
