import java.util.*;


public class MagicCard {
    public int CMC;
    ArrayList <CardCost> Costs = new ArrayList <CardCost> ();
    public String Name;
    public String Description;
    public String Artist;
    public String FlavorText;
    public String Image;
    public int CardNumber;
    public int Power;
    public int Toughness;
    public CardCategory Type;
    public CardRarity Rarity;
    public enum CardRarity {
        Common,
        Uncommon,
        Rare,
        Mythic,
    }
    public enum CardCategory {
        Instant,
        Sorcery,
        Artifact,
        Enchantment,
        Plainswalker,
    }


    public MagicCard(int cost, String name, String description, String artist, String flavorText, String image, int cardNumber, int power, int toughness, CardRarity rarity, CardCategory type) { //this is constructor, function that returns an instance of class
        this.CMC = cost;
        this.Name = name;
        this.Description = description;
        this.Artist = artist;
        this.FlavorText = flavorText;
        this.Image = image;
        this.CardNumber = cardNumber;
        this.Power = power;
        this.Toughness = toughness;
        this.Rarity = rarity;
        this.Type = type;

    }

    public MagicCard() {

    }
//must finish constructor so that it includes all of these types above

}

