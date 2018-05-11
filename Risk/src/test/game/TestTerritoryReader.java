package test.game;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import code.game.Territory;
import code.game.TerritoryReader;

public class TestTerritoryReader {

	@Test
	public void parseTerritory() {
		TerritoryReader tr = new TerritoryReader();
		Territory t = tr.parseTerritory("NA1 | Alaska | [NA2,NA6,AS6] | (0.0567,0.1211)");
		assertEquals(t.getTerritoryID(), "NA1");
		assertEquals(t.getName(), "Alaska");
		ArrayList < String > neighboors = new ArrayList < String > ();
		neighboors.add("NA2");
		neighboors.add("NA6");
		neighboors.add("AS6");
		assertEquals(t.getBorderingTerritories(), neighboors);
		assertEquals(t.getX(), 0.0567, 0.001);
		assertEquals(t.getY(), 0.1211, 0.001);
	}
}
