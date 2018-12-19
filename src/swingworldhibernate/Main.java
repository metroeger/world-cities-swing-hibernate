/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingworldhibernate;

import hibernate.HibernateUtil;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.City;
import pojos.Country;

public class Main extends javax.swing.JFrame implements TableModelListener {

    private Session session;
    private List<Country> countries = new ArrayList<>();
    private Set<City> cities = new TreeSet<>();
    private DefaultTableModel dtm;
    private Country country;
    private List<Country> choosen = new ArrayList<>();
    private List<City> ccc = new ArrayList<>();
    private Map<Integer, City> varosMap = new HashMap<>();

    public void setCountryList() {
        lstCountry.setListData(countries.toArray());
    }

    public Country searchCountryByName(String countryName) {
        choosen.clear();
        for (Country c : countries) {
            if (c.getName().toLowerCase().startsWith(countryName.toLowerCase())) {
                country = c;
                choosen.add(c);
            }
        }
        lstCountry.setListData(choosen.toArray());
        return country;
    }

    public void deleteCity(City cityToDelete) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cityToDelete);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public void addCity(City newCity) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(newCity);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCity(City cityToUpdate) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cityToUpdate);
            session.getTransaction().commit();
            session.close();
            System.out.println(cityToUpdate.getDistrict());
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public void refreshTable(Country country) {//Set<City>ccc) {
        session = hibernate.HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("FROM City WHERE country= :par1");
        q.setParameter("par1", country);
        ccc = q.list();
        session.close();

        dtm = (DefaultTableModel) tableCity.getModel();
        dtm.getDataVector().clear();
        for (City c : ccc) {
            Vector row = new Vector();
            row.add(c.getName());
            row.add(c.getDistrict());
            row.add(c.getPopulation());
            dtm.addRow(row);
        }
    }

    public Main() {
        initComponents();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                hibernate.HibernateUtil.getSessionFactory().close();
                dispose();
                System.exit(0);
            }
        });

        session = HibernateUtil.getSessionFactory().openSession();
        countries = session.createQuery("FROM Country").list();
        session.close();

        dtm = (DefaultTableModel) tableCity.getModel();
        dtm.addTableModelListener(this);

        setCountryList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlCountry = new javax.swing.JLabel();
        tfCountryName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCountry = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCity = new javax.swing.JTable();
        btnNewCity = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(null);

        jlCountry.setText("Country: ");
        getContentPane().add(jlCountry);
        jlCountry.setBounds(25, 22, 61, 26);

        tfCountryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCountryNameActionPerformed(evt);
            }
        });
        tfCountryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCountryNameKeyReleased(evt);
            }
        });
        getContentPane().add(tfCountryName);
        tfCountryName.setBounds(110, 20, 181, 22);

        lstCountry.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCountryValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCountry);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 70, 240, 365);

        tableCity.setBackground(new java.awt.Color(153, 255, 255));
        tableCity.setForeground(new java.awt.Color(51, 51, 51));
        tableCity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Name", "District", "Population"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCity);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(430, 40, 452, 392);

        btnNewCity.setText("New City");
        btnNewCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCityActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewCity);
        btnNewCity.setBounds(470, 450, 128, 25);

        btnDelete.setText("Delete City");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(710, 450, 114, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\uj\\IMAG5334.jpg")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 800));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 970, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstCountryValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCountryValueChanged
        country = (Country) lstCountry.getSelectedValue();
        refreshTable(country);
    }//GEN-LAST:event_lstCountryValueChanged

    private void tfCountryNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCountryNameKeyReleased
        refreshTable(searchCountryByName(tfCountryName.getText()));
    }//GEN-LAST:event_tfCountryNameKeyReleased

    private void btnNewCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCityActionPerformed

        CityForm cityForm = new CityForm(this, true, countries);
        cityForm.setVisible(true);

        if (cityForm.isSave()) {
            City newCity = cityForm.getCity();
            addCity(newCity);
            refreshTable(newCity.getCountry());
        }

    }//GEN-LAST:event_btnNewCityActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int tableRowIndex = tableCity.getSelectedRow();
        if (tableRowIndex > -1) {
            City selected = ((City) ccc.get(tableRowIndex));//(cities.toArray())[tableRowIndex]);
            int answer = JOptionPane.showConfirmDialog(rootPane, "Sure, you wanna delete it? " + selected,
                    "Confirmation [delete]", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                deleteCity(selected);
                refreshTable(selected.getCountry());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tfCountryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCountryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCountryNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewCity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlCountry;
    private javax.swing.JList<Object> lstCountry;
    private javax.swing.JTable tableCity;
    private javax.swing.JTextField tfCountryName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {
        int rowIndex = e.getFirstRow();
        int colIndex = e.getColumn();

        if (e.getType() == TableModelEvent.UPDATE && rowIndex >= 0 && colIndex >= 0) {

            Object newValue = dtm.getValueAt(rowIndex, colIndex);
            City cityToUpdate = (City) ccc.get(rowIndex);

            switch (colIndex) {
                case 0:
                    cityToUpdate.setName((String) newValue);
                    break;
                case 1:
                    cityToUpdate.setDistrict((String) newValue);
                    break;
                case 2:
                    cityToUpdate.setPopulation((Integer) newValue);
                    break;
            }
            System.out.println(cityToUpdate.getName());

            updateCity(cityToUpdate);

        }
    }

}
