package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void should_return_same_results_between_refactored_and_legacy_versions() {
		ItemLegacy[] itemsLegacy = new ItemLegacy[] { new ItemLegacy("+5 Dexterity Vest", 10, 20), //
				new ItemLegacy("Aged Brie", 2, 0), //
				new ItemLegacy("Elixir of the Mongoose", 5, 7), //
				new ItemLegacy("Sulfuras, Hand of Ragnaros", 0, 80), //
				new ItemLegacy("Sulfuras, Hand of Ragnaros", -1, 80),
				new ItemLegacy("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new ItemLegacy("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new ItemLegacy("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new ItemLegacy("Conjured Mana Cake", 3, 6) };

		GildedRoseLegacy legacyApp = new GildedRoseLegacy(itemsLegacy);

		int days = 50;

		StringBuilder legacyResult = new StringBuilder();
		for (int i = 0; i < days; i++) {
			legacyResult.append("-------- day " + i + " --------");
			legacyResult.append("name, sellIn, quality");
			for (ItemLegacy item : itemsLegacy) {
				legacyResult.append(item);
			}
			legacyResult.append("\n");
			legacyApp.updateQuality();
		}

		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		days = 50;

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < days; i++) {
			result.append("-------- day " + i + " --------");
			result.append("name, sellIn, quality");
			for (Item item : items) {
				result.append(item);
			}
			result.append("\n");
			app.updateQuality();
		}

		Assert.assertEquals(legacyResult.toString(), result.toString());

	}

}
