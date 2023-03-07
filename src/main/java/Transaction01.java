import java.sql.*;

/*
    Transaction: DB'deki atomik(parcalanamaz) en kücük islem.
    Birden fazla işlem için custom olarak transaction oluşturulabilir.
    Bu işlemlerin tamamı başarılı bir şekilde gerçekleşince transaction commit edilir.
    En az birinde problem olursa rollback ile tüm işlemler iptal edilir.
 */

public class Transaction01 {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_db", "dev_user", "password");
        Statement st = con.createStatement();

        System.out.println("-------------ÖRNEK1---------------");
        //Hesap no:1234 den hesap no:5678 e 1000 para transferi olsun.

        con.setAutoCommit(false);
        try {
            String sql1 = "UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
            PreparedStatement prst = con.prepareStatement(sql1);
            prst.setDouble(1, -1000);
            prst.setInt(2, 1234);
            prst.executeUpdate();

            //SISTEMDE HATA OLUSTU
            if (true) {
                throw new Exception();
            }

            prst.setDouble(1, 1000);
            prst.setInt(2, 5678);
            prst.executeUpdate();
            prst.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            con.rollback();
        }

    }
}
