package ch.fankib.sendmail.template;

import org.simplejavamail.email.Email;

import ch.fankib.sendmail.model.Model;

public interface EmailTemplate {

	Email build(Model model);

}
