package com.tupeuxmarcher.tupeuxmarcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TupeuxmarcherApplication {

    public static void main(String[] args) {
        createGUI();
        SpringApplication.run(TupeuxmarcherApplication.class, args);
    }

    private static void createGUI() {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Application Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Bouton de redirection
        JButton redirectButton = new JButton("Rediriger");
        redirectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action à exécuter lors du clic sur le bouton de redirection
                JOptionPane.showMessageDialog(frame, "Redirection vers une autre page");
            }
        });
        frame.add(redirectButton);

        // Label pour afficher l'heure
        JLabel timeLabel = new JLabel();
        updateTime(timeLabel);
        frame.add(timeLabel);

        // Menu déroulant
        String[] menuOptions = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> dropdownMenu = new JComboBox<>(menuOptions);
        frame.add(dropdownMenu);

        // Champ de saisie et bouton de soumission
        JTextField inputField = new JTextField(15);
        frame.add(inputField);

        JButton submitButton = new JButton("Valider");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action à exécuter lors du clic sur le bouton de soumission
                String inputValue = inputField.getText();
                JOptionPane.showMessageDialog(frame, "Contenu du champ : " + inputValue);
            }
        });
        frame.add(submitButton);

        // Rafraîchissement de l'heure toutes les secondes
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTime(timeLabel);
            }
        });
        timer.start();

        // Affichage de la fenêtre principale
        frame.setVisible(true);
    }

    private static void updateTime(JLabel timeLabel) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(new Date());
        timeLabel.setText("Heure : " + time);
    }
}
