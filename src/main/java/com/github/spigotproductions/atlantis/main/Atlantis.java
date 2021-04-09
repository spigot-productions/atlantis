package com.github.spigotproductions.atlantis.main;

import com.github.spigotproductions.atlantis.config.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Atlantis extends JavaPlugin {

    public static Atlantis plugin;

    public void onEnable() {
        plugin = this;

        //Willkommens Nachrichten in der Konsole
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§7----------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§cCoded by:"));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§4               Hufeisen                 "));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§4            Simon_der_Eine              "));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage(""));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("    §2Thank you for using this Plugin!    "));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§7----------------------------------------"));

        //Ausführen der Init Methode
        init();

    }

    public void onDisable() {
        //Aufwiedersehen Nachrichten in der Konsole
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§7----------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§cCoded by:"));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§4               Hufeisen                 "));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§4            Simon_der_Eine              "));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage(""));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("                §2Godbye!                 "));
        Bukkit.getConsoleSender().sendMessage(Messages.getMessage("§7----------------------------------------"));
    }

    public void init() {

        //Generieren der Configs, wenn nicht vorhanden
        Messages.Setup();

        //Registrieren der Listener
        //TODO

        //Registieren der Befehle
        //TODO

    }

    public static void reload() {
        Messages.Setup();
        Atlantis.getPlugin().reloadConfig();
    }

    public static Atlantis getPlugin() {
        return plugin;
    }
}
