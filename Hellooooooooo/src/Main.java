public class Main {

    public static void main(String[] args) {
        MagicCard test = new MagicCard(3, "Lava Axe", "Deal 3 damage to target player","Steve Argyle","mmmmmmmm","URL",1,2,3, MagicCard.CardRarity.Common, MagicCard.CardCategory.Sorcery);
        test.Name = "Tarmogoyf";
        System.out.println(test.Name);
        cardDatabase GoyfDatabase = new cardDatabase();
        GoyfDatabase.GetCardById(22);
    }

}
//how to do int properly
