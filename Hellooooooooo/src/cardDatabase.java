import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class cardDatabase {

     MagicCard GetCardById (int id) {

         MagicCard result = new MagicCard();
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
             ResultSet rs = stmt.executeQuery( "SELECT * FROM CARDS WHERE id = " + id + ";" );
             while ( rs.next() ) {
                 int cardId = rs.getInt("id");
                 String name = rs.getString("cardname");
                 String description = rs.getString("carddescription");
                 String artist = rs.getString("artist");
                 String flavortext = rs.getString("flavortext");
                 String cardimage = rs.getString("cardimage");
                 int cardnumber = rs.getInt("cardnumber");
                 int power = rs.getInt("power");
                 int toughness = rs.getInt("toughness");
                 String cardrarity = rs.getString("rarity");
                 result = new MagicCard(cardId,name, description, artist, flavortext, cardimage, cardnumber, power, toughness, MagicCard.CardRarity.valueOf(cardrarity), MagicCard.CardCategory.Instant);

             }
             rs.close();
             stmt.close();
             c.close();
         } catch ( Exception e ) {
             System.err.println( e.getClass().getName()+": "+ e.getMessage() );
             System.exit(0);
         }
         System.out.println("Operation done successfully");
     return result;
     }

     public void insertCardIntoDatabase(MagicCard card) {
         // put all the stuff in card into the database
     }

     public void updateCardInDatabase(int id, MagicCard input) {
         // replace all the stuff in card #id with all the stuff in input
     }

     public void deleteCardInDatabase(int id) {
         // Deletes this row in the cards table
     }



}
