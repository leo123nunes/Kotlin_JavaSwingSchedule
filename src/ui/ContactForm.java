package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame{
    private JTextField textFieldName;
    private JTextField textFieldTelefone;
    private JButton buttonCancel;
    private JButton buttonSave;
    private JPanel rootPanel;

    public ContactForm(){
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation(dim.width/2 - getWidth()/2, dim.height/2 - getHeight()/2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        eventListeners();
    }

    private void eventListeners(){
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });
    }
}
