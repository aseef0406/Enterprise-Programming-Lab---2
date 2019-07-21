/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author MD-Aseef
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Timer timer;
    @Resource
    private SessionContext context;
    Future obj1;
    
    public void init(Future obj,int time){
        obj1=obj;
        TimerService timerservice=context.getTimerService();
        timer=timerservice.createSingleActionTimer(time, null);
    }
    
    @Timeout
    public void timeOutMethod(Timer t){
        obj1.cancel(true);
        timer.cancel();
    }
    
    @Asynchronous
    public Future<Long> calprimebelow(long upperlimit){
        Long current=null;
        for(long c=2;c<upperlimit+1;c++){
            if(isPrime(c)){
                current=c;
            }
        }
        ////////////
        if(context.wasCancelCalled()){
            return null;
        }
        return new AsyncResult<Long>(current);
    }
    private boolean isPrime(long l){
        for(long i=2;i<l;i++){
            if(l%i==0)
                return false;
        }
        
        return true;
    }
    
}
