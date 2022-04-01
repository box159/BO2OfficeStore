package me.box159.BO2officalstore.Gui;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;


public class Menu {
    static final int[] buyslot= {1,2,3,10,11,12,19,20,21};
    static final int[] sellslot= {5,6,7,14,15,16,23,24,25};
    public static void menu(Player p){
        
        Inventory gui = Bukkit.createInventory(p,27,ChatColor.WHITE+ "\uF807\uF801");
        ItemStack buyitem = new ItemStack(Material.DIAMOND);
        ItemStack sellitem = new ItemStack(Material.GOLD_INGOT);

        ItemMeta buymeta = buyitem.getItemMeta();
        ItemMeta sellmeta = sellitem.getItemMeta();

        buymeta.setDisplayName(ChatColor.of(Color.green)+"購買");
        sellmeta.setDisplayName(ChatColor.of(Color.yellow)+"售出");
        buymeta.setCustomModelData(2081);
        sellmeta.setCustomModelData(2081);

        buyitem.setItemMeta(buymeta);
        sellitem.setItemMeta(sellmeta);

        for(int i :buyslot){
            gui.setItem(i,buyitem);
        }
        for(int i :sellslot){
            gui.setItem(i,sellitem);
        }


        p.openInventory(gui);
    }
}
