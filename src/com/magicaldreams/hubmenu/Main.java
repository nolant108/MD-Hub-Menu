package com.magicaldreams.hubmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.magicaldreams.hubmenu.OpenHub;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("HubMenu Enabled");
		
		Bukkit.getPluginManager().registerEvents(new OpenHub(this), this);
		
	}
	
	public static void applyHubMenuUI(Player player) {
		Inventory HubMenuGUI = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Hub Navigator");
		
		ItemStack Glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta GlassMeta = Glass.getItemMeta();
		GlassMeta.setDisplayName(" ");
		Glass.setItemMeta(GlassMeta);
		
		ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner(player.getName());
        skullMeta.setDisplayName(ChatColor.YELLOW + player.getName());
        skull.setItemMeta(skullMeta);
        
        ItemStack report = new ItemStack(Material.BARRIER);
        ItemMeta reportMeta = report.getItemMeta();
        reportMeta.setDisplayName(ChatColor.RED + "Report/Issue");
        report.setItemMeta(reportMeta);
        
        ItemStack parks = new ItemStack(Material.NETHER_STAR);
        ItemMeta parksMeta = parks.getItemMeta();
        parksMeta.setDisplayName(ChatColor.YELLOW + "Parks");
        parks.setItemMeta(parksMeta);
		
	//  HubMenuGUI.setItem(0, Glass);
	//	HubMenuGUI.setItem(1, Glass);
		HubMenuGUI.setItem(2, report);
	//	HubMenuGUI.setItem(3, Glass);
		HubMenuGUI.setItem(4, skull);
	//	HubMenuGUI.setItem(5, Glass);
		HubMenuGUI.setItem(6, parks);
	//	HubMenuGUI.setItem(7, Glass);
	//	HubMenuGUI.setItem(8, Glass);

		
		player.openInventory(HubMenuGUI);

	}
	
	@Override
	public void onDisable() {
		System.out.println("HubMenu Disabled");
	}
	

}
