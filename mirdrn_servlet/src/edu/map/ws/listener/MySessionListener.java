package edu.map.ws.listener;


import java.util.HashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import edu.map.ws.persistent.connection.HibernateConfig;
import edu.map.ws.service.WSDispatcher;
import edu.map.ws.vo.VoGo;
import edu.map.ws.vo.VoPpi2014Genes;


public class MySessionListener implements HttpSessionListener{

	static public HashMap<String, VoGo> GO_HASH_MAP;
	static public HashMap<Integer, VoPpi2014Genes> GENE_INFO_HASH_MAP_BY_ID;
	static public HashMap<String, VoPpi2014Genes> GENE_INFO_HASH_MAP_BY_SYMBOL;
	/**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("========================================================");
    	System.out.println("========           MAP  Server Initial          ========");
    	System.out.println("========================================================");
    	
    	
    	try {
    		
    		// create MySql connection
        	HibernateConfig sessionInstance = new HibernateConfig();
        	sessionInstance.createSessionFactory();
        	
        	WSDispatcher ws = new WSDispatcher();
        	GO_HASH_MAP = ws.GetGoInfoAll();
        	GENE_INFO_HASH_MAP_BY_ID = ws.GetGeneInfoAllByGeneId();
        	GENE_INFO_HASH_MAP_BY_SYMBOL = ws.GetGeneInfoAllByGeneSymbol();
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
    	
    }
    
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println(arg0.getSession().getId()+"\tSession Created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		String session = arg0.getSession().getId();	      
		System.out.println(arg0.getSession().getId()+"\tSession Destoryed");	  
	}

}
