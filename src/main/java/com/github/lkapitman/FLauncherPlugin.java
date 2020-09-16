package com.github.lkapitman;

import com.github.lkapitman.commands.FLauncherCommand;
import com.github.lkapitman.utils.Auth;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class FLauncherPlugin extends JavaPlugin {

    private FileConfiguration config = getConfig();
    private FLauncherCommand command = new FLauncherCommand();
    private Auth auth = new Auth();

    @Override
    public void onEnable() {
        System.out.println("FLauncher Plugin Started");

        this.getCommand("flauncher").setExecutor(command);

    }

    @Override
    public void onDisable() {
        System.out.println("FLauncher Plugin Stopped");
    }

    public FLauncherCommand getCommand() {
        return command;
    }

}
