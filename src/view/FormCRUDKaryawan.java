/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Karyawan;
import util.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author M. Rafli Al Hadid
 */
public class FormCRUDKaryawan extends javax.swing.JFrame {
    private DefaultTableModel model;

    /**
     * Creates new form FormCRUDKaryawan
     */
    public FormCRUDKaryawan() {
        initComponents();
        initTable();
        loadData();

        setLocationRelativeTo(null);
        setTitle("CRUD Data Karyawan - Hibernate"); 

        txtId.setEnabled(false);

        // EVENT tombol
        btnSimpan.addActionListener(e -> saveData());
        btnUpdate.addActionListener(e -> updateData());
        btnDelete.addActionListener(e -> deleteData());
        btnClear.addActionListener(e -> clearForm());
        btnRefresh.addActionListener(e -> loadData());

        // EVENT pilih tabel
        tblKaryawan.getSelectionModel().addListSelectionListener(e -> fillFormFromTable());
    }
    
    private void initTable() {
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NIK");
        model.addColumn("Nama");
        model.addColumn("Jabatan"); 
        tblKaryawan.setModel(model);
    }
    
    private void loadData() {
        model.setRowCount(0);

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<Karyawan> list = session.createQuery("FROM Karyawan").list();

            for (Karyawan k : list) { 
                model.addRow(new Object[]{
                    k.getId(),
                    k.getNik(),    
                    k.getNama(),
                    k.getJabatan() 
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error load data: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    private void saveData() {
        if (txtNik.getText().isEmpty() ||
            txtNama.getText().isEmpty() ||
            txtJabatan.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Semua field wajib diisi!");
            return;
        }

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Karyawan k = new Karyawan(); 
            k.setNik(txtNik.getText());    
            k.setNama(txtNama.getText());
            k.setJabatan(txtJabatan.getText()); 

            session.save(k);
            tx.commit();

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
            loadData();
            clearForm();

        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(this, "Error simpan data: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    private void updateData() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data dari tabel dulu!");
            return;
        }

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            // Ganti Mahasiswa.class
            Karyawan k = session.get(Karyawan.class, Integer.parseInt(txtId.getText()));
            k.setNik(txtNik.getText());    
            k.setNama(txtNama.getText());
            k.setJabatan(txtJabatan.getText()); 

            session.update(k);
            tx.commit();

            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            loadData();
            clearForm();

        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(this, "Error update data: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    private void deleteData() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data dari tabel dulu!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus data?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Karyawan k = session.get(Karyawan.class, Integer.parseInt(txtId.getText()));
            session.delete(k);
            tx.commit();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            loadData();
            clearForm();

        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(this, "Error hapus data: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    private void fillFormFromTable() {
        int row = tblKaryawan.getSelectedRow();
        if (row == -1) return;

        txtId.setText(model.getValueAt(row, 0).toString());
        txtNik.setText(model.getValueAt(row, 1).toString()); 
        txtNama.setText(model.getValueAt(row, 2).toString());
        txtJabatan.setText(model.getValueAt(row, 3).toString()); 
    }

    private void clearForm() {
        txtId.setText("");
        txtNik.setText(""); 
        txtNama.setText("");
        txtJabatan.setText(""); 
        txtNik.requestFocus(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNik = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJabatan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnCetakLaporan = new javax.swing.JButton();
        btnExportPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKaryawan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FORRM CRUD DATA KARYAWAN");

        jLabel2.setText("ID:");

        jLabel3.setText("NIK:");

        jLabel4.setText("Nama:");

        jLabel5.setText("Jabatan:");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCetakLaporan.setText("Cetak Laporan");
        btnCetakLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakLaporanActionPerformed(evt);
            }
        });

        btnExportPDF.setText("Export PDF");
        btnExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDFActionPerformed(evt);
            }
        });

        tblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKaryawan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId)
                            .addComponent(txtNik)
                            .addComponent(txtNama)
                            .addComponent(txtJabatan, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnSimpan)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCetakLaporan)
                                .addGap(18, 18, 18)
                                .addComponent(btnExportPDF))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRefresh)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetakLaporan)
                    .addComponent(btnExportPDF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Pilih data dari table terlebih dahulu!", 
            "Validasi", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Apakah Anda yakin ingin menghapus data ini?", 
        "Konfirmasi Hapus", 
        JOptionPane.YES_NO_OPTION);
    
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    
    try {
        transaction = session.beginTransaction();
        
        int id = Integer.parseInt(txtId.getText().trim());
        
        Karyawan k = (Karyawan) session.get(Karyawan.class, id);
        
        if (k != null) {
            session.delete(k);
            transaction.commit();
            
            JOptionPane.showMessageDialog(this, 
                "Data berhasil dihapus!", 
                "Sukses", 
                JOptionPane.INFORMATION_MESSAGE);
            
            loadData();
            clearForm();
            
        } else {
            JOptionPane.showMessageDialog(this, 
                "Data tidak ditemukan!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        JOptionPane.showMessageDialog(this, 
            "Error hapus data: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
        session.close();
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (txtNik.getText().trim().isEmpty() || 
            txtNama.getText().trim().isEmpty() || 
            txtJabatan.getText().trim().isEmpty()) { 
            
            JOptionPane.showMessageDialog(this, 
                "Semua field harus diisi!", 
                "Validasi", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            
            Karyawan k = new Karyawan(); 
            k.setNik(txtNik.getText().trim());    
            k.setNama(txtNama.getText().trim());
            k.setJabatan(txtJabatan.getText().trim()); 
            
            session.save(k);
            transaction.commit();
            
            JOptionPane.showMessageDialog(this, 
                "Data berhasil disimpan!", 
                "Sukses", 
                JOptionPane.INFORMATION_MESSAGE);
            
            loadData();
            clearForm();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            JOptionPane.showMessageDialog(this, 
                "Error simpan data: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            session.close();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Pilih data dari table terlebih dahulu!", 
            "Validasi", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    if (txtNik.getText().trim().isEmpty() || 
        txtNama.getText().trim().isEmpty() || 
        txtJabatan.getText().trim().isEmpty()) { 
        
        JOptionPane.showMessageDialog(this, 
            "Semua field harus diisi!", 
            "Validasi", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    
    try {
        transaction = session.beginTransaction();
        
        int id = Integer.parseInt(txtId.getText().trim());
        
        Karyawan k = (Karyawan) session.get(Karyawan.class, id);
        
        if (k != null) {
            k.setNik(txtNik.getText().trim());    
            k.setNama(txtNama.getText().trim());
            k.setJabatan(txtJabatan.getText().trim()); 
            
            session.update(k);
            transaction.commit();
            
            JOptionPane.showMessageDialog(this, 
                "Data berhasil diupdate!", 
                "Sukses", 
                JOptionPane.INFORMATION_MESSAGE);
            
            loadData();
            clearForm();
            
        } else {
            JOptionPane.showMessageDialog(this, 
                "Data tidak ditemukan!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        JOptionPane.showMessageDialog(this, 
            "Error update data: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
        session.close();
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadData();
        JOptionPane.showMessageDialog(this, 
            "Data berhasil direfresh!", 
            "Info", 
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKaryawanMouseClicked
        // TODO add your handling code here:
        int row = tblKaryawan.getSelectedRow(); 
        
        if (row != -1) {
            txtId.setText(model.getValueAt(row, 0).toString());
            txtNik.setText(model.getValueAt(row, 1).toString()); 
            txtNama.setText(model.getValueAt(row, 2).toString());
            txtJabatan.setText(model.getValueAt(row, 3).toString()); 
        }
    }//GEN-LAST:event_tblKaryawanMouseClicked

    private void btnCetakLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakLaporanActionPerformed
        // TODO add your handling code here:
        try {
            System.out.println("Tombol Cetak Laporan diklik...");
            report.ReportGenerator.generateReport();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error cetak laporan:\n" + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCetakLaporanActionPerformed

    private void btnExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDFActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Simpan Laporan PDF");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Files", "pdf"));
        fileChooser.setSelectedFile(new java.io.File("LaporanKaryawan.pdf")); // **Ganti Nama File Default**
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            String outputPath = fileChooser.getSelectedFile().getAbsolutePath();
            
            if (!outputPath.toLowerCase().endsWith(".pdf")) {
                outputPath += ".pdf";
            }
            
            try {
                System.out.println("Export PDF dimulai...");
                report.ReportGenerator.exportToPDF(outputPath);
                
                JOptionPane.showMessageDialog(this, 
                    "PDF berhasil disimpan!\n\nLokasi:\n" + outputPath, 
                    "Sukses", 
                    JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Error export PDF:\n" + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnExportPDFActionPerformed

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
            java.util.logging.Logger.getLogger(FormCRUDKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCRUDKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCRUDKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCRUDKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCRUDKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetakLaporan;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExportPDF;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKaryawan;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNik;
    // End of variables declaration//GEN-END:variables
}
