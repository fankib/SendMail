/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.fankib.sendmail.model;

public interface Model {

	public String getValue(String key);

	public boolean hasNext();

	public void next();

}
