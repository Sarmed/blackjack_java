package BlackJack.model.rules;

import BlackJack.model.Player;

public class Soft17Strategy implements IHitStrategy{

    private final int hitLimit = 18;

    @Override
    public boolean doHit(Player dealer) {
        return dealer.calcScore() < hitLimit;
    }
}
