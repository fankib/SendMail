/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.fankib.sendmail.template.impl;

import java.util.ArrayList;
import java.util.List;

import org.simplejavamail.email.Email;

import ch.fankib.sendmail.model.Model;
import ch.fankib.sendmail.template.EmailBuilder;
import ch.fankib.sendmail.template.EmailTemplate;

/**
 * The default implementation of a EmailBuilder: it builds every email and
 * collects them in a list.
 * 
 * @author fsb1
 *
 */
public class SimpleEmailBuilder implements EmailBuilder {

	public List<Email> build(EmailTemplate template, Model model) {
		List<Email> result = new ArrayList<Email>();
		while (model.hasNext()) {
			model.next();
			result.add(template.build(model));
		}
		return result;
	}

}
