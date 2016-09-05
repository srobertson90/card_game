package game;
import cards.*;
import java.util.*;
import players.*;

public class Game {

  ArrayList<Player> players;
  ArrayList<Card> deck;

  public Game(){
    this.players = new ArrayList<Player>();
    this.deck = new ArrayList<Card>();
  }

  public int deckSize(){
    return deck.size();
  }

  public void addToDeck(Card card){
    deck.add(card);
  }

  public void fullDeck(){
    for(SuitType suit : SuitType.values()){
      for(RankType rank : RankType.values()){
        deck.add(new Card(suit, rank));
      }
    }
  }

  public void shuffleDeck() {
    Collections.shuffle(this.deck); 
  }

  public void clearDeck(){
    deck.clear();
  }

  public Card removeFromDeck(){
    if (deck.get(0) != null) {
      Card card = deck.remove(0);
      return card;
    }
    return null;
  }

  public void dealCard(Player player){
    Card card = removeFromDeck();
    player.handAdd(card);
  }

  public void moveCardBetweenPlayers(Player player1, Player player2, Card card){
    player1.handRemove(card);
    player2.handAdd(card);
  }

}
