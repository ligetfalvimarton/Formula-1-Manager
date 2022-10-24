/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.GameField;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marton
 */
public class TimeSimulation extends Thread {
    private LocalTime dateTime;
    private String date;
    private int daysPassed;
    private long toAdd;
    private int timeGap;
    private boolean inGame;
    
    private GameField gameField;

    /**
     * Alap konstruktor
     */
    public TimeSimulation() {
        dateTime = LocalTime.of(0, 0, 0);
        daysPassed = 1;
        FormatDate();
        toAdd = 1;
        timeGap = 50;
        inGame = true;
    }
    
    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public void run() {
       while(inGame){
            LocalTime prevTime = dateTime;
            dateTime = dateTime.plusMinutes(toAdd);
            if(prevTime.getHour() == 23 && dateTime.getHour() == 0){
                daysPassed += 1;
            }
            FormatDate();
           try {
               gameField.setDateText(date);
           } catch (IOException ex) {
               Logger.getLogger(TimeSimulation.class.getName()).log(Level.SEVERE, null, ex);
           }
            gameField.setMoneyText();
            try {
                sleep(timeGap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void FasterTime(){
        PauseTimer();
        toAdd = 1;
        timeGap = 10;
        ResumeTimer();
    }


    public void StopTime(){
        PauseTimer();
        toAdd = 0;
        ResumeTimer();
    }

    public void NormalTime(){
        PauseTimer();
        toAdd = 1;
        timeGap=50;
        ResumeTimer();
    }

    public void resetTime(){
        dateTime = LocalTime.of(0, 0, 0);
        daysPassed = 1;
    }

    private void FormatDate(){
        String hour = dateTime.getHour()/10 == 0 ? "0" + dateTime.getHour() : ""+dateTime.getHour();
        String minute = dateTime.getMinute()/10 == 0 ? "0" + dateTime.getMinute() : ""+dateTime.getMinute();

        date = daysPassed + ". nap, " + hour  + ":" + minute;
    }

    public void PauseTimer(){
        inGame = false;
    }

    public void ResumeTimer(){
        inGame = true;
    }

    public String getDate() {
        return date;
    }

    public LocalTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getDaysPassed() {
        return daysPassed;
    }

    public void setDaysPassed(int daysPassed) {
        this.daysPassed = daysPassed;
    }

    public long getToAdd() {
        return toAdd;
    }

    public void setToAdd(long toAdd) {
        this.toAdd = toAdd;
    }

    public int getTimeGap() {
        return timeGap;
    }

    public void setTimeGap(int timeGap) {
        this.timeGap = timeGap;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
}
