package perso1.domain;

public class BeverageOrderBuilder {

    private Drink drink;
    private int numberOfSugars = 0;
    private Money moneyInserted = Money.NO_MONEY;
    private boolean extraHot;

    public BeverageOrderBuilder withDrinkName(String drinkName) {
        this.drink = Drink.from(drinkName);
        return this;
    }

    public BeverageOrderBuilder withNumberOfSugars(String numberOfSugars) {
        this.numberOfSugars = Integer.valueOf(numberOfSugars);
        return this;
    }

    public BeverageOrderBuilder withMoneyInserted(String moneyInserted) {
        this.moneyInserted = new Money(moneyInserted);
        return this;
    }

    public BeverageOrderBuilder extraHot() {
        this.extraHot = true;
        return this;
    }

    public BeverageOrder build() {
        return new BeverageOrder(drink, numberOfSugars, moneyInserted, extraHot);
    }
}