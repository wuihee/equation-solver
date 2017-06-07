import java.util.*;
import javax.script.*;

public class EquationSolver {
    public static void main(String[] args) throws ScriptException {
        Scanner console = new Scanner(System.in);
        String equation = getEquation(console);
        System.out.println(equation);
        evalString("1 + 1 + 10 * 100");
    }

    public static String getEquation(Scanner console) {
        System.out.print("Enter Equation (Use Whitespace): ");
        return "y = " + console.nextLine();
    }

    public static void evalString(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        System.out.println(engine.eval(expression));
    }
}
