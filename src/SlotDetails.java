
public class SlotDetails {

	private int[] Number;
	private String[] date;
	private String[] typeOfVehicle;
	private Flag flag;

	public SlotDetails() {
		this.flag = Flag.O;
	}

	public int[] getNumber() {
		return Number;
	}

	public void setNumber(int[] number) {
		Number = number;
	}

	public String[] getDate() {
		return date;
	}

	public void setDate(String[] date) {
		this.date = date;
	}

	public String[] getTypeOfVehicle() {
		return typeOfVehicle;
	}

	public void setTypeOfVehicle(String[] typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

}
