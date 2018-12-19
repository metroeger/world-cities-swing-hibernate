/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingworldhibernate;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pojos.City;
import pojos.Country;

/**
 *
 * @author Agi
 */
public class CityForm extends javax.swing.JDialog {

    private City city;
    private boolean save;
      
    public CityForm(java.awt.Frame parent, boolean modal, List<Country>countries) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(parent);
        setTitle("New city: ");  
        save = false;
        cbCountries.setModel(new DefaultComboBoxModel<>(countries.toArray()));
    }
    
    public City getCity(){
        return city;
    }
    
    public boolean isSave(){
      return save;  
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbCountries = new javax.swing.JComboBox<>();
        lbName = new javax.swing.JLabel();
        lbName1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfDistrict = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lbPop = new javax.swing.JLabel();
        tfPopulation = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(null);

        cbCountries.setPreferredSize(new java.awt.Dimension(200, 22));
        cbCountries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountriesActionPerformed(evt);
            }
        });
        getContentPane().add(cbCountries);
        cbCountries.setBounds(210, 90, 340, 22);

        lbName.setText("Name: ");
        lbName.setPreferredSize(new java.awt.Dimension(80, 20));
        getContentPane().add(lbName);
        lbName.setBounds(90, 160, 90, 20);

        lbName1.setText("District: ");
        lbName1.setPreferredSize(new java.awt.Dimension(80, 20));
        getContentPane().add(lbName1);
        lbName1.setBounds(90, 190, 60, 20);

        tfName.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(tfName);
        tfName.setBounds(198, 156, 392, 22);

        tfDistrict.setBackground(new java.awt.Color(255, 255, 204));
        tfDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDistrictActionPerformed(evt);
            }
        });
        getContentPane().add(tfDistrict);
        tfDistrict.setBounds(200, 190, 392, 22);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(390, 280, 61, 25);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(260, 280, 71, 25);

        lbPop.setText("Population:");
        lbPop.setPreferredSize(new java.awt.Dimension(80, 20));
        getContentPane().add(lbPop);
        lbPop.setBounds(90, 220, 60, 20);

        tfPopulation.setBackground(new java.awt.Color(255, 255, 204));
        tfPopulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPopulationActionPerformed(evt);
            }
        });
        getContentPane().add(tfPopulation);
        tfPopulation.setBounds(200, 220, 392, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            save = true;
            city = new City();
            city.setName(tfName.getText());
            city.setDistrict(tfDistrict.getText());
            city.setPopulation(Integer.parseInt(tfPopulation.getText()));
            city.setCountry((Country)cbCountries.getSelectedItem());
            setVisible(false);
         
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tfDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDistrictActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDistrictActionPerformed

    private void tfPopulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPopulationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPopulationActionPerformed

    private void cbCountriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountriesActionPerformed
       
    }//GEN-LAST:event_cbCountriesActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Object> cbCountries;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbName1;
    private javax.swing.JLabel lbPop;
    private javax.swing.JTextField tfDistrict;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPopulation;
    // End of variables declaration//GEN-END:variables
}
