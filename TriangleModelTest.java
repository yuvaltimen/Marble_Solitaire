import cs3500.marblesolitaire.MarbleSolitaire;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.TriangleSolitaireModelImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing class for TriangleMarbleSolitaireImpl.
 */
public class TriangleModelTest {


    /**
     * Test for default constructor.
     */

    @Test
    public void testConstructor1() {

        MarbleSolitaireModel model = new TriangleSolitaireModelImpl();
        String exp = "    _\n"
                + "   O O\n"
                + "  O O O\n"
                + " O O O O\n"
                + "O O O O O";
        assertEquals(exp, model.getGameState());
    }

    /**
     * Test for 1 argument constructor.
     */

    @Test
    public void testConstructor2() {

        MarbleSolitaireModel m3 = new TriangleSolitaireModelImpl(3);
        MarbleSolitaireModel m4 = new TriangleSolitaireModelImpl(4);
        MarbleSolitaireModel m5 = new TriangleSolitaireModelImpl(5);
        MarbleSolitaireModel m9 = new TriangleSolitaireModelImpl(9);

        String exp3 = "  _\n"
                + " O O\n"
                + "O O O";
        String exp4 = "   _\n"
                + "  O O\n"
                + " O O O\n"
                + "O O O O";
        String exp5 = "    _\n"
                + "   O O\n"
                + "  O O O\n"
                + " O O O O\n"
                + "O O O O O";
        String exp9 = "        _\n"
                + "       O O\n"
                + "      O O O\n"
                + "     O O O O\n"
                + "    O O O O O\n"
                + "   O O O O O O\n"
                + "  O O O O O O O\n"
                + " O O O O O O O O\n"
                + "O O O O O O O O O";

        assertEquals(exp3, m3.getGameState());
        assertEquals(exp4, m4.getGameState());
        assertEquals(exp5, m5.getGameState());
        assertEquals(exp9, m9.getGameState());
    }

    /**
     * Test for 2 argument constructor.
     */

    @Test
    public void testConstructor3() {

        MarbleSolitaireModel m10 = new TriangleSolitaireModelImpl(1, 0);
        MarbleSolitaireModel m22 = new TriangleSolitaireModelImpl(2, 2);
        MarbleSolitaireModel m31 = new TriangleSolitaireModelImpl(3, 1);
        MarbleSolitaireModel m44 = new TriangleSolitaireModelImpl(4, 4);

        String exp10 = "    O\n"
                + "   _ O\n"
                + "  O O O\n"
                + " O O O O\n"
                + "O O O O O";

        String exp22 = "    O\n"
                + "   O O\n"
                + "  O O _\n"
                + " O O O O\n"
                + "O O O O O";

        String exp31 = "    O\n"
                + "   O O\n"
                + "  O O O\n"
                + " O _ O O\n"
                + "O O O O O";

        String exp44 = "    O\n"
                + "   O O\n"
                + "  O O O\n"
                + " O O O O\n"
                + "O O O O _";


        assertEquals(exp10, m10.getGameState());
        assertEquals(exp22, m22.getGameState());
        assertEquals(exp31, m31.getGameState());
        assertEquals(exp44, m44.getGameState());
    }


    /**
     * Tests for the 4th constructor.
     */

    @Test
    public void testConstructor4Triangle() {

        MarbleSolitaireModel m3 = new TriangleSolitaireModelImpl(3, 2, 1);
        MarbleSolitaireModel m4 = new TriangleSolitaireModelImpl(4, 2, 2);
        MarbleSolitaireModel m5 = new TriangleSolitaireModelImpl(5, 2, 1);
        MarbleSolitaireModel m9 = new TriangleSolitaireModelImpl(9, 6, 4);

        String exp3 = "  O\n"
                + " O O\n"
                + "O _ O";

        String exp4 = "   O\n"
                + "  O O\n"
                + " O O _\n"
                + "O O O O";

        String exp5 = "    O\n"
                + "   O O\n"
                + "  O _ O\n"
                + " O O O O\n"
                + "O O O O O";

        String exp9 = "        O\n"
                + "       O O\n"
                + "      O O O\n"
                + "     O O O O\n"
                + "    O O O O O\n"
                + "   O O O O O O\n"
                + "  O O O O _ O O\n"
                + " O O O O O O O O\n"
                + "O O O O O O O O O";

        assertEquals(exp3, m3.getGameState());
        assertEquals(exp4, m4.getGameState());
        assertEquals(exp5, m5.getGameState());
        assertEquals(exp9, m9.getGameState());

    }

    /**
     * Tests for Exceptions: Constructor 2.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSideLength1() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSideLength2() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSideLength3() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(2);
    }

    /**
     * Tests for Exceptions: Constructor 3.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosn1() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(5, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosn2() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(-1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosn3() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(3, -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosn4() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(7, 3);
    }

    /**
     * Tests for Exceptions: Constructor 4.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosn() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(9, 0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosn_1() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(9, 3, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosn_2() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(9, -2, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosn_3() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(9, 12, 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosnAndSideLength() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(0, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosnAndSideLength2() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(-3, 4, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosnAndSideLength3() {
        MarbleSolitaireModel inv = new TriangleSolitaireModelImpl(2, 1, 0);
    }


    /**
     * Test for getGameState().
     */

    @Test
    public void testGetGameState() {
        MarbleSolitaireModel m3 = new TriangleSolitaireModelImpl(3, 2, 1);
        MarbleSolitaireModel m4 = new TriangleSolitaireModelImpl(4, 2, 2);
        MarbleSolitaireModel m5 = new TriangleSolitaireModelImpl(5, 2, 1);
        MarbleSolitaireModel m9 = new TriangleSolitaireModelImpl(9, 6, 4);

        String exp3 = "  O\n"
                + " O O\n"
                + "O _ O";

        String exp4 = "   O\n"
                + "  O O\n"
                + " O O _\n"
                + "O O O O";

        String exp5 = "    O\n"
                + "   O O\n"
                + "  O _ O\n"
                + " O O O O\n"
                + "O O O O O";

        String exp9 = "        O\n"
                + "       O O\n"
                + "      O O O\n"
                + "     O O O O\n"
                + "    O O O O O\n"
                + "   O O O O O O\n"
                + "  O O O O _ O O\n"
                + " O O O O O O O O\n"
                + "O O O O O O O O O";

        assertEquals(exp3, m3.getGameState());
        assertEquals(exp4, m4.getGameState());
        assertEquals(exp5, m5.getGameState());
        assertEquals(exp9, m9.getGameState());
    }

    /**
     * Test for getScore().
     */

    @Test
    public void testGetScore() {
        MarbleSolitaireModel md6 = new TriangleSolitaireModelImpl(6);
        MarbleSolitaireModel md3 = new TriangleSolitaireModelImpl(3);
        MarbleSolitaireModel md33 = new TriangleSolitaireModelImpl(33);
        MarbleSolitaireModel m4 = new TriangleSolitaireModelImpl(4);

        m4.move(2, 2, 0, 0);
        m4.move(3, 1, 1, 1);
        m4.move(3, 3, 3, 1);

        assertEquals(20, md6.getScore());
        assertEquals(5, md3.getScore());
        assertEquals(560, md33.getScore());
        assertEquals(6, m4.getScore());
    }

    /**
     * Test for move().
     */

    @Test
    public void testMove() {
        MarbleSolitaireModel model = new TriangleSolitaireModelImpl(9, 6, 4);

        String exp1 ="        O\n"
                +    "       O O\n"
                +    "      O O O\n"
                +    "     O O O O\n"
                +    "    O O O O O\n"
                +    "   O O O O O O\n"
                +    "  O O O O _ O O\n"
                +    " O O O O O O O O\n"
                +    "O O O O O O O O O";

        String exp2 = "        O\n"
                +     "       O O\n"
                +     "      O O O\n"
                +     "     O O O O\n"
                +     "    O O _ O O\n"
                +     "   O O O _ O O\n"
                +     "  O O O O O O O\n"
                +     " O O O O O O O O\n"
                +     "O O O O O O O O O";

        String exp3 = "        O\n"
                + "       O O\n"
                + "      O O O\n"
                + "     O O O O\n"
                + "    O O _ O O\n"
                + "   O O O O _ _\n"
                + "  O O O O O O O\n"
                + " O O O O O O O O\n"
                + "O O O O O O O O O";

        String exp4 = "        O\n"
                + "       O O\n"
                + "      O O O\n"
                + "     O O O O\n"
                + "    O O _ O O\n"
                + "   O O O O O _\n"
                + "  O O O O _ O O\n"
                + " O O O O _ O O O\n"
                + "O O O O O O O O O";

        String exp5 = "        O\n"
                + "       O O\n"
                + "      O O O\n"
                + "     O O O O\n"
                + "    O O _ O O\n"
                + "   O O O O O _\n"
                + "  O O _ _ O O O\n"
                + " O O O O _ O O O\n"
                + "O O O O O O O O O";

        String exp6 = "        O\n"
                + "       O O\n"
                + "      O O O\n"
                + "     O O O O\n"
                + "    O O O O O\n"
                + "   O O O _ O _\n"
                + "  O O _ _ _ O O\n"
                + " O O O O _ O O O\n"
                + "O O O O O O O O O";

        String exp7 = "        O\n"
                + "       O O\n"
                + "      O O O\n"
                + "     O O O _\n"
                + "    O O O _ O\n"
                + "   O O O O O _\n"
                + "  O O _ _ _ O O\n"
                + " O O O O _ O O O\n"
                + "O O O O O O O O O";

        assertEquals(exp1, model.getGameState());

        model.move(4, 2, 6, 4);
        assertEquals(exp2, model.getGameState());

        model.move(5, 5, 5, 3);
        assertEquals(exp3, model.getGameState());

        model.move(7, 4, 5, 4);
        assertEquals(exp4, model.getGameState());

        model.move(6, 2, 6, 4);
        assertEquals(exp5, model.getGameState());

        model.move(6, 4, 4, 2);
        assertEquals(exp6, model.getGameState());

        model.move(3, 3, 5, 3);
        assertEquals(exp7, model.getGameState());
    }

    /**
     * Test for isGameOver().
     */

    @Test
    public void testIsGameOver() {
        MarbleSolitaireModel model = new TriangleSolitaireModelImpl(3);

        assertEquals(false, model.isGameOver());

        model.move(2, 2, 0,0);

        assertEquals(false, model.isGameOver());

        model.move(2, 0, 2, 2);

        assertEquals(false, model.isGameOver());

        model.move(0, 0, 2, 0);

        assertEquals(true, model.isGameOver());
    }
}
