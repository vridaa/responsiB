package Model;
import java.sql.*;


public class Connector {
    /* 
        Menyimpan informasi database ke dalam sebuah variabel.
        Pada contoh ini kita menggunakan database bernama "responsi_2024_pbo_if_b".
     */
    private static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static String nama_db = "responsi_pbo_2024_if_b";
    private static String url_db = "jdbc:mysql://localhost:3306/" + nama_db;
    private static String username_db = "root";
    private static String password_db = "";

    static Connection conn;
    
    // Mencoba menghubungkan program kita dengan ke database MySQL.
    public static Connection Connect() {
        try {
            // 1. Register driver yang akan dipakai
            Class.forName(jdbc_driver);
            
            // 2. Buat koneksi ke database
            conn = DriverManager.getConnection(url_db, username_db, password_db);

            // 3. Menampilkan pesan "Connection Success" jika berhasil terhubung ke database.
            System.out.println("MySQL Connected");
        } catch (ClassNotFoundException | SQLException exception) {
            // Menampilkan pesan error ketika MySQL gagal terhubung.
            System.out.println("Connection Failed: " + exception.getLocalizedMessage());
        }
        return conn;
    }
    
}
