package org.codeandmagic.affected.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple implementation of {@link TagScanner} that only looks for the string
 * "@affects", followed by a comma or semicolon separated list of component
 * names, enclosed in square brackets
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
			endMatcher = endMatcher
					.region(startMatcher.start(), input.length());

			// find the end of the list
			if (endMatcher.find()) {
				Matcher contentMatcher = this.contentPattern.matcher(input);
				contentMatcher = contentMatcher.region(startMatcher.start(),
						endMatcher.start());
				List<String> results = new ArrayList<String>();

				// add the found tag to the list
				while (contentMatcher.find()) {
					String partialResult = contentMatcher.group().trim();
					partialResult = partialResult.substring(0,
							partialResult.length() - 1).trim();
					results.add(partialResult);
				}
				// add the tag
				results.add(endMatcher.group().substring(0,
						endMatcher.group().length() - 1).trim());
				return results;
			}
		}
		return null;
	}

}
