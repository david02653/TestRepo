package ntou.cs.java.mask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// References: https://gist.github.com/arnaudroger/7cbb9ca1acda66341fc10bf54ab01439

/**
 * This class can help you to read and parse json file.
 * <br>
 * <strong>GSON</strong> library is required.
 * <p>
 *     There are four methods in this class.
 *     <br>
 *     References: https://gist.github.com/arnaudroger/7cbb9ca1acda66341fc10bf54ab01439
 * </p>
 * <h2>Note</h2>
 * This class is from Exercise 1
 * <br>
 * check {@link ntou.cs.java.mask.MaskJsonHandlerTest} if you are looking for test class.
 * <br>
 *
 * @see ntou.cs.java.mask.MaskJsonHandlerTest
 * @see ntou.cs.java.mask.Pharmacy
 *
 * @author me
 * @version 1.0.1
 */

public class MaskJsonHandler {

	/**
	 * jsonFileName - target json file name/path
	 */
	private static String jsonFileName = "mask.json";
	/**
	 * pharmacyList - this List will store pharmacy data read from json file
	 */
	private List<Pharmacy> pharmacyList;

	/**
	 * This method will read json file and return content in <strong>String</strong> type
	 * @param fileName your json file name
	 * @return content in the json file
	 * @throws IOException throw IOException if something goes wrong when file read in
	 */
	public String produceStringFromFile(String fileName) throws IOException {
		InputStream is = new FileInputStream(fileName);
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();
		while (line != null) {
			sb.append(line).append("\n");
			line = buf.readLine();
		}
		buf.close();
		return sb.toString();
	}

	/**
	 * This method will convert json data(String type) in to a List of Pharmacy
	 * @param jsonData your json data in String type
	 * @return result List of Pharmacy
	 */
	public List<Pharmacy> convertToObjects(String jsonData) {

		/* create conflict */
		Gson gson = new Gson();
		ArrayList<Pharmacy> clinicList = new ArrayList<Pharmacy>();

		try {
			Type listType = new TypeToken<List<Pharmacy>>() {
			}.getType();
			clinicList = gson.fromJson(jsonData, listType);
		} catch (Exception e) {
			System.err.println("Exception: " + e);
		}
		return clinicList;
	}

	/**
	 * This method help you to find search result of what you wants to query.<br>
	 * You need pharmacy keyword and address in this method
	 * @param queryName pharmacy keyword
	 * @param queryAddress pharmacy address
	 * @return query result
	 */
	public List<Pharmacy> findPharmacies(String queryName, String queryAddress) {
		List<Pharmacy> matchingElements = pharmacyList.stream().filter(
				str -> str.getName().trim().contains(queryName) && str.getAddress().trim().contains(queryAddress))
				.collect(Collectors.toList());

		return matchingElements;
	}

	/**
	 * Initialize this class, including read json file and convert it into List of Pharmacy
	 * @throws IOException throw error if something goes wrong
	 */
	public void initialize() throws IOException {

		String maskDataJson = produceStringFromFile(jsonFileName);
		pharmacyList = convertToObjects(maskDataJson);
	}

}
