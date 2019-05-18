/*package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class JSONDataParser {

	public static HashMap<String, Double[]> landmarkFileParser(final String fileName) {
		HashMap<String, Double[]> landmarkMap = new HashMap<String, Double[]>();
		try {
			JSONObject jo = (JSONObject) new JSONParser().parse(new FileReader(fileName));

			JSONObject landmarkObject = (JSONObject) jo.get("landmarks");

			Object[] landmarks = landmarkObject.keySet().toArray();

			for (int i = 0; i < landmarks.length; i++) {
				String landmarkName = landmarks[i].toString();
				JSONObject coorObj = (JSONObject) landmarkObject.get(landmarkName);
				String x = (coorObj.get("x").toString());
				String y = (coorObj.get("y").toString());
				String theta = (coorObj.get("theta").toString());
				Double[] coor = new Double[] { new Double(x), new Double(y), new Double(theta) };

				landmarkMap.put(landmarkName, coor);
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return landmarkMap;

	}

	public static LinkedHashMap<String, Config> getConfigFromJSON(final String fileName) {
		LinkedHashMap<String, Config> configMap = new LinkedHashMap<String, Config>(16, (float) 0.75, true);
		try {
			JSONObject jo = (JSONObject) new JSONParser().parse(new FileReader(fileName));
			Object[] configNames = jo.keySet().toArray(new String[jo.keySet().size()]);

			for (int i = configNames.length - 1; i >= 0; i--) {
				String key = configNames[i].toString();
				JSONObject configObj = (JSONObject) jo.get(key);
				double dt = Double.parseDouble(configObj.get("dt").toString());
				double vel = Double.parseDouble(configObj.get("maxVel").toString());
				double acc = Double.parseDouble(configObj.get("maxAcc").toString());
				double jerk = Double.parseDouble(configObj.get("maxJerk").toString());
				double wheelbase = Double.parseDouble(configObj.get("wheelbaseWidth").toString());
//				Config config = new Config(dt, vel, acc, jerk, wheelbase);
//				configMap.put(key, config);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Add the config.json file to path");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return configMap;
	}

	public static void writeConfigToJSON(LinkedHashMap<String, Config> configMap, String fileName) {
		JSONObject obj = new JSONObject();

		Object[] keySet = configMap.keySet().toArray();
		for (int i = keySet.length - 1; i >= 0; i--) {
			String key = keySet[i].toString();
			Config config = configMap.get(key);

			JSONObject subObj = new JSONObject();
			subObj.put("dt", config.dt);
			subObj.put("maxVel", config.max_vel);
			subObj.put("maxAcc", config.max_acc);
			subObj.put("maxJerk", config.max_jerk);
			subObj.put("wheelbaseWidth", config.wheelbase_width);

			obj.put(keySet[i], subObj);
		}

		try (FileWriter file = new FileWriter(fileName)) {
			file.write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] a) {
//		landmarkFileParser("C:\\Users\\DELL\\eclipse-workspace\\JavaFXPathGenerator\\src\\landmarks.json");
//	}
}
*/