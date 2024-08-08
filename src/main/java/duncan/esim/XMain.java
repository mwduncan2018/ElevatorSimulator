package duncan.esim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class XMain {
	static Integer startFloor;
	static List<Integer> floorsToVisit;

	public static void main(String[] args) {
		printInstructions();
		processInput();
		
		ElevatorSimulator elevatorSimulator = new ElevatorSimulator(startFloor);
		floorsToVisit.forEach(floor -> elevatorSimulator.moveToFloor(floor));
		
		System.out.println("Outputs: " + 
							elevatorSimulator.getTravelTime() + " " + 
							elevatorSimulator.getFloorHistory().stream().map(
									x -> String.valueOf(x)).collect(Collectors.joining(",")));
	}
	
	static void printInstructions() {
		System.out.println("The input must be 'elevator start=', the start floor, a space, 'floor=', and a comma-delimited list of floors visited.");
		System.out.println("Here is example input: elevator start=12 floor=2,9,1,32\n");
	}
	
	static void processInput() {
		while (true) {
			System.out.print("Inputs: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				String line = reader.readLine();
				if(Pattern.compile("^elevator start=[0-9]+ floor=[0-9]+(,[0-9]+)*$").matcher(line).find()) {
					Scanner scan = new Scanner(line);
					scan.next();
					startFloor = Integer.valueOf(scan.next().split("=")[1]);
					floorsToVisit = Arrays.asList(scan.next().split("=")[1].split(",")).stream().map(x -> Integer.valueOf(x)).toList();
					scan.close();
					return;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("There was a problem with the input.\n");
			printInstructions();			
		}
	}

	
}
