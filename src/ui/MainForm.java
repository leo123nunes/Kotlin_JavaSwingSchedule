package ui;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame{
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable contactList;

    public MainForm(){
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getWidth()/2,dim.height/2 - getHeight()/2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
