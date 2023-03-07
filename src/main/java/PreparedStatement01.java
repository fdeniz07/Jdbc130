import java.sql.*;

/*
    PreparedStatement : Statement interface'ini extend eder.
    Statement ile olusturdugumuz sorgu icin Db'de bellekte sorgunun bir örnegi olusturulur. Sorgu her calistirildiginda yeni bir örnegi olusturulur.
    PreparedStatement : Birden fazla kez calistirilabilen parametrelendirilmis SQL sorgularini temsil eder.
    PreparedStatement ile sorgu olusturudumuzda, bu sorgunun örnegi DB'de bellekte tutulur,sorgu her çalıştırıldığında aynı önceki örneği kullanılır.
 */


public class PreparedStatement01 {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_db", "dev_user", "password");
        Statement st = con.createStatement();

        System.out.println("-------------ÖRNEK1---------------");
        //ÖRNEK1: (Prepared Statement kullanarak) bolumler tablosunda Matematik bölümünün taban_puanı'nı 475 olarak güncelleyiniz.

        //Statement ile
//        String sql1 = "UPDATE bolumler SET taban_puani=475 WHERE bolum ILIKE 'matematik'";
//        st.executeUpdate(sql1);
//        System.out.println("Updated: " +sql1);
//        st.executeUpdate("UPDATE bolumler SET taban_puani=475 WHERE bolum ILIKE 'CENG'");


        //PreparedStatement ile
        //prepared statement için parametreli queryi yaz
        String sql = "UPDATE bolumler SET taban_puanı=? WHERE bolum ILIKE ?";
        //prepared statement oluştur
        PreparedStatement prst = con.prepareStatement(sql);
        //parametrelerin değerlerini gir
        prst.setInt(1, 475);
        prst.setString(2, "matematik");
        //prepared statement ile queryi çalıştır.
        int updated = prst.executeUpdate();
        System.out.println("updated: " + updated);

        ResultSet rs1 = st.executeQuery("SELECT * FROM bolumler");
        while(rs1.next()){
            System.out.println(rs1.getInt("bolum_id")+"--"+rs1.getString("bolum")+"--"+rs1.getInt("taban_puanı"));
        }

        System.out.println("-------------ÖRNEK1---------------");
        //ÖRNEK2:Prepared Statement kullanarak bolumler tablosunda Edebiyat bölümünün taban_puanı'nı 455 olarak güncelleyiniz.






    }


}
