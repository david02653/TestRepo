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

public class MaskJsonHandler {

	private static String jsonFileName = "mask.json";
	private List<Pharmacy> pharmacyList;

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

	public List<Pharmacy> convertToObjects(String jsonData) {

		/* no more error ! */
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

	public List<Pharmacy> findPharmacies(String queryName, String queryAddress) {
		List<Pharmacy> matchingElements = pharmacyList.stream().filter(
				str -> str.getName().trim().contains(queryName) && str.getAddress().trim().contains(queryAddress))
				.collect(Collectors.toList());

		return matchingElements;
	}

	public void initialize() throws IOException {

		String maskDataJson = produceStringFromFile(jsonFileName);
		pharmacyList = convertToObjects(maskDataJson);
	}

}
