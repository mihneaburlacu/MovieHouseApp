package Presenter;

import Model.User;
import View.IManager;

public class PManager {
    private User manager;
    private IManager iManager;

    public PManager() {}

    public PManager(User manager, IManager iManager) {
        this.manager = manager;
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
}
