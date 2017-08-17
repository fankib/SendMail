package ch.fankib.sendmail.template.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.fankib.sendmail.model.Model;
import ch.fankib.sendmail.template.Variable;

/**
 * Use the template like "static text {var1}" and the model is used to replace
 * {var1}
 * 
 * @author beni
 *
 */
public class StringVariable implements Variable {

	private static final Pattern KEY_PATTERN = Pattern.compile("\\{.*?\\}");

	private String template;
	private Set<String> keys = new HashSet<String>();

	public StringVariable(String template) {
		this.template = template;
		Matcher matcher = KEY_PATTERN.matcher(template);
		while (matcher.find()) {
			keys.add(template.substring(matcher.start() + 1, matcher.end() - 1));
		}
	}

	public String getValue(Model model) {
		String result = this.template;
		for (String key : keys) {
			result = result.replace("{" + key + "}", model.getValue(key.trim()));
		}
		return result;
	}

}
