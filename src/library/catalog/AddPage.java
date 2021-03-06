/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marshall
 */
public class AddPage extends javax.swing.JDialog {

    /**
     * Creates new form AddUser
     */     
     Return retObj = new Return();
     Enum chosenType;
    public AddPage(java.awt.Frame parent, boolean modal, Enum chosenType) {
        super(parent, modal);
        this.chosenType = chosenType;
        initComponents();       
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        numberLabel = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        idLabel.setText("ID:");
        getContentPane().add(idLabel);
        getContentPane().add(idField);

        firstNameLabel.setText("First Name:");
        getContentPane().add(firstNameLabel);
        getContentPane().add(firstNameField);

        lastNameLabel.setText("Last Name:");
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameField);

        numberLabel.setText("Phone Number:");
        getContentPane().add(numberLabel);
        getContentPane().add(numberField);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Staff staff = new Staff();
        if(chosenType.equals(Types.user)){
            retObj = retObj.getUser().checkforTypo(idField.getText(), firstNameField.getText(),
                   lastNameField.getText(), numberField.getText(), true);            
       }
       else {
           retObj = retObj.getStaff().checkforTypo(idField.getText(), firstNameField.getText(),
                   lastNameField.getText(), numberField.getText(), true);
       }
        addUserStaff(chosenType);       
                       
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void addUserStaff(Enum type) {
        if(Library.checkForLength(retObj.getWarnings())){                
            boolean checkSuccess = true;                        
            try {
                if(type.equals(Types.user)){
                    checkSuccess = retObj.addUser(retObj.getUser());
                }
                else if(type.equals(Types.staff)){
                    checkSuccess = retObj.addStaff(retObj.getStaff());
                }
                
            } catch (ClassNotFoundException ex) {
            
                System.err.println("An error occurred " + ex.getMessage());                
            }
            
            if(checkSuccess == true){
                JOptionPane.showMessageDialog(this, type.name() + " was added successfully!", "Info",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose();
        
        }
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField numberField;
    private javax.swing.JLabel numberLabel;
    // End of variables declaration//GEN-END:variables

   

    
}
