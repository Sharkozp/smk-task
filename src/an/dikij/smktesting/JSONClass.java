package an.dikij.smktesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONClass {
	private ConnectionClass con;

	public JSONClass() {
		con = new ConnectionClass();
	}

	public List<Map<String, Object>> getProducts(String api) {
		List<Map<String, Object>> listOfProducts = new ArrayList<Map<String, Object>>();
		try {
			JSONArray json = new JSONArray(con.connect(api));
			for (int i = 0; i < json.length(); i++) {
				Map<String, Object> pm = new HashMap<String, Object>();
				JSONObject object = json.getJSONObject(i);
				pm.put("id", object.getInt("id"));
				pm.put("img", con.getImage(object.getString("img")));
				pm.put("text", object.getString("text"));
				pm.put("title", object.getString("title"));
				listOfProducts.add(pm);
			}
		} catch (JSONException e) {
			Log.e("ME", e.toString());
		}
		return listOfProducts;
	}

}
