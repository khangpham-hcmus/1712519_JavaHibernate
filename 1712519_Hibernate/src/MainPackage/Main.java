package MainPackage;

import dao.*;
import pojo.*;

import java.util.List;
import java.util.Optional;
import swingUI.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginSystem();
            }
        });
    }
}
