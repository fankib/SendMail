package ch.beni.sendmail.impl;

import org.junit.Assert;
import org.junit.Test;

import ch.fankib.sendmail.model.Model;
import ch.fankib.sendmail.template.Variable;
import ch.fankib.sendmail.template.impl.StringVariable;

public class VariableImplTest {

	private Model model = new ModelAdapter() {

		@Override
		public String getValue(String key) {
			if (key.equals("key1")) {
				return "foo";
			}
			if (key.equals("key2")) {
				return "bar";
			}
			throw new IllegalArgumentException(key);
		}

	};

	@Test
	public void testOneKey() {
		Variable var = new StringVariable("this is {key1}");
		Assert.assertEquals("this is foo", var.getValue(model));
	}

	@Test
	public void testOneKeyWithSpaces() {
		Variable var = new StringVariable("this is { key1 }");
		Assert.assertEquals("this is foo", var.getValue(model));
	}

	@Test
	public void testTwoKey() {
		Variable var = new StringVariable("this is {key1} and {key2}");
		Assert.assertEquals("this is foo and bar", var.getValue(model));
	}

	@Test
	public void testSameKey() {
		Variable var = new StringVariable("this is {key1} and {key1}!");
		Assert.assertEquals("this is foo and foo!", var.getValue(model));
	}

}
