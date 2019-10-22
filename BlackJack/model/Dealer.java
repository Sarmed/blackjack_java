package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck deck;
  private INewGameStrategy newGameRule;
  private IHitStrategy hitRule;
  private IHitStrategy soft17Rule;

  public Dealer(RulesFactory rulesFactory) {
  
    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    soft17Rule = rulesFactory.getSoft17Rule();
  }
  
  
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameRule.newGame(deck, this, player);
    }
    return false;
  }

  public boolean hit(Player player) {
    if (deck != null && player.calcScore() < maxScore && !isGameOver()) {
      Card c;
      c = deck.getCard();
      c.show(true);
      player.dealCard(c);
      
      return true;
    }
    return false;
  }

  public boolean isDealerWinner(Player player) {
    if (player.calcScore() > maxScore) {
      return true;
    } else if (calcScore() > maxScore) {
      return false;
    }
    return calcScore() >= player.calcScore();
  }

  public boolean isGameOver() {
    if (deck != null && hitRule.doHit(this) != true) {
        return true;
    }
    return false;
  }

  public Deck getDeck() {
    return deck;
  }
  public IHitStrategy getHitRule() {
    return hitRule;
  }
  public IHitStrategy getSoft17Rule() {
    return soft17Rule;
  }
  
}