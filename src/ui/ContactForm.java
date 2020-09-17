package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import business.ContactBusiness;

public class ContactForm extends JFrame{
    private JTextField textFieldName;
    private JTextField textFieldTelephone;
    private JButton buttonCancel;
    private JButton buttonSave;
    private JPanel rootPanel;
    private ContactBusiness contactBusiness;

    public ContactForm(){
        this.setTitle("Schedule");
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation(dim.width/2 - getWidth()/2, dim.height/2 - getHeight()/2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contactBusiness = new ContactBusiness();

        eventListeners();
    }

    private void eventListeners(){
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String name = textFieldName.getText();
                    String telephone = textFieldTelephone.getText();

                    contactBusiness.save(name,telephone);

                    new MainForm();

                    dispose();
                }catch(Exception excp){
                    JOptionPane.showMessageDialog(new JFrame(), excp.getMessage());
                }
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
