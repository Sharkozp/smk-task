package an.dikij.smktesting;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listV = (ListView) findViewById(R.id.listView1);
		GetClass get = new GetClass();
		List<Map<String, Object>> list = get.getProducts();
		SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.products_list, new String[] { "img", "title" },
				new int[] { R.id.imageView1, R.id.textView1 });
		listV.setAdapter(adapter);
		ImageView img = (ImageView) findViewById(R.id.imageView8);
		img.setImageBitmap((Bitmap) list.get(0).get("img"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
