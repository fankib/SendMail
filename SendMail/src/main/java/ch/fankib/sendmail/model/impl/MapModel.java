/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.fankib.sendmail.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ch.fankib.sendmail.model.Model;

public class MapModel implements Model {

	private List<Map<String, String>> entries = new ArrayList<Map<String, String>>();
	private int index = -1;

	public void addEntry(Map<String, String> entry) {
		entries.add(entry);
	}

	public String getValue(String key) {
		return entries.get(index).get(key);
	}

	public boolean hasNext() {
		return index + 1 < entries.size();
	}

	public void next() {
		index++;
	}

}
