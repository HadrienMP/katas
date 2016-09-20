package coffee.machine.perso1;

import coffee.machine.perso1.domain.BeverageOrder;

class CoffeeMachine {

    private DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    void prepare(BeverageOrder beverageOrder) {
        if (beverageOrder.wasEnoughMoneyInserted()) {
            drinkMaker.execute(beverageOrder.toDrinkMakerCommand());
        } else {
            drinkMaker.execute("M:"+ beverageOrder.getMissingMoney());
        }
    }
}
