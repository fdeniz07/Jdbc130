import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute0 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver"); //Java 7 ile birlikte gerek kalmadi.

        //2. Adım: Database'e bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_db", "dev_user", "password");

        //3. Adım: Statement oluştur. SQL komutlarini DB ye iletmek ve calistirmak icin
        Statement st = con.createStatement();

        //System.out.println("Connection Success");

        //4.Adim: Query(sorgu) calistirma

        //ÖRNEK 1:"workers" adında bir tablo oluşturup "worker_id,worker_name,salary" sütunlarını ekleyiniz.

//        boolean sql1 = st.execute("Create Table workers(worker_id INT,worker_name Varchar(50),salary real)");
//        System.out.println("sql1: " + sql1);

        //execute(): DDL veya DQL
        //DDL icin kullanilirsa: ResultSet nesnesi alirsa true döndürür aksi halde false döndürür.
        //DDL icin kullanilirsa: geriye False döndürür.


        //ÖRNEK 2:"workers" tablosuna VARCHAR(20) tipinde "city" sütununu ekleyiniz.
//        String query2 = "Alter Table workers add column city varchar(20)";
//        st.execute(query2);

        //ÖRNEK 3:"workers" tablosunu SCHEMAdan siliniz.
//        String query3 = "DROP TABLE workers";
//        st.execute(query3);

        //5.ADIM:bağlantı ve statementı kapatma
        st.close();
        con.close();
    }
}
