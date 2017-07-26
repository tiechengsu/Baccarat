package dummy;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.baccarat.Deck;

public class DeckgetSizeTest {

	@Test
	public void testGetSize() {
		Deck deck = new Deck();
		int size = deck.getSize();
		assertEquals(52, size);
	}

}
