package com.magicaldreams.hubmenu;

import java.io.IOException;
import java.net.URISyntaxException;

import org.bukkit.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.magicaldreams.hubmenu.Main;

@SuppressWarnings("unused")
public class OpenHub implements Listener {
	
	 ItemStack JoinMBHub;
	    ItemMeta JoinMBHubMeta;
		private Main main;
	    public OpenHub(Main main) {
			// TODO Auto-generated constructor stub
	    	this.main = main;
		}


		@EventHandler
	    public void APHubJoin(PlayerJoinEvent e){

	        Player player = e.getPlayer();

	        JoinMBHub = new ItemStack(Material.PAPER);

	        JoinMBHubMeta = JoinMBHub.getItemMeta();
	        JoinMBHubMeta.setDisplayName(ChatColor.BLUE + player.getName() + "'s Navigator");

	        JoinMBHub.setItemMeta(JoinMBHubMeta);

	        player.getInventory().setItem(0, JoinMBHub);


	    }
	    



	        @SuppressWarnings("deprecation")
		    @EventHandler
		    public void onClick(InventoryClickEvent e) {

		        Player player = (Player) e.getWhoClicked();

		        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + player.getName() + "'s Navigator")) {

		            if(e.getCurrentItem() != null) {
		                e.setCancelled(true);
		                switch (e.getCurrentItem().getType()) {
	                case BARRIER:
	                	
	                	 player.sendMessage(ChatColor.YELLOW
	                                + "Click this link to Report/Issue: https://docs.google.com/forms/d/e/1FAIpQLSf-7fXP9KbaQ6FcpzPaqBA7eeqtBIr1mc0cfxFtQmHMBNp_dg/viewform");
	                        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "-------------------- " + player.getName() + " has to report something --------------------");
	                        player.sendMessage(ChatColor.RED + "The staff has been notified of your issue!(Shows up in console log)");
	                        player.closeInventory();

	                        break;
                    case NETHER_STAR:
                        main.applyHUBParksUI((Player) player);
	                        
                    break;
                default:
                    return;

	                }
	            }
	            

	        }
	    }
	        
	        
	        @EventHandler
	        public void ParksonClick(InventoryClickEvent e) {



	            Player player = (Player) e.getWhoClicked();


	            if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Parks")) {

	                if(e.getCurrentItem() != null) {
	                    e.setCancelled(true);
	                    switch (e.getCurrentItem().getType()) {
	                        case GREEN_STAINED_GLASS_PANE:
	                            Main.applyHubMenuUI((Player) player);

	                            break;
	                        case TROPICAL_FISH:
	                            player.performCommand("join swsa");
	                            player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: SWSA");
	                            player.closeInventory();

	                            break;
	                        case DIAMOND_HOE:
	                            player.performCommand("join dlr");
	                            player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: DLR");
	                            player.closeInventory();

	                            break;
	                        case DIAMOND_PICKAXE:
	                            player.performCommand("join creative");
	                            player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: Creative");
	                            player.closeInventory();

	                            break;
	                        case POTATO:
	                            player.performCommand("join tdr");
	                            player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: TDR");
	                            player.closeInventory();

	                            break;
	                        case ENCHANTED_BOOK:
	                            player.performCommand("join hub");
	                            player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: HUB");
	                            player.closeInventory();

	                            break;
	                        case GOLDEN_PICKAXE:
	                            player.performCommand("join custom");
	                            player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: Custom");
	                            player.closeInventory();

	                            break;
	                        default:
	                            return;
	                    }
	                }

	            }

	        }
	     
	    @SuppressWarnings("deprecation")
		@EventHandler
	    public static void PlayerMB(PlayerInteractEvent e){
	        Action action = e.getAction();
	        Player player = (Player) e.getPlayer();
	        Player p = e.getPlayer();
	        Action item = e.getAction();

	        if(p.getItemInHand().getType() == Material.PAPER) {
		        if(action.equals(Action.PHYSICAL)) {
		        	return;
		        }
	            ((Player) player).playSound(((OfflinePlayer) player).getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 2.0F, 1.0F);

	            Main.applyHubMenuUI((Player) player);

	        }else {
	        	return;
	        
	    }
	    }
	    
	   

}
