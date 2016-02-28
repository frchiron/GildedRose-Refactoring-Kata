package com.gildedrose;

public class ItemUpdater {
	private static final int DEFAULT_QUALITY_DROP = 1;
	private static final int FIVE_DAYS = 5;
	private static final int TEN_DAYS = 10;
	private static final int QUALITY_MIN = 0;
	private static final int QUALITY_MAX = 50;
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	Item item;

	public ItemUpdater(Item item) {
		super();
		this.item = item;
	}

	public void updateQuality() {
		if (SULFURAS.equals(item.name)) {
			return;
		}
		decrementSellIn();
		updateQualityByItemName();
	}

	public void updateQualityByItemName() {
		switch (item.name) {
		case AGED_BRIE:
			incrementQuality();
			if (item.sellIn < 0) {
				incrementQuality();
			}
			break;
		case BACKSTAGE_PASSES:
			incrementQuality();
			if (item.sellIn < TEN_DAYS) {
				incrementQuality();
			}
			if (item.sellIn < FIVE_DAYS) {
				incrementQuality();
			}
			if (item.sellIn < 0) {
				item.quality = QUALITY_MIN;
			}
			break;
		default:
			int qualityDrop = item.sellIn < 0 ? DEFAULT_QUALITY_DROP * 2 : DEFAULT_QUALITY_DROP;
			if (item.quality > QUALITY_MIN) {
				item.quality = Math.max(QUALITY_MIN, decrementQualityBy(qualityDrop));
			}
			break;
		}
	}

	public void decrementSellIn() {
		item.sellIn = item.sellIn - 1;
	}

	public void incrementQuality() {
		if (item.quality < QUALITY_MAX) {
			item.quality = item.quality + 1;
		}
	}

	public int decrementQualityBy(int drop) {
		return item.quality = item.quality - drop;
	}
}
