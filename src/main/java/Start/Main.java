package Start;

import Model.DBContextMovie;
import Model.Enums.Type;
import Model.Movie;
import Presenter.PAdministrator;
import View.LogInView;

public class Main {
    public static void main(String[] args) {
        LogInView logInView = new LogInView();
        logInView.setVisible(true);
    }
}
