package ch.fankib.sendmail.template.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ch.fankib.sendmail.model.Model;
import ch.fankib.sendmail.template.Variable;

/**
 * 
 * Uses a StringVariable with the lazy loaded input of a given file
 * 
 * @author beni
 *
 */
public class FileVariable implements Variable {

	private File file;
	private StringVariable stringVariable;

	public FileVariable(File file) {
		this.file = file;
	}

	private StringVariable getInternVariable() {
		if (stringVariable == null) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(file));
				String line;
				List<String> lines = new ArrayList<>();
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}
				stringVariable = new StringVariable(lines.stream().collect(Collectors.joining("\n")));
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return stringVariable;
	}

	@Override
	public String getValue(Model model) {
		return getInternVariable().getValue(model);
	}

}
