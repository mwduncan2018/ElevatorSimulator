package duncan.esim.steps;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.testng.Assert;

import duncan.esim.ElevatorSimulator;
import io.cucumber.java8.En;

public class FloorsVisitedSteps implements En {
	HashMap<String, Object> context;

	public FloorsVisitedSteps(HashMap<String, Object> context) {
		this.context = context;
		
		Then("the floors visited in order are {string}", (String floorsVisited) -> {
			ElevatorSimulator elevatorSimulator = (ElevatorSimulator) context.get("elevatorSimulator");
			Assert.assertEquals(
					elevatorSimulator.getFloorHistory().stream().map(x -> String.valueOf(x)).collect(Collectors.joining(",")),
					floorsVisited);
		});
	}

}
