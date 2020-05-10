package com.magicaldreams.hubmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.magicaldreams.hubmenu.OpenHub;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("HubMenu Enabled");
		
		Bukkit.getPluginManager().registerEvents(new OpenHub(this), this);
		
	}
	
	public static void applyHubMenuUI(Player player) {
		Inventory HubMenuGUI = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Navigator");
		
		player.openInventory(HubMenuGUI);

	}
	
	@Override
	public void onDisable() {
		System.out.println("HubMenu Disabled");
	}
	

}
