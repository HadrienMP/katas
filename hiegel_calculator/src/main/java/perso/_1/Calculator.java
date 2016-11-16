package perso._1;

class Calculator {
    int compute(String operations) {
        int firstOperand = Character.getNumericValue(operations.charAt(0));
        int secondOperand = Character.getNumericValue(operations.charAt(2));
        return firstOperand + secondOperand;
    }
}
