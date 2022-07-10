import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProcessForParking {

	public static String checkOut(String num, String exitDate) throws ParseException {
		for (int j = 0; j < 23; j++) {
			ParkingDetails pd = Main.parkingLot.getParkingLot().get(j);
			for (int k = 0; k < pd.getPlaceForVehicle().size(); k++) {
				SlotDetails sd = pd.getPlaceForVehicle().get(k);
				try {
					for(int i = 0 ; i < sd.getNumber().length ; i++) {
						if (sd.getNumber()[i] == Integer.parseInt(num)) {
							String type = sd.getTypeOfVehicle()[i];
							String name = pd.getLotName();
							String startDate = sd.getDate()[i];
							pd.getPlaceForVehicle().set(k , new SlotDetails());
							
							/*
							 * // This below code can be changed as above code.
							 * pd.getPlaceForVehicle().get(k).setTypeOfVehicle("");
							 * pd.getPlaceForVehicle().get(k).setDate("");
							 * pd.getPlaceForVehicle().get(k).setNumber(0);
							 * pd.getPlaceForVehicle().get(k).setFlag(Flag.O);
							 */
							
							String str = "Success:Vehicle (" + type + "," + num + ") is available in " + name + (k + 1);
							return str + ". " + getAmount(exitDate, startDate, type);
						}
					}	
				} catch (Exception e) {
					// Catch NullPointerException
				}
			}
		}

		return "Failure:Vehicle(" + num + ") is not available.";
	}

	public static String vehicleSearch(String num) {

		for (int j = 0; j < 23; j++) {
			ParkingDetails pd = Main.parkingLot.getParkingLot().get(j);
			for (int k = 0; k < pd.getPlaceForVehicle().size(); k++) {
				SlotDetails sd = pd.getPlaceForVehicle().get(k);
				try {
					for(int i = 0 ; i < sd.getNumber().length ; i++) {
						if (sd.getNumber()[i] == Integer.parseInt(num)) {
							return "Success:Vehicle (" + sd.getTypeOfVehicle()[i] + "," + num + ") is available in "
									+ pd.getLotName() + (k + 1) + ". ";
						}					
					}	
				} catch(Exception e) {
					// Catch the NullPointerException
				}
			}
		}

		return "Failure:Vehicle(" + num + ") is not available.";
	}

	public static String checkIn(String num, String type, String date, String slot) {

		for (int j = 0; j < 23; j++) {
			ParkingDetails pd = Main.parkingLot.getParkingLot().get(j);
			if (slot.equals(pd.getLotName())) {
				for (int k = 0; k < pd.getPlaceForVehicle().size(); k++) {
					SlotDetails sd = pd.getPlaceForVehicle().get(k);
					if (sd.getFlag() == Flag.O && type.toUpperCase().equals("CAR")) {
						int[] Number = {Integer.parseInt(num)} ;
						String[] Date = {date};
						String[] Type = {type.toUpperCase()};
						sd.setNumber(Number);
						sd.setDate(Date);
						sd.setTypeOfVehicle(Type);
						sd.setFlag(Flag.X);
						return "Success:Vehicle parked at " + slot + (k + 1);
					}
					if (sd.getFlag() != Flag.X && (type.toUpperCase().equals("BIKE") || type.toUpperCase().equals("CYCLE") )) {
						
						// In Car Space
						if(j < 9) {
							
						}
						
						if (j >= 9 && j < 17) {
							
						}
						
						int[] Number = {Integer.parseInt(num)} ;
						String[] Date = {date};
						String[] Type = {type.toUpperCase()};
						sd.setNumber(Number);
						sd.setDate(Date);
						sd.setTypeOfVehicle(Type);
						sd.setFlag(Flag.P);
						return "Success:Vehicle parked at " + slot + (k + 1);
					}
				}
			}
		}
		return "Failure:Lot \'" + slot + "\' is full";
	}

	private static String getAmount(String exitDate, String enterDate, String typeOfVehicle) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy h:mm a");
		Date exD = format.parse(exitDate);
		Date enD = format.parse(enterDate);
		long totalInTime = exD.getTime() - enD.getTime();
		long totalSecs = TimeUnit.MILLISECONDS.toSeconds(totalInTime);
		double amount = (totalSecs / 3600.0) * Main.price.get(typeOfVehicle);
		// (totalSecs%3600)/60 -> Understand the Modulus => Here Modulus seconds will
		// convert to minutes
		// (totalSecs/3600) -> Covert Seconds to Hours (in Whole Number even it has
		// Minutes because of java)
		return "Total duration : " + (totalSecs / 3600) + " hours " + (totalSecs % 3600) / 60 + " mintues."
				+ "Amount to be paid Rs:" + (int) amount;
	}

}
