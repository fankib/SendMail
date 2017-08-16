/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.fankib.sendmail.template;

import ch.fankib.sendmail.model.Model;

public interface Variable {

	public String getValue(Model model);

}
