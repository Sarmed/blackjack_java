package BlackJack.model.rules;

import BlackJack.model.Player;

class BasicHitStrategy implements IHitStrategy {
    private final int hitLimit = 17;

    public boolean doHit(Player dealer) {
      return dealer.calcScore() < hitLimit;
    }
}