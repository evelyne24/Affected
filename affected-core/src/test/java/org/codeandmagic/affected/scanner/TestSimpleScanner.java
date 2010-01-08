package org.codeandmagic.affected.scanner;

import junit.framework.TestCase;
import org.codeandmagic.affected.scanner.impl.SimpleTagScanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class TestSimpleScanner extends TestCase {
    private SimpleTagScanner simpleScanner;
    private String input;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        simpleScanner = new SimpleTagScanner();
        BufferedReader reader = new BufferedReader(new InputStreamReader(TestSimpleScanner.class.getResourceAsStream("TestSimpleScanner.txt")));
        input = "";
        String line = null;
        while ((line = reader.readLine()) != null) {
            input += line;
        }
    }

    public void testRegex() {
        List<String> result = simpleScanner.scan(input);
        System.out.println(result);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("ComponentA", result.get(0));
        assertEquals("ComponentB", result.get(1));
        assertEquals("ComponentC", result.get(2));
    }
}
