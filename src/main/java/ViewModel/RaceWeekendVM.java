/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Model.GameModel;
import Model.ReactiveGameModel;
import View.MainWindow;
import View.RaceWeekend;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JProgressBar;
import rx.subjects.PublishSubject;

/**
 *
 * @author Marton
 */
public class RaceWeekendVM {
    private final GameModel gameModel;
    public ReactiveGameModel gM;
    public final PublishSubject<ActionEvent> v2vm_simulationButtonEvents = PublishSubject.create();
    public final PublishSubject<ActionEvent> v2vm_upgradePowerUnitButtonEvents = PublishSubject.create();
    public final PublishSubject<ActionEvent> v2vm_upgradeAeroButtonEvents = PublishSubject.create();
    public final PublishSubject<ActionEvent> v2vm_upgradeChasingButtonEvents = PublishSubject.create();
    public final PublishSubject<ActionEvent> v2vm_upgradeDurabilityButtonEvents = PublishSubject.create();
    public final PublishSubject<ActionEvent> v2vm_upgradeMechanicsButtonEvents = PublishSubject.create();
    public final PublishSubject<ActionEvent> v2vm_upgradeWorkersEvents = PublishSubject.create();
    
    public RaceWeekendVM(GameModel gameModel)
    {
        this.gameModel = gameModel;
        gM = new ReactiveGameModel(gameModel);
        
        v2vm_simulationButtonEvents.subscribe(v -> gM.raceweekSimulation().subscribe(m -> {
            RaceWeekend.simulationStartButton.setVisible(false);
            RaceWeekend.MinigameButton.setVisible(false);
            RaceWeekend.simulationLabel.setIcon(m);
        },Throwable::printStackTrace,() ->  {
            RaceWeekend.backToGF.setVisible(true);
            RaceWeekend.winnerLabel.setText("Winner: " + gM.getWinner().split("_")[1].toUpperCase());
        }));
        
        v2vm_upgradePowerUnitButtonEvents.subscribe(v -> gM.raceweekUpgradePlus().subscribe(m -> {
            statIncrease(RaceWeekend.powerUnitBar,0,true);
        }));
        
        v2vm_upgradeAeroButtonEvents.subscribe(v -> gM.raceweekUpgradePlus().subscribe(m -> {
            statIncrease(RaceWeekend.aeroBar,1,true);
        }));
        
        v2vm_upgradeChasingButtonEvents.subscribe(v -> gM.raceweekUpgradePlus().subscribe(m -> {
            statIncrease(RaceWeekend.chasingBar,2,true);
        }));
        
        v2vm_upgradeDurabilityButtonEvents.subscribe(v -> gM.raceweekUpgradePlus().subscribe(m -> {
            statIncrease(RaceWeekend.durabilityBar,3,true);
        }));
        
        v2vm_upgradeMechanicsButtonEvents.subscribe(v -> gM.raceweekUpgradePlus().subscribe(m -> {
            statIncrease(RaceWeekend.mechanicsBar,4,false);
        }));
        
        v2vm_upgradeWorkersEvents.subscribe(v -> gM.raceweekUpgradePlus().subscribe(m -> {
            statIncrease(RaceWeekend.workersBar,5,false);
        }));
    }
    private void statIncrease(JProgressBar jBar, int idx,boolean b)
    {
        RaceWeekend.MinigameButton.setVisible(false);
        if(b)
        {
            Random rand = new Random();
            int numberOne = rand.nextInt(RaceWeekend.increasedChance);
            if(RaceWeekend.upgradeChance)
            {
                RaceWeekend.upgradeStatLabel.setText("Sucessful");
                int addon = jBar.getValue() +1;
                jBar.setValue(addon);
                jBar.setToolTipText(String.valueOf(addon));
                RaceWeekend.barValues.set(idx, addon);
                RaceWeekend.devPoints--;
                gameModel.setDevelopmentPoints(RaceWeekend.devPoints);
                RaceWeekend.availablePointsText();
                RaceWeekend.hideButtons();
            }
            else if(numberOne%3 ==0)
            {
                RaceWeekend.upgradeStatLabel.setText("Sucessful");
                int addon = jBar.getValue() +1;
                jBar.setValue(addon);
                jBar.setToolTipText(String.valueOf(addon));
                RaceWeekend.barValues.set(idx, addon);
                RaceWeekend.devPoints--;
                gameModel.setDevelopmentPoints(RaceWeekend.devPoints);
                RaceWeekend.availablePointsText();
                RaceWeekend.hideButtons();
            }
            else
            {
                RaceWeekend.upgradeStatLabel.setText("Failed");
                RaceWeekend.devPoints--;
                gameModel.setDevelopmentPoints(RaceWeekend.devPoints);
                RaceWeekend.availablePointsText();
                RaceWeekend.hideButtons();
            }
        }
        else
        {
            Random rand = new Random();
            int numberOne = rand.nextInt(RaceWeekend.increasedChance);
            if(RaceWeekend.upgradeChance)
            {
                RaceWeekend.upgradeStatLabel.setText("Sucessful");
                int addon = jBar.getValue() +1;
                jBar.setValue(addon);
                jBar.setToolTipText(String.valueOf(addon));
                RaceWeekend.barValues.set(idx, addon);
                RaceWeekend.workPoints--;
                gameModel.setDevelopmentPoints(RaceWeekend.workPoints);
                RaceWeekend.availablePointsText();
                RaceWeekend.hideButtons();
            }
            else if(numberOne%3 ==0)
            {
                RaceWeekend.upgradeStatLabel.setText("Sucessful");
                int addon = jBar.getValue() +1;
                jBar.setValue(addon);
                jBar.setToolTipText(String.valueOf(addon));
                RaceWeekend.barValues.set(idx, addon);
                RaceWeekend.workPoints--;
                gameModel.setDevelopmentPoints(RaceWeekend.workPoints);
                RaceWeekend.availablePointsText();
                RaceWeekend.hideButtons();
            }
            else
            {
                RaceWeekend.upgradeStatLabel.setText("Failed");
                RaceWeekend.workPoints--;
                gameModel.setDevelopmentPoints(RaceWeekend.workPoints);
                RaceWeekend.availablePointsText();
                RaceWeekend.hideButtons();
            }
        }
    }
}
