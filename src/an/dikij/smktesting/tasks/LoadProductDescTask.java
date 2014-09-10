package an.dikij.smktesting.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Log;

/**
 * Created by Oleksandr Dykyi.
 */
public class LoadProductDescTask extends TaskUrls  {	
	
	@Override
	protected String doInBackground(String... apis) {
		StringBuilder result = new StringBuilder();
		StringBuilder newUrl = new StringBuilder();
		newUrl.append(BASE_URL).append(apis[0]);

		HttpURLConnection urlConnection = null;
		try {
			URL url = new URL(newUrl.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));

			String temp = null;
			while ((temp = reader.readLine()) != null) {
				result.append(temp);
			}
		} catch (MalformedURLException e) {
			Log.e("UTException", e.toString());
		} catch (IOException e) {
			Log.e("UTException", e.toString());
		} finally {
			urlConnection.disconnect();
		}
		return result.toString();
	}
}
