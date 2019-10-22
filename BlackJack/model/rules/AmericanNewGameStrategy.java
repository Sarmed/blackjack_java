package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy extends GameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    return super.newGame(deck,dealer,player);
  }
}