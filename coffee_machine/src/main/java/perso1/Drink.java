package perso1;

public enum Drink {
    COFFEE      ("C", new Money("0.6")),
    ORANGE_JUICE("O", new Money("0.6")),
    TEA         ("T", new Money("0.4")),
    CHOCOLATE   ("H", new Money("0.5"));

    private final String drinkMakerCommand;
    private Money price;

    Drink(String drinkMakerCommand, Money priceInCents) {

        this.drinkMakerCommand = drinkMakerCommand;
        this.price = priceInCents;
    }

    public static Drink from(String drinkName) {
        return Drink.valueOf(drinkName.toUpperCase().replaceAll(" ", "_"));
    }

    public String getDrinkMakerCommand() {
        return drinkMakerCommand;
    }

    public boolean isEnoughMoney(Money cents) {
        return price.isLessOrEqualTo(cents);
    }

    public Money getMoneyDifference(Money moneyInserted) {
        return price.difference(moneyInserted);
    }
}
