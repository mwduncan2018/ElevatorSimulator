package duncan.esim.steps;

import java.util.HashMap;

import org.testng.Assert;

import duncan.esim.ElevatorSimulator;
import io.cucumber.java8.En;

public class TotalTravelTimeSteps implements En {
	HashMap<String, Object> context;
	
	public TotalTravelTimeSteps(HashMap<String, Object> context) {
		this.context = context;

		Then("the total travel time is {int}", (Integer totalTravelTime) -> {
			ElevatorSimulator elevatorSimulator = (ElevatorSimulator) context.get("elevatorSimulator");
			Assert.assertEquals(Integer.valueOf(elevatorSimulator.getTravelTime()), totalTravelTime);
		});
		
		Then("the total travel time is", (String totalTravelTime) -> {
			ElevatorSimulator elevatorSimulator = (ElevatorSimulator) context.get("elevatorSimulator");
			Assert.assertEquals(Integer.valueOf(elevatorSimulator.getTravelTime()), Integer.valueOf(totalTravelTime));
		});
	}
}