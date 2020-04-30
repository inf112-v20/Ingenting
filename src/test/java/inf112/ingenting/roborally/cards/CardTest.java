package inf112.ingenting.roborally.cards;

import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void addTwoCardsWithUniquePriority(){
        ProgrammingCard card1 = new ProgrammingCard();
        ProgrammingCard card2 = new ProgrammingCard();
        Assert.assertNotEquals(card1.getPriority(), card2.getPriority());
    }


    @Test
    public void addCardToMoveThreeForward(){
        ProgrammingCard card = new ProgrammingCard(ProgrammingCardType.MOVE_3);
        Assert.assertEquals(ProgrammingCardType.MOVE_3, card.getCardType());
    }

    @Test
    public void updatePriorityTo100And50OfRandomCard(){
        ProgrammingCard card = new ProgrammingCard();
        card.setPriority(100);
        Assert.assertEquals(card.getPriority(), 100);
        card.setPriority(50);
        Assert.assertEquals(card.getPriority(), 50);
    }

}
