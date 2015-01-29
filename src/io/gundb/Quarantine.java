package io.gundb;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Quarantine {
    
    Gun gun;
    Timer timer;
    
    Quarantine(Gun gun) {
        this.gun = gun;
        timer = new Timer();
    }
    
    void addTask(final Node data, long time) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gun.ham.handleIncomingData(data);
            }
        }, new Date(time+1));
    }
}
