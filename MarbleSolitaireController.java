package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface represents the controller used to "run" a game of Marble Solitaire.
 * Uses an instance of (@code MarbleSolitaireModel).
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire using the given model.
   * @param model An instance of (@code MarbleSolitaireModel), represents the model of the game.
   * @throws IllegalArgumentException if the given model is (@code null).
   * @throws IllegalStateException if this controller is unable to receive input or transmit output.
   */
  void playGame(MarbleSolitaireModel model);
}
