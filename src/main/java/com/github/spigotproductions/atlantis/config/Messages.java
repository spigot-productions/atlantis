package com.github.spigotproductions.atlantis.config;

import com.github.spigotproductions.atlantis.main.Atlantis;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Messages {

    private static File messageConfigFile;
    private static YamlConfiguration messageConfig = new YamlConfiguration();;

    public static void Setup() {
        messageConfigFile = new File(Atlantis.getPlugin().getDataFolder(), "messages.yml");
        File dir = new java.io.File("./plugins/Atlantis/Messages");
        if (!dir.exists()) {

            messageConfigFile.getParentFile().mkdirs();
            Atlantis.getPlugin().saveResource("messages.yml", false);

            try {
                messageConfig.load(messageConfigFile);
                messageConfig.set("prefix", "&2[&bAtlantis&2] ");
                messageConfig.set("noPlayer", "%prefix% &cYou have to be a player to use this command!");
                messageConfig.set("help", "%prefix% &6Comming Soon!");
                messageConfig.set("noPermission", "%prefix% &4You do not have permission to perform this command!");
                messageConfig.set("reloaded", "%prefix% &aAll Configs was reloaded!");
                messageConfig.set("reloading", "%prefix% &9Reloading &bAtlantis&9...");
            } catch (IOException | InvalidConfigurationException e) {
                Bukkit.getConsoleSender().sendMessage("§cError while creating Configs...");
                e.printStackTrace();
            }
        } else {
            try {
                messageConfig.load(messageConfigFile);
            } catch (IOException | InvalidConfigurationException e) {
                Bukkit.getConsoleSender().sendMessage("§cError while creating Configs...");
                e.printStackTrace();
            }
        }

    }

    public static String getMessage(String key) {
        String message = ChatColor.translateAlternateColorCodes ('&',getMessageConfig().getString(key, "§This is a default message and means that the real message was not found."));
        message.replace("%prefix%", getMessageConfig().getString("prefix", "§This is a default message and means that the real message was not found."));

        if (Atlantis.getPlugin().getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            message = PlaceholderAPI.setPlaceholders(null, message);
        }
        return message;
    }

    public static String getMessage(String key, Player p) {
        String message = ChatColor.translateAlternateColorCodes ('&',getMessageConfig().getString(key, "§This is a default message and means that the real message was not found."));
        message.replace("%prefix%", getMessageConfig().getString("prefix", "§This is a default message and means that the real message was not found."));
        message.replace("%player%", p.getDisplayName());
        if (Atlantis.getPlugin().getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            message = PlaceholderAPI.setPlaceholders(p, message);
        }
        return message;
    }

    public static FileConfiguration getMessageConfig() {
        return messageConfig;
    }

}
