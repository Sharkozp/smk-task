package an.dikij.smktesting.system;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import an.dikij.smktesting.tasks.LoadProductDescTask;
import an.dikij.smktesting.tasks.LoadProductImageTask;
import android.graphics.Bitmap;
import android.util.Log;

public class JSONClass {
	private LoadProductDescTask productDeskTask;
	private LoadProductImageTask productImageTask;

	public List<Product> getProducts(String api) {
		List<Product> listOfProducts = new ArrayList<Product>();
		productDeskTask = new LoadProductDescTask();
		productDeskTask.execute(api);
		JSONArray json = null;
		try {
			json = new JSONArray(productDeskTask.get());

			for (int i = 0; i < json.length(); i++) {
				JSONObject object = json.getJSONObject(i);
				listOfProducts.add(new Product(object.getInt("id"),
						getImageOfProduct(object.getString("img")), object
								.getString("text"), object.getString("title")));
			}
		} catch (InterruptedException e) {
			Log.e("ME", e.toString());
		} catch (ExecutionException e) {
			Log.e("ME", e.toString());
		} catch (JSONException e) {
			Log.e("ME", e.toString());
		}
		return listOfProducts;
	}

	public Bitmap getImageOfProduct(String url) {
		productImageTask = new LoadProductImageTask();
		productImageTask.execute(url);
		Bitmap image = null;
		try {
			image = productImageTask.get();
		} catch (InterruptedException e) {
			Log.e("ME", e.toString());
		} catch (ExecutionException e) {
			Log.e("ME", e.toString());
		}
		return image;
	}

}
