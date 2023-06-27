import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Welcome extends JFrame {
    private JLabel welcomeLabel;
    private JLabel currentDateLabel;
    private JLabel enteredDateLabel;
    private JLabel nameLabel;
    private JTextField dateTextField;
    private JButton submitButton;

    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    public Welcome(String name) {
        super("Willkommen");
        setLayout(new FlowLayout());

        welcomeLabel = new JLabel("Willkommen!");
        currentDateLabel = new JLabel("Heutiges Datum:" + getCurrentDate());
        enteredDateLabel = new JLabel("Eingegebenes Datum:");
        nameLabel = new JLabel("Name:" + name);
        dateTextField = new JTextField(10);
        submitButton = new JButton("Datum bestätigen");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredDate = dateTextField.getText();
                enteredDateLabel.setText("Eingegebenes Datum:" + enteredDate);
            }
        });

        add(welcomeLabel);
        add(nameLabel);
        add(currentDateLabel);
        add(enteredDateLabel);
        add(dateTextField);
        add(submitButton);
    }
}
