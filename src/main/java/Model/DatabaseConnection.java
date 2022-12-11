/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;

/**
 *
 * @author Marton
 */
public class DatabaseConnection {
    int maxScores = 0;
    PreparedStatement insertStatement;
    PreparedStatement deleteStatement;
    Connection connection;

    public DatabaseConnection() throws SQLException {
        String dbURL = "jdbc:sqlite:/" +Paths.get("").toAbsolutePath().toString()+ "\\save.db";
        connection = DriverManager.getConnection(dbURL);
        System.out.println("Connection Successful");

        String insertQuery = "INSERT INTO GAMES (TIMESTAMP, NAME, SCORE, WINS, MONEY, CONSTRUCTOR, DAY, BARVALUES, BOARD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertStatement = connection.prepareStatement(insertQuery);
        String deleteQuery = "DELETE FROM GAMES WHERE SCORE=?";
        deleteStatement = connection.prepareStatement(deleteQuery);
    }

    //INSERT INTO save.formuladatas (Board) VALUES ('["hot", "cold"]');
    
    public ArrayList<HighScore> getDatabase() throws SQLException {
        String query = "SELECT * FROM GAMES";
        ArrayList<HighScore> highScores = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        while (results.next()) {
            String name = results.getString("NAME");
            int score = results.getInt("SCORE");
            int wins = results.getInt("WINS");
            int money = results.getInt("MONEY");
            String constructor = results.getString("CONSTRUCTOR");
            int day = results.getInt("DAY");
            String values = results.getString("BARVALUES");
            String board = results.getString("BOARD");
            highScores.add(new HighScore(name, score, wins, money, constructor, day, values, board));
        }
        sortDatas(highScores);
        return highScores;
    }

    public void saveDatas(String name, int score, int wins, int money, String constructor, int day, String values, String board) throws SQLException {
        ArrayList<HighScore> highScores = getDatabase();
        if (highScores.size() < maxScores) {
            insertDatas(name, score, wins, money, constructor, day, values, board);
        } else {
            int leastScore = highScores.get(highScores.size() - 1).getScore();
            if (leastScore < score) {
                deleteDatas(leastScore);
                insertDatas(name, score, wins, money, constructor, day, values, board);
            }
        }
    }

    private void sortDatas(ArrayList<HighScore> highScores) {
        Collections.sort(highScores, new Comparator<HighScore>() {
            @Override
            public int compare(HighScore t, HighScore t1) {
                return t1.getScore() - t.getScore();
            }
        });
    }

    private void insertDatas(String name, int score,int wins, int money, String constructor, int day, String values, String board) throws SQLException {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        insertStatement.setTimestamp(1, ts);
        insertStatement.setString(2, name);
        insertStatement.setInt(3, score);
        insertStatement.setInt(4, wins);
        insertStatement.setInt(5, money);
        insertStatement.setString(6, constructor);
        insertStatement.setInt(7, day);
        insertStatement.setString(8,values);
        insertStatement.setString(9,board);
        insertStatement.executeUpdate();
    }

    private void deleteDatas(int score) throws SQLException {
        deleteStatement.setInt(1, score);
        deleteStatement.executeUpdate();
    }
}
