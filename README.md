## Aplikasi CRUD Karyawan
Aplikasi ini dibuat untuk mengelola data karyawan dengan memanfaatkan Java, Hibernate, dan JasperReports. Sistem dirancang agar pengguna dapat mengolah data karyawan secara lengkap, mulai dari menambah, melihat, mengubah, menghapus, hingga mencetak laporan.

# Fitur
Aplikasi menyediakan fitur utama berupa operasi Create, Read, Update, dan Delete (CRUD) untuk data karyawan.
Koneksi dan pengelolaan data dilakukan menggunakan Hibernate ORM, sehingga proses akses database menjadi lebih mudah dan terstruktur.
Pengguna juga dapat mencetak laporan karyawan melalui JasperReports dan mengekspornya ke format PDF.

# Teknologi yang Digunakan
Aplikasi dibangun menggunakan beberapa teknologi berikut:
1. Java Swing: untuk antarmuka aplikasi (GUI)
2. Hibernate ORM: untuk manajemen data dan koneksi ke database
3. MySQL: sebagai sistem database
4. JasperReports: untuk pembuatan dan pencetakan laporan
5. iReport / Jaspersoft Studio: untuk desain template laporan

# Database
Aplikasi menggunakan database bernama db_karyawan yang berisi tabel karyawan.
Struktur tabel meliputi:
1. id: primary key (otomatis, sesuai entitas Java)
2. nik: nomor identitas karyawan
3. nama: nama lengkap karyawan
4. jabatan: posisi atau jabatan karyawan

# Setup Aplikasi
1. Lakukan clone atau download project Java ini.
2. Tambahkan library berikut ke dalam proyek:
   - Hibernate Core
   - MySQL Connector/J
   - JasperReports
   - iReport / Jaspersoft Studio
3. Lakukan konfigurasi Hibernate pada file hibernate.cfg.xml.
4. Sesuaikan username dan password MySQL sesuai kebutuhan Anda.
5. Jalankan aplikasi menggunakan NetBeans atau IDE lain.

## Author
[Muhammad Rafli Al Hadid_51422116]
