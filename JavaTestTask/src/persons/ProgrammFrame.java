package persons;

import static persons.WorkDB.name;
import static persons.WorkDB.age;
import static persons.WorkDB.city;
import static persons.WorkDB.type;
import static persons.WorkDB.price;
import static persons.WorkDB.id;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static persons.WorkDB.deletedRecordFromPerson;
import static persons.WorkDB.deletedRecordFromProperty;
import static persons.WorkDB.deletedTableColumns;
import static persons.WorkDB.showTableOfFourColumns;
import static persons.WorkDB.selectTableAllColumns;
import static persons.WorkDB.selectTableProperty;
import static persons.WorkDB.clearAll;

/**
 *
 * @author Artem
 */
public class ProgrammFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProgrammFrame
     */
    public ProgrammFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePerson = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProperty = new javax.swing.JTable();
        jButtonAddRecord = new javax.swing.JButton();
        jButtonEditRecord = new javax.swing.JButton();
        jButtonDeleteRecord = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        clearAll = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane4MouseClicked(evt);
            }
        });

        jTablePerson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "age", "city"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePerson.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTablePersonAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jTablePersonAncestorRemoved(evt);
            }
        });
        jTablePerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePersonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePerson);
        if (jTablePerson.getColumnModel().getColumnCount() > 0) {
            jTablePerson.getColumnModel().getColumn(0).setResizable(false);
            jTablePerson.getColumnModel().getColumn(1).setResizable(false);
            jTablePerson.getColumnModel().getColumn(2).setResizable(false);
            jTablePerson.getColumnModel().getColumn(3).setResizable(false);
        }

        jTabbedPane4.addTab("Person", jScrollPane1);

        jTableProperty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "type", "id_person", "price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProperty.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTablePropertyAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jTablePropertyAncestorRemoved(evt);
            }
        });
        jTableProperty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePropertyMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProperty);
        if (jTableProperty.getColumnModel().getColumnCount() > 0) {
            jTableProperty.getColumnModel().getColumn(0).setResizable(false);
            jTableProperty.getColumnModel().getColumn(1).setResizable(false);
            jTableProperty.getColumnModel().getColumn(2).setResizable(false);
            jTableProperty.getColumnModel().getColumn(3).setResizable(false);
        }

        jTabbedPane4.addTab("Property", jScrollPane2);

        jButtonAddRecord.setText("Add record");
        jButtonAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRecordActionPerformed(evt);
            }
        });

        jButtonEditRecord.setText("Edit record");
        jButtonEditRecord.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jButtonEditRecordAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jButtonEditRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditRecordActionPerformed(evt);
            }
        });

        jButtonDeleteRecord.setText("Delete record");
        jButtonDeleteRecord.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jButtonDeleteRecordAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jButtonDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRecordActionPerformed(evt);
            }
        });

        jMenu.setText("File");

        clearAll.setText("Clear All");
        clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllActionPerformed(evt);
            }
        });
        jMenu.add(clearAll);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu.add(exit);

        jMenuBar.add(jMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDeleteRecord)
                        .addGap(56, 56, 56)
                        .addComponent(jButtonEditRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jButtonAddRecord)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddRecord)
                    .addComponent(jButtonEditRecord)
                    .addComponent(jButtonDeleteRecord))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void jTablePersonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTablePersonAncestorAdded
        DefaultTableModel model = (DefaultTableModel) jTablePerson.getModel(); 
        String sql = selectTableAllColumns("Person");
        showTableOfFourColumns(model, sql);
    }//GEN-LAST:event_jTablePersonAncestorAdded

    private void jTablePersonAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTablePersonAncestorRemoved
        DefaultTableModel model = (DefaultTableModel) jTablePerson.getModel(); 
        deletedTableColumns(model);
    }//GEN-LAST:event_jTablePersonAncestorRemoved

    private void jTablePropertyAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTablePropertyAncestorAdded
        DefaultTableModel model = (DefaultTableModel) jTableProperty.getModel(); 
        String sql = selectTableProperty();
        showTableOfFourColumns(model, sql);
    }//GEN-LAST:event_jTablePropertyAncestorAdded

    private void jTablePropertyAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTablePropertyAncestorRemoved
        DefaultTableModel model = (DefaultTableModel) jTableProperty.getModel(); 
        deletedTableColumns(model);
    }//GEN-LAST:event_jTablePropertyAncestorRemoved

    private void jButtonAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRecordActionPerformed
        if(jTablePerson.isShowing() == true){
            new AddPersonRecordFrame().setVisible(true);
            this.setVisible(false);
        } else {
            new AddPropertyRecordFrame().setVisible(true);
            this.setVisible(false);
        }        
    }//GEN-LAST:event_jButtonAddRecordActionPerformed

    private void jButtonDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRecordActionPerformed
        Object[] options = { "Yes", "No!" };
        int index = JOptionPane.showOptionDialog(rootPane, "Delete record ?", null, 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                options, rootPane);
        if (index == 0){
            if(jTablePerson.isShowing() == true){
                try {
                    DefaultTableModel model = (DefaultTableModel) jTablePerson.getModel();
                    int indexSelectedRow = jTablePerson.getSelectedRow();
                    String id = model.getValueAt(indexSelectedRow, 0).toString();
                    deletedRecordFromPerson(model, id);
                    model.removeRow(indexSelectedRow);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                try {
                    DefaultTableModel model = (DefaultTableModel) jTableProperty.getModel();
                    int indexSelectedRow = jTableProperty.getSelectedRow();
                    String id = model.getValueAt(indexSelectedRow, 0).toString();
                    deletedRecordFromProperty(model, id);
                    model.removeRow(indexSelectedRow);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 
    }//GEN-LAST:event_jButtonDeleteRecordActionPerformed
   
    private void jButtonEditRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditRecordActionPerformed
        if(jTablePerson.isShowing() == true){
            DefaultTableModel model = (DefaultTableModel) jTablePerson.getModel();
            int indexSelectedRow = jTablePerson.getSelectedRow();
            id = Integer.valueOf(model.getValueAt(indexSelectedRow, 0).toString());
            name = model.getValueAt(indexSelectedRow, 1).toString();
            age = Integer.valueOf(model.getValueAt(indexSelectedRow, 2).toString());
            city = model.getValueAt(indexSelectedRow, 3).toString();
            new UpdatePersonRecordFrame().setVisible(true);
            this.setVisible(false);
        } else {
            DefaultTableModel model = (DefaultTableModel) jTableProperty.getModel();
            int indexSelectedRow = jTableProperty.getSelectedRow();
            id = Integer.valueOf(model.getValueAt(indexSelectedRow, 0).toString());
            type = model.getValueAt(indexSelectedRow, 1).toString();
            name = model.getValueAt(indexSelectedRow, 2).toString();
            price = Integer.valueOf(model.getValueAt(indexSelectedRow, 3).toString());
            new UpdatePropertyRecordFrame().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonEditRecordActionPerformed

    private void jButtonDeleteRecordAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jButtonDeleteRecordAncestorAdded
        jButtonDeleteRecord.setEnabled(false);       
    }//GEN-LAST:event_jButtonDeleteRecordAncestorAdded

    private void jTablePersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePersonMouseClicked
        jButtonDeleteRecord.setEnabled(true);
        jButtonEditRecord.setEnabled(true);
    }//GEN-LAST:event_jTablePersonMouseClicked

    private void jButtonEditRecordAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jButtonEditRecordAncestorAdded
        jButtonEditRecord.setEnabled(false);
    }//GEN-LAST:event_jButtonEditRecordAncestorAdded

    private void jTablePropertyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePropertyMouseClicked
        jButtonDeleteRecord.setEnabled(true);
        jButtonEditRecord.setEnabled(true);
    }//GEN-LAST:event_jTablePropertyMouseClicked

    private void jTabbedPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane4MouseClicked
        int indexSelectedRow = jTablePerson.getSelectedRow();
        int indexSelectedRow2 = jTableProperty.getSelectedRow();
        if (indexSelectedRow == -1 && indexSelectedRow2 == -1) {
            jButtonEditRecord.setEnabled(false);
            jButtonDeleteRecord.setEnabled(false);
        }
    }//GEN-LAST:event_jTabbedPane4MouseClicked

    private void clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTablePerson.getModel();
        Object[] options = { "Yes", "No!" };
        int index = JOptionPane.showOptionDialog(rootPane, "Clear all ?", null, 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                options, rootPane);
        if (index == 0){
            try {
                clearAll(model);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
            while (model.getRowCount()>0){
                model.removeRow(0);
            }
        }
    }//GEN-LAST:event_clearAllActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clearAll;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton jButtonAddRecord;
    private javax.swing.JButton jButtonDeleteRecord;
    private javax.swing.JButton jButtonEditRecord;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTablePerson;
    private javax.swing.JTable jTableProperty;
    // End of variables declaration//GEN-END:variables
}
