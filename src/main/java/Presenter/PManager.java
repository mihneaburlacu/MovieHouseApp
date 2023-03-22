package Presenter;

import Model.Comparators.MovieComparator;
import Model.DBContextMovie;
import Model.Movie;
import Model.User;
import View.IManager;
import View.ViewAndFilterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PManager {
    private User manager;
    private IManager iManager;
    private PEmployee pEmployee;
    private static final DBContextMovie dbContextMovie = new DBContextMovie();

    public PManager() {}

    public PManager(User manager, IManager iManager, PEmployee pEmployee) {
        this.manager = manager;
        this.iManager = iManager;
        this.pEmployee = pEmployee;
    }

    public PManager(IManager iManager) {
        this.iManager = iManager;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public IManager getIManager() {
        return iManager;
    }

    public void setIManager(IManager iManager) {
        this.iManager = iManager;
    }

    public PEmployee getPEmployee() {
        return pEmployee;
    }

    public void setPEmployee(PEmployee pEmployee) {
        this.pEmployee = pEmployee;
    }

    public void openViewAndFilter() {
        iManager.addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewAndFilterView viewAndFilterView = new ViewAndFilterView();
                viewAndFilterView.setVisible(true);
            }
        });
    }
}
