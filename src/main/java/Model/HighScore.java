/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Marton
 */
public class HighScore {
    private final String name;
    private final int score;
    private final int wins;
    private final int money;
    private final String constructor;
    private final int day;
    private final String values;
    private final String board;

    public HighScore(String name, int score, int wins,int money, String constructor, int day, String values, String board) {
        this.name = name;
        this.score = score;
        this.wins = wins;
        this.money = money;
        this.constructor = constructor;
        this.day = day;
        this.values = values;
        this.board = board;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }

    public int getWin() {
        return wins;
    }

    public int getWins() {
        return wins;
    }

    public int getMoney() {
        return money;
    }

    public String getConstructor() {
        return constructor;
    }

    public String getValues() {
        return values;
    }

    public int getDay() {
        return day;
    }

    public String getBoard() {
        return board;
    }
    
    @Override
    public String toString() {
        return name + " " + score + " " + wins + " " + money + " " + constructor + " " + day + " " + values;
    }
}
