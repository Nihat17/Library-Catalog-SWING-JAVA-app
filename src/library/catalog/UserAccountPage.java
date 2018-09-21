/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;

/**
 *
 * @author marshall
 */
public class UserAccountPage extends javax.swing.JFrame {

    User user;
    public UserAccountPage(User user) {
        initComponents();
        setLocationRelativeTo(null);
        this.user = user;
        setFont();         
        fillUserDetails();
    }

    private void fillUserDetails() {
        idField.setText(String.valueOf(user.getUserID()));
        firstNameField.setText(user.getFirstName());
        lastNameField.setText(user.getLastName());
        numberField.setText(user.getPhoneNumber());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LAtextField = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        idField = new javax.swing.JLabel();
        firstNameField = new javax.swing.JLabel();
        lastNameField = new javax.swing.JLabel();
        numberField = new javax.swing.JLabel();
        listOfBookLabel = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        bookDetailsTable = new javax.swing.JTable();
        titleField = new javax.swing.JTextField();
        authorTitle = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LAtextField.setText("Library Account");

        idLabel.setText("User ID:");

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        numberLabel.setText("Phone number:");

        listOfBookLabel.setText("List of Books taken by User");

        bookDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Title", "Author", "ISBN", "Due Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollPane.setViewportView(bookDetailsTable);

        searchButton.setText("Search!");

        titleLabel.setText("Title");

        authorLabel.setText("Author");

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        fileMenu.add(exitMenuItem);

        MenuBar.add(fileMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LAtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel)
                .addGap(3, 3, 3)
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorLabel)
                .addGap(9, 9, 9)
                .addComponent(authorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(firstNameLabel)
                            .addComponent(lastNameLabel))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idField)
                            .addComponent(numberField)
                            .addComponent(lastNameField)
                            .addComponent(firstNameField)))
                    .addComponent(numberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listOfBookLabel)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LAtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(titleLabel)
                    .addComponent(authorLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField)
                    .addComponent(listOfBookLabel))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameLabel)
                            .addComponent(firstNameField))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lastNameField))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberLabel)
                            .addComponent(numberField)))
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LAtextField;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextField authorTitle;
    private javax.swing.JTable bookDetailsTable;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel listOfBookLabel;
    private javax.swing.JLabel numberField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    private void setFont() {       
        
        this.setTitle("Account ~ " + user.getFirstName() + " " + user.getLastName());
        listOfBookLabel.setText("List of books taken by " + user
                .getFirstName() + " " + user.getLastName());
                
        LAtextField.setFont(new Font("Serif", Font.ROMAN_BASELINE, 25));
        LAtextField.setForeground(Color.RED);
        idLabel.setFont(new Font("Billy", Font.BOLD, 16));
        firstNameLabel.setFont(new Font("Billy", Font.BOLD, 16));
        lastNameLabel.setFont(new Font("Billy", Font.BOLD, 16));
        numberLabel.setFont(new Font("Billy", Font.BOLD, 16));
        idField.setFont(new Font("Ballpark", Font.BOLD, 12));
        firstNameField.setFont(new Font("Ballpark", Font.BOLD, 12));
        lastNameField.setFont(new Font("Ballpark", Font.BOLD, 12));
        numberField.setFont(new Font("Ballpark", Font.BOLD, 12));
        scrollPane.getViewport().add(bookDetailsTable);
        listOfBookLabel.setFont(new Font("Ballpark",Font.ITALIC,19));
        listOfBookLabel.setForeground(Color.DARK_GRAY);
    }
    
    
}