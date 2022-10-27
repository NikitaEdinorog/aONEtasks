import Task1.ipvProcessor;
import Task2.FunctionCalculator;

public class Main {
    public static void main(String[] args) {
        long number = 4294967295L;
        String line = "20.0.1.1";
        view.print(ipvProcessor.ipv4ToLine(number));
        view.print(ipvProcessor.ipv4ToNumber(line));


        int testNumber = 4;
        FunctionCalculator functionCalculator = new FunctionCalculator();
        view.print(functionCalculator.calculateFunction(testNumber));

    }
}