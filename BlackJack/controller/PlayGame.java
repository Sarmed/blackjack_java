package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame {

  public boolean play(Game game, IView view) {
    view.displayWelcomeMessage();
    
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver())
    {
        view.displayGameOver(game.isDealerWinner());
    }

    int input = view.getInput();
    
    if (input == 'p')
    {
        game.newGame();
    }
    else if (input == 'h')
    {
        game.hit();
    }
    else if (input == 's')
    {
        game.stand();
    }

    return input != 'q';
  }
}