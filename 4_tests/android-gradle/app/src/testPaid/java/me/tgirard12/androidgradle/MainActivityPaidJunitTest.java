package me.tgirard12.androidgradle;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by tgirard on 09/03/15
 */
public class MainActivityPaidJunitTest {


    @Test
    public void testTextView() {

        Assert.assertEquals("test Junit Paid", "test Junit Paid");

    }
}
