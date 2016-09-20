package perso1.domain;

public class BeverageOrder {
    private static final String NEEDS_STICK_COMMAND = "0";
    private static final String DRINK_MAKER_ARGUMENT_SEPARATOR = ":";
    private static final String EXTRA_HOT_COMMAND = "h";

    private Drink drink;
    private final int numberOfSugars;
    private final Money moneyInserted;
    private boolean extraHot;

    BeverageOrder(Drink drink, int numberOfSugars, Money moneyInserted, boolean extraHot) {
        this.drink = drink;
        this.numberOfSugars = numberOfSugars;
        this.moneyInserted = moneyInserted;
        this.extraHot = extraHot;
    }

    public String toDrinkMakerCommand() {
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

    public boolean wasEnoughMoneyInserted() {
        return drink.isEnoughMoney(moneyInserted);
    }

    public String getMissingMoney() {
        return drink.getMoneyDifference(moneyInserted).toString();
    }
}
