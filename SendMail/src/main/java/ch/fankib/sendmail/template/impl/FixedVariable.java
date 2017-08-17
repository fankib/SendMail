package ch.fankib.sendmail.template.impl;

import ch.fankib.sendmail.model.Model;
import ch.fankib.sendmail.template.Variable;

/**
 * This is a fixed Variable aka String
 * 
 * @author beni
 *
 */
public class FixedVariable implements Variable {

	private String value;

	public FixedVariable(String value) {
		this.value = value;
	}

	public String getValue(Model model) {
		return value;
	}

}
