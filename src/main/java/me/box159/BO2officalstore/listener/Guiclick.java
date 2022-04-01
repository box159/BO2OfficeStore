package me.box159.BO2officalstore.listener;

import me.box159.BO2officalstore.Gui.Buy;
import me.box159.BO2officalstore.Gui.Sell;
import me.box159.BO2officalstore.OfficalStore;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Guiclick implements Listener {
    final static String menu = ChatColor.WHITE+ "\uF807\uF801";
    final static String buypage = ChatColor.GREEN + "購買介面";
    final static String sellpage = org.bukkit.ChatColor.YELLOW + "賣出介面";
    private static HashMap<Material, Integer> bprice = Buy.getBprice();
    private static HashMap<Material, Integer> sprice = Sell.getSprice();

    @EventHandler
    public void click(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        Economy eco = OfficalStore.getEconomy();


        if (e.getView().getTitle().equalsIgnoreCase(menu)) {
            if (e.getCurrentItem() == null) {
                return;
            }
            switch (e.getCurrentItem().getType()){
                case DIAMOND -> Buy.buypage(player);
                case GOLD_INGOT -> Sell.sellpage(player);
            }
            e.setCancelled(true);
        }
        else if (e.getView().getTitle().equalsIgnoreCase(buypage)) {
            if (e.getCurrentItem() == null)
                return;
            Material material = e.getCurrentItem().getType();

            if (material.equals(Material.BEACON)) {
                Character type = null;
                int price = 0;

                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "小範圍區加載器")){
                    //tmaterial = Material.SLIME_SPAWN_EGG;
                    type = 's';
                    price = 2000;}
                else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "中範圍區加載器")) {
                    type = 'm';
                    price = 4000;}
                else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "大範圍區加載器")){
                    type = 'l';
                    price = 6000;}
                if (eco.getBalance(player) >= price) {
                    eco.withdrawPlayer(player, price);
                    if (type == 's')
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"loader give " + player.getName() + " normal_loader ");
                    else if (type == 'm')
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"loader give " + player.getName() + " medium_loader ");
                    else if (type == 'l')
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"loader give " + player.getName() + " large_loader ");
                    player.sendMessage("購買成功!");
                    /*if (material.equals(Material.SLIME_SPAWN_EGG))
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"loader give " + player.getName() + " normal_loader ");
                    else if (material.equals(Material.SHEEP_SPAWN_EGG))
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"loader give " + player.getName() + " large_loader ");
                    player.sendMessage("購買成功!");*/
                } else {
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED + "您沒有足夠的錢!");
                }
            }
            else if (bprice.containsKey(material)) {
                int count = 1;
                if (e.getClick().isRightClick()){
                    count = 64;
                }
                if (eco.getBalance(player) >= bprice.get(material)*count) {
                    eco.withdrawPlayer(player, bprice.get(material)*count);
                    player.getInventory().addItem(new ItemStack(material));
                    player.sendMessage("購買成功!");
                } else {
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED + "您沒有足夠的錢!");
                }
                }
                e.setCancelled(true);
            }
        else if (e.getView().getTitle().equalsIgnoreCase(sellpage)){
            if(e.getCurrentItem() == null){
                return;
            }
            Material material = e.getCurrentItem().getType();
            if(sprice.containsKey(material)) {
                int count = 1;
                if (e.getClick().isRightClick()){
                    count = 64;
                }
                if (player.getInventory().contains(material,count)) {
                    eco.depositPlayer(player, sprice.get(material)*count);
                    player.getInventory().removeItem(new ItemStack(material,count));
                    player.sendMessage("出售成功!");
                } else {
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED + "您沒有足夠的物品!");

                }
            }
            e.setCancelled(true);
        }
    }
}
