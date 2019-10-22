package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy getHitRule() {
    return new BasicHitStrategy();
  }
  public IHitStrategy getSoft17Rule() { return new Soft17Strategy();}
  public INewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}