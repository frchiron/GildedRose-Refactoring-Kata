package com.gildedrose;

class GildedRose {
	private static final int FIVE_DAYS = 5;
	private static final int TEN_DAYS = 10;
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
		for (Item item : items) {
			decrementSellIn(item);
			updateQuality(item);
		}

	}

	public void decrementSellIn(Item item) {
		if (!SULFURAS.equals(item.name)) {
			item.sellIn = item.sellIn - 1;
		}
	}

	public void updateQuality(Item item) {
		switch (item.name) {
		case AGED_BRIE:
			updateQualityForAgedBrie(item);
			break;
		case SULFURAS:
			updateQualityForSulfuras(item);
			break;
		case BACKSTAGE_PASSES:
			updateQualityForBackstagePasses(item);
			break;
		default:
			updateQualityDefault(item);
			break;
		}

	}

	public void updateQualityDefault(Item item) {
		if (item.quality > QUALITY_MIN) {
			decrementQualityByOne(item);
		}

		if (item.quality > QUALITY_MIN && item.sellIn < 0) {
			decrementQualityByOne(item);
		}

	}

	public void updateQualityForBackstagePasses(Item item) {
		if (item.quality < QUALITY_MAX) {
			incrementQualityByOne(item);

		}
		if (item.quality < QUALITY_MAX) {
			if (item.sellIn < TEN_DAYS) {
				incrementQualityByOne(item);
			}

			if (item.sellIn < FIVE_DAYS) {
				incrementQualityByOne(item);
			}
		}

		if (item.sellIn < 0) {
			item.quality = QUALITY_MIN;
		}
	}

	public void updateQualityForAgedBrie(Item item) {
		if (item.quality < QUALITY_MAX) {
			incrementQualityByOne(item);

		}

		if (item.sellIn < 0) {
			if (item.quality < QUALITY_MAX) {
				incrementQualityByOne(item);
			}

		}
	}

	public void updateQualityForSulfuras(Item item) {
		if (item.quality < QUALITY_MAX) {
			incrementQualityByOne(item);
		}

	}

	public int decrementQualityBy(Item item, int drop) {
		return item.quality = item.quality - drop;
	}

	public int decrementQualityByOne(Item item) {
		return item.quality = item.quality - 1;
	}

	public int incrementQualityByOne(Item item) {
		return item.quality = item.quality + 1;
	}

}
