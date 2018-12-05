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

     public int insertCardIntoDatabase(MagicCard card) {
         int finalId = 0;
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
             String sql = "INSERT INTO CARDS (cardname, carddescription, artist, flavortext, cardimage, cardnumber, power, toughness, rarity) " // MAKE THIS STRING WITH ALL THE COLUMN NAMES IN IT
                     + "VALUES ("LavaSpike', 'Deal 3 Damage', 'Me'', 'Spikey', 'FireballImage', '4', 0, 0, 'uncommon' );"; // MAKE THIS STRING WITH THE CORRESPONDING VALUES IN card
             stmt.executeUpdate(sql);


             stmt.close();
             c.commit();
             c.close();
         } catch (Exception e) {
             System.err.println( e.getClass().getName()+": "+ e.getMessage() );
             System.exit(0);
         }
         System.out.println("Records created successfully");
         return finalId;
     }

     public void updateCardInDatabase(int id, MagicCard input) {
         String sql = "UPDATE CARDS (carddescription) = Deal 4 Damage WHERE = ID =22; "
         // replace all the stuff in card #id with all the stuff in input
         //updateCardInDatabase(22, Bolt, threedamage, ChrisRush, Boltzzz, BestImage, 1, none, none, Common, Instant);
     }

     public void deleteCardInDatabase(int id) {
         String sql = "DELETE FROM CARDS (cardname) WHERE carddescription = 'Deal 3 Damage' "
         //updateCardInDatabase() artist = ChrisRush WHERE id = 22;
     }



}
