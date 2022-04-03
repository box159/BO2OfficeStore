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

public class Buy {
    private static final HashMap<Material, Integer> bprice = new HashMap<>();

    static final int slots = 27;

    public static void buypage(Player p){
        bprice.put(Material.GRAVEL,1);
        bprice.put(Material.NETHER_STAR,5000);
        bprice.put(Material.DIAMOND,40);
        bprice.put(Material.IRON_INGOT,25);
        bprice.put(Material.GOLD_INGOT,30);
        bprice.put(Material.EMERALD,35);
        bprice.put(Material.LAPIS_LAZULI,30);
        bprice.put(Material.REDSTONE_BLOCK,30);
        bprice.put(Material.COAL_BLOCK,30);

        Inventory gui = Bukkit.createInventory(p,slots, ChatColor.GREEN + "購買介面");
        ItemStack[] items = new ItemStack[27];
        items[0] = new ItemStack(Material.IRON_INGOT);
        items[1] = new ItemStack(Material.LAPIS_LAZULI);
        items[2] = new ItemStack(Material.REDSTONE_BLOCK);
        items[3] = new ItemStack(Material.COAL_BLOCK);
        items[4] = new ItemStack(Material.GOLD_INGOT);
        items[5] = new ItemStack(Material.EMERALD);
        items[6] = new ItemStack(Material.DIAMOND);
        items[9] = new ItemStack(Material.BEACON);
        items[10] = new ItemStack(Material.BEACON);
        items[11] = new ItemStack(Material.BEACON);
        items[18] = new ItemStack(Material.GRAVEL);
        items[19] = new ItemStack(Material.NETHER_STAR);

        ItemMeta metaI = items[0].getItemMeta();
        ItemMeta metaL = items[1].getItemMeta();
        ItemMeta metaR = items[2].getItemMeta();
        ItemMeta metaCO= items[3].getItemMeta();
        ItemMeta metaGO = items[4].getItemMeta();
        ItemMeta metaE = items[5].getItemMeta();
        ItemMeta metaD = items[6].getItemMeta();
        ItemMeta metac1 = items[9].getItemMeta();
        ItemMeta metac2 = items[10].getItemMeta();
        ItemMeta metac3 = items[11].getItemMeta();
        ItemMeta metaGA= items[18].getItemMeta();
        ItemMeta metaN= items[19].getItemMeta();

        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("價格： 25 元");
        lore2.add("左鍵購買一個");
        lore2.add("右鍵購買64個");
        metaI.setLore(lore2);

        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("價格： 30 元");
        lore3.add("左鍵購買一個");
        lore3.add("右鍵購買64個");
        metaGO.setLore(lore3);

        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("價格： 2000 元");
        lore4.add("左鍵購買一個");
        lore4.add("可加載1*1範圍的Chunk");
        metac1.setLore(lore4);
        metac1.setDisplayName(ChatColor.GOLD + "小範圍區加載器");

        ArrayList<String> lore5 = new ArrayList<>();
        lore5.add("價格： 4000 元");
        lore5.add("左鍵購買一個");
        lore5.add("可加載3*3範圍的Chunk");
        metac2.setLore(lore5);
        metac2.setDisplayName(ChatColor.GOLD + "中範圍區加載器");

        ArrayList<String> lore6 = new ArrayList<>();
        lore6.add("價格： 6000 元");
        lore6.add("左鍵購買一個");
        lore6.add("可加載5*5範圍的Chunk");
        metac3.setLore(lore6);
        metac3.setDisplayName(ChatColor.GOLD + "大範圍區加載器");

        ArrayList<String> lore7 = new ArrayList<>();
        lore7.add("價格： 35 元");
        lore7.add("左鍵購買一個");
        lore7.add("右鍵購買64個");
        metaE.setLore(lore7);

        ArrayList<String> lore8 = new ArrayList<>();
        lore8.add("價格： 30 元");
        lore8.add("左鍵購買一個");
        lore8.add("右鍵購買64個");
        metaL.setLore(lore8);

        ArrayList<String> lore9 = new ArrayList<>();
        lore9.add("價格： 40 元");
        lore9.add("左鍵購買一個");
        lore9.add("右鍵購買64個");
        metaD.setLore(lore9);

        ArrayList<String> lore10 = new ArrayList<>();
        lore10.add("價格： 30 元");
        lore10.add("左鍵購買一個");
        lore10.add("右鍵購買64個");
        metaR.setLore(lore10);

        ArrayList<String> lore11 = new ArrayList<>();
        lore11.add("價格： 50 元");
        lore11.add("左鍵購買64個");
        lore11.add("右鍵購買64個");
        metaGA.setLore(lore11);

        ArrayList<String> lore12 = new ArrayList<>();
        lore12.add("價格： 5000 元");
        lore12.add("左鍵購買1個");
        lore12.add("右鍵購買64個");
        metaN.setLore(lore12);

        ArrayList<String> lore13 = new ArrayList<>();
        lore13.add("價格： 30 元");
        lore13.add("左鍵購買1個");
        lore13.add("右鍵購買64個");
        metaCO.setLore(lore13);

        items[0].setItemMeta(metaI);
        items[1].setItemMeta(metaL);
        items[2].setItemMeta(metaR);
        items[3].setItemMeta(metaCO);
        items[4].setItemMeta(metaGO);
        items[5].setItemMeta(metaE);
        items[6].setItemMeta(metaD);
        items[9].setItemMeta(metac1);
        items[10].setItemMeta(metac2);
        items[11].setItemMeta(metac3);
        items[18].setItemMeta(metaGA);
        items[19].setItemMeta(metaN);

        gui.setContents(items);
        p.openInventory(gui);
    }

    public static HashMap<Material, Integer> getBprice(){
        return bprice;
    }
}
