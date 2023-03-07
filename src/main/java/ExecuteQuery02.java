import java.sql.*;

public class ExecuteQuery02 {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_db", "dev_user", "password");
        Statement st = con.createStatement();

        System.out.println("---------- ÖRNEK 1 -------------");
        //ÖRNEK1:bolumler tablosunda taban puanı en yüksek 2. bölümün ismini ve puanını yazdırınız.
        String sql = "SELECT bolum,taban_puanı FROM bolumler ORDER BY taban_puanı DESC OFFSET 1 LIMIT 1";
        ResultSet resultSet = st.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("bolum") + "--" + resultSet.getInt("taban_puanı"));
        }

        //Subquery
        String sql1 = "SELECT bolum,taban_puanı FROM bolumler WHERE taban_puanı="+
                "(SELECT max(taban_puanı) FROM bolumler WHERE taban_puanı<(SELECT max(taban_puanı) FROM bolumler))";

        ResultSet resultSet1 = st.executeQuery(sql1);

        while (resultSet1.next()) {
            System.out.println(resultSet1.getString("bolum") + "--" + resultSet1.getInt("taban_puanı"));
        }

        System.out.println("-------------ÖRNEK2---------------");
        //ÖRNEK2:Bölüm isimlerini, kampüslerini ve
        //her bölümde okuyan öğrencilerin en yüksek puanlarını listeleyiniz.

        String sql2="SELECT bolum,kampus,(SELECT max(puan) FROM ogrenciler o WHERE o.bolum=b.bolum ) max_puan FROM bolumler b";
        ResultSet rs2=st.executeQuery(sql2);

        while(rs2.next()){
            System.out.println(rs2.getString("bolum")+
                    "--"+rs2.getString("kampus")+"--"+
                    rs2.getInt("max_puan"));
        }

    }
}
