package io.gundb.core;

import io.gundb.Gun;
import io.gundb.data.Node;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Quarantine {
    
    Gun gun;
    Timer timer;
    
    public Quarantine(Gun gun) {
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
