package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemLegacy[] items = new ItemLegacy[] {
                new ItemLegacy("+5 Dexterity Vest", 10, 20), //
                new ItemLegacy("Aged Brie", 2, 0), //
                new ItemLegacy("Elixir of the Mongoose", 5, 7), //
                new ItemLegacy("Sulfuras, Hand of Ragnaros", 0, 80), //
                new ItemLegacy("Sulfuras, Hand of Ragnaros", -1, 80),
                new ItemLegacy("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new ItemLegacy("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new ItemLegacy("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new ItemLegacy("Conjured Mana Cake", 3, 6) };

        GildedRoseLegacy app = new GildedRoseLegacy(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (ItemLegacy item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
