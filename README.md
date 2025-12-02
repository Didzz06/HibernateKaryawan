## Aplikasi CRUD Karyawan
Aplikasi ini dibuat untuk mengelola data karyawan dengan memanfaatkan Java, Hibernate, JasperReports, serta NetBeans IDE 8.2 sebagai tools pengembangan. Sistem dirancang agar pengguna dapat melakukan pengolahan data secara lengkap, mulai dari penambahan, pengubahan, penghapusan, hingga pembuatan laporan data karyawan.

# Fitur
Aplikasi menyediakan fungsi utama Create, Read, Update, dan Delete (CRUD) untuk data karyawan.
Selain itu, aplikasi terhubung ke database menggunakan Hibernate ORM sehingga proses penyimpanan data menjadi lebih terstruktur.
Pengguna juga dapat mencetak laporan karyawan menggunakan JasperReports dan mengekspornya ke format PDF.

# Teknologi yang Digunakan
Aplikasi ini dibangun menggunakan beberapa teknologi berikut:
- Java (Swing GUI) sebagai antarmuka aplikasi
- Hibernate ORM untuk manajemen entitas dan koneksi database
- MySQL sebagai database
- JasperReports / iReport untuk pembuatan laporan
- NetBeans IDE 8.2 sebagai lingkungan pengembangan utama

# Database
Aplikasi menggunakan database bernama db_karyawan dengan tabel karyawan, yang memiliki struktur kolom sebagai berikut:
- id → Primary key
- nik → Nomor Induk Karyawan
- nama → Nama karyawan
- jabatan → Jabatan karyawan 

# Setup Aplikasi
1. Lakukan clone atau download project Java.
2. Buka project menggunakan NetBeans IDE 8.2.
3. Tambahkan library berikut ke dalam project:
   - Hibernate Core
   - MySQL Connector/J
   - JasperReports
   - Jaspersoft Studio atau iReport
4. Konfigurasi Hibernate melalui file hibernate.cfg.xml.
5. Sesuaikan konfigurasi database (username, password, URL).
6. Jalankan aplikasi melalui NetBeans dan pastikan database telah aktif.

# Author
[Muhammad Rafli Al Hadid — 51422116]
