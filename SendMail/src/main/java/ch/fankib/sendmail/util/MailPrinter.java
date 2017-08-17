package ch.fankib.sendmail.util;

import java.util.List;
import java.util.stream.Collectors;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.Recipient;

/**
 * Prints the first
 * 
 * @author beni
 *
 */
public class MailPrinter {

	public void print(Email email) {
		System.out.println(String.format("~~~ Message to %s ~~~", names(email.getRecipients())));
		System.out.println(email.getText());
	}

	private Object names(List<Recipient> recipients) {
		return recipients.stream().map(Recipient::getName).collect(Collectors.joining(", "));
	}

}
