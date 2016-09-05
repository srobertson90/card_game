package players;
import cards.*;
import java.util.*;

public abstract class Player {

  String name;
  ArrayList<Card> hand;

  public Player(){
    this.hand = new ArrayList<Card>();
  }

  public int handCount() {
    return hand.size();
  }

  public void handAdd(Card card) {
    hand.add(card);
  }

  public void handClear() {
    hand.clear();
  }

  public int handValue() {
    int total = 0;
    for (Card card : hand){
      total += card.getValue();
    }
    return total;
  }

  public Card handRemove(Card card) {
    if (hand.remove(card)) {
      return card;
    }
    return null;
  }

  public Card handRemoveAtZero() {
    Card card = hand.remove(0);
    return null;
  }

  public Card firstCard() {
    return hand.get(0);
  }

}