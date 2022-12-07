/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import rx.Observable;

/**
 *
 * @author Marton
 */
public class ReactiveGameModel 
{
    private GameModel gM;
    private String winner;
    
    public ReactiveGameModel() 
    {}
    public ReactiveGameModel(GameModel gameModel) 
    {
        gM = gameModel;
        winner = gM.raceWinnerCalculator();
    }
    
    public Observable<Integer> minigameLightCord() 
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<6;i++)
        {
            list.add(i);
        }
        Collections.shuffle(list);
        list.add(0);
        Observable<Integer> nums = Observable.from(list);
        Observable<Long> trigger = Observable.interval(1, TimeUnit.SECONDS);
        return Observable.zip(nums, trigger, (num, aLong) -> num);
    }  

    public Observable<ImageIcon> raceweekSimulation()
    {
        
        ArrayList<ImageIcon> list = new ArrayList<>();
        for(int i=0;i<11;i++)
        {
            list.add(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Simulation/"+ i +".png"));
        }
        list.add(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Simulation/Finish/"+winner+".png"));
        list.add(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Simulation/Finish/"+winner+".png"));
        if(winner.split("_")[1].toUpperCase().equals(gM.getGameField().getWindow().getConstructor().toString()))
        {
            list.add(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/win.jpg"));
            gM.setWins(gM.getWins()+1);
        }
        Observable<ImageIcon> simulation = Observable.from(list);
        Observable<Long> trigger = Observable.interval(900, TimeUnit.MILLISECONDS);
        
        return Observable.zip(simulation, trigger, (sim, aLong) -> sim);
    } 
    
    public Observable<Integer> raceweekUpgradePlus() 
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        Observable<Integer> num = Observable.from(list);
        return num;
    }
    
    public String getWinner() {
        return winner;
    }
}
