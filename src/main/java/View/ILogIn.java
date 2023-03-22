package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface ILogIn {
    void addLogInListener(ActionListener actionListener);

    String getUsernameTextField();

    String getPasswordTextField();

}
