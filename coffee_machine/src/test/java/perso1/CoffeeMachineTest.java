package perso1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
        BeverageOrder beverageOrder = new BeverageOrder("Tea", "1", "0.4");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("T:1:0");
    }

    @Test
    public void coffee_with_one_sugar_and_a_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Coffee", "1", "0.6");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("C:1:0");
    }

    @Test
    public void chocolate_with_one_sugar_and_a_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Chocolate", "1", "0.5");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("H:1:0");
    }

    @Test
    public void tea_with_two_sugar_and_a_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Tea", "2", "0.4");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("T:2:0");
    }

    @Test
    public void tea_without_sugar_and_stick() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Tea", "0", "0.4");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("T::");
    }

    @Test
    public void should_send_error_message_to_drink_maker_when_not_enough_money_was_inserted_for_tea() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Tea", "0", "0.39");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker, times(1)).execute(any());
        verify(drinkMaker).execute(matches("M:0.01"));
    }

    @Test
    public void should_send_error_message_to_drink_maker_when_not_enough_money_was_inserted_for_coffee() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Coffee", "0", "0.20");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker, times(1)).execute(any());
        verify(drinkMaker).execute(matches("M:0.40"));
    }

    @Test
    public void should_send_error_message_to_drink_maker_when_not_enough_money_was_inserted_for_chocolate() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Chocolate", "0", "0.10");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker, times(1)).execute(any());
        verify(drinkMaker).execute(matches("M:0.40"));
    }

    @Test
    public void should_make_the_beverage_when_too_much_money_was_inserted() {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Tea", "0", "0.41");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("T::");
    }

    @Test
    public void orange_juice() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Orange juice", "0", "0.6");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker).execute("O::");
    }

    @Test
    public void should_send_error_message_to_drink_maker_when_not_enough_money_was_inserted_for_orange_juice() throws Exception {
        // GIVEN
        BeverageOrder beverageOrder = new BeverageOrder("Orange juice", "0", "0.59");
        // WHEN
        coffeeMachine.prepare(beverageOrder);
        // THEN
        verify(drinkMaker, times(1)).execute(any());
        verify(drinkMaker).execute(matches("M:0.01"));
    }
}