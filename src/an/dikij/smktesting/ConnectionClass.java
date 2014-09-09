package an.dikij.smktesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class ConnectionClass {
	private HttpClient client;
	private HttpGet get;
	private static final String url = "http://smktesting.herokuapp.com";
	private static final String url_image = "http://smktesting.herokuapp.com/static/";

	// private static final String PROXY = "10.0.8.38";
	// private static final HttpHost PROXY_HOST = new HttpHost(PROXY, 3128);

	public ConnectionClass() {
		HttpParams httpParameters = new BasicHttpParams();
		client = new DefaultHttpClient(httpParameters);
		// client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
		// PROXY_HOST);
	}

	public String connect(String api) {
		StringBuilder result = new StringBuilder();
		get = new HttpGet(url + api);
		InputStream is = null;
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				is = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				String temp = null;

				while ((temp = reader.readLine()) != null) {
					result.append(temp);
				}
			}
		} catch (ClientProtocolException e) {
			Log.e("ME", e.toString());
		} catch (IOException e) {
			Log.e("ME", e.toString());
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				Log.e("ME", e.toString());
			}
		}
		return result.toString();
	}

	public Bitmap getImage(String src) {
		InputStream is = null;
		try {
			URL url = new URL(url_image + src);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			is = connection.getInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			return bitmap;
		} catch (IOException e) {
			Log.e("ME", e.toString());
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				Log.e("ME", e.toString());
			}
		}
		// return Drawable.createFromStream(is, null);
		return null;
	}

}
