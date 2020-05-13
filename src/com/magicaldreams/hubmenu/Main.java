package com.magicaldreams.hubmenu;

import java.util.ArrayList;
import java.util.List;

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
	
	@SuppressWarnings("deprecation")
	public static void applyHubMenuUI(Player player) {
		
		Inventory HubMenuGUI = Bukkit.createInventory(null, 9, ChatColor.BLUE + player.getName() + "'s Navigator");
		

		
		ItemStack HUBskull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
        SkullMeta HUBskullMeta = (SkullMeta) HUBskull.getItemMeta();
        HUBskullMeta.setOwner(player.getName());
        HUBskullMeta.setDisplayName(ChatColor.YELLOW + player.getName());
        HUBskull.setItemMeta(HUBskullMeta);
        
        ItemStack report = new ItemStack(Material.BARRIER);
        ItemMeta reportMeta = report.getItemMeta();
        reportMeta.setDisplayName(ChatColor.RED + "Report/Issue");
        report.setItemMeta(reportMeta);
        
        ItemStack parks = new ItemStack(Material.NETHER_STAR);
        ItemMeta parksMeta = parks.getItemMeta();
        parksMeta.setDisplayName(ChatColor.YELLOW + "Parks");
        parks.setItemMeta(parksMeta);
		

		HubMenuGUI.setItem(2, report);
		HubMenuGUI.setItem(4, HUBskull);
		HubMenuGUI.setItem(6, parks);


		
		player.openInventory(HubMenuGUI);

	}
	
    public void applyHUBParksUI(Player player) {

        //	ResultSet result = DriverManager.executeQuery("SELECT * FROM PlayerData WHERE BALANCE = 0;");		
        //	List<String> bankruptPlayers = new ArrayList<String>();
        //while (result.next()) {
        //    String name = result.getString("PLAYERNAME");
        //    bankruptPlayers.add(name);
        //	}
        List<String> parksLore = new ArrayList<>();
        //	parksLore.add(ChatColor.GRAY + "Ride is: " + );


        Inventory ParksGUI = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Parks");

        ItemStack back = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "<-- Back");
        back.setItemMeta(backMeta);

        ItemStack parks = new ItemStack(Material.NETHER_STAR);
        ItemMeta parksMeta = parks.getItemMeta();
        parksMeta.setDisplayName(ChatColor.YELLOW + "Parks");
        parks.setItemMeta(parksMeta);

        ItemStack fish = new ItemStack(Material.TROPICAL_FISH);
        ItemMeta fishMeta = fish.getItemMeta();
        fishMeta.setDisplayName(ChatColor.YELLOW + "Join SWSA");
        fish.setItemMeta(fishMeta);

        ItemStack key = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta keyMeta = key.getItemMeta();
        keyMeta.setDisplayName(ChatColor.AQUA + "Join DLR");
        key.setItemMeta(keyMeta);

        ItemStack DAXE = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta DAXEMeta = DAXE.getItemMeta();
        DAXEMeta.setDisplayName(ChatColor.AQUA + "Join Creative");
        DAXE.setItemMeta(DAXEMeta);

        ItemStack Mickey = new ItemStack(Material.POTATO);
        ItemMeta MickeyMeta = Mickey.getItemMeta();
        MickeyMeta.setDisplayName(ChatColor.GOLD + "Join TDL");
        Mickey.setItemMeta(MickeyMeta);

        ItemStack BOOK = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta BOOKMeta = BOOK.getItemMeta();
        BOOKMeta.setDisplayName(ChatColor.BOLD + "Join HUB");
        BOOK.setItemMeta(BOOKMeta);

        ItemStack GAXE = new ItemStack(Material.GOLDEN_PICKAXE);
        ItemMeta GAXEMeta = GAXE.getItemMeta();
        GAXEMeta.setDisplayName(ChatColor.GOLD + "Join Custom");
        GAXE.setItemMeta(GAXEMeta);


        ParksGUI.setItem(4, parks);
        ParksGUI.setItem(12, fish);
        ParksGUI.setItem(13, key);
        ParksGUI.setItem(14, DAXE);
        ParksGUI.setItem(21, Mickey);
        ParksGUI.setItem(22, BOOK);
        ParksGUI.setItem(23, GAXE);
        ParksGUI.setItem(0, back);

        player.openInventory(ParksGUI);


    }
	
	@Override
	public void onDisable() {
		System.out.println("HubMenu Disabled");
	}
	

}
