package de.viralvince.paintball.methods;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.viralvince.paintball.main.Main;

public class CooldownMethoden {
	
	int cd;
	int z;
	int cdTime;
	int dela;
	ArrayList<Player> array;
	Player p;
	
	public CooldownMethoden(int z, int cdTime, int dela, Player p, ArrayList<Player> arraylist) {
		this.z = z;
		this.cdTime = cdTime;
		this.dela = dela;
		this.p = p;
		this.array = arraylist;
	}
	
	public CooldownMethoden() {
		
	}
	
	public void cooldownRepeatingTask() {
			
			cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
	
				@Override
				public void run() {
					
					z--;
					
					if(z == 0) {
						array.remove(p);
						Bukkit.getScheduler().cancelTask(cd);
					}
				}
				
			}, dela, cdTime);
		}
	
	public void cooldownDelayedTask() {
		
		cd = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
	
			@Override
			public void run() {
				
				z--;
				
				if(z == 0) {
					array.remove(p);
					Bukkit.getScheduler().cancelTask(cd);
				}
			}
			
		}, dela);
	}
}
