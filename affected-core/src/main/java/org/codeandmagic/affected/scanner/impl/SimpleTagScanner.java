/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *
 * This file is part of Affected.
 *
 * Affected is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Affected is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package org.codeandmagic.affected.scanner.impl;

import org.codeandmagic.affected.scanner.api.TagScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple implementation of {@link TagScanner} that only looks for the string "@affects", followed
 * by a comma or semicolon separated list of component names, enclosed in square brackets
 */
public class SimpleTagScanner implements TagScanner {

    public static final String SEPARATORS = "[,;]";
    public static final String TAG = "(\\s)*(\\w)+(\\s)*"; // (\\s)*[^\\s]*(\\s)*

    // TODO allow empty list
    // TODO make a dictionary, with configurable tag names
    public static final String START = "@(affect)?(affects)?(affected)?(\\s)*(:)?(\\s)*\\[";
    public static final String CONTENT = TAG + "[" + SEPARATORS + "]";
    public static final String END = TAG + "\\]";

    private final Pattern startPattern;
    private final Pattern contentPattern;
    private final Pattern endPattern;

    public SimpleTagScanner() {
        this.startPattern = Pattern.compile(START);
        this.contentPattern = Pattern.compile(CONTENT);
        this.endPattern = Pattern.compile(END);
    }

    public List<String> scan(String input) {
        Matcher startMatcher = this.startPattern.matcher(input);

        // find the start of the searched tags
        if (startMatcher.find()) {
            Matcher endMatcher = this.endPattern.matcher(input);
            endMatcher = endMatcher.region(startMatcher.start(), input.length());

            // find the end of the list
            if (endMatcher.find()) {
                Matcher contentMatcher = this.contentPattern.matcher(input);
                contentMatcher = contentMatcher.region(startMatcher.start(), endMatcher.start());
                List<String> results = new ArrayList<String>();

                // add the found tag to the list
                while (contentMatcher.find()) {
                    String partialResult = contentMatcher.group().trim();
                    partialResult = partialResult.substring(0, partialResult.length() - 1).trim();
                    results.add(partialResult);
                }
                // add the tag
                results.add(endMatcher.group().substring(0, endMatcher.group().length() - 1).trim());
                return results;
            }
        }
        return null;
    }

}
