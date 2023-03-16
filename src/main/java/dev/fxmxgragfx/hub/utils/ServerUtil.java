package dev.fxmxgragfx.hub.utils;

import dev.fxmxgragfx.hub.HubCore;
import lombok.Data;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;


@Data
public class ServerUtil implements PluginMessageListener {

	private HubCore plugin;
	private HashMap<ServerType, Integer> servers;
	
	public ServerUtil(HubCore plugin) {
		this.plugin = plugin;
		this.load();
	}
	
	public void load() {
		this.servers = new HashMap<>();
		plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", this);
		for(ServerType server : ServerType.values()) {
			this.servers.put(server, 0);
		}
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for(ServerType server : ServerType.values()) {
					try {
	     	      		ByteArrayOutputStream b = new ByteArrayOutputStream();
	            		DataOutputStream out = new DataOutputStream(b);
	            		
	            		out.writeUTF("PlayerCount");
	            		out.writeUTF(server.getBungeeName());
	            		
	            		plugin.getServer().sendPluginMessage(HubCore.getInstance(), "BungeeCord", b.toByteArray());
					} catch (Exception e) {}
				}
			}         
		}, 20L, 100);
	}
	
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord")) return;

		try {
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
			String command = in.readUTF();
                    
			if (command.equals("PlayerCount")) {

				String server = in.readUTF();
				int playerCount = in.readInt();
				this.servers.put(ServerType.fromBungeeName(server), playerCount);
				
			}
		} catch (Exception e) {}
     }
	
	@Getter
	public enum ServerType {
		
		GLOBAL("GLOBAL", "ALL", 0),
		KitMap("KitMap", "KitMap", 4),
		Masters("Masters", "Masters", 5),
		Bunkers("Bunkers", "Bunkers", 6),
		PotSG("PotSG", "PotSG", 7),
		uHCF("uHCF", "uHCF", 8),
		Practice("Practice", "Practice", 3);


		private String name;
		private String bungeeName;
		private int port;
		
		ServerType(String name, String bungeeName, int port) {
			this.name = name;
			this.bungeeName = bungeeName;
			this.port = port;
		}
		
		public static ServerType fromBungeeName(String string){
	        for(ServerType serverType : values()){
	            if(serverType.getBungeeName().equalsIgnoreCase(string)){
	                return serverType;
	            }
	        }
	        return null;
	    }
		
		public static ServerType fromName(String string){
	        for(ServerType serverType : values()){
	            if(serverType.getName().equalsIgnoreCase(string)){
	                return serverType;
	            }
	        }
	        return null;
	    }
		
		public static boolean isOnline(ServerType serverType) {
			try {
				Socket s = new Socket("127.0.0.1", serverType.getPort());
				s.close();
				return true;
			} catch (UnknownHostException e) {
				return false;
			} catch (IOException e) {
				return false;
			}
		}
		
		public static boolean isWhitelisted(ServerType type) {
			return false;
		}
	}
}
