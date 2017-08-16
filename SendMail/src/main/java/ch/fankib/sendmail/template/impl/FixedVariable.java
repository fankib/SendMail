/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.fankib.sendmail.template.impl;

import ch.fankib.sendmail.model.Model;
import ch.fankib.sendmail.template.Variable;

/**
 * This is a fixed Variable aka String
 * 
 * @author fsb1
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
