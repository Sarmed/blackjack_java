package BlackJack.model;

import BlackJack.model.rules.RulesFactory;

public class Game {

  private Dealer dealer;
  private Player player;

  public Game()
  {
    dealer = new Dealer(new RulesFactory());
    player = new Player();
  }
    
  public boolean isGameOver()
  {
    return dealer.isGameOver();
  }
  
  public boolean isDealerWinner()
  {
    return dealer.isDealerWinner(player);
  }
  
  public boolean newGame()
  {
    return dealer.newGame(player);
  }
  
  public boolean hit()
  {
    return dealer.hit(player);
  }
  
  public boolean stand()
  {
    // TODO: Implement this according to Game Stand sequence diagram
    if(dealer.getDeck() != null) {
      dealer.showHand();
      for(Card c : dealer.getHand()) {
        c.show(true);
      }
      while(dealer.getSoft17Rule().doHit(dealer)) {
        dealer.hit(dealer);
        Card c = dealer.getDeck().getCard();
        c.show(true);
        dealer.dealCard(c);
      }
      return true;
    }
    return false;
  }
  
  public Iterable<Card> getDealerHand()
  {
    return dealer.getHand();
  }
  
  public Iterable<Card> getPlayerHand()
  {
    return player.getHand();
  }
  
  public int getDealerScore()
  {
    return dealer.calcScore();
  }
  
  public int getPlayerScore()
  {
    return player.calcScore();
  }
    
  
}