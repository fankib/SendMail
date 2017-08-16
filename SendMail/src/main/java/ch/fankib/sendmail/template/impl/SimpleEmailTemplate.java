/* 
 * Copyright E-Voting Group BFH, Bern University of Applied Sciences
 * Exclusively licensed to Valuetainment AG
 */
package ch.fankib.sendmail.template.impl;

import javax.mail.Message.RecipientType;

import org.simplejavamail.email.Email;

import ch.fankib.sendmail.model.Model;
import ch.fankib.sendmail.template.EmailTemplate;
import ch.fankib.sendmail.template.Variable;

/**
 * This is the most basic email template with the following fields:
 * 
 * <pre>
 * 	- from: the name where the email comes from
 *  - fromAddress: the email address where the email comes from
 *  - to: the name of the reciepient
 *  - toAddress: the email address of the reciepient
 *  - subject: the subject
 *  - body: the plain text body
 * </pre>
 * 
 * Put one {@link Variable} in each field and you are fine
 * 
 * @author fsb1
 *
 */
public class SimpleEmailTemplate implements EmailTemplate {

	private Variable from;
	private Variable fromAddress;
	private Variable to;
	private Variable toAddress;

	private Variable subject;
	private Variable body;

	public Email build(Model model) {
		Email email = new Email();

		email.setFromAddress(from.getValue(model), fromAddress.getValue(model));
		email.setReplyToAddress(from.getValue(model), fromAddress.getValue(model));

		email.addRecipient(to.getValue(model), toAddress.getValue(model), RecipientType.TO);

		email.setSubject(subject.getValue(model));
		email.setText(body.getValue(model));

		return email;
	}

	public Variable getFrom() {
		return from;
	}

	public void setFrom(Variable from) {
		this.from = from;
	}

	public Variable getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(Variable fromAddress) {
		this.fromAddress = fromAddress;
	}

	public Variable getTo() {
		return to;
	}

	public void setTo(Variable to) {
		this.to = to;
	}

	public Variable getToAddress() {
		return toAddress;
	}

	public void setToAddress(Variable toAddress) {
		this.toAddress = toAddress;
	}

	public Variable getSubject() {
		return subject;
	}

	public void setSubject(Variable subject) {
		this.subject = subject;
	}

	public Variable getBody() {
		return body;
	}

	public void setBody(Variable body) {
		this.body = body;
	}

}
