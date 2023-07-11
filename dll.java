import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;

public class dll{
	public static void main(String[] args){
		new dll(args[0], args[1]);
	}
	
	public dll(String url, String fname){
		try{
			FileOutputStream o= new FileOutputStream(fname);
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection(Proxy.NO_PROXY);
			conn.setFollowRedirects(true);
			conn.setInstanceFollowRedirects(true);
			conn.addRequestProperty("User-Agent","chrome; 199 gecko ;firefox ;linux 12");
			InputStream ins = conn.getInputStream();
			byte[] buff = new byte[1024*1024*2];
			int red;
			
			while( (red = ins.read(buff) ) != -1){
				o.write(buff,0,red);
			}
			o.flush();
			o.close();
			
			ins.close();
			
			conn.disconnect();
		}catch (IOException e){}

	}
	
	void log(String msg){
		System.out.println(msg);
	}
}
