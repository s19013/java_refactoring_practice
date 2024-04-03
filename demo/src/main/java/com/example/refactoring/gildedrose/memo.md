# 役目
システムに新しい機能を追加して､新しいカテゴリーのアイテムを販売できるようにする  
->とはいえまずは修正が先かな?

テストコードも不十分なので作る

# 仕様 

sellIn:残り日数  
Quality:価値  

毎日の終わりにこの2つの変数の値が変化する  

Conjuredのアイテムは品質変化速度が2倍

# 縛り
Itemクラス､Itemプロパティは変更不可  
↑この縛りがなければかなりらくなんだけどな

継承するか?

## Quality
日数が減る毎に値が-2  
例外として`Aged Brie`日が減るごとに+1ずつ  
0<= 値 <= 50  
sulfurasは､値が下がらない｡  

Backstage passesは以下の法則で値が変化する  
|日にち|値の変化|
|--|--|
|それ以外|+1|
|残り10日|+2|
|残り5日|+3|
|最終日|値が0になる|

今度112ページ以降を見せてもらう


# 修正案
名前毎に関数を作って実行するのがよいかと｡  
-> Itemクラスに書くのが良いとおもうけど縛りがあるからやむなし｡
-> その関数でさらに`Conjured`製かどうか調べるか｡

これ最終日はsellIn == 0 のこと?  
それともsellIn == 1 のこと?

1. sellinが0以上か
3. Backstageか
4. Aged Brieか
5. それ以外の商品の処理


# コード解析
なんかやっててあほらしい｡時間の無駄  
全部つくりなおしたほうがってとりばやい
## 初期化処理
Item型の配列が渡される  
GildedRoseクラスの変数`Item`に渡される

## 更新作業
forでItem配列の中身を見ていく

### 1. アイテムの名前が`Aged Brie`,`Backstage passes to a TAFKAL80ETC concert`以外か
この時点ですでにややこしい｡
#### 1-1. 品質の値が0より上か
#### 1-1-1 アイテムの名前が`Sulfuras, Hand of Ragnaros`以外か
品質の値を1下げる
