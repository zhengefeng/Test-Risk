package com.za.http.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;

public class MySecureProtocolSocketFactory implements
		SecureProtocolSocketFactory {

	private SSLContext sslcontext = null;
	
    private SSLContext createSSLContext()
    {
        SSLContext sslcontext = null;
        try{
            sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, new TrustManager[]
            {  new TrustAnyTrustManager() }, new java.security.SecureRandom());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (KeyManagementException e)
        {
            e.printStackTrace();
        }
        return sslcontext;
    }

    private SSLContext getSSLContext()
    {
        if (this.sslcontext == null)
        {
            this.sslcontext = createSSLContext();
        }
        return this.sslcontext;
    }

	
	@Override
	public Socket createSocket(String host, int port) throws IOException,
			UnknownHostException {
		// TODO Auto-generated method stub
		return getSSLContext().getSocketFactory().createSocket(host, port);
	}

	@Override
	public Socket createSocket(String host, int port, 
			InetAddress clientHost, int clientPort)
			throws IOException, UnknownHostException {
		// TODO Auto-generated method stub
		return getSSLContext().getSocketFactory().createSocket(host, port,
                clientHost, clientPort);
	}

	@Override
	public Socket createSocket(String host, int port, InetAddress localAddress,
			int localPort, HttpConnectionParams params) throws IOException,
			UnknownHostException, ConnectTimeoutException {
		// TODO Auto-generated method stub
		if (params == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        }
        int timeout = params.getConnectionTimeout();
        SocketFactory socketfactory = getSSLContext().getSocketFactory();
        if (timeout == 0)
        {
            return socketfactory.createSocket(host, port, localAddress,
                    localPort);
        }
        else
        {
            Socket socket = socketfactory.createSocket();
            SocketAddress localaddr = new InetSocketAddress(localAddress,
                    localPort);
            SocketAddress remoteaddr = new InetSocketAddress(host, port);
            socket.bind(localaddr);
            socket.connect(remoteaddr, timeout);
            return socket;
        }

	}

	@Override
	public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
			throws IOException, UnknownHostException {
		// TODO Auto-generated method stub
		return getSSLContext().getSocketFactory().createSocket(socket, host,
                port, autoClose);

	}
	
	 // 自定义私有类
    private static class TrustAnyTrustManager implements X509TrustManager
    {

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			//return null;
            return new X509Certificate[]{};
		}
    	
    }	

}
