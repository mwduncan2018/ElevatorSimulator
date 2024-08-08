package duncan.esim.steps;

import java.util.HashMap;

import duncan.esim.ElevatorSimulator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SharedSteps {
	HashMap<String, Object> context;
	
	public SharedSteps(HashMap<String, Object> context) {
		this.context = context;
	}

	@Given("the elevator starts on {int}")
	public void the_elevator_starts_on_v1(Integer startFloor) {
		ElevatorSimulator elevatorSimulator = new ElevatorSimulator(startFloor);
		context.put("elevatorSimulator", elevatorSimulator);
	}

	@Given("the elevator starts on")
	public void the_elevator_starts_on_v2(String startFloor) {
		the_elevator_starts_on_v1(Integer.valueOf(startFloor));
	}
	
	@When("the elevator moves to {int}")
	public void the_elevator_moves_to_v1(Integer floor) {
		ElevatorSimulator elevatorSimulator = (ElevatorSimulator) context.get("elevatorSimulator");
		elevatorSimulator.moveToFloor(floor);
	}
	
	@When("the elevator moves to")
	public void the_elevator_moves_to_v2(String floor) {
		the_elevator_moves_to_v1(Integer.valueOf(floor));
	}
	
}
