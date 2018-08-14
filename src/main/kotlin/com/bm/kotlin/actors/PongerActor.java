package com.bm.kotlin.actors;

import io.vlingo.actors.Actor;

/**
 * @author luoqi04
 * @version $Id: PongerActor.java, v 0.1 2018/8/14 下午1:23 luoqi Exp $
 */
public class PongerActor extends Actor implements Ponger {
    private final Ponger self;

    public PongerActor() {
        self = selfAs(Ponger.class);
    }

    @Override
    public void pong(final Pinger pinger) {
        logger().log("pong");
        pinger.ping(self);
    }
}
