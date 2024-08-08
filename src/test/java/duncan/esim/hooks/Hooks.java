package duncan.esim.hooks;

import java.util.HashMap;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private HashMap<String, Object> context;

	public Hooks(HashMap<String, Object> context) {
		this.context = context;
	}

	@Before(value = "@Browser", order = 99)
	public void beforeScenario() {
		
	}

	@After(value = "@Browser", order = 1)
	public void afterScenario() {
		
	}
}