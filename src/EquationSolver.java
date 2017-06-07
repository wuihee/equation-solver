import java.util.*;
import javax.script.*;

public class EquationSolver {
    public static void main(String[] args) throws ScriptException {
        Scanner console = new Scanner(System.in);
        int[] points1 = getPoints(getEquation(console), 1, 10);
        int[] points2 = getPoints(getEquation(console), -10, 20);
    }

    public static int[] getPoints(String equation, int start, int end) throws ScriptException {
        int[] points = new int[Math.abs(start - end) + 1];
        int count = 0;

        for (int i = start; i < end; i++) {
            String coefficient = " * " + i;
            String expression = equation.replace("x", coefficient);
            System.out.println(expression);
            points[count] = evalString(expression);
            count++;
        }

        return points;
    }

    public static String getEquation(Scanner console) {
        System.out.print("Enter Equation (Use Whitespace): ");
        return "y = " + console.nextLine();
    }

    public static int evalString(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (int) engine.eval(expression);
    }
}
