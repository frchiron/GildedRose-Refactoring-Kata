package com.gildedrose;

class GildedRose {
	private static final int QUALITY_MIN = 0;
	private static final int QUALITY_MAX = 50;
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
			decrementSellIn(item);

			updateQuality(item);

			if (item.sellIn < 0) {
				updateQualityWhenNegativeSellIn(item);
			}
		}

	}

	public void updateQuality(Item item) {
		if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES) && !item.name.equals(SULFURAS)) {
			if (item.quality > QUALITY_MIN) {
				decrementQualityByOne(item);
			}
			return;
		}

		if (item.quality < QUALITY_MAX) {
			incrementQualityByOne(item);

		}

		if (item.name.equals(BACKSTAGE_PASSES)) {
			if (item.sellIn < 10) {
				if (item.quality < QUALITY_MAX) {
					incrementQualityByOne(item);
				}
			}

			if (item.sellIn < 5) {
				if (item.quality < QUALITY_MAX) {
					incrementQualityByOne(item);
				}
			}
		}

	}

	public void updateQualityWhenNegativeSellIn(Item item) {
		if (item.name.equals(AGED_BRIE)) {
			if (item.quality < QUALITY_MAX) {
				incrementQualityByOne(item);
			}
			return;
		}
		if (item.name.equals(BACKSTAGE_PASSES)) {
			item.quality = QUALITY_MIN;
			return;
		}
		if (!item.name.equals(SULFURAS)) {
			if (item.quality > QUALITY_MIN) {
				decrementQualityByOne(item);
			}
			return;
		}
	}

	public int decrementQualityByOne(Item item) {
		return item.quality = item.quality - 1;
	}

	public int incrementQualityByOne(Item item) {
		return item.quality = item.quality + 1;
	}

	public void decrementSellIn(Item item) {
		if (!item.name.equals(SULFURAS)) {
			item.sellIn = item.sellIn - 1;
		}
	}
}
