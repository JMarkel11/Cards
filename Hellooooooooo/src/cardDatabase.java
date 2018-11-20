import java.sql.Connection;
import java.sql.DriverManager;

public class cardDatabase {

     MagicCard GetCardById (int id) {

         String Address = System.getenv("POSTGRES_ADDRESS");
         String UserName = System.getenv("POSTGRES_USERNAME");
         String Password = System.getenv("POSTGRES_PASSWORD");

         Connection c = null;
         try {
             Class.forName("org.postgresql.Driver");
             c = DriverManager
                     .getConnection(Address,
                             UserName, Password);
         } catch (Exception e) {
             e.printStackTrace();
             System.err.println(e.getClass().getName()+": "+e.getMessage());
             System.exit(0);
         }
         System.out.println("Opened database successfully");
     return new MagicCard();
     }
}
