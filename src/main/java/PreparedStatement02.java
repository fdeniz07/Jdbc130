import java.sql.*;

public class PreparedStatement02 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_db", "dev_user", "password");
        Statement st = con.createStatement();

        System.out.println("-------------ÖRNEK1---------------");
        //ÖRNEK1:Prepared Statement kullanarak ogrenciler tablosundan Matematik bölümünde okuyanları siliniz.

        String sql1 = "DELETE FROM ogrenciler WHERE bolum ILIKE ? ";
        PreparedStatement prst1 = con.prepareStatement(sql1);
        prst1.setString(1, "Matematik");
        //int deleted = prst1.executeUpdate();
        //System.out.println(deleted);

        System.out.println("-------------ÖRNEK2---------------");
        //ÖRNEK2:Prepared Statement kullanarak bolumler tablosuna
        // Yazılım Mühendisliği(id=5006,taban_puanı=475, kampus='Merkez') bölümünü ekleyiniz.
        String sql2 = "INSERT INTO bolumler VALUES(?,?,?,?) ";
        PreparedStatement prst2 = con.prepareStatement(sql2);
        prst2.setInt(1, 5600);
        prst2.setString(2, "Yazılım Mühendisliği");
        prst2.setInt(3, 475);
        prst2.setString(4, "Merkez");
        int inserted = prst2.executeUpdate();
        System.out.println("Eklenen: " + inserted);

        prst2.close();
        prst1.close();
        st.close();
        con.close();
    }
}
