
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/**
 * Testing class for (@code MarbleSolitaireModelImpl)
 */
public class MarbleSolitaireImplTest {
  /**
   * Test the constructor that takes in no parameters. Produces board of arm length 3. The empty
   * slot is in the center.
   */

  @Test
  public void testConstructorNoParameters() {
    MarbleSolitaireModel noParams = new MarbleSolitaireModelImpl();
    String stdGameState = "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O";
    assertEquals(stdGameState, noParams.getGameState());
  }

  /**
   * Test the constructor that takes in (sRow, sCol). Produces board of arm length 3. The empty slot
   * is at position (sRow, sCol).
   */

  @Test
  public void testConstructorPosition1() {
    MarbleSolitaireModel pos1 = new MarbleSolitaireModelImpl(0, 2);
    String pos1GameState = "    _ O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O";
    assertEquals(pos1GameState, pos1.getGameState());
  }

  @Test
  public void testConstructorPosition2() {
    MarbleSolitaireModel std = new MarbleSolitaireModelImpl();
    MarbleSolitaireModel std2 = new MarbleSolitaireModelImpl(3, 3);
    assertEquals(std.getGameState(), std2.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition1() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition2() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionNegative() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(-1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionExceedsMax() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(8, 8);
  }

  /**
   * Test the constructor that takes in an arm length. Arm length must be positive odd number. The
   * empty slot is in the center.
   */

  @Test
  public void testConstructorArmLength2() {
    MarbleSolitaireModel threeByThree = new MarbleSolitaireModelImpl(3);
    MarbleSolitaireModel std = new MarbleSolitaireModelImpl();
    assertEquals(std.getGameState(), threeByThree.getGameState());
  }

  @Test
  public void testConstructorArmLength3() {
    MarbleSolitaireModel fiveByFive = new MarbleSolitaireModelImpl(5);
    String fiveByFiveGameState = "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O";
    assertEquals(fiveByFiveGameState, fiveByFive.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthOneByOne() {
    MarbleSolitaireModel oneByOne = new MarbleSolitaireModelImpl(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthEven() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthZero() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthNegativeOdd() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthNegativeEven() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(-8);
  }

  /**
   * Test the constructor that takes in an arm length and a position. The arm length must be a
   * positive odd number. The empty slot is given by (sRow, sCol).
   */

  @Test
  public void testConstructorArmLengthAndPosition1() {
    MarbleSolitaireModel std = new MarbleSolitaireModelImpl();
    MarbleSolitaireModel armPos1 = new MarbleSolitaireModelImpl(3, 3, 3);
    assertEquals(std.getGameState(), armPos1.getGameState());
  }

  @Test
  public void testConstructorArmLengthAndPosition2() {
    MarbleSolitaireModel armPos = new MarbleSolitaireModelImpl(3, 0, 2);
    String armPosGameState = "    _ O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O";
    assertEquals(armPosGameState, armPos.getGameState());
  }

  @Test
  public void testConstructorArmLengthAndPosition3() {
    MarbleSolitaireModel armPos = new MarbleSolitaireModelImpl(5, 5, 4);
    String armPosGameState = "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O";
    assertEquals(armPosGameState, armPos.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthValidPosition1() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthValidPosition2() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthValidPosition3() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(-5, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidArmLengthInvalidPosition1() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(3, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidArmLengthInvalidPosition2() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(3, 10, 11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidArmLengthInvalidPosition3() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(5, -1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmLengthInvalidPosition() {
    MarbleSolitaireModel inv = new MarbleSolitaireModelImpl(6, -3, 100);
  }

  /**
   * Tests for getGameState(). Only legal characters are (' ', 'O' or '_'). No spaces after last
   * slot in each row. One space between each position. No newline character at end of last row.
   */

  @Test
  public void testGetGameState1() {
    MarbleSolitaireModel std = new MarbleSolitaireModelImpl();
    String stdGameState = "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O";
    assertEquals(stdGameState, std.getGameState());
  }

  @Test
  public void testGetGameState2() {
    MarbleSolitaireModel fiveByFive = new MarbleSolitaireModelImpl(5, 3, 4);
    String fiveByFiveGameState = "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        _ O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O";
    assertEquals(fiveByFiveGameState, fiveByFive.getGameState());
  }

  @Test
  public void testLegalGameStateCharacters() {
    MarbleSolitaireModel sevenBySeven = new MarbleSolitaireModelImpl(7, 6, 5);
    String sevenBySevenGameState = sevenBySeven.getGameState();
    boolean allLegalCharacters = true;
    for (Character ch : sevenBySevenGameState.toCharArray()) {
      allLegalCharacters &= (ch == ' ' || ch == 'O' || ch == '_' || ch == '\n');
    }
    assertEquals(true, allLegalCharacters);
  }

  /**
   * Tests for move(): (a) the “from” and “to” positions are valid (b) there is a marble at the
   * specified “from” position (c) the “to” position is empty (d) the “to” and “from” positions are
   * exactly two positions away (horizontally or vertically) (e) there is a marble in the slot
   * between the “to” and “from” positions.
   */

  @Test
  public void testMoveOnce() {
    MarbleSolitaireModel std = new MarbleSolitaireModelImpl();
    std.move(1, 3, 3, 3);
    String movedGameState = "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O";
    assertEquals(movedGameState, std.getGameState());
  }

  @Test
  public void testMoveBunchaTimes() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl(5, 3, 4);
    game.move(3, 6, 3, 4);
    game.move(1, 5, 3, 5);
    game.move(5, 6, 3, 6);
    game.move(2, 6, 4, 6);
    String gameState = "        O O O O O\n"
            + "        O _ O O O\n"
            + "        O _ _ O O\n"
            + "        O O _ O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O";
    assertEquals(gameState, game.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalidFromPosition1() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl(3, 0, 2);
    game.move(0, 0, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalidFromPosition2() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(7, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalidToPosition1() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(2, 0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalidToPosition2() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(5, 3, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveNoMarbleAtFrom1() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(3, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveNoMarbleAtFrom2() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(1, 3, 3, 3);
    game.move(2, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToPositionOccupied() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(2, 3, 2, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveDistanceToFromGreaterThan2() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(0, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveDistanceToFromLessThan2() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(2, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveNoMarbleBetweenMovedPiece() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(1, 3, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(5, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToSelf() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(1, 3, 1, 3);
  }

  /**
   * Tests for isGameOver.
   */

  @Test
  public void testIsGameOverBeginning() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    assertEquals(false, game.isGameOver());
  }

  @Test
  public void testIsGameOverMiddle() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(1, 3, 3, 3);
    game.move(2, 5, 2, 3);
    assertEquals(false, game.isGameOver());
  }

  @Test
  public void testIsGameOverEnd() {
    MarbleSolitaireModel game = new MarbleSolitaireModelImpl();
    game.move(1, 3, 3, 3);
    game.move(2, 5, 2, 3);
    game.move(0, 4, 2, 4);
    game.move(0, 2, 0, 4);
    game.move(2, 2, 0, 2);
    game.move(3, 3, 1, 3);
    game.move(3, 5, 3, 3);
    game.move(4, 2, 2, 2);
    game.move(3, 0, 3, 2);
    game.move(2, 2, 4, 2);
    game.move(5, 2, 3, 2);
    game.move(3, 3, 3, 1);
    game.move(4, 0, 4, 2);
    game.move(2, 1, 4, 1);
    game.move(4, 2, 4, 0);
    game.move(4, 4, 4, 2);
    game.move(6, 4, 4, 4);
    game.move(6, 2, 6, 4);
    game.move(4, 5, 4, 3);
    game.move(5, 3, 3, 3);

    assertEquals(true, game.isGameOver());
  }

  /**
   * Tests for getScore.
   */

  @Test
  public void testGetScoreInitial() {
    MarbleSolitaireModel std = new MarbleSolitaireModelImpl();
    assertEquals(32, std.getScore());
  }

  @Test
  public void testGetScoreAfterMove() {
    MarbleSolitaireModel std = new MarbleSolitaireModelImpl();
    std.move(1, 3, 3, 3);
    assertEquals(31, std.getScore());
  }

  @Test
  public void testGetScoreFiveByFive() {
    MarbleSolitaireModel fiveByFive = new MarbleSolitaireModelImpl(5);
    assertEquals(104, fiveByFive.getScore());
  }
}
