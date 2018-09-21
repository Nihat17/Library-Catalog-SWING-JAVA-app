package library.catalog;

import java.awt.Color;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marshall
 */
public class StaffAccountPage extends javax.swing.JFrame {

    /**
     * Creates new form StaffAccountPage
     */    
    Staff staff;
    public StaffAccountPage(Staff staff) {
        initComponents();
        this.staff = staff;
        setLocationRelativeTo(null);
        setFont();
        fillStaffDetails();        
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staffAccountLabel = new javax.swing.JLabel();
        addBookButton = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        idField = new javax.swing.JLabel();
        firstNameField = new javax.swing.JLabel();
        lastNameField = new javax.swing.JLabel();
        numberField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffAccountLabel.setText("Staff Account");

        addBookButton.setText("Add Book");

        idLabel.setText("Staff ID:");

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        numberLabel.setText("Phone Number:");

        numberField.setText("Phone Number:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(firstNameLabel)
                                    .addComponent(lastNameLabel))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numberLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numberField)
                        .addGap(194, 194, 194))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(staffAccountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBookButton)
                        .addGap(91, 91, 91))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffAccountLabel)
                    .addComponent(addBookButton))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLabel))
                        .addGap(35, 35, 35)
                        .addComponent(lastNameLabel))
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberLabel)
                    .addComponent(numberField))
                .addGap(123, 123, 123))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillStaffDetails() {
     idField.setText(String.valueOf(staff.getStaffID()));
     firstNameField.setText(staff.getFirstName());
     lastNameField.setText(staff.getLastName());
     numberField.setText(staff.getPhoneNumber());
    }
   
    private void setFont() {
       staffAccountLabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 23));
       staffAccountLabel.setForeground(Color.red);
       idLabel.setFont(new Font("Serif", Font.ITALIC, 16));
       firstNameLabel.setFont(new Font("Serif", Font.ITALIC, 16));
       lastNameLabel.setFont(new Font("Serif", Font.ITALIC, 16));
       numberLabel.setFont(new Font("Serif", Font.ITALIC, 16));
       idField.setFont(new Font("Serif", Font.ITALIC, 16));
       firstNameField.setFont(new Font("Serif", Font.ITALIC, 16));
       lastNameField.setFont(new Font("Serif", Font.ITALIC, 16));
       numberField.setFont(new Font("Serif", Font.ITALIC, 16));
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JLabel firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel numberField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JLabel staffAccountLabel;
    // End of variables declaration//GEN-END:variables
      
}
