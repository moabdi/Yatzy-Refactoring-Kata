package moabdi.yatzy.kata;

import static java.util.Arrays.asList;
import static java.util.Collections.frequency;
import static moabdi.yatzy.kata.Dice.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum Category {

  YATZY(allDiceAreEqual()),
  CHANCE(matchAlways()),
  ONES(contains(ONE)),
  TWOS(contains(TWO)),
  THREES(contains(THREE)),
  FOURS(contains(FOUR)),
  FIVES(contains(FIVE)),
  SIXES(contains(SIX)),
  PAIR(hasXTimesPair(1)),
  TWO_PAIRS(hasXTimesPair(2)),
  THREE_OF_A_KIND(hasXTimes(3)),
  FOUR_OF_A_KIND(hasXTimes(4)),
  FULL_HOUSE(hasFullHouse()),
  SMALL_STRAIGHT(allDiceMatch(asList(ONE, TWO, THREE, FOUR, FIVE))),
  LARGE_STRAIGHT(allDiceMatch(asList(TWO, THREE, FOUR, FIVE, SIX)));

  private Predicate<List<Dice>> rule;

  private Category(Predicate<List<Dice>> rule) {
    this.rule = rule;
  }

  public boolean evaluate(Dice... dice) {
    return evaluate(Arrays.asList(dice));
  }

  public boolean evaluate(List<Dice> dice) {
    return rule.test(dice);
  }

  private static Predicate<List<Dice>> matchAlways() {
    return dice -> true;
  }

  private static Predicate<List<Dice>> contains(Dice die) {
    return dice -> dice.contains(die);
  }

  private static Predicate<List<Dice>> hasXTimes(int times) {
    return dice -> dice.stream().anyMatch(die -> dice.stream().filter(d -> d == die).count() >= times);
  }

  private static Predicate<List<Dice>> allDiceAreEqual() {
    return dice -> dice.stream().allMatch(die -> die == dice.get(0));
  }

  private static Predicate<List<Dice>> hasXTimesPair(int times) {
    return dice -> dice.stream()
        .filter(current -> frequency(dice, current) >= 2)
        .collect(Collectors.toSet()).size()>=times;
  }

  private static Predicate<List<Dice>> hasFullHouse() {
    return dice -> dice.stream()
        .filter(current -> frequency(dice, current) >= 2)
        .collect(Collectors.toSet()).size() == new HashSet<>(dice).size();
  }

  private static Predicate<List<Dice>> allDiceMatch(List<Dice> dices) {
    return dice -> new HashSet<>(dice).size() == dices.size();
  }
}
