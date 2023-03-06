import java.sql.*;

import java.sql.SQLException;

public class ExecuteQuery01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Database e bağlanma
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_db", "dev_user", "password");

        //Stament oluştur; SQL komutlarını DB ye iletmek ve çalıştırmak için
        Statement st = con.createStatement();

        //System.out.println("Connection success");

        //Query(sorgu) çalıştırma

        //ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.
        String query1 = "Select country_name from countries where id between 5 and 10";
        boolean sql1 = st.execute(query1);
        System.out.println("sql1: " + sql1);

        //kayitlari görmek icin executeQuery() kullanmaliyiz
        ResultSet resultSet = st.executeQuery(query1);
//        resultSet.next();
//        System.out.println(resultSet.getString("country_name"));

        while (resultSet.next()) {
            //System.out.println("Ülke Ismi: " + resultSet.getString("country_name"));
            //ya kolon adiyla ya da kolon indexi ile ulasilabilir. Not: DB de index numarasi 1 den baslar. Sütun ismi ile cagirmak daha sagliklidir.
            System.out.println(resultSet.getString(1));
        }

        //ResultSet'in first(),last(),next() gibi metotlari vardir.
        //ResultSet'te geriye dönüs yoktur.

        System.out.println("-----------------------------------------------------");

        //ÖRNEK 2: phone_code'u 600 den büyük olan ülkelerin "phone_code" ve "country_name" bilgisini listeleyiniz.
        String query2 = "Select phone_code,country_name from countries where phone_code>600";
        ResultSet rs2 = st.executeQuery(query2);

        while (rs2.next()) {
            System.out.println(rs2.getInt("phone_code") + ": " + rs2.getString("country_name"));
        }

        //ÖRNEK 3:developers tablosunda "salary" değeri en düşük olan developerların tüm bilgilerini gösteriniz.
        String query3 = "SELECT * from developers where salary= (select min(salary) from developers)";
        ResultSet rs3 = st.executeQuery(query3);

        while (rs3.next()) {
            System.out.println("ID " + rs3.getInt("id") + ", Name:" + rs3.getString("name") + ", Salary:" + rs3.getDouble("salary") + ", Programming Language:" + rs3.getString("prog_lang"));
        }

        //ÖRNEK 4:Puanı taban puanlarının ortalamasından yüksek olan öğrencilerin isim ve puanlarını listeleyiniz.
        String query4 = " select isim,puan from ogrenciler where puan>( select avg(taban_puanı)from bolumler)";
        ResultSet rs4 = st.executeQuery(query4);

        while (rs4.next()) {
            System.out.println("Isim:" + rs4.getString("isim") + ", Puan:" + rs4.getInt("puan"));
        }
        st.close();
        con.close();
    }


}
