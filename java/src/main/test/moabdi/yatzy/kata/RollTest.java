package moabdi.yatzy.kata;

import static moabdi.yatzy.kata.Category.*;
import static moabdi.yatzy.kata.Dice.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RollTest {


    @Test
    public void shouldPossibleCategoriesReturnValidItems() {
        assertThat(new Roll(ONE, ONE, ONE, FOUR, FOUR).possibleCategories(),
                hasItems(CHANCE, FULL_HOUSE, ONES, PAIR, FOURS, TWO_PAIRS));
    }

    @Test
    public void shouldChanceReturn14(){
        assertEquals(14, new Roll(ONE,ONE,THREE,THREE,SIX).getScore(CHANCE));
    }

    @Test
    public void shouldYatzyReturn50(){
        assertEquals(50, new Roll(ONE,ONE,ONE,ONE,ONE).getScore(YATZY));
    }

    @Test
    public void shouldOnesReturn2(){
        assertEquals(2, new Roll(ONE,ONE,THREE,THREE,THREE).getScore(ONES));
    }

    @Test
    public void shouldTwosReturn4(){
        assertEquals(4, new Roll(TWO,TWO,THREE,THREE,THREE).getScore(TWOS));
    }

    @Test
    public void shouldThreesReturn6(){
        assertEquals(6, new Roll(TWO,TWO,THREE,THREE,FOUR).getScore(THREES));
    }

    @Test
    public void shouldFoursReturn8(){
        assertEquals(8, new Roll(TWO,TWO,THREE,FOUR,FOUR).getScore(FOURS));
    }

    @Test
    public void shouldFivesReturn10(){
        assertEquals(10, new Roll(TWO,TWO,THREE,FIVE,FIVE).getScore(FIVES));
    }

    @Test
    public void shouldSixesReturn12(){
        assertEquals(12, new Roll(TWO,TWO,SIX,SIX,FIVE).getScore(SIXES));
    }

    @Test
    public void shouldPairReturn8(){
        assertEquals(8, new Roll(ONE,ONE,FOUR,FOUR,FIVE).getScore(PAIR));
    }

    @Test
    public void shouldTwoPairsReturn6(){
        assertEquals(6, new Roll(ONE,ONE,TWO,TWO,TWO).getScore(TWO_PAIRS));
    }

    @Test
    public void shouldThreeOfKindReturn9(){
        assertEquals(9, new Roll(THREE,THREE,THREE,FOUR,FIVE).getScore(THREE_OF_A_KIND));
    }

    @Test
    public void shouldFourOfKindReturn8(){
        assertEquals(8, new Roll(TWO,TWO,TWO,TWO,TWO).getScore(FOUR_OF_A_KIND));
    }

    @Test
    public void shouldSmallStraightReturn15(){
        assertEquals(15, new Roll(ONE, TWO, THREE, FOUR, FIVE).getScore(SMALL_STRAIGHT));
    }

    @Test
    public void shouldLargeStraightReturn20(){
        assertEquals(20, new Roll(TWO, THREE, FOUR, FIVE, SIX).getScore(LARGE_STRAIGHT));
    }

    @Test
    public void shouldFullHouseReturn8(){
        assertEquals(8, new Roll(ONE, ONE, TWO, TWO, TWO).getScore(FULL_HOUSE));
    }
}
