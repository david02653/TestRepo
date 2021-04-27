package ntou.cs.java.mask;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;

/**
 * Test class of MaskJsonHandler.
 *
 * @see ntou.cs.java.mask.MaskJsonHandler
 * @see ntou.cs.java.mask.Pharmacy
 *
 * @author me
 * @version 1.0.1
 */
public class MaskJsonHandlerTest {
	/**
	 * start point of this class. <br>
	 * query for pharmacy with key word and address.
	 * @param args parameter when using command line, unused
	 */
	public static void main(String[] args) {
		String zone = "";
		String keyword = "";
		Scanner input;
		
		try {
			MaskJsonHandler handler = new MaskJsonHandler();
			handler.initialize();
			List<Pharmacy> filteredClinicList = handler.findPharmacies("新豐活力", "基隆");
			System.out.println(filteredClinicList.get(0));	
			System.out.println();
			
			// Code Here
			
		} catch (IOException | IndexOutOfBoundsException e) {
			System.err.println("Error: " + e);
		}
	}
}
