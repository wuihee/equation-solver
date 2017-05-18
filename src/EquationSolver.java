import java.util.*;

public class EquationSolver {
    public static void main(String[] args) {
        ArrayList<String> equation = getEquation();
        System.out.println(equation);
}

    private static ArrayList<String> getEquation() {
        Scanner console = new Scanner(System.in);
        String userInput;
        ArrayList<String> equation = new ArrayList<>();
        String currentPrompt;
        String termPrompt = "Enter a Term: ";
        String operatorPrompt = "Enter an Operator: ";
        boolean current = true;  // true -> term, false -> operator.
        boolean quit = false;

        while (!quit) {
            // Prompt User
            currentPrompt = current ? termPrompt : operatorPrompt;
            System.out.print(currentPrompt);
            userInput = console.next();

            // Update Equation
            if (userInput.equals("quit")) {
                quit = true;
            }
            else {
                equation.add(userInput);
            }

            // Print Equation
            System.out.print("Equation: f(x) = ");
            for (String i : equation) {
                System.out.print(i + " ");
            }
            System.out.println();

            // Toggle Value
            current = !current;
        }
        return equation;
    }
}
