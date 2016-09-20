package coffee.machine.perso1.domain;

enum Drink {
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

    static Drink from(String drinkName) {
        return Drink.valueOf(drinkName.toUpperCase().replaceAll(" ", "_"));
    }

    String getDrinkMakerCommand() {
        return drinkMakerCommand;
    }

    boolean isEnoughMoney(Money cents) {
        return price.isLessOrEqualTo(cents);
    }

    Money getMoneyDifference(Money moneyInserted) {
        return price.difference(moneyInserted);
    }
}
