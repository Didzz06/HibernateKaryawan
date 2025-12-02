/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import model.Karyawan;
import util.NewHibernateUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author M. Rafli Al Hadid
 */
public class ReportGenerator {
    public static void generateReport() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            System.out.println("===========================================");
            System.out.println("GENERATE LAPORAN KARYAWAN");
            System.out.println("===========================================");
            
            System.out.println("1. Memuat data karyawan dari database...");
            
            @SuppressWarnings("unchecked")
            List<Karyawan> listKaryawan = session.createQuery("FROM Karyawan").list();
            
            System.out.println("   Data berhasil dimuat: " + listKaryawan.size() + " records");
            
            if (listKaryawan.isEmpty()) {
                System.out.println("   ERROR: Tidak ada data untuk ditampilkan!");
                return;
            }
            
            String reportPath = "reports/LaporanKaryawan.jrxml";
            
            System.out.println("2. Compiling report template...");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            System.out.println("   Report template berhasil di-compile");
            
            System.out.println("3. Menyiapkan data source...");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listKaryawan);
            
            HashMap<String, Object> parameters = new HashMap<>();
            
            System.out.println("4. Filling report dengan data...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            System.out.println("   Report berhasil di-fill");
            
            System.out.println("5. Menampilkan report viewer...");
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Laporan Data Karyawan");
            viewer.setVisible(true);
            
            System.out.println("===========================================");
            System.out.println("LAPORAN BERHASIL DITAMPILKAN");
            System.out.println("===========================================\n");
            
        } catch (JRException e) {
            System.out.println("ERROR JasperReports: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public static void exportToPDF(String outputPath) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            System.out.println("===========================================");
            System.out.println("EXPORT LAPORAN KE PDF");
            System.out.println("===========================================");
            
            System.out.println("1. Memuat data karyawan dari database...");
            
            @SuppressWarnings("unchecked")
            List<Karyawan> listKaryawan = session.createQuery("FROM Karyawan").list();
            
            System.out.println("   Data berhasil dimuat: " + listKaryawan.size() + " records");
            
            if (listKaryawan.isEmpty()) {
                System.out.println("   ERROR: Tidak ada data untuk diekspor!");
                return;
            }
            
            String reportPath = "reports/LaporanKaryawan.jrxml";
            
            System.out.println("2. Compiling report template...");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            
            System.out.println("3. Menyiapkan data source...");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listKaryawan);
            
            HashMap<String, Object> parameters = new HashMap<>();
            
            System.out.println("4. Filling report dengan data...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            
            System.out.println("5. Exporting to PDF...");
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);
            
            System.out.println("===========================================");
            System.out.println("PDF BERHASIL DISIMPAN");
            System.out.println("Lokasi: " + outputPath);
            System.out.println("===========================================\n");
            
        } catch (JRException e) {
            System.out.println("ERROR JasperReports: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
