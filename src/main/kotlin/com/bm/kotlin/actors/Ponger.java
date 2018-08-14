package com.bm.kotlin.actors;

import io.vlingo.actors.Stoppable;

/**
 * @author luoqi04
 * @version $Id: Ponger.java, v 0.1 2018/8/14 下午1:17 luoqi Exp $
 */
public interface Ponger extends Stoppable {

    void pong(final Pinger pinger);
}
