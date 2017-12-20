package de.viralvince.paintball.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.viralvince.paintball.commands.CMDaddcoins;
import de.viralvince.paintball.commands.CMDaddkit;
import de.viralvince.paintball.commands.CMDcoins;
import de.viralvince.paintball.methods.CoinsAPI;
import de.viralvince.paintball.methods.KitAPI;
import de.viralvince.paintball.methods.MySQL;







public class Main extends JavaPlugin implements Listener {
	
	private static Main instance;
	private MySQL mysql;
	private CoinsAPI coinsApi;
	private KitAPI kitApi;
	
 	

	private static Main plugin;
	public static final String pr = "§5Paintball §7>>";
	
	
	

	
	public static Gamestate gameState = Gamestate.Lobby;
	
	
	
	public  CoinsAPI getCoinsapi() { 
		return this.coinsApi;
	}
	public  KitAPI getKitapi() { 
		return this.kitApi;
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
	
	
	public void onEnable() {
		
		instance = this;
	    mysql = new MySQL();
	    mysql.connect();
	    mysql.createCoinsTable();
	    mysql.createKitTable();
	    coinsApi = new CoinsAPI();
	    coinsApi.setMysql(mysql);
	    kitApi = new KitAPI();
	    kitApi.setMysql(mysql);
	   
	    
	    	    	    	    	 	    
		plugin = this;
		
		this.getCommand("coins").setExecutor(new CMDcoins());
		this.getCommand("addcoins").setExecutor(new CMDaddcoins());
		this.getCommand("addkit").setExecutor(new CMDaddkit());
	
	
		
//		Gamestate gameState = Gamestate.Lobby;
		
		
		
		System.out.println("[Paintball] Das Plugin wurde erfolgreich gestartet");
		
		
		
	}
	
	 
	
	
	


	
	
	  public void onDisable()
	  {
		  MySQL mysql = new MySQL();
	    mysql.close();
	  }

	  public void log(String log) {
	    Bukkit.getConsoleSender().sendMessage(log);
	  }

	  public static Main getInstance()
	  {
	    return instance;
	  }
	  public MySQL getMysql() {
	    return this.mysql;
	  }
	  
	
	  
	  
	  }
	  


