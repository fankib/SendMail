package ch.beni.sendmail.impl;

import ch.fankib.sendmail.model.Model;

public class ModelAdapter implements Model {

	@Override
	public String getValue(String key) {
		return null;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void next() {
	}

}
