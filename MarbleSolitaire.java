package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw02.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw02.TriangleSolitaireModelImpl;

import java.io.InputStreamReader;

public final class MarbleSolitaire {
    public static void main(String[] args) {
        MarbleSolitaireModel msm = new MarbleSolitaireModelImpl(3);
        MarbleSolitaireModel esm = new EuropeanSolitaireModelImpl(5, 2, 3);
        MarbleSolitaireModel tsm = new TriangleSolitaireModelImpl(9, 6, 4);

        Readable rd = new InputStreamReader(System.in);

        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(rd, System.out);

        controller.playGame(tsm);
    }
}
