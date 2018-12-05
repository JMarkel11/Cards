public class Main {

    public static void main(String[] args) {
       TestDatbase();
    }


    private static void TestDatbase() {
        MagicCard testCard = new MagicCard(3, "Lava Axe", "Deal 3 damage to target player", "Steve Argyle", "mmmmmmmm", "URL", 1, 2, 3, MagicCard.CardRarity.Common, MagicCard.CardCategory.Sorcery);
        MagicCard updateCard = new MagicCard(3, "Savage Punch", "Bears!", "Steve Argyle", "mmmmmmmm", "URL", 1, 2, 3, MagicCard.CardRarity.Common, MagicCard.CardCategory.Sorcery);
        cardDatabase testDatabase = new cardDatabase();
        int testId = testDatabase.insertCardIntoDatabase(testCard); // This should give you the id that was generated for the card
        MagicCard returnCard = testDatabase.GetCardById(testId); // This should give you the data that we put in on the line above
        testDatabase.updateCardInDatabase(testId, updateCard); // Update the card to have all the values of updateCard, instead of the values in TestCard. Only the id remains the same
        testDatabase.deleteCardInDatabase(testId); // The card should not be in the database after this
    }

}

//how to do int properly
//Main works with cardDatabase.java
//VCS-Comment-Commit and push