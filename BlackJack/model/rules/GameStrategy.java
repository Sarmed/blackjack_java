package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;

public abstract class GameStrategy implements INewGameStrategy{

    private int dealingLimit;

    @Override
    public boolean newGame(Deck deck, Dealer dealer, Player player) {
        if(this instanceof AmericanNewGameStrategy)
            dealingLimit = 4;
        if(this instanceof InternationalNewGameStrategy)
            dealingLimit = 3;

        dealCards(deck,dealer,player);
        return true;
    }

    private void dealCards(Deck deck, Dealer dealer, Player player) {
        Card c;
        for(int i = 0; i < dealingLimit; i++) {
            if(i % 2 == 0) {
                c = deck.getCard();
                c.show(true);
                player.dealCard(c);
            }else {
                c = deck.getCard();
                if(i == 3)
                    c.show(false);
                else
                    c.show(true);
                dealer.dealCard(c);
            }
        }
    }
}
