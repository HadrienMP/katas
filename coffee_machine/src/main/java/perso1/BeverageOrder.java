package perso1;

import static perso1.Drink.*;

class BeverageOrder {
    private static final String NEEDS_STICK_COMMAND = "0";
    private static final String DRINK_MAKER_ARGUMENT_SEPARATOR = ":";
    private static final String EXTRA_HOT_COMMAND = "h";

    private Drink drink;
    private final int numberOfSugars;
    private final Money moneyInserted;
    private boolean extraHot;

    BeverageOrder(String drinkName, String numberOfSugars, String moneyInserted, boolean extraHot) {

        this.drink = from(drinkName);
        this.numberOfSugars = Integer.valueOf(numberOfSugars);
        this.moneyInserted = new Money(moneyInserted);
        this.extraHot = extraHot;
    }

    String toDrinkMakerCommand() {
        String drinkCommand = this.getDrinkCommand();
        String extraHotCommand = getExtraHotCommand();
        String sugarCommand = this.getSugarCommand();
        String stickCommand = this.getStickCommand();
        return drinkCommand + extraHotCommand + DRINK_MAKER_ARGUMENT_SEPARATOR + sugarCommand + DRINK_MAKER_ARGUMENT_SEPARATOR + stickCommand;
    }

    private String getDrinkCommand() {
        return drink.getDrinkMakerCommand();
    }

    private String getExtraHotCommand() {
        return extraHot ? EXTRA_HOT_COMMAND : "";
    }

    private String getSugarCommand() {
        return needsSugar() ? String.valueOf(numberOfSugars) : "";
    }

    private String getStickCommand() {
        return needsSugar() ? NEEDS_STICK_COMMAND : "";
    }

    private boolean needsSugar() {
        return numberOfSugars != 0;
    }

    boolean wasEnoughMoneyInserted() {
        return drink.isEnoughMoney(moneyInserted);
    }

    String getMissingMoney() {
        return drink.getMoneyDifference(moneyInserted).toString();
    }
}
