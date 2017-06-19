public class Client {
  public static void main(String[] args) {
    Keypad keypad = new Keypad();
    keypad.createAndShowGUI();  // Create a Keypad object and show GUI.

    /*
    Currently, the program can only calculate simple functions and its graphing function is almost non-usable.
    The next step would be to find a better way to evaluate mathematical expressions. Currently, the calculator
    creates a JavaScript engine and uses the eval() function from JavaScript which is very inconsistent. The
    shunting-yard algorithm should be used instead. After the calculator is thoroughly complete, and returns a
    set of x-points from a given equation, the graphing class would be created. A graph will be made with those
    set of x poitns. After all of that is complete, there will be some finalization and the project will be
    finished.
    */
  }
}
