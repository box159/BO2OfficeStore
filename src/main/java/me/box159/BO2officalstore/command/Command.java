package me.box159.BO2officalstore.command;

import me.box159.BO2officalstore.Gui.Menu;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(sender instanceof Player p){
            Menu.menu(p);
        }
        return true;
    }
}
