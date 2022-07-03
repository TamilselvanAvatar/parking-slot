import java.util.*;
import java.io.*;
import java.text.ParseException;

public class Main {
	static GeneratingParkingLot parkingLot;
	
	static Map<String,Integer> price = Map.of(
			"CAR",50,
			"BIKE",10,
			"CYCLE",6
			); // Price is in the unit of per hour

	public static void main(String[] args) throws IOException, ParseException {
		
		parkingLot = new GeneratingParkingLot();
		Set<String> view = new LinkedHashSet<String>();
		//Receive the input file
		File file = new File("F:\\WorkspaceForEclipse\\ParkingApplication\\input.txt");
		String st;
		List<String[]> inputData = new ArrayList<>();
		if (file.exists()) {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				String[] str = st.split(",");
				inputData.add(str);
			}
		} else {
			for (String str : args) {
				System.out.println(str);
				inputData.add(str.split(","));
			}
		}
		// Process the input file
		for (String[] str : inputData) {
			if (str[0].equals("1")) {
				String output = ProcessForParking.checkIn(str[1], str[2], str[3], str[4]);
				view.add(str[4]);
				System.out.println(output);
			}
			if (str[0].equals("2")) {
				String output = ProcessForParking.checkOut(str[1], str[2]);
				System.out.println(output);
			}
			if (str[0].equals("3")) {
				String output = ProcessForParking.vehicleSearch(str[1]);
				System.out.println(output);
			}
		}
		//View the Parking Lot in 2D
		View2DParkingLot.view(view);
	}	
}
