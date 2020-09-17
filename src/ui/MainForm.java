package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import business.ContactBusiness;
import contact.ContactEntity;

public class MainForm extends JFrame{
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;
    private JLabel contactsQuantity;
    private String mName = "";
    private String mTelephone = "";

    private ContactBusiness mContactBusiness = new ContactBusiness();

    public MainForm(){
        this.setTitle("Schedule");
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getWidth()/2,dim.height/2 - getHeight()/2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        eventListeners();
        loadContacts();
    }

    private void loadContacts(){
        List<ContactEntity> contactList= mContactBusiness.getList();

        String[] columns = {"Nome","Telefone"};

        DefaultTableModel model= new DefaultTableModel(new Object[0][0],columns);

        for(ContactEntity c : contactList){
            Object[] o = new Object[columns.length];

            o[0] = c.getName();
            o[1] = c.getTelephone();

            model.addRow(o);
        }

        tableContacts.clearSelection();
        tableContacts.setModel(model);

        contactsQuantity.setText(mContactBusiness.getContactsQuantity());
    }

    private void eventListeners(){
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    if(tableContacts.getSelectedRow()!=-1){
                        mName = tableContacts.getValueAt(tableContacts.getSelectedRow(),0).toString();
                        mTelephone = tableContacts.getValueAt(tableContacts.getSelectedRow(),1).toString();
                    }
                }
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    mContactBusiness.delete(mName,mTelephone);

                    loadContacts();

                    mName = "";
                    mTelephone = "";
                }catch(Exception excp){
                    JOptionPane.showMessageDialog(new JFrame(), excp.getMessage());
                }


            }
        });
    }
}
