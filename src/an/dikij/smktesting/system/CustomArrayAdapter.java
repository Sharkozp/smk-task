package an.dikij.smktesting.system;

import java.util.List;

import an.dikij.smktesting.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String> {
	private List<Product> list;
	private static GetClass get = new GetClass();
	private Context context;

	public CustomArrayAdapter(Context context) {		
		super(context, R.layout.products_list, get.getTitlesOfProducts());
		this.context = context;
		list = get.getProducts();
		
	}

	static class ViewHolder {
		public ImageView imageView;
		public TextView listId;
		public TextView productName;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.products_list, null, true);
			holder = new ViewHolder();

			holder.listId = (TextView) rowView.findViewById(R.id.productListId);
			holder.imageView = (ImageView) rowView
					.findViewById(R.id.thumbnailImage);
			holder.productName = (TextView) rowView
					.findViewById(R.id.productListName);

			rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}

		Product product = list.get(position);
		
		/*holder.listId.setText(product.getId());*/
		holder.imageView.setImageBitmap(product.getImg());
		holder.productName.setText(product.getTitle());

		return rowView;
	}
}
