package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.GameState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import java.io.InputStreamReader;

/**
 * Represents some game of MarbleSolitaire.
 */
public final class MarbleSolitaire {

  /**
   * Main method for running the game from the console.
   *
   * <p>@param args Console input.</p>
   */

  public static void main(String[] args) {


    GameState gs = GameState.INIT;
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();


    while (gs == GameState.INIT) {

      int numArg = args.length;

      switch (numArg) {
        /////////////////////////////////////////
        case 1:
          try {
            model = getModel1(args, model);
          } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            continue;
          }
          gs = GameState.PLAYING;
          break;

        /////////////////////////////////////////
        case 3:
          try {
            model = getModel3(args, model);
          } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            continue;
          }
          gs = GameState.PLAYING;
          break;

        /////////////////////////////////////////
        case 4:
          try {
            model = getModel4(args, model);
          } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            continue;
          }
          gs = GameState.PLAYING;
          break;

        case 6:
          try {
            model = getModel6(args, model);
          } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            continue;
          }
          gs = GameState.PLAYING;
          break;

        /////////////////////////////////////////
        default:
          System.out.println("Impossible number of input arguments...");
      }
    }

    //Now that the game has finished initializing, let's play
    Readable rd = new InputStreamReader(System.in);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(rd, System.out);
    controller.playGame(model);
  }

  /**
   * Creates the model with 1 input arg.
   *
   * @param arg the String[] that represents the inputs.
   * @return the instantiated model.
   */
  private static MarbleSolitaireModel getModel1(String[] arg, MarbleSolitaireModel model) {

    switch (arg[0]) {
      case "english":
        model = new MarbleSolitaireModelImpl();
        break;
      case "european":
        model = new EuropeanSolitaireModelImpl();
        break;
      case "triangular":
        model = new TriangleSolitaireModelImpl();
        break;
      default:
        throw new IllegalArgumentException("Not a valid constructor name...");
    }

    return model;
  }

  /**
   * Creates the model with 3 input args.
   *
   * @param arg the String[] that represents the inputs.
   * @return the instantiated model.
   */

  private static MarbleSolitaireModel getModel3(String[] arg, MarbleSolitaireModel model) {

    switch (arg[0]) {

      case "english":

        //check the 2nd argument
        if (!arg[1].equals("-size")) {
          //deal with it
          throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        } else { //check the 3rd arg
          try {
            int size = Integer.parseInt(arg[2]);
            model = new MarbleSolitaireModelImpl(size);
          } catch (NumberFormatException e) {
            System.out.println(String.format("Not a number: %s", arg[2]));
          }
        }
        break;


      case "european":
        //check the 2nd argument
        if (!arg[1].equals("-size")) {
          throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        } else {
          try {
            int size = Integer.parseInt(arg[2]);
            model = new EuropeanSolitaireModelImpl(size);
          } catch (NumberFormatException e) {
            System.out.println(String.format("Not a number: %s", arg[2]));
          }
        }
        break;


      case "triangular":
        //check the 2nd argument
        if (!arg[1].equals("-size")) {
          throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        } else {
          try {
            int size = Integer.parseInt(arg[2]);
            model = new TriangleSolitaireModelImpl(size);
          } catch (NumberFormatException e) {
            System.out.println(String.format("Not a number: %s", arg[2]));
          }
        }
        break;


      default:
        throw new IllegalArgumentException("Not a valid constructor name...");
    }

    return model;
  }

  /**
   * Creates the model with 4 input args.
   *
   * @param arg the String[] that represents the inputs.
   * @return the instantiated model.
   */

  private static MarbleSolitaireModel getModel4(String[] arg, MarbleSolitaireModel model) {

    switch (arg[0]) {

      case "english":

        //check the 2nd argument
        if (!arg[1].equals("-hole")) {
          //deal with it
          throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        } else { //check the 3rd args
          try {
            int r = Integer.parseInt(arg[2]);
            int c = Integer.parseInt(arg[3]);
            model = new MarbleSolitaireModelImpl(r, c);
          } catch (NumberFormatException e) {
            System.out.println(String.format("Not a number: %s, %s", arg[2], arg[3]));
          }
        }
        break;


      case "european":
        //check the 2nd argument
        if (!arg[1].equals("-hole")) {
          //deal with it
          throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        } else { //check the 3rd args
          try {
            int r = Integer.parseInt(arg[2]);
            int c = Integer.parseInt(arg[3]);
            model = new EuropeanSolitaireModelImpl(r, c);
          } catch (NumberFormatException e) {
            System.out.println(String.format("Not a number: %s, %s", arg[2], arg[3]));
          }
        }
        break;


      case "triangular":
        //check the 2nd argument
        if (!arg[1].equals("-hole")) {
          //deal with it
          throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        } else { //check the 3rd args
          try {
            int r = Integer.parseInt(arg[2]);
            int c = Integer.parseInt(arg[3]);
            model = new TriangleSolitaireModelImpl(r, c);
          } catch (NumberFormatException e) {
            System.out.println(String.format("Not a number: %s, %s", arg[2], arg[3]));
          }
        }
        break;


      default:
        throw new IllegalArgumentException("Not a valid constructor name...");
    }

    return model;
  }


  /**
   * Creates the model with 6 input args.
   *
   * @param arg the String[] that represents the inputs.
   * @return the instantiated model.
   */

  private static MarbleSolitaireModel getModel6(String[] arg, MarbleSolitaireModel model) {

    int size = 0;
    int r = 0;
    int c = 0;

    switch (arg[0]) {

      case "english":


        switch (arg[1]) {

          case "-size":

            if (!arg[3].equals("-hole")) {
              throw new IllegalArgumentException(String.format("bad input: %s", arg[3]));
            } else {

              try {
                size = Integer.parseInt(arg[2]);
                r = Integer.parseInt(arg[4]);
                c = Integer.parseInt(arg[5]);

              } catch (NumberFormatException e) {
                System.out.println(String.format("Not numbers: %s,%s,%s", arg[2], arg[4], arg[5]));
              }
              model = new MarbleSolitaireModelImpl(size, r, c);
            }
            break;


          case "-hole":

            if (!arg[4].equals("-size")) {
              throw new IllegalArgumentException(String.format("bad input: %s", arg[4]));
            } else {

              try {
                r = Integer.parseInt(arg[2]);
                c = Integer.parseInt(arg[3]);
                size = Integer.parseInt(arg[5]);

              } catch (NumberFormatException e) {
                System.out.println(String.format("Not numbers: %s,%s,%s", arg[2], arg[3], arg[5]));
              }
              model = new MarbleSolitaireModelImpl(size, r, c);
            }
            break;

          default:
            throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        }
        break;

      case "european":

        switch (arg[1]) {

          case "-size":

            if (!arg[3].equals("-hole")) {
              throw new IllegalArgumentException(String.format("bad input: %s", arg[3]));
            } else {

              try {
                size = Integer.parseInt(arg[2]);
                r = Integer.parseInt(arg[4]);
                c = Integer.parseInt(arg[5]);

              } catch (NumberFormatException e) {
                System.out.println(String.format("Not numbers: %s,%s,%s", arg[2], arg[4], arg[5]));
              }
              model = new EuropeanSolitaireModelImpl(size, r, c);
            }
            break;


          case "-hole":

            if (!arg[4].equals("-size")) {
              throw new IllegalArgumentException(String.format("bad input: %s", arg[4]));
            } else {

              try {
                r = Integer.parseInt(arg[2]);
                c = Integer.parseInt(arg[3]);
                size = Integer.parseInt(arg[5]);

              } catch (NumberFormatException e) {
                System.out.println(String.format("Not numbers: %s,%s,%s", arg[2], arg[3], arg[5]));
              }
              model = new EuropeanSolitaireModelImpl(size, r, c);
            }
            break;

          default:
            throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        }
        break;

      case "triangular":

        switch (arg[1]) {

          case "-size":

            if (!arg[3].equals("-hole")) {
              throw new IllegalArgumentException(String.format("bad input: %s", arg[3]));
            } else {

              try {
                size = Integer.parseInt(arg[2]);
                r = Integer.parseInt(arg[4]);
                c = Integer.parseInt(arg[5]);

              } catch (NumberFormatException e) {
                System.out.println(String.format("Not numbers: %s,%s,%s", arg[2], arg[4], arg[5]));
              }
              model = new TriangleSolitaireModelImpl(size, r, c);
            }
            break;


          case "-hole":

            if (!arg[4].equals("-size")) {
              throw new IllegalArgumentException(String.format("bad input: %s", arg[4]));
            } else {

              try {
                r = Integer.parseInt(arg[2]);
                c = Integer.parseInt(arg[3]);
                size = Integer.parseInt(arg[5]);

              } catch (NumberFormatException e) {
                System.out.println(String.format("Not numbers: %s,%s,%s", arg[2], arg[3], arg[5]));
              }
              model = new TriangleSolitaireModelImpl(size, r, c);
            }
            break;

          default:
            throw new IllegalArgumentException(String.format("bad input: %s", arg[1]));
        }
        break;

      default:
        throw new IllegalArgumentException("Not a valid constructor name...");
    }

    return model;

  }

}
