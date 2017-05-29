package rkv.team.seminar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.widget.Toast;

public class SocketThread extends Thread{
	static Socket socket=null;
	static ObjectInputStream ips=null;
	static DataOutputStream ops=null;
	static String host,username,pwd;
	static int port;
	public SocketThread(String host,int port,String username,String pwd) throws UnknownHostException, IOException{
		this.host=host;
		this.port=port;
		this.username=username;
		this.pwd=pwd;		
	}
	public void createSocket() throws UnknownHostException, IOException{
		InetAddress addr = InetAddress.getByName(host);
		
		socket=new Socket(addr,port);
		
		ips = new ObjectInputStream(socket.getInputStream());
		ops = new DataOutputStream(socket.getOutputStream());
		
		// ops.writeUTF(username+" "+pwd);
		/*while (true) {
			try {
				
				Message<?> msg = (Message<?>) ips.readObject();
				SeminarActivity.ss="while";
				if (msg.getPayload() instanceof File) {
					File file = (File) msg.getPayload();
					SeminarActivity.ss="dk";
					FileOutputStream fos;
					FileInputStream fis = new FileInputStream(file);
					if (msg.getTag().equals("PREVIEW")) {
						fos = new FileOutputStream("preview.jpg");
						
					} else {
						
						fos = new FileOutputStream(file.getName());
					}
					int bread = 0;
					byte[] buf = new byte[666666];
					while ((bread = fis.read(buf)) != -1) {
						fos.write(buf, 0, bread);

					}
					fos.close();
					fis.close();
					SeminarActivity.ss="file recevied"+file.getAbsolutePath()+" "+file.getName();
					// File tmp=File.createTempFile("preview", ".jpg");
					// FileInputStream fis=new FileInputStream(file);
					// fis.re
				}
				else {
				//	Log.d(this,msg.getPayload().toString());
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				SeminarActivity.ss=e.getMessage();
				e.printStackTrace();
			}
		}*/

		
	}
	public void run(){
		try {
			
			createSocket();
			 SeminarActivity.conn=1;
		} catch (UnknownHostException e) {
			 SeminarActivity.conn=0;
			e.printStackTrace();
		} catch (IOException e) {
			 SeminarActivity.conn=0;
			e.printStackTrace();
		}		
	}	
}
