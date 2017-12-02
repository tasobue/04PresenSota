import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class EchoServer {
	
    public static final int ECHO_PORT = 10007;
	
    public static void main(String args[]) {
    	
	    ServerSocket serverSocket = null;
	    Socket socket = null;
    	
    	SotaController sotaCntrllr = new SotaController();
    	
	    	
	    try {
	        serverSocket = new ServerSocket(ECHO_PORT);
	        System.out.println("EchoServerが起動しました(port=" + serverSocket.getLocalPort() + ")");
	    	
	    	String rcvStr = "";
	    	
	    	while(true){
	    		System.out.println("待機中です。");
		        socket = serverSocket.accept();
		        System.out.println("接続されました " + socket.getRemoteSocketAddress() );
		    	
		        BufferedReader rcv = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		        PrintWriter snd = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF8"), true);
		    	
		        while ( (rcvStr = rcv.readLine()) != null ) {
		            System.out.println("000");
		            System.out.println(rcvStr);
		        	
		        	switch(rcvStr){
		        		case "selectPpt":
				        	sotaCntrllr.selectPpt(rcvStr);
		        			break;
		        		case "doPresentaion":
				        	snd.println(sotaCntrllr.doPresentation(rcvStr));
		        			break;
		        		
		        	default:
		        		break;
		        	}
		        }
		    	socket.close();
	    		socket = null;
	    		System.out.println("接続を切りました。");
	    	
	    	}
	    } catch (Exception e) {
	        e.printStackTrace();
	    
	    } finally {
	        try {
	            if (socket != null) {
	            System.out.println("009");
	                socket.close();
	            }
	        } catch (IOException e) {
	        }
	        try {
	            if (serverSocket != null) {
	                serverSocket.close();
	            }
	        } catch (IOException e) {
	        }
	    }
	}
}