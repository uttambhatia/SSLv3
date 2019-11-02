package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Security;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.*;

//@SpringBootApplication
public class DemoApplication {

	static {
	    //Security.setProperty("jdk.tls.disabledAlgorithms", "");
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		//printJavaCiphers();
		//printEnabledProtocols();
	}


	public static void printJavaCiphers()
			throws Exception
	{
		SSLServerSocketFactory ssf = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();

		String[] defaultCiphers = ssf.getDefaultCipherSuites();
		String[] availableCiphers = ssf.getSupportedCipherSuites();

		TreeMap ciphers = new TreeMap();

		System.out.println("Supported\tCipher");
		for(int i=0; i<availableCiphers.length; ++i ){
			ciphers.put(availableCiphers[i], Boolean.FALSE);
			System.out.println(availableCiphers[i]);
		}

		System.out.println("Enabled\tCipher");
		for(int i=0; i<defaultCiphers.length; ++i ){
			ciphers.put(defaultCiphers[i], Boolean.TRUE);
			System.out.println(defaultCiphers[i]);
		}

		System.out.println("Default\tCipher");
		/*for(Iterator i = ciphers.entrySet().iterator(); i.hasNext(); ) {
	            Map.Entry cipher=(Map.Entry)i.next();

	            if(Boolean.TRUE.equals(cipher.getValue()))
	                System.out.print('*');
	            else
	                System.out.print(' ');

	            System.out.print('\t');
	            System.out.println(cipher.getKey());
	        }*/
	}

	public static void printEnabledProtocols() throws Exception{

		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket soc = (SSLSocket) factory.createSocket();

		// Returns the names of the protocol versions which are
		// currently enabled for use on this connection.
		String[] protocols = soc.getEnabledProtocols();

		System.out.println("Enabled protocols:");
		for (String s : protocols) {
			System.out.println(s);
		}

	}
	
}
