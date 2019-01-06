package net.yogstation.ping.service.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ImplStatusServiceTest {

    public ImplStatusService implStatusService = new ImplStatusService();

    @Test
    public void test_decodeData_SingleKeyValue() {
        String testString = "testKey=testValue";

        Map<String, String> value = implStatusService.decodeData(testString);

        Assert.assertEquals("map should have 1 item", value.size(), 1);
        Assert.assertEquals("testKey should have value testValue", value.get("testKey"), "testValue");
        //TODO: Assert.
    }

    @Test
    public void test_decodeData_MultipleKeyValue() {
        String testString = "testKey=testValue&testKeyTwo=testValueTwo";

        Map<String, String> value = implStatusService.decodeData(testString);

        Assert.assertEquals("map should have 2 items", value.size(), 2);
        Assert.assertEquals("testKey should have value testValue", value.get("testKey"), "testValue");
        Assert.assertEquals("testKeyTwo should have value testValueTwo", value.get("testKeyTwo"), "testValueTwo");
    }

    @Test
    public void test_decodeData_IncorrectKeyValue() {
        String testString = "testKey&testKeyTwo=testValueTwo";

        Map<String, String> value = implStatusService.decodeData(testString);

        Assert.assertEquals("map should have 1 item", value.size(), 1);
        Assert.assertEquals("testKey should have value testValue", value.get("testKeyTwo"), "testValueTwo");
    }

    @Test
    public void test_decodeData_UrlDecodeKeyValue() {
        String testString = "testKey=test+value";

        Map<String, String> value = implStatusService.decodeData(testString);

        Assert.assertEquals("map should have 1 item", value.size(), 1);
        Assert.assertEquals("testKey should have value test value", value.get("testKey"), "test value");
    }
}
