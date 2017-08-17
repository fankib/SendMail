package ch.fankib.sendmail.model;

public interface Model {

	public String getValue(String key);

	public boolean hasNext();

	public void next();

}
