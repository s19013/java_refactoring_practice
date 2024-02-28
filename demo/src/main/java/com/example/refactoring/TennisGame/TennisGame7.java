package com.example.refactoring.TennisGame;

public class TennisGame7 implements TennisGame{
    private final String player1Name;
    private final String player2Name;

    //獲得したポイント数
    private int player1point;
    private int player2point;

    //獲得したゲーム数
    private int player1Games;
    private int player2Games;

    private String deuceMessages[] =new String[]{"Love-All","Fifteen-All","Thirty-All","Deuce","Deuce"};
    private String scoreMessages[] =new String[]{"Love","Fifteen","Thirty","Forty"};

    public TennisGame7(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        return "emp";
    }
    public void wonPoint(String playerName){
        if (playerName == "player1")
            player1Games += 1;
        else
            player2Games += 1;
    }
}
