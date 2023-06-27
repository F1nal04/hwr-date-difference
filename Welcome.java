import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Welcome extends JFrame {
    private JLabel welcomeLabel;
    private JLabel dateLabel;
    private JLabel nameLabel;

    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    public Welcome(String name) {
        super("Willkommen");
        setLayout(new FlowLayout());

        welcomeLabel = new JLabel("Willkommen!");
        dateLabel = new JLabel("Heutiges Datum:" + getCurrentDate());
        nameLabel = new JLabel("Name:" + name);

        add(welcomeLabel);
        add(nameLabel);
        add(dateLabel);
    }
}
