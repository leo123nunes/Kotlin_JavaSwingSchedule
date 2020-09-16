import javax.swing.*;

public class MainForm extends JFrame{
    private JPanel rootPanel;
    private JButton newContactButton;
    private JButton removeButton;
    private JTable contactList;

    public MainForm(){
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);
    }
}
