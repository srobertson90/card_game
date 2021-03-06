import static org.junit.Assert.*;
import org.junit.*;
import players.*;
import cards.*;

public class PlayerTest {

  User user;
  Card card;
  Card card2;

  @Before
  public void before(){
    user = new User();
    card = new Card(SuitType.DIAMONDS, RankType.THREE);
    card2 = new Card(SuitType.SPADES, RankType.FOUR);
  }

  @Test
  public void startsWithEmptyHand() {
    assertEquals(0, user.handCount());
  }

  @Test
  public void canAddCardtoHand() {
    user.handAdd(card);
    assertEquals(1, user.handCount());
  }

  @Test
  public void canGetHandValueWithOneCard(){
    user.handAdd(card);
    assertEquals(3, user.handValue());
  }

  @Test
  public void canGetHandValueWithTwoCards(){
    user.handAdd(card);
    user.handAdd(card2);
    assertEquals(7, user.handValue());
  }

  @Test
  public void clearHand() {
    user.handAdd(card);
    assertEquals(1, user.handCount());
    user.handClear();
    assertEquals(0, user.handCount());
  }

  @Test
  public void canRemoveCardfromHand(){
    user.handAdd(card);
    assertEquals(1, user.handCount());
    user.handRemove(card);
    assertEquals(0, user.handCount());
  }

  @Test
  public void canRemoveCardfromHandBAtZero(){
    user.handAdd(card);
    user.handRemoveAtZero();
    assertEquals(0, user.handCount());
  }

  @Test
  public void canReturnCardOnRemove(){
    user.handAdd(card);
    Card returnedCard = user.handRemove(card);
    assertEquals(SuitType.DIAMONDS, returnedCard.getSuit());
  }

  @Test
  public void canReturnCardOnRemove2(){
    user.handAdd(card);
    Card returnedCard = user.firstCard();
    assertEquals(SuitType.DIAMONDS, returnedCard.getSuit());
  }



}