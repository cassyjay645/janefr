//package com.parttly;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;

public class dll{
	public static void main(String[] args){
		System.out.println("args.length == "+args.length);
		System.out.println(""+args.toString());
		new dll(args[0], args[1]);
	}

	// 
	int BUFFER_SIZE = 3145728; // 3145728bytes = 3mb
	String uas1 = "Mozilla/5.0 (Android 12; Mobile; LG-M255; rv:100.0) Gecko/100.0 Firefox/100.0Mozilla/5.0 (Linux; Android 12) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.61 Mobile Safari/537.36";

	public dll(String url, String fname){
		FileOutputStream o = null;
		HttpURLConnection conn=null;
		BufferedInputStream ins=null;
		System.out.println(url+"\n~~"+fname);
		try{
			o= new FileOutputStream(fname);
			conn = (HttpURLConnection) new URL(url).openConnection(Proxy.NO_PROXY);
			conn.setFollowRedirects(true);
			conn.setInstanceFollowRedirects(true);
			conn.addRequestProperty("User-Agent", uas1);
			ins = new BufferedInputStream( conn.getInputStream());
			byte[] buff = new byte[BUFFER_SIZE];
			int red=0;

			//while( (red = ins.read(buff) ) != -1){
				//o.write(buff,0,red);

			//}
			//o.flush();

		}catch (IOException e){}
		finally{
			if(o!=null){
				try{
					o.close();
				}catch(IOException ioe){}
			}
			if(ins!=null){
				try{
					ins.close();
				}catch(IOException ioe){}
			}
			if(conn!=null){
				try{
					conn.disconnect();
				}catch(Exception e){}
			}
		}
		System.out.println("done");

	}

	void log(String msg){
		System.out.println(msg);
	}
}
