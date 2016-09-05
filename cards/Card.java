package cards; 

public class Card {

  SuitType suit;
  RankType rank;

  public Card(SuitType suit, RankType rank){
    this.suit = suit;
    this.rank = rank;
  }

  public SuitType getSuit(){
    return this.suit;
  }

  public RankType getRank(){
    return this.rank;
  }

  public int getValue() {
    return rank.getValue();
  }

}