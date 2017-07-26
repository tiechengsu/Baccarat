package dummy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.baccarat.Deck;

public class DeckgetRandomTest {

	@Test
	public void testGetSize_AftergetCard() {
		Deck deck = new Deck();
		deck.getCard();
		assertEquals(51, deck.getSize());
	}

}
