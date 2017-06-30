package com.example.js;

import kikaha.core.test.KikahaServerRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by ronei on 24/06/17.
 */
@RunWith(KikahaServerRunner.class)
public class ServerTest {

    @Test
    public void runServerPerOneDay() throws InterruptedException {
        Thread.sleep( 1000 * 60 * 60 * 24 );
    }

}
