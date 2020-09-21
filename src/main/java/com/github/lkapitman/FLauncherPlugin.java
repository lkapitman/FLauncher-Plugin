package com.github.lkapitman;

import com.github.lkapitman.commands.FLauncherCommand;
import com.github.lkapitman.utils.Auth;
import com.github.lkapitman.utils.Connector;
import com.github.lkapitman.utils.ReturnValues;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class FLauncherPlugin extends JavaPlugin {

    private FileConfiguration config = getConfig();
    private FLauncherCommand command = new FLauncherCommand();
    private Auth auth = new Auth();
    private Connector connector = new Connector();

    @Override
    public void onEnable() {
        System.out.println("FLauncher Plugin Started");

        this.getCommand("flauncher").setExecutor(command);

        Runnable connect = ()-> {
            while (true) {
                if (command.isLogin()) {
                    if (command.isUsername() && command.isPassword()) {
                        if (auth.isRegistered(command.getUsername())) {
                            if (auth.checkPassword(command.getUsername(), command.getPassword())) {
                                connector.setWord(new ReturnValues().SUCCESS_OK);
                                return;
                            } else {
                                connector.setWord(new ReturnValues().SUCCESS_DENIED);
                                return;
                            }
                        } else {
                            connector.setWord(new ReturnValues().ACCOUNT_EXIST);
                            return;
                        }
                    }
                    connector.connect();
                    return;
                } else {
                    if (command.isRegister()) {
                        if (command.isUsername() && command.isPassword() && command.isRePassword()) {
                            if (!auth.isRegistered(command.getUsername())) {
                                if (command.passwordIsRepassword()) {
                                    auth.registerPlayer(command.getUsername(), command.getPassword());
                                    connector.setWord(new ReturnValues().REG_ACCOUNT_OK);
                                    return;
                                } else {
                                    connector.setWord(new ReturnValues().REG_ACCOUNT_DENIED);
                                    return;
                                }
                            } else {
                                connector.setWord(new ReturnValues().REG_ACCOUNT_DENIED);
                                return;
                            }
                        }
                    }
                    connector.connect();
                    return;
                }
            }
        };

        Thread thread = new Thread(connect);
        thread.start();


    }

    @Override
    public void onDisable() {
        System.out.println("FLauncher Plugin Stopped");
    }

    public FLauncherCommand getCommand() {
        return command;
    }

}
