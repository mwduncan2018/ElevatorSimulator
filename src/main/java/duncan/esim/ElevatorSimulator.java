package duncan.esim;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSimulator {
	
	static final int SINGLE_FLOOR_TRAVEL_TIME = 10;
	int currentFloor;
	List<Integer> floorHistory;

	public List<Integer> getFloorHistory() {
		return floorHistory;
	}
	
	public int getTravelTime() {
		int travelTime = 0;
		for (int i = 0; i < floorHistory.size()-1; i++) {
			travelTime = travelTime + Math.abs(floorHistory.get(i) - floorHistory.get(i+1));
		}
		return travelTime * SINGLE_FLOOR_TRAVEL_TIME;
	}

	public ElevatorSimulator(int startFloor) {
		floorHistory = new ArrayList<Integer>();
		moveToFloor(startFloor);
	}
	
	public void moveToFloor(int floor) {
		this.currentFloor = floor;
		floorHistory.add(currentFloor);
	}
}