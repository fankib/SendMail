/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.beni.sendmail;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.simplejavamail.email.Email;

import ch.fankib.sendmail.model.impl.MapModel;
import ch.fankib.sendmail.template.EmailBuilder;
import ch.fankib.sendmail.template.impl.FixedVariable;
import ch.fankib.sendmail.template.impl.DefaultEmailBuilder;
import ch.fankib.sendmail.template.impl.SimpleEmailTemplate;
import ch.fankib.sendmail.template.impl.StringVariable;

public class SendMailTest {

	@Test
	public void integrationTest() {

		MapModel model = new MapModel();
		addRow(model, "benjamin.xxx@bfh.com", "electionId", "Hallo", "Beni", "Axid");
		addRow(model, "nimajneb_xxx@mail.com", "electionId", "Guten Tag", "nimajneb", "xxx");

		SimpleEmailTemplate template = new SimpleEmailTemplate();
		template.setFrom(new FixedVariable("testvote"));
		template.setFromAddress(new FixedVariable("no-reply@bfh.ch"));
		template.setTo(new StringVariable("{email}"));
		template.setToAddress(new StringVariable("{email}"));
		template.setSubject(new StringVariable("Zugangsdaten der Wahl {electionId}"));
		template.setBody(new StringVariable(//
				"Guten Tag {name}, \n" //
						+ "\n" //
						+ "Die Wahlen stehen an! \n" //
						+ "\n" //
						+ "Ihre Zugangsdaten sind: \n" //
						+ "URL: http://voting.ch/{electionId}\n" //
						+ "PIN: {pin} \n" //
						+ "\n" //
						+ "Freundliche Gruesse \n"//
						+ "e-Voting"));

		EmailBuilder builder = new DefaultEmailBuilder();
		List<Email> emails = builder.build(template, model);

		for (Email email : emails) {
			System.out.println(email);
		}

		Assert.assertEquals(2, emails.size());
		Assert.assertEquals("benjamin.xxx@bfh.com", emails.get(0).getRecipients().get(0).getAddress());
		Assert.assertEquals("nimajneb_xxx@mail.com", emails.get(1).getRecipients().get(0).getAddress());
	}

	private void addRow(MapModel model, String email, String electionId, String anrede, String name, String pin) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put("email", email);
		row.put("electionId", electionId);
		row.put("name", name);
		row.put("pin", pin);
		model.addEntry(row);
	}

}
