import java.util.*;

public class GeneratingParkingLot {

	private List<ParkingDetails> parkingLot;
	
	GeneratingParkingLot(){
		List<ParkingDetails> list = new ArrayList<ParkingDetails>();
		
		// Generate Parking Lots
		for (int i = 65; i <= 89; i++) {
			ParkingDetails parkingDetails = new ParkingDetails();
			List<SlotDetails> listSlotDetails = new ArrayList<SlotDetails>(5);
			for (int j = 1; j <= 5; j++) {
				listSlotDetails.add(new SlotDetails());
			}
			parkingDetails.setPlaceForVehicle(listSlotDetails);
			parkingDetails.setLotName((char) (i) + "");
			list.add(parkingDetails);
		}

		this.setParkingLot(list);
	}

	public List<ParkingDetails> getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(List<ParkingDetails> parkingLot) {
		this.parkingLot = parkingLot;
	}

}
