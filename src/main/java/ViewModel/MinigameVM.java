/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Model.ReactiveGameModel;
import View.Minigame;
import static View.Minigame.randomize;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import rx.subjects.PublishSubject;

/**
 *
 * @author Marton
 */
public class MinigameVM {
    public final PublishSubject<ActionEvent> v2vm_startButtonEvents = PublishSubject.create();
    public ReactiveGameModel gM = new ReactiveGameModel();
    public int buttonCounter = 0;
    ArrayList<JButton> tmp = new ArrayList<>();
    public MinigameVM() {
        v2vm_startButtonEvents.subscribe(v -> gM.minigameLightCord().subscribe(m -> {
            if(buttonCounter > randomize.size()-1)
                {
                    Minigame.light1.setBackground(null);
                    Minigame.light2.setBackground(null);
                    Minigame.light3.setBackground(null);
                    Minigame.light4.setBackground(null);
                    Minigame.light5.setBackground(null);
                    Minigame.light6.setBackground(null);
                    Minigame.light1.setEnabled(true);
                    Minigame.light2.setEnabled(true);
                    Minigame.light3.setEnabled(true);
                    Minigame.light4.setEnabled(true);
                    Minigame.light5.setEnabled(true);
                    Minigame.light6.setEnabled(true);
                    Minigame.backToRW.setVisible(true);
                }
                else
                {
                    randomize.get(m).setBackground(Color.cyan);
                    tmp.add(randomize.get(m));
                }
                buttonCounter++;
                if(buttonCounter == 6)
                {
                    randomize = tmp;
                }
        }));
    }
}
