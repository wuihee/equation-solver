import java.util.*;

public class Equation {
    static ArrayList<String> getEquation() {
        Scanner console = new Scanner(System.in);
        ArrayList<String> equation = new ArrayList<>();
        String term;
        String prompt = "Enter a Term (Enter 'q' to quit): ";
        boolean quit = false;

        while (!quit) {
            // Prompt User
            System.out.print(prompt);
            term = console.next();

            // Update Equation
            if (term.equals("q")) {
                quit = true;
            }
            else {
                if (term.charAt(0) != '-' && !equation.isEmpty()) {
                    term = "+" + term;
                }
                equation.add(term);
            }
        }
        return equation;
    }
}
