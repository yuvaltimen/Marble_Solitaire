import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/**
 * Do not modify this file. This file should compile correctly with your code!
 * You DO NOT need to submit this file.
 */
public class Hw03TypeChecks {

  /**
   * The contents of this method are meaningless.
   * They are only here to ensure that your code compiles properly.
   */
  public static void main(String[] args) {
    Readable rd = null;
    Appendable ap = null;
    helper(new MarbleSolitaireModelImpl(),
           new MarbleSolitaireControllerImpl(rd, ap));
    helper(new MarbleSolitaireModelImpl(3, 3),
           new MarbleSolitaireControllerImpl(rd, ap));
  }

  private static void helper(
           MarbleSolitaireModel model,
           MarbleSolitaireController controller) {
    controller.playGame(model);
  }

}
