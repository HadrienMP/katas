package coffee.machine.perso1.domain;

enum Drink {
    COFFEE      ("C", "0.6"),
    ORANGE_JUICE("O", "0.6"),
    TEA         ("T", "0.4"),
    CHOCOLATE   ("H", "0.5");

    private final String drinkMakerCommand;
    private Money price;

    Drink(String drinkMakerCommand, String priceInEuros) {

        this.drinkMakerCommand = drinkMakerCommand;
        this.price = new Money(priceInEuros);
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
