package moabdi.yatzy.kata;

import org.junit.Test;

import static moabdi.yatzy.kata.Category.*;
import static moabdi.yatzy.kata.Dice.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CategoryTest {

  @Test
  public void shouldEvaluateContainsReturnTrue() {
    assertTrue(ONES.evaluate(ONE, TWO, THREE, FOUR, FIVE));
    assertTrue(TWOS.evaluate(ONE, TWO, THREE, FOUR, FIVE));
    assertTrue(THREES.evaluate(ONE, TWO, THREE, FOUR, FIVE));
    assertTrue(FOURS.evaluate(ONE, TWO, THREE, FOUR, FIVE));
    assertTrue(FIVES.evaluate(ONE, TWO, THREE, FOUR, FIVE));
    assertTrue(SIXES.evaluate(ONE, TWO, THREE, FOUR, SIX));
  }

  @Test
  public void shouldEvaluateContainsReturnFalse() {
    assertFalse(ONES.evaluate(TWO, THREE, FOUR, FIVE, SIX));
    assertFalse(TWOS.evaluate(ONE, THREE, FOUR, FIVE, SIX));
    assertFalse(THREES.evaluate(ONE, TWO, FOUR, FIVE, SIX));
    assertFalse(FOURS.evaluate(ONE, TWO, THREE, FIVE, SIX));
    assertFalse(FIVES.evaluate(ONE, TWO, THREE, FOUR, SIX));
    assertFalse(SIXES.evaluate(ONE, TWO, THREE, FOUR, FIVE));
  }


  @Test
  public void shouldEvaluateHasXTimesPairReturnTrue() {
    assertTrue(PAIR.evaluate(TWO, TWO, FOUR, FIVE, SIX));
    assertTrue(TWO_PAIRS.evaluate(TWO, TWO, FOUR, FOUR, SIX));
  }

  @Test
  public void shouldEvaluateHasXTimesPairReturnFalse() {
    assertFalse(PAIR.evaluate(ONE, TWO, THREE, FOUR, FIVE));
    assertFalse(TWO_PAIRS.evaluate(ONE, ONE, THREE, FOUR, FIVE));
  }

  @Test
  public void shouldEvaluateHasXTimesReturnTrue() {
    assertTrue(THREE_OF_A_KIND.evaluate(TWO, TWO, TWO, FIVE, SIX));
    assertTrue(FOUR_OF_A_KIND.evaluate(FOUR, FOUR, FOUR, FOUR, SIX));
  }

  @Test
  public void shouldEvaluateHasXTimesReturnFalse() {
    assertFalse(THREE_OF_A_KIND.evaluate(ONE, TWO, THREE, FOUR, FIVE));
    assertFalse(FOUR_OF_A_KIND.evaluate(ONE, ONE, THREE, FOUR, FIVE));
  }

  @Test
  public void shouldEvaluateHasFullHouseReturnTrue() {
    assertTrue(FULL_HOUSE.evaluate(ONE, ONE, ONE, FOUR, FOUR));
  }

  @Test
  public void shouldEvaluateHasFullHouseReturnFalse() {
    assertFalse(FULL_HOUSE.evaluate(ONE, ONE, ONE, ONE, ONE));
  }

  @Test
  public void shouldEvaluateSmallStraightReturnTrue() {
    assertTrue(SMALL_STRAIGHT.evaluate(ONE, TWO, THREE, FOUR, FIVE));
  }

  @Test
  public void shouldEvaluateSmallStraightReturnFalse() {
    assertFalse(SMALL_STRAIGHT.evaluate(ONE, ONE, ONE, TWO, THREE));
  }

  @Test
  public void shouldEvaluateLargeStraightReturnTrue() {
    assertTrue(LARGE_STRAIGHT.evaluate(TWO, THREE, FOUR, FIVE, SIX));
  }

  @Test
  public void shouldEvaluateLargeStraightReturnFalse() {
    assertFalse(LARGE_STRAIGHT.evaluate(ONE, ONE, ONE, TWO, THREE));
  }

  @Test
  public void shouldEvaluateYatzyReturnTrue() {
    assertTrue(YATZY.evaluate(TWO, TWO, TWO, TWO, TWO));
  }

  @Test
  public void shouldEvaluateYatzyReturnFalse() {
    assertFalse(YATZY.evaluate(ONE, ONE, ONE, TWO, THREE));
  }

  @Test
  public void shouldEvaluateChanceReturnTrue() {
    assertTrue(CHANCE.evaluate(ONE, TWO));
  }
}
