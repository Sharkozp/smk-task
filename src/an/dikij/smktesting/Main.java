package an.dikij.smktesting;

import an.dikij.smktesting.system.CustomArrayAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ListView listV = (ListView) findViewById(R.id.productsList);
		CustomArrayAdapter adapter = new CustomArrayAdapter(this);		
		listV.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
