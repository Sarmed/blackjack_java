package BlackJack.model;

public class Card {

  public enum Color {
    Hearts,
    Spades,
    Diamonds,
    Clubs,
    Count,
    Hidden
  }
  
  public enum Value {
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Ten,
    Knight,
    Queen,
    King,
    Ace,
    Count,
    Hidden
  }
  
  private Color color;
  private Value value;
  private boolean isHidden;
  
  public Card(Color color, Value value) {
    this.value = value;
    this.color = color;
    isHidden = true;
  }
  
  public Color getColor() {
      if (isHidden) {
          return Color.Hidden;
      }
      return color;
  }

  public Value getValue() {
      if (isHidden) {
          return Value.Hidden;
      }
      return value;
  }

  public void show(boolean show) {
      isHidden = !show;
  }
}