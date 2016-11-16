package perso._1;

class Calculator {
    int compute(String operations) {
        int plus = operations.indexOf('+');
        String firstOperand = operations.substring(0, plus);
        String secondOperand = operations.substring(plus + 1);
        return Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand);
    }
}
