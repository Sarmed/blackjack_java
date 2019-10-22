package BlackJack.view;

import BlackJack.model.Card;

public class SimpleView implements IView 
{

  public void displayWelcomeMessage()
        {
          for(int i = 0; i < 10; i++) {System.out.print("\n");};
          System.out.println("Hello Black Jack World");
          System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        }

        public int getInput()
        {
          try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
              c = System.in.read();
            }
            return c;
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
          }
        }

        public void displayCard(Card card)
        {
            System.out.println("" + card.getValue() + " of " + card.getColor());
        }

        public void displayPlayerHand(Iterable<Card> hand, int score)
        {
            displayHand("Player", hand, score);
        }

        public void displayDealerHand(Iterable<Card> hand, int score)
        {
            displayHand("Dealer", hand, score);
        }

        private void displayHand(String name, Iterable<Card> hand, int score)
        {
            System.out.println(name + " Has: ");
            for(Card c : hand)
            {
                displayCard(c);
            }
            System.out.println("Score: " + score);
            System.out.println("");
        }

        public void displayGameOver(boolean dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }
    }
