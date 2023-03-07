import java.sql.*;

public class ExecuteQuery03 {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_db", "dev_user", "password");
        Statement st = con.createStatement();

        System.out.println("-------------ÖRNEK1---------------");
        //ÖRNEK1:developers tablosunda maaşı ortalama maaştan az olanların maaşını ortalama maaş ile güncelleyiniz
        String sql1 = "UPDATE developers SET salary=(SELECT avg(salary) FROM developers)" +
                "WHERE salary<(SELECT avg(salary) FROM developers)";
//        int updated = st.executeUpdate(sql1);
//        System.out.println("Güncellenen kayit sayisi: " + updated);

        ResultSet rs1 = st.executeQuery("SELECT id,name,salary FROM developers");

        while (rs1.next()) {
            System.out.println(rs1.getInt("id") + "--" + rs1.getString("name") + "--" + rs1.getDouble("salary"));
        }


        System.out.println("-------------ÖRNEK2---------------");
        //ÖRNEK2:developers tablosuna yeni bir developer ekleyiniz.
        String sql2 = "INSERT INTO developers(name,salary,prog_lang) VALUES('Ilker',5300,'React')";
        //int inserted=  st.executeUpdate(sql2);
        //System.out.println("Eklenen kayit sayisi: "+inserted);


    }


}