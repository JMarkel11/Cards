import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class cardDatabase {

     MagicCard GetCardById (int id) {

         String Address = System.getenv("POSTGRES_ADDRESS");
         String UserName = System.getenv("POSTGRES_USERNAME");
         String Password = System.getenv("POSTGRES_PASSWORD");

         Connection c = null;
         Statement stmt = null;
         try {
             Class.forName("org.postgresql.Driver");
             c = DriverManager
                     .getConnection(Address,
                             UserName, Password);
             c.setAutoCommit(false);
             System.out.println("Opened database successfully");

             stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery( "SELECT * FROM CARDS;" );
             while ( rs.next() ) {
                 int cardId = rs.getInt("id");
                 String  name = rs.getString("cardname");
                 System.out.println( "ID = " + id );
                 System.out.println( "NAME = " + name );
             }
             rs.close();
             stmt.close();
             c.close();
         } catch ( Exception e ) {
             System.err.println( e.getClass().getName()+": "+ e.getMessage() );
             System.exit(0);
         }
         System.out.println("Operation done successfully");
     return new MagicCard();
     }
}
