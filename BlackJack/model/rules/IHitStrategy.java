package BlackJack.model.rules;


/*
* Design and implement a new rule variant for when the dealer should
*  take one more card. The new variant is “Soft 17″, use the same
*  design pattern already present for Hit. Soft 17 means that the
*  dealer has 17 but in a combination of Ace and 6 (for example Ace,
*  two, two, two). This means that the Dealer can get another card
* valued at 10 but still have 17 as the value of the ace is reduced
* to 1. Using the soft 17 rule the dealer should take another card
*  (compared to the original rule when the dealer only takes cards
*  on a score of 16 or lower).
* */
import BlackJack.model.Player;

public interface IHitStrategy {
    boolean doHit(Player dealer);
}