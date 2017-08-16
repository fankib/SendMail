/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.fankib.sendmail.template;

import java.util.List;

import org.simplejavamail.email.Email;

import ch.fankib.sendmail.model.Model;

public interface EmailBuilder {

	List<Email> build(EmailTemplate template, Model model);

}
