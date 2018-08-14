package com.bm.kotlin.actors;

import io.vlingo.actors.Actor;

/**
 * @author luoqi04
 * @version $Id: PingerActor.java, v 0.1 2018/8/14 下午1:20 luoqi Exp $
 */
public class PingerActor extends Actor implements Pinger {
    private final Pinger self;
    private int count;

    public PingerActor() {
        count = 0;
        self = selfAs(Pinger.class);
    }

    @Override
    public void ping(final Ponger ponger) {
        ++count;
        logger().log("ping " + count);
        if (count >= 10) {
            self.stop();
            ponger.stop();
        } else {
            ponger.pong(self);
        }
    }

    @Override
    protected void afterStop() {
        logger().log("Pinger " + address() + " just stopped!");
        super.afterStop();
    }
}
