package me.box159.BO2officalstore.Gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class Sell {
    static final int slots = 27;
    private static HashMap<Material, Integer> sprice = new HashMap<>();

    public static void sellpage(Player p){
        sprice.put(Material.EMERALD,20);
        sprice.put(Material.DIAMOND,25);
        sprice.put(Material.IRON_INGOT,10);
        sprice.put(Material.GOLD_INGOT,15);
        sprice.put(Material.LAPIS_LAZULI,15);
        sprice.put(Material.REDSTONE_BLOCK,15);
        sprice.put(Material.NETHERITE_INGOT,30);

        Inventory gui = Bukkit.createInventory(p,slots, ChatColor.YELLOW + "賣出介面");
        ItemStack[] items = new ItemStack[27];

        items[0] = new ItemStack(Material.IRON_INGOT);
        items[1] = new ItemStack(Material.LAPIS_LAZULI);
        items[2] = new ItemStack(Material.REDSTONE_BLOCK);
        items[3] = new ItemStack(Material.GOLD_INGOT);
        items[4] = new ItemStack(Material.EMERALD);
        items[5] = new ItemStack(Material.DIAMOND);
        items[6] = new ItemStack(Material.NETHERITE_INGOT);


        ItemMeta metaI = items[0].getItemMeta();
        ItemMeta metaL = items[1].getItemMeta();
        ItemMeta metaR = items[2].getItemMeta();
        ItemMeta metaGO = items[3].getItemMeta();
        ItemMeta metaE = items[4].getItemMeta();
        ItemMeta metaD = items[5].getItemMeta();
        ItemMeta metaN = items[6].getItemMeta();

        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("價格： 10 元");
        lore2.add("左鍵賣出一個");
        lore2.add("右鍵賣出64個");
        metaI.setLore(lore2);

        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("價格： 15 元");
        lore3.add("左鍵賣出一個");
        lore3.add("右鍵賣出64個");
        metaGO.setLore(lore3);

        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("價格： 20 元");
        lore4.add("左鍵賣出一個");
        lore4.add("右鍵賣出64個");
        metaE.setLore(lore4);

        ArrayList<String> lore8 = new ArrayList<>();
        lore8.add("價格： 15 元");
        lore8.add("左鍵賣出一個");
        lore8.add("右鍵賣出64個");
        metaL.setLore(lore8);

        ArrayList<String> lore9 = new ArrayList<>();
        lore9.add("價格： 25 元");
        lore9.add("左鍵賣出一個");
        lore9.add("右鍵賣出64個");
        metaD.setLore(lore9);

        ArrayList<String> lore10 = new ArrayList<>();
        lore10.add("價格： 15 元");
        lore10.add("左鍵賣出一個");
        lore10.add("右鍵賣出64個");
        metaR.setLore(lore10);

        ArrayList<String> lore5 = new ArrayList<>();
        lore5.add("價格： 30 元");
        lore5.add("左鍵賣出一個");
        lore5.add("右鍵賣出64個");
        metaN.setLore(lore5);


        items[0].setItemMeta(metaI);
        items[1].setItemMeta(metaL);
        items[2].setItemMeta(metaR);
        items[3].setItemMeta(metaGO);
        items[4].setItemMeta(metaE);
        items[5].setItemMeta(metaD);
        items[6].setItemMeta(metaN);

        gui.setContents(items);
        p.openInventory(gui);
    }
    public static HashMap<Material, Integer> getSprice(){
        return sprice;
    }
}
