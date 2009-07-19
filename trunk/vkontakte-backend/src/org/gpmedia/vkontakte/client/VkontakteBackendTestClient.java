package org.gpmedia.vkontakte.client;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class VkontakteBackendTestClient {
	
	@Option(name="-url",usage="Server to call")
	private final String url = null;
	
	
	public static void main(String[] args) {
		System.out.println("Starting Vkontakte backend");
		VkontakteBackendTestClient client = parseParameters(args);
		System.out.println("Calling url: " + client.url);
		
		WebConversation conversation = new WebConversation ();
		HttpUnitOptions.setScriptingEnabled(false);
		WebRequest request = new GetMethodWebRequest (client.url);
		WebResponse response = null;
		try {
			response = conversation.sendRequest(request );
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Cannot send request");
		} 
		System.out.println("Received responce: " + response);
	}


	private static VkontakteBackendTestClient parseParameters(String[] args) {
		VkontakteBackendTestClient client = new VkontakteBackendTestClient ();
		
		CmdLineParser parser = new CmdLineParser(client);
    	try {
    		parser.parseArgument(args);
    		//client.run();
        } catch (CmdLineException e) {
            // handling of wrong arguments
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }
        //TODO understand how to use Arguments
        if (client.url == null) {
        	System.err.println("URL should be specified");
        	System.exit(1);
        }
        return client;
	}
}
