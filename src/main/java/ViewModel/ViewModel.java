/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Model.GameModel;
import rx.subjects.BehaviorSubject;

/**
 *
 * @author Marton
 */
public class ViewModel {
    public final BehaviorSubject<String> vm2v_info = BehaviorSubject.create();
    
    public void connectTo(final GameModel model) {
        model.infos().subscribe(vm2v_info);
    }
}
