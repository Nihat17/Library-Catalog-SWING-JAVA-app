/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author marshall
 */
public class SearchResult extends javax.swing.JDialog {
    
    /**
     * Creates new form SearchResult
     */
    Return retObj = new Return();
    int userID = 0;    
    int selectedRow = -1;
    boolean putDetsToTable = true;
    
    public SearchResult(java.awt.Frame parent, boolean modal, String title,
            String author, int userID) {
        
        super(parent, modal);
        setLocationRelativeTo(parent);        
        initComponents();
        this.userID = userID;
        searchBook(title, author);
    }

    private void searchBook(String title, String author) {
       List<ArrayList> listOfResults = new ArrayList<>();
       listOfResults = retObj.searchBook(title, author);
       retObj.setBookTable(bookDetTable, listOfResults);
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        bookDetTable = new javax.swing.JTable();
        getButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        setDateLabel = new javax.swing.JLabel();
        setDateField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bookDetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title", "Author", "Genre", "Edition", "Publication Date", "DueDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bookDetTable);

        getButton.setText("Get the book!");
        getButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        setDateLabel.setText("Set due date:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(getButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(setDateLabel)
                .addGap(18, 18, 18)
                .addComponent(setDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setDateLabel)
                    .addComponent(setDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getButton)
                    .addComponent(cancelButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        putDetsToTable = false;
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void getButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getButtonActionPerformed
       String date = getCurrentDate();
       Book book = new Book();
       Return retObj = new Return();
       
       if(checkIfGivenDateIsValid()){
           int ISBN = getDetailsOnSelectedRow();
           if(ISBN > 0){
                          
             book.setDueDate(setDateField.getText());           
             book.setStatus(StatusType.notAvailable); 
             try {
                  if(retObj.modifyBookTableAfterTaken(book, userID, ISBN)){
                  JOptionPane.showMessageDialog(this, "You took the book successfully. \n"
                          + "Please remember to bring it back on " + setDateField.getText(),                           
                          "Information", JOptionPane.INFORMATION_MESSAGE);
                  this.dispose();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
           
           if(ISBN < 0){
               JOptionPane.showMessageDialog(this, "Please select one of these list on table.",
                       "Warning",JOptionPane.ERROR_MESSAGE);               
           }
       }
       else{
           JOptionPane.showMessageDialog(this, "Please use a date in dd/mm/yyyy format");
       }
    }//GEN-LAST:event_getButtonActionPerformed
    
    private int getDetailsOnSelectedRow() {
       selectedRow = bookDetTable.getSelectedRow();
       String ISBN = "";
       if(selectedRow > -1){
            ISBN = (String) bookDetTable.getValueAt(selectedRow, 0);       
       }
       
       return Integer.parseInt(ISBN);
    }
    private boolean checkIfGivenDateIsValid(){
        boolean output = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try{
            LocalDate date = formatter.parse(setDateField.getText(), LocalDate::from);
        }
        catch(DateTimeParseException ex){
            output = false;
        }
        return output;
    }
  
    public List getListForTable() {
        List bookDetails = new ArrayList();
        List listOfLists = new ArrayList();
        if(putDetsToTable){
            for(int i = 0; i < 6; i++){
                 bookDetails.add(bookDetTable.getValueAt(selectedRow, i));
            }
            bookDetails.add(setDateField.getText());
            listOfLists.add(bookDetails);
        }
        return listOfLists;
    }
     
    private void checkIfDateIsPassed(String date) {
        int inputYear, inputMonth, inputDay;
        int currYear, currMonth, currDay;
        String inputDate = setDateField.getText();
        String inputYearStr = "", inputMonthStr = "", inputDayStr= "";
        String currYearStr = "", currMonthStr = "", currDayStr = "";
        String str = "";        
        boolean checkYear, checkMonth, checkDay;        
        
        for(int c = 0; c < 2; c++){
           checkYear = true;
           checkMonth = false;
           checkDay = false;
           for(int i = 0; i < setDateField.getText().length(); i++){
               if(c == 0){
                       if(!"/".equals(inputDate.substring(i, ++i)) && checkYear){
                            inputYearStr += inputDate.substring(i - 1, i);
                       }
                       if(inputDate.substring(i, ++i).equals("/")){
                           checkYear = false;
                           checkMonth = true;
                           continue;
                       }
                       if(!inputDate.substring(i, ++i).equals("/") && checkMonth){
                           inputMonthStr += inputDate.substring(i - 1, i);                           
                       }
                       if(inputDate.substring(i, ++i).equals("/")){
                           checkMonth = false;
                           checkDay = true;
                           continue;
                       }
                       if(!inputDate.substring(i, ++i).equals("/") && checkDay){
                           inputDayStr += inputDate.substring(i - 1, i);                           
                       }
                       if(inputDate.substring(i, ++i).equals("/")){
                           checkDay = false;
                           continue;
                       }                       
               
               }
               
               else{
                       if(!"/".equals(date.substring(i, ++i)) && checkYear){
                            currYearStr += date.substring(i - 1, i);
                       }
                       if(date.substring(i, ++i).equals("/")){
                           checkYear = false;
                           checkMonth = true;
                           continue;
                       }
                       if(!date.substring(i, ++i).equals("/") && checkMonth){
                           currMonthStr += date.substring(i - 1, i);                           
                       }
                       if(date.substring(i, ++i).equals("/")){
                           checkMonth = false;
                           checkDay = true;
                           continue;
                       }
                       if(!date.substring(i, ++i).equals("/") && checkDay){
                           currDayStr += date.substring(i - 1, i);                           
                       }
                       if(date.substring(i, ++i).equals("/")){
                           checkDay = false;
                           continue;
                       }
               
                    }
           }
        }
        int m = 0;
    }
    
    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        return date;        
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookDetTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton getButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField setDateField;
    private javax.swing.JLabel setDateLabel;
    // End of variables declaration//GEN-END:variables
          
}
