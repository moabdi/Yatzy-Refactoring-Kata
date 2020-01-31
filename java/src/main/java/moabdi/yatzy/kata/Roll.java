package moabdi.yatzy.kata;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static moabdi.yatzy.kata.Dice.*;
import static java.util.Collections.frequency;
import static java.util.Collections.reverseOrder;

public class Roll {

    private List<Dice> dices;

    public Roll(Dice first, Dice second, Dice third, Dice fourth, Dice fifth) {
        this.dices = Arrays.asList(first, second, third, fourth, fifth);
    }

    public Set<Category> possibleCategories() {
        return Stream.of(Category.values()).filter(category -> category.evaluate(dices)).collect(Collectors.toSet());
    }

    public int getScore(Category category){
        if(!category.evaluate(dices)){
            return 0;
        }

        switch (category){
            case ONES:
                return sumOf(ONE);
            case TWOS:
                return sumOf(TWO);
            case THREES:
                return sumOf(THREE);
            case FOURS:
                return sumOf(FOUR);
            case FIVES:
                return sumOf(FIVE);
            case SIXES:
                return sumOf(SIX);
            case PAIR:
                return sumOfXTimesPair(1);
            case TWO_PAIRS:
                return sumOfXTimesPair(2);
            case THREE_OF_A_KIND:
                return sumDiceXTimes(3);
            case FOUR_OF_A_KIND:
                return sumDiceXTimes(4);
            case SMALL_STRAIGHT:
                return 15;
            case LARGE_STRAIGHT:
                return 20;
            case YATZY:
                return 50;
            default:
                return dices.stream().mapToInt(Dice::getValue).sum();
        }
    }

    private int sumOf(Dice dice) {
        return Math.toIntExact(dices.stream()
            .filter(die -> die == dice)
            .count() * dice.getValue());
    }

    private int sumDiceXTimes(int times) {
        return dices.stream()
            .filter(current -> frequency(dices, current) >= times)
            .findFirst().get().getValue()* times;
    }

    private int sumOfXTimesPair(int times) {
        return
            dices.stream()
                .filter(die -> frequency(dices, die) >= 2)
                .collect(Collectors.toSet())
                .stream()
                .sorted(reverseOrder())
                .limit(times)
                .mapToInt(d -> d.getValue()*2)
                .sum();
    }
}
