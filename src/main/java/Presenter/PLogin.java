package Presenter;

import Model.DBContextUser;
import Model.User;
import View.ILogIn;
import View.LogInView;

public class PLogin {
    private ILogIn iLogIn;
    private static final DBContextUser dbContextUser = new DBContextUser();

    public PLogin() {}

    public PLogin(ILogIn iLogIn) {
        this.iLogIn = iLogIn;
    }

    public ILogIn getILogIn() {
        return iLogIn;
    }

    public void setILogIn(ILogIn iLogIn) {
        this.iLogIn = iLogIn;
    }

    public User logIn()  {
        String username = this.iLogIn.getUsernameTextField();
        String password = this.iLogIn.getPasswordTextField();

        String query = dbContextUser.createFindQueryByUsernameAndPassword(username, password);
        User user = dbContextUser.findUser(query);

        return user;
    }
}
