package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface INewGameStrategy {
    boolean newGame(Deck deck, Dealer dealer, Player player);
}