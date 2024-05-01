package com.example.refactoring.gildedrose;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GlidedRose_ConjuredTest {
    //    期待:qualityが絶対に変化しない
    @Test
    void sulfuras(){
        Item[] items = new Item[] {
                new Item("Conjured_Sulfuras",10,20)
        };

        Integer[] answerBook = {20,20,20,20};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

//    期待:4ずつへる
    @Test
    void Other(){
        Item[] items = new Item[] {
                new Item("Conjured_other",10,20)
        };

        Integer[] answerBook = {16,12};

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
                new Item("Conjured_other",10,8)
        };

        Integer[] answerBook = {4,0,0,0};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
        }
    }

    //    期待:2ずつ増えているか
    @Test
    void Aged_Brie() {
        Item[] items = new Item[] {
                new Item("Conjured_Aged Brie",10,4)
        };

        Integer[] answerBook = {6,8,10,12};

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
                new Item("Conjured_Aged Brie",10,47)
        };

        Integer[] answerBook = {49,50,50,50};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    //    期待:2ずつ増えるか
    @Test
    void BackStage_sellinが11日以上() {
        Item[] items = new Item[] {
                new Item("Conjured_Aged Brie",20,10)
        };

        Integer[] answerBook = {12,14,16,18};

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
                new Item("Conjured_Aged Brie",20,47)
        };

        Integer[] answerBook = {49,50,50,50};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    //    期待:最初の2つは+2,後は+4
    @Test
    void BackStage_qualityの加算が2と4の境界値() {
        Item[] items = new Item[] {
                new Item("Conjured_Backstage",12,10)
        };

        Integer[] answerBook = {12,14,18,22};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {

            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }

    //    期待:最初の2つは+4,後は+6
    @Test
    void BackStage_qualityの加算が4と6の境界値() {
        Item[] items = new Item[] {
                new Item("Conjured_Backstage",7,10)
        };

        Integer[] answerBook = {14,18,24,30};

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
                new Item("Conjured_Backstage",2,10)
        };

        Integer[] answerBook = {16,22,0,0};

        int days = 4;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {

            app.oneDayHasPassed();
            assertEquals(items[0].quality,answerBook[i]);

        }
    }
}
