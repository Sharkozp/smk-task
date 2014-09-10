package an.dikij.smktesting.system;

import java.util.List;

public class GetClass {
	private static final String API_GET_PRODUCTS = "/api/products/";
	private JSONClass json;
	private List<Product> list;

	public List<Product> getProducts() {
		json = new JSONClass();
		list = json.getProducts(API_GET_PRODUCTS);
		return list;
	}

	public String[] getTitlesOfProducts() {
		if (list == null) {
			this.getProducts();
		}
		String[] titles = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			titles[i] = list.get(i).getTitle();
		}
		return titles;
	}
}
