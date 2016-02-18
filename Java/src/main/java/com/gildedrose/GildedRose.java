package com.gildedrose;

class GildedRose {
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {

			Item item = items[i];
			if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
				if (item.quality > 0) {
					if (!item.name.equals(SULFURAS)) {
						item.quality = item.quality - 1;
					}
				}
			} else {
				if (item.quality < 50) {
					item.quality = item.quality + 1;

					if (item.name.equals(BACKSTAGE_PASSES)) {
						if (item.sellIn < 11) {
							if (item.quality < 50) {
								item.quality = item.quality + 1;
							}
						}

						if (item.sellIn < 6) {
							if (item.quality < 50) {
								item.quality = item.quality + 1;
							}
						}
					}
				}
			}

			decrementSellIn(item);

			if (item.sellIn < 0) {
				if (item.name.equals(AGED_BRIE)) {
					if (item.quality < 50) {
						item.quality = item.quality + 1;
					}
				}
				if (item.name.equals(BACKSTAGE_PASSES)) {
					item.quality = 0;
				}
				if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)
						&& !item.name.equals(SULFURAS)) {
					if (item.quality > 0) {
						item.quality = item.quality - 1;
					}
				}
			}
		}

	}

	public void decrementSellIn(Item item) {
		if (!item.name.equals(SULFURAS)) {
			item.sellIn = item.sellIn - 1;
		}
	}
}
