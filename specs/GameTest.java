import static org.junit.Assert.*;
import org.junit.*;
import players.*;
import cards.*;
import game.*;

public class GameTest {


  User player1;
  Dealer player2;
  Card card1;
  Card card2;
  Card card3;
  Card card4;
  Game game;

  @Before
  public void before(){
    player1 = new User();
    player2 = new Dealer();
    card1 = new Card(SuitType.DIAMONDS, RankType.THREE);
    card2 = new Card(SuitType.HEARTS, RankType.KING);
    card3 = new Card(SuitType.CLUBS, RankType.QUEEN);
    card4 = new Card(SuitType.SPADES, RankType.SEVEN);
    game = new Game();
  }

  @Test
  public void deckStartsEmpty(){
    assertEquals(0, game.deckSize());
  }

  @Test
  public void canAddCardToDeck(){
    game.addToDeck(card1);
    assertEquals(1, game.deckSize());
  }

  @Test
  public void canClearDeck(){
    game.addToDeck(card1);
    game.clearDeck();
    assertEquals(0, game.deckSize());
  }

  @Test 
  public void canRemoveCardPile() {
    game.addToDeck(card1);
    game.removeFromDeck();
    assertEquals(0, game.deckSize());
  }

  @Test
  public void returnsCardOnRemoval() {
    game.addToDeck(card1);
    Card card = game.removeFromDeck();
    assertEquals(SuitType.DIAMONDS, card.getSuit());
  }

  @Test
  public void canDealCardToPlayer() {
    game.addToDeck(card1);
    game.dealCard(player1);
    assertEquals(1, player1.handCount());
    assertEquals(0, game.deckSize());
  }

  @Test
  public void canMoveCardBetweenPLayers(){
    player1.handAdd(card1);
    game.moveCardBetweenPlayers(player1, player2, card1);
    assertEquals(0, player1.handCount());
    assertEquals(1, player2.handCount());
  }

  @Test
  public void deckCanPopulate(){
    game.clearDeck();
    game.fullDeck();
    assertEquals(52, game.deckSize());
  }

  @Test
  public void canDealOutCards(){
    game.clearDeck();
    game.fullDeck();
    game.addToPlayers(player1);
    game.addToPlayers(player2);
    game.dealOut();
    assertEquals(2, player1.handCount());
    assertEquals(2, player2.handCount());
  }

}