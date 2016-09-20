package perso1;

public class BeverageOrderBuilder {
    private String drinkName;
    private String numberOfSugars;
    private String moneyInserted;
    private boolean extraHot;

    public BeverageOrderBuilder withDrinkName(String drinkName) {
        this.drinkName = drinkName;
        return this;
    }

    public BeverageOrderBuilder withNumberOfSugars(String numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
        return this;
    }

    public BeverageOrderBuilder withMoneyInserted(String moneyInserted) {
        this.moneyInserted = moneyInserted;
        return this;
    }

    public BeverageOrderBuilder withExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
        return this;
    }

    public BeverageOrderBuilder extraHot() {
        this.extraHot = true;
        return this;
    }

    public BeverageOrder build() {
        return new BeverageOrder(drinkName, numberOfSugars, moneyInserted, extraHot);
    }
}