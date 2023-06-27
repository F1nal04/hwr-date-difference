import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Welcome extends JFrame {
    private JLabel welcomeLabel;
    private JLabel currentDateLabel;
    private JLabel enteredDateLabel;
    private JLabel nameLabel;
    private JTextField dateTextField;
    private JButton submitButton;
    private JLabel timeDifferenceLabel;

    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    private LocalDateTime parseDateTime(String dateTimeText) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(dateTimeText, formatter);
            return localDate.atStartOfDay();
        } catch (Exception e) {
            return null;
        }
    }

    private Period calculateTimeDifference (LocalDateTime enteredDateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate enteredDate = enteredDateTime.toLocalDate();
        LocalDate currentDate = currentDateTime.toLocalDate();
        return Period.between(enteredDate, currentDate);
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
        timeDifferenceLabel = new JLabel("Zeitdifferenz:");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredDateText = dateTextField.getText();
                LocalDateTime enteredDateTime = parseDateTime(enteredDateText);
                if (enteredDateTime != null) {
                    Period period = calculateTimeDifference(enteredDateTime);
                    enteredDateLabel.setText("Eingegebenes Datum:" + enteredDateText);
                    timeDifferenceLabel.setText("Zeitdifferenz:" + period.getYears() + " Jahre");
                } else {
                    enteredDateLabel.setText("Eingegebenes Datum: Ungültig!");
                    timeDifferenceLabel.setText("Zeitdifferenz: N/A");
                }
            }
        });

        add(welcomeLabel);
        add(nameLabel);
        add(currentDateLabel);
        add(enteredDateLabel);
        add(dateTextField);
        add(submitButton);
        add(timeDifferenceLabel);
    }
}
