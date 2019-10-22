package BlackJack.view;

import BlackJack.model.Card;

public interface IView
{
  void displayWelcomeMessage();
  int getInput();
  void displayCard(Card c);
  void displayPlayerHand(Iterable<Card> hand, int score);
  void displayDealerHand(Iterable<Card> hand, int score);
  void displayGameOver(boolean dealerIsWinner);
}