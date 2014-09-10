package an.dikij.smktesting.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Oleksandr Dykyi.
 */
public class LoadProductImageTask extends AsyncTask<String, Void, Bitmap> {	
	public static final String URL_IMAGE = "http://smktesting.herokuapp.com/static/";
	
	@Override
	protected Bitmap doInBackground(String... src) {
		StringBuilder newUrl = new StringBuilder();
		newUrl.append(URL_IMAGE).append(src[0]);
		InputStream is = null;
		Bitmap image = null;
		try {
			URL url = new URL(newUrl.toString());
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			is = connection.getInputStream();
			image  = BitmapFactory.decodeStream(is);
		        			
		} catch (IOException e) {
			Log.e("ME", e.toString());
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				Log.e("ME", e.toString());
			}
		}		
		return image;
	}
}
