package com.example.refactoring.TennisGame;

public class TennisGame7 implements TennisGame{
    private final String player1Name;
    private final String player2Name;

    //獲得したポイント数
    private int player1Points;
    private int player2Points;
    private String scoreMessages[] =new String[]{"Love","Fifteen","Thirty","Forty"};

    public TennisGame7(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

//    テストなどの外部からポイントを入れる関数
    public void wonPoint(String playerName){
        if (playerName == "player1")
            player1Points += 1;
        else
            player2Points += 1;
    }

    public String getScore(){
        if (this.player1Points == this.player2Points){
//            deuceか
            if (this.player1Points >= 3) { return "Deuce"; }
            return scoreMessages[this.player1Points] + "-All";
        }
        if (this.player1Points>=4 || this.player2Points>=4) {
            return this.advantage();
        }

        return this.scoreMessages[this.player1Points] + "-" + this.scoreMessages[this.player2Points];
    }

//    deuce以降の計算?
    public String advantage(){
        int pointDifference = this.player1Points - this.player2Points;
        if (pointDifference== 1) return "Advantage player1";
        if (pointDifference == -1) return "Advantage player2";
        if (pointDifference>=2) return  "Win for player1";
        return "Win for player2";
    }

}
