/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/**
 *
 * @author Marton
 */
public class MinigameModel {

    public MinigameModel() {
    }
    
    public Observable<Integer> lightCord() 
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<5;i++)
        {
            list.add(i+1);
        }
        Collections.shuffle(list);
        Observable<Integer> nums = Observable.range(0, 5).map(i->list.get(i));
        Observable<Long> trigger = Observable.interval(2, TimeUnit.SECONDS);
        return Observable.zip(nums, trigger, (num, aLong) -> num);
    }
}
