package com.example.refactoring.gildedrose;

public class GildedRose {
    Item[] items;
//    テスト用変数
    Integer[][] answerBook;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    //    テスト用関数
    public void setAnswerBook(Integer[][] anserBook) { this.answerBook = anserBook;}



//    さっさと次に行ってほっしためelseではなくcontinue
//    かぶることもないので
//    sellInはquary計算で参照するので｢日数を減らしてから｣というのはできない
    public void oneDayHasPassed(){
        for (int i = 0; i < items.length; i++) {

//            sulfurasは変化しないから無視
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
            return increaseQuality(item,1);
        }

//        残り10日
        if (10>= item.sellIn && item.sellIn >5){
            return increaseQuality(item,2);
        }

//        残り5日
        if (5 >= item.sellIn && item.sellIn > 0){
            return increaseQuality(item,3);
        }

//        最終日
//      0にするため今の値をすべて引く
        return decreaseQuality(item,item.quality);
    }

    public Item isAgedBrie(Item item){
        return increaseQuality(item,1);
    }

    public Item isOther(Item item){
        return decreaseQuality(item,2);
    }

    public Item increaseQuality(Item item,Integer value){
        if (item.name.contains("Conjured")) { item.quality += value*2; }
        else { item.quality += value; }
//        50より上には上がらないため整える
        if (item.quality > 50 ) {item.quality = 50;}
        return item;
    }

    public Item decreaseQuality(Item item,Integer value) {
        if (item.name.contains("Conjured")) {item.quality -= value*2;}
        else {item.quality -= value;}
        //        0より下には下がらないため整える
        if (item.quality < 0 ) {item.quality = 0;}
        return item;
    }

}
