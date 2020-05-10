package com.magicaldreams.hubmenu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.magicaldreams.hubmenu.Main;

public class OpenHub implements Listener {
	
	 ItemStack JoinMB;
	    ItemMeta JoinMBMeta;
		private Main main;
	    public OpenHub(Main main) {
			// TODO Auto-generated constructor stub
	    	this.main = main;
		}


		@EventHandler
	    public void MBJoin(PlayerJoinEvent e){

	        Player player = e.getPlayer();

	        JoinMB = new ItemStack(Material.PAPER);

	        JoinMBMeta = JoinMB.getItemMeta();
	        JoinMBMeta.setDisplayName(ChatColor.BLUE + player.getName() + "'s Navigator");

	        JoinMB.setItemMeta(JoinMBMeta);

	        player.getInventory().setItem(4, JoinMB);


	    }
	    
	    
	    @SuppressWarnings({ "deprecation", "unlikely-arg-type" })
	    @EventHandler
	    public static void PlayerMB(PlayerInteractEvent e){
	        Action action = e.getAction();
	        Player player = (Player) e.getPlayer();
	        Player p = e.getPlayer();
	        Action item = e.getAction();

	        if(p.getItemInHand().getType() == Material.PAPER) {


	            ((Player) player).playSound(((OfflinePlayer) player).getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 2.0F, 1.0F);

	            Main.applyHubMenuUI((Player) player);

	        }
	    }

}
