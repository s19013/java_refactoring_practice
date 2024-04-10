package com.example.refactoring.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


//    さっさと次に行ってほっしためelseではなくcontinue
//    かぶることもないので
//    sellInはquary計算で参照するので｢日数を減らしてから｣というのはできない
    public void oneDayHasPassed(){
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.contains("Sulfuras")) {
                items[i].sellIn -= 1;
                continue;
            }


            if (items[i].name.contains("Backstage")){
                items[i] = this.isBackStage(items[i]);
                items[i].sellIn -= 1;

                continue;
            }

            if (items[i].name.contains("Aged Brie")){
                items[i] = this.isAgedBrie(items[i]);
                items[i].sellIn -= 1;

                continue;
            }

            items[i] = this.isOther(items[i]);
            items[i].sellIn -= 1;

        }
    }

//    これ最終日はsellIn == 0 のこと?
//    それともsellIn == 1 のこと?
//    とりあえずここではsellIn == 0と仮定する
    public Item isBackStage(Item item){
        if (item.sellIn > 10){
            return updateQuality(item,1);
        }

//        残り10日
        if (10>= item.sellIn && item.sellIn >5){
            return updateQuality(item,2);
        }

//        残り5日
        if (5 >= item.sellIn && item.sellIn > 0){
            return updateQuality(item,3);
        }

//        最終日
//      0にするため今の値をすべて引く
        return updateQuality(item,-(item.quality));


    }

    public Item isAgedBrie(Item item){
        return updateQuality(item,1);
    }

    public Item isOther(Item item){
        return updateQuality(item,-1);
    }

    public Item updateQuality(Item item,Integer day){
        //  Conjured製かどうかはここで判断したほうがわかりやすいかと
        if (item.name.contains("Conjured")) {
            item.quality += day*2;
        } else {
            item.quality += day;
        }

//        値が規定範囲内かどうか調べる
        item.quality = this.qualityAdjustment(item.quality);

        return item;
    }

    public Integer qualityAdjustment(Integer day){
//        0未満
        if (day < 0 ) return 0;
//        50より上
        if (day > 50 ) return 50;

        return day;
    }

}
