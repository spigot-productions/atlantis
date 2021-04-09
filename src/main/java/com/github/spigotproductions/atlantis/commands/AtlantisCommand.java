package com.github.spigotproductions.atlantis.commands;

import com.github.spigotproductions.atlantis.config.Messages;
import com.github.spigotproductions.atlantis.main.Atlantis;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AtlantisCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (p.hasPermission("atlantis.reload")) {
                        p.sendMessage(Messages.getMessage("reloading"));
                        Atlantis.reload();
                        p.sendMessage(Messages.getMessage("reloaded"));
                    } else {
                        p.sendMessage(Messages.getMessage("noPermission"));
                    }
                } else {
                    p.sendMessage(Messages.getMessage("help"));
                }
            } else {
                p.sendMessage(Messages.getMessage("help"));
            }
        } else {
            sender.sendMessage(Messages.getMessage("noPlayer"));
        }
        return false;
    }
}
