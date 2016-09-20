package perso1;

public class CoffeeMachine {

    private DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void prepare(BeverageOrder beverageOrder) {
        if (beverageOrder.wasEnoughMoneyInserted()) {
            drinkMaker.execute(beverageOrder.toDrinkMakerCommand());
        } else {
            drinkMaker.execute("M:"+ beverageOrder.getMissingMoney());
        }
    }
}
