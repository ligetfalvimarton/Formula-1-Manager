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
import rx.subjects.PublishSubject;

/**
 *
 * @author Marton
 */
public class RaceWeekendVM {
    private final GameModel gameModel;
    public final PublishSubject<ActionEvent> v2vm_simulationButtonEvents = PublishSubject.create();
    public ReactiveGameModel gM;
    
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
    }
}
