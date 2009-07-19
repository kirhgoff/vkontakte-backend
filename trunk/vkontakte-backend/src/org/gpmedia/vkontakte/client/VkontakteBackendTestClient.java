package org.gpmedia.vkontakte.client;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class VkontakteBackendTestClient {
	
	@Option(name="-url",usage="Server to call")
	private final static String url = null;
	
	
	public static void main(String[] args) {
		System.out.println("Starting Vkontakte backend");
		VkontakteBackendTestClient client = parseParameters(args);
		System.out.println("Calling url: " + url);
		
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
        return client;
	}
}
