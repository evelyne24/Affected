/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *   
 * This file is part of Affected.
 *   
 * Affected is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *   
 * Affected is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied   warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU Lesser General Public License for more details.
 *   
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
package org.codeandmagic.affected.scanner;

import junit.framework.TestCase;

import org.codeandmagic.affected.scanner.SimpleTagScanner;

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
