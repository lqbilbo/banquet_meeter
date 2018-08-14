package com.bm.kotlin.actors;

import io.vlingo.actors.Stoppable;

/**
 * @author luoqi04
 * @version $Id: Pinger.java, v 0.1 2018/8/14 下午1:14 luoqi Exp $
 */
public interface Pinger extends Stoppable {

    void ping(final Ponger ponger);
}
