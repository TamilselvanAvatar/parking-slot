import java.util.List;

public class ParkingDetails {

	private String lotName;
	private List<SlotDetails> placeForVehicle;

	public String getLotName() {
		return lotName;
	}

	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	public List<SlotDetails> getPlaceForVehicle() {
		return placeForVehicle;
	}

	public void setPlaceForVehicle(List<SlotDetails> placeForVehicle) {
		this.placeForVehicle = placeForVehicle;
	}

}
