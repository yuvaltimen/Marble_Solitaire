import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.InputStreamReader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/**
 * Testing class for (@code cs3500.marblesolitaire.controller)
 */
public class MarbleSolitaireControllerTest {


  /**
   * Play the goddamn game.
   * @param args The user input to the console.
   */
  /*
  public static void main(String[] args) {
    MarbleSolitaireModel myModel = new MarbleSolitaireModelImpl();
    Readable rd = new InputStreamReader(System.in);
    MarbleSolitaireController myCtrlr = new MarbleSolitaireControllerImpl(rd, System.out);
    myCtrlr.playGame(myModel);
  }
  */


  /**
   * Test that the constructor works properly.
   */

  @Test
  public void testControllerConstructor() {
    Readable rd = new StringReader("Some arbitrary string...");
    Appendable ap = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(rd, ap);
  }

  /**
   * Test that the constructor throws an IllegalArgumentException if either parameter is null.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorNullReadable() {
    Appendable ap = new StringBuilder();
    MarbleSolitaireController inv = new MarbleSolitaireControllerImpl(null, ap);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorNullAppendable() {
    Readable rd = new InputStreamReader(System.in);
    MarbleSolitaireController inv = new MarbleSolitaireControllerImpl(rd, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorBothNull() {
    MarbleSolitaireController inv = new MarbleSolitaireControllerImpl(null, null);
  }

  /**
   * Tests that the user quits instantly.
   */

  @Test
  public void testPlayGameQuitInstantly() {
    String inp = "q";
    String exp = "    O O O\n"
            + "    O O O\n"
            +            "O O O O O O O\n"
            +            "O O O _ O O O\n"
            +            "O O O O O O O\n"
            +            "    O O O\n"
            +            "    O O O\n"
            +            "Score: 32\n"
            +            "Game quit!\n"
            +            "State of game when quit:\n"
            +            "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n";
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    Readable rd = new StringReader(inp);
    Appendable ap = new StringBuilder();
    MarbleSolitaireController ctrl = new MarbleSolitaireControllerImpl(rd, ap);
    ctrl.playGame(model);
    assertEquals(exp, ap.toString());
  }

  /**
   * Test that model cannot be null.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameNullModel() {
    Readable rd = new StringReader("Some string");
    Appendable ap = new StringBuilder();
    MarbleSolitaireController ctrl = new MarbleSolitaireControllerImpl(rd, ap);
    ctrl.playGame(null);
  }

  /**
   * Test that uppercase Q is also a valid quit.
   */

  @Test
  public void testPlayGameQWorks() {
    String inp = "Q";
    String exp = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "Game quit!\n"
            + "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n";
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    Readable rd = new StringReader(inp);
    Appendable ap = new StringBuilder();
    MarbleSolitaireController ctrl = new MarbleSolitaireControllerImpl(rd, ap);
    ctrl.playGame(model);
    assertEquals(exp, ap.toString());
  }

  /**
   * Test that the user can quit in each of the positions of row and column.
   */

  @Test
  public void testPlayGameQuitInEachPosition() {
    String inp1 = "Q";
    String inp2 = "1 q";
    String inp3 = "1 2 q";
    String inp4 = "1 2 3 q";
    String exp1 = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "Game quit!\n"
            +             "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n";
    String exp2 = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "Game quit!\n"
            +             "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n";
    String exp3 = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "Game quit!\n"
            +             "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n";
    String exp4 = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "Game quit!\n"
            +             "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n";
    MarbleSolitaireModel model1 = new MarbleSolitaireModelImpl();
    MarbleSolitaireModel model2 = new MarbleSolitaireModelImpl();
    MarbleSolitaireModel model3 = new MarbleSolitaireModelImpl();
    MarbleSolitaireModel model4 = new MarbleSolitaireModelImpl();
    Readable rd1 = new StringReader(inp1);
    Readable rd2 = new StringReader(inp2);
    Readable rd3 = new StringReader(inp3);
    Readable rd4 = new StringReader(inp4);
    Appendable ap1 = new StringBuilder();
    Appendable ap2 = new StringBuilder();
    Appendable ap3 = new StringBuilder();
    Appendable ap4 = new StringBuilder();
    MarbleSolitaireController ctrl1 = new MarbleSolitaireControllerImpl(rd1, ap1);
    MarbleSolitaireController ctrl2 = new MarbleSolitaireControllerImpl(rd2, ap2);
    MarbleSolitaireController ctrl3 = new MarbleSolitaireControllerImpl(rd3, ap3);
    MarbleSolitaireController ctrl4 = new MarbleSolitaireControllerImpl(rd4, ap4);
    ctrl1.playGame(model1);
    ctrl2.playGame(model2);
    ctrl3.playGame(model3);
    ctrl4.playGame(model4);

    assertEquals(exp1, ap1.toString());
    assertEquals(exp2, ap2.toString());
    assertEquals(exp3, ap3.toString());
    assertEquals(exp4, ap4.toString());
  }

  /**
   * Tests that the game can be quit after some number of moves using only valid and invalid moves.
   */

  @Test
  public void testPlayGameQuitAfterTwoMoves() {
    String inp = "2 4 4 4 1 3 2 3 1 2 q";
    String exp = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n"
            +             "Invalid move. Play again. (0,2) -> (1,2)\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n"
            +             "Game quit!\n"
            +             "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n";
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    Readable rd = new StringReader(inp);
    Appendable ap = new StringBuilder();
    MarbleSolitaireController ctrl = new MarbleSolitaireControllerImpl(rd, ap);
    ctrl.playGame(model);
    assertEquals(exp, ap.toString());
  }

  /**
   * Tests that the user can quit the game after valid and invalid moves with strings in between.
   */

  @Test
  public void testPlayGameValidAndInvalidMoves() {
    String moves = "2 4 v 4 4 1 2 d s 2 2 2 s 2 2 2 2 w s q";
    String exp = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "Please input a number...\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n"
            +             "Please input a number...\n"
            +             "Please input a number...\n"
            +             "Invalid move. Play again. (0,1) -> (1,1)\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n"
            +             "Please input a number...\n"
            +             "Invalid move. Play again. (1,1) -> (1,1)\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n"
            +             "Please input a number...\n"
            +             "Please input a number...\n"
            +             "Game quit!\n"
            +             "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n";
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    Readable rd = new StringReader(moves);
    Appendable ap = new StringBuilder();
    MarbleSolitaireController ctrl = new MarbleSolitaireControllerImpl(rd, ap);
    ctrl.playGame(model);
    assertEquals(exp, ap.toString());
  }

  /**
   * Tests that the user can input more strings after the q on the same line.
   */

  @Test
  public void testPlayGameSameLineInputsAfterQuit() {
    String moves = "2 4 4 4 q 1 2 3 4 d l";
    String exp = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +            "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n"
            +             "Game quit!\n"
            +             "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n";
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    Readable rd = new StringReader(moves);
    Appendable ap = new StringBuilder();
    MarbleSolitaireController ctrl = new MarbleSolitaireControllerImpl(rd, ap);
    ctrl.playGame(model);
    assertEquals(exp, ap.toString());
  }

  /**
   * Test that an IllegalStateException is thrown if the game is not over and user hasn't quit.
   */

  @Test(expected = IllegalStateException.class)
  public void testPlayGameNoMoreUserInputs() {
    String moves = "1 2 e 2 1 3 2";
    String exp = "";
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    Readable rd = new StringReader(moves);
    Appendable ap = new StringBuilder();
    MarbleSolitaireController ctrl = new MarbleSolitaireControllerImpl(rd, ap);
    ctrl.playGame(model);
  }

  /**
   * Check that the game has ended after a sequence of moves.
   */

  @Test
  public void testPlayGameWinGame() {
    String moves = "2 4 4 4 3 6 3 4 1 5 3 5 1 3 1 5 3 3 1 3 4 4 2 4 4 6 4 4 5 3 3 3 4 1 4 3 3 3 5" +
            " 3 6 3 4 3 4 4 4 2 5 1 5 3 3 2 5 2 5 3 5 1 5 5 5 3 7 5 5 5 7 3 7 5 5 6 5 4 6 4 4 4";
    String exp = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O O _ _ O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 30\n"
            +             "    O O _\n"
            +             "    O _ _\n"
            +             "O O O O O _ O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 29\n"
            +             "    _ _ O\n"
            +             "    O _ _\n"
            +             "O O O O O _ O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 28\n"
            +             "    O _ O\n"
            +             "    _ _ _\n"
            +             "O O _ O O _ O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 27\n"
            +             "    O _ O\n"
            +             "    _ O _\n"
            +             "O O _ _ O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 26\n"
            +             "    O _ O\n"
            +             "    _ O _\n"
            +             "O O _ _ O _ O\n"
            +             "O O O O _ _ O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 25\n"
            +             "    O _ O\n"
            +             "    _ O _\n"
            +             "O O O _ O _ O\n"
            +             "O O _ O _ _ O\n"
            +             "O O _ O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 24\n"
            +             "    O _ O\n"
            +             "    _ O _\n"
            +             "O O O _ O _ O\n"
            +             "_ _ O O _ _ O\n"
            +             "O O _ O O O O\n"
            +             "    O O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O O _ _ O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O O _ _ O _ O\n" +
            "_ _ O O _ _ O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O O _ _ O _ O\n" +
            "_ O _ _ _ _ O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O O _ _ O _ O\n" +
            "_ O _ _ _ _ O\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ O O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ O _ _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ O _ O O O\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 15\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ O _ O O O\n" +
            "    _ O _\n" +
            "    _ _ O\n" +
            "Score: 14\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ O O _ _ O\n" +
            "    _ O _\n" +
            "    _ _ O\n" +
            "Score: 13\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "O _ O _ _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "Score: 12\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    _ O _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "O _ O _ _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "Score: 12\n";
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    Readable rd = new StringReader(moves);
    Appendable ap = new StringBuilder();
    MarbleSolitaireController ctrl = new MarbleSolitaireControllerImpl(rd, ap);
    ctrl.playGame(model);

    assertEquals(exp, ap.toString());
  }

  /**
   * Test that the input ignores random strings that are not "q" or "Q".
   */

  @Test
  public void testIgnoreStringInput() {
    Readable sr = new StringReader("2 4 w em || / f f%d 4 4 Q");
    Appendable sb = new StringBuilder();
    MarbleSolitaireModel md = new MarbleSolitaireModelImpl();
    MarbleSolitaireController cr = new MarbleSolitaireControllerImpl(sr, sb);
    cr.playGame(md);
    String expt = "    O O O\n"
            +             "    O O O\n"
            +             "O O O O O O O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 32\n"
            +             "Please input a number...\n"
            +             "Please input a number...\n"
            +             "Please input a number...\n"
            +             "Please input a number...\n"
            +             "Please input a number...\n"
            +             "Please input a number...\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n"
            +             "Game quit!\n"
            +             "State of game when quit:\n"
            +             "    O O O\n"
            +             "    O _ O\n"
            +             "O O O _ O O O\n"
            +             "O O O O O O O\n"
            +             "O O O O O O O\n"
            +             "    O O O\n"
            +             "    O O O\n"
            +             "Score: 31\n";
    assertEquals(expt, sb.toString());
  }
}
