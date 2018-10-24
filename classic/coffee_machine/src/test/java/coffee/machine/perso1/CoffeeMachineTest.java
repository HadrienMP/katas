package coffee.machine.perso1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import coffee.machine.perso1.domain.BeverageOrder;
import coffee.machine.perso1.domain.BeverageOrderBuilder;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineTest {

    @Mock
    private DrinkMaker drinkMaker;
    @InjectMocks
    private CoffeeMachine coffeeMachine;

    @Test
    public void tea_with_one_sugar_and_a_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Tea")
                .withNumberOfSugars("1")
                .withMoneyInserted("0.4")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("T:1:0");
    }

    @Test
    public void coffee_with_one_sugar_and_a_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Coffee")
                .withNumberOfSugars("1")
                .withMoneyInserted("0.6")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("C:1:0");
    }

    @Test
    public void chocolate_with_one_sugar_and_a_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Chocolate")
                .withNumberOfSugars("1")
                .withMoneyInserted("0.5")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("H:1:0");
    }

    @Test
    public void tea_with_two_sugar_and_a_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Tea")
                .withNumberOfSugars("2")
                .withMoneyInserted("0.4")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("T:2:0");
    }

    @Test
    public void tea_without_sugar_and_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Tea")
                .withMoneyInserted("0.4")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("T::");
    }

    @Test
    public void should_send_error_message_to_drink_maker_when_not_enough_money_was_inserted_for_tea() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Tea")
                .withMoneyInserted("0.39")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker, times(1)).execute(any());
        verify(drinkMaker).execute(matches("M:0.01"));
    }

    @Test
    public void should_send_error_message_to_drink_maker_when_not_enough_money_was_inserted_for_coffee() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Coffee")
                .withMoneyInserted("0.20")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker, times(1)).execute(any());
        verify(drinkMaker).execute(matches("M:0.40"));
    }

    @Test
    public void should_send_error_message_to_drink_maker_when_not_enough_money_was_inserted_for_chocolate() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Chocolate")
                .withMoneyInserted("0.10")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker, times(1)).execute(any());
        verify(drinkMaker).execute(matches("M:0.40"));
    }

    @Test
    public void should_make_the_beverage_when_too_much_money_was_inserted() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Tea")
                .withMoneyInserted("0.41")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("T::");
    }

    @Test
    public void orange_juice() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Orange juice")
                .withMoneyInserted("0.6")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("O::");
    }

    @Test
    public void should_send_error_message_to_drink_maker_when_not_enough_money_was_inserted_for_orange_juice() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Orange juice")
                .withMoneyInserted("0.59")
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker, times(1)).execute(any());
        verify(drinkMaker).execute(matches("M:0.01"));
    }

    @Test
    public void extra_hot_tea() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Tea")
                .withMoneyInserted("0.60")
                .extraHot()
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("Th::");
    }

    @Test
    public void extra_hot_coffee_with_two_sugars_and_a_stick() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrderBuilder()
                .withDrinkName("Coffee")
                .withNumberOfSugars("2")
                .withMoneyInserted("0.60")
                .extraHot()
                .build();
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("Ch:2:0");
    }
}