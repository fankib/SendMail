/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.fankib.sendmail.model.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import ch.fankib.sendmail.model.Model;

public class CsvModel implements Model {

	private Iterator<CSVRecord> recordIterator;
	private CSVRecord record;

	public CsvModel(Reader in) throws IOException {
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		recordIterator = records.iterator();
	}

	public String getValue(String key) {
		return record.get(key);
	}

	public boolean hasNext() {
		return recordIterator.hasNext();
	}

	public void next() {
		record = recordIterator.next();
	}

}
