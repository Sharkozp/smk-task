package an.dikij.smktesting;

import java.util.List;
import java.util.Map;

public class GetClass {
	private static final String API_GET_PRODUCTS = "/api/products/";
	private JSONClass json;
	private List<Product> list;

	public GetClass() {

	}

	public List<Map<String, Object>> getProducts() {
		json = new JSONClass();
		return json.getProducts(API_GET_PRODUCTS);
	}

	public String[] getTitlesOfProducts() {
		String[] titles = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			titles[i] = list.get(i).getTitle();
		}
		return titles;
	}
}
