/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Model.GameModel;
import Model.MinigameModel;
import io.reactivex.rxjava3.core.Observer;
import java.awt.event.ActionEvent;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 *
 * @author Marton
 */
public class ViewModel {
    public final BehaviorSubject<Integer> vm2v_numbers = BehaviorSubject.create();
    public final PublishSubject<ActionEvent> v2vm_startButtonEvents = PublishSubject.create();
    public MinigameModel gM = new MinigameModel();
    
    public ViewModel() {
        //Observer<ActionEvent> o =  v2vm_startButtonEvents.subscribe();
        v2vm_startButtonEvents.subscribe(v -> gM.lightCord().subscribe(m -> System.out.println(m)));
    }
}
