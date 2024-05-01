package com.example.refactoring.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
//    期待:qualityが絶対に変化しない
    @Test
    void sulfuras(){
        Item[] items = new Item[] {
                new Item("Sulfuras",10,20)
        };

        Integer[] answerBook = {20,20,20,20};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    @Test
    void Other(){
        Item[] items = new Item[] {
                new Item("other",10,20)
        };

        Integer[] answerBook = {18,16};

        int days = 2;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    //期待: とにかくマイナスにならないことを確認したい
    @Test
    void Other_0以下にならない(){
        Item[] items = new Item[] {
                new Item("other",10,4)
        };

        Integer[] answerBook = {2,0,0,0};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

//    期待:1ずつ増えているか
    @Test
    void Aged_Brie() {
        Item[] items = new Item[] {
                new Item("Aged Brie",10,4)
        };

        Integer[] answerBook = {5,6,7,8};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

//    期待:51以上の値にならない｡50で止まる
    @Test
    void Aged_Brie_51以上にならない() {
        Item[] items = new Item[] {
                new Item("Aged Brie",10,48)
        };

        Integer[] answerBook = {49,50,50,50};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    //    期待:1ずつ増えるか
    @Test
    void BackStage_sellinが11日以上() {
        Item[] items = new Item[] {
                new Item("Aged Brie",20,10)
        };

        Integer[] answerBook = {11,12,13,14};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    //    期待:51以上の値にならない｡50で止まる
    @Test
    void BackStage_sellinが11日以上_qualityが50でとまる() {
        Item[] items = new Item[] {
                new Item("Aged Brie",20,48)
        };

        Integer[] answerBook = {49,50,50,50};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    //    期待:最初の2つは+1,後は+2
    @Test
    void BackStage_qualityの加算が1と2の境界値() {
        Item[] items = new Item[] {
                new Item("Backstage",12,10)
        };

        Integer[] answerBook = {11,12,14,16};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {

            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    //    期待:最初の2つは+2,後は+3
    @Test
    void BackStage_qualityの加算が2と3の境界値() {
        Item[] items = new Item[] {
                new Item("Backstage",7,10)
        };

        Integer[] answerBook = {12,14,17,20};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {

            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);
//            System.out.println("sellin:" + items[0].sellIn +",quality:"+items[0].quality);

        }
    }


    //    期待:sellinが0になったらqualityも0
    @Test
    void BackStage_sellinが0になったらqualityも0() {
        Item[] items = new Item[] {
                new Item("Backstage",2,10)
        };

        Integer[] answerBook = {13,16,0,0};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {

            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

}
