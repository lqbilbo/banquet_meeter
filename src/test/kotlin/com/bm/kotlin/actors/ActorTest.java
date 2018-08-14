package com.bm.kotlin.actors;

import io.vlingo.actors.Definition;
import io.vlingo.actors.World;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author luoqi04
 * @version $Id: ActorTest.java, v 0.1 2018/8/14 下午1:54 luoqi Exp $
 */
public class ActorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 像游戏一样
     */
    @Test
    public void testPlayPingPong() {
        final World world = World.start("playground");
        final Pinger pinger = world.actorFor(Definition.has(PingerActor.class, Definition.NoParameters), Pinger.class);
        final Ponger ponger = world.actorFor(Definition.has(PongerActor.class, Definition.NoParameters), Ponger.class);

        pinger.ping(ponger);

        pauseThisThread();

        world.terminate();
    }

    private void pauseThisThread() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            //ignore
        }
    }
}