public class Main {

    public static void main(String[] args) {
        MagicCard test = new MagicCard(3, "Lava Axe", "Deal 3 damage to target player","Steve Argyle","mmmmmmmm","URL",1,2,3, MagicCard.CardRarity.Common, MagicCard.CardCategory.Sorcery);
        cardDatabase GoyfDatabase = new cardDatabase();
        MagicCard databaseResult = GoyfDatabase.GetCardById(22);
        GoyfDatabase.insertCardIntoDatabase(test);
        System.out.println(databaseResult.Name);
    }

}
//how to do int properly
//Main works with cardDatabase.java
//VCS-Comment-Commit and push