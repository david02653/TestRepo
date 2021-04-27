package ntou.cs.java.mask;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class MaskJsonHandlerTest {
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
