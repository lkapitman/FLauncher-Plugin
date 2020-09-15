package com.github.lkapitman;

import com.github.lkapitman.commands.FLauncherCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class FLauncherPlugin extends JavaPlugin {

    private FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        System.out.println("FLauncher Plugin Started");

        this.getCommand("flauncher").setExecutor(new FLauncherCommand());

    }

    @Override
    public void onDisable() {
        System.out.println("FLauncher Plugin Stopped");
    }

}
