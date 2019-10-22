package BlackJack.model;

import java.util.List;
import java.util.LinkedList;

public class Deck {

  private List<Card> cards;
  
  public Deck() {
    cards = new LinkedList<>();
  
    for(int i = 0; i < Card.Color.Count.ordinal(); i++) {
      for (int j = 0; j < Card.Value.Count.ordinal(); j++) {
        Card c = new Card(Card.Color.values()[i], Card.Value.values()[j]);
        addCard(c);
      }
    }
    
    shuffle();
  }
  
  
  public void addCard(Card newCard) {
    cards.add(newCard);
  }
  
  public Card getCard() {
    Card c = cards.get(0);
    cards.remove(0);
    
    return c;
  }
  
  public Iterable<Card> getCards()
  {
      return cards;
  }
  
  private void shuffle()
  {
      for (int i = 0; i < 1017; i++)
      {
          int index = (int)(Math.random() * 171717.0) % cards.size();
          Card c = cards.get(index);
          cards.remove(index);
          addCard(c);
      }
  }
  
}