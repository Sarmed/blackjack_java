package BlackJack.model;

import java.util.List;
import java.util.LinkedList;

public class Player {

  private List<Card> cardsInHand;
  protected final int maxScore = 21;

  public Player()
  {
    cardsInHand = new LinkedList<>();
  }
  
  public void dealCard(Card newCard)
  {
    cardsInHand.add(newCard);
  }
  
  public Iterable<Card> getHand()
  {
    return cardsInHand;
  }
  
  public void clearHand()
  {
    cardsInHand.clear();
  }
  
  public void showHand()
  {
    for(Card c : getHand())
    {
      c.show(true);
    }
  }
  
  public int calcScore()
  {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int cardScores[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
    };
    assert (cardScores.length == Card.Value.Count.ordinal()) :
            "Card Scores array size does not match number of card values";

    int score = 0;

    for(Card c : getHand()) {
        if (c.getValue() != Card.Value.Hidden)
        {
            score += cardScores[c.getValue().ordinal()];
        }
    }

    if (score > maxScore)
    {
        for(Card c : getHand())
        {
            if (c.getValue() == Card.Value.Ace)
            {
                score -= 10;
            }
        }
    }

    return score;
  }
}
