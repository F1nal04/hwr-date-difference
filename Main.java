import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String name = "Leon Bojanowski";

        Welcome welcome = new Welcome(name);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setSize(300,200);
        welcome.setVisible(true);
    }
}