import java.util.*;
import javax.script.*;

public class EquationSolver {
    public static void main(String[] args) throws ScriptException {
        Scanner console = new Scanner(System.in);
        int[] points1 = getPoints(getEquation(console), 1, 10);
        System.out.println(Arrays.toString(points1));
    }

    private static int[] getPoints(String equation, int start, int end) throws ScriptException {
        int len = Math.abs(start - end) + 1;
        int[] xPoints = new int[len];
        int[] yPoints = new int[len];
        int count = 0;

        for (int i = start; i < end; i++) {
            String coefficient = " * " + i;
            String expression = equation.replace("x", coefficient);
            xPoints[count] = evalString(expression);
            yPoints[count] = i;
            count++;
        }

        return xPoints;
    }

    private static String getEquation(Scanner console) {
        System.out.print("Enter Equation (Use Whitespace): ");
        return "y = " + console.nextLine();
    }

    private static int evalString(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (int) engine.eval(expression);
    }
}
