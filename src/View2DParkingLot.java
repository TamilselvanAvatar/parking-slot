import java.util.List;
import java.util.Set;

public class View2DParkingLot {

	public static void view(Set<String> set) {
		List<ParkingDetails> pd = Main.parkingLot.getParkingLot();
		System.out.println("2D View");
		// First Line of the View :
		for (int j = 0; j <= 5; j++) {
			if (j == 0) {
				System.out.printf("\t");
			} else {
				System.out.printf("%d\t", j);
			}

			if (j == 5) {
				System.out.printf("\n");
			}
		}
		/**
		 * Rest of the View : Remove of first for loop and if condition will result in
		 * whole parking lot with status
		 */

		// View Specified View
		for (int i = 0; i < set.size(); i++) {
			for (int j = 0; j < pd.size(); j++) {
				List<SlotDetails> sd = pd.get(i).getPlaceForVehicle();
				String name = pd.get(j).getLotName();
				if (set.contains(name)) {
					for (int k = -1; k < sd.size(); k++) {
						if (k == -1) {
							System.out.printf("%s\t", name);
						} else {
							System.out.printf("%s\t", sd.get(k).getFlag());
						}
						if (k == sd.size() - 1) {
							System.out.printf("\n");
						}
					}
				}
			}
		}
	}
}
