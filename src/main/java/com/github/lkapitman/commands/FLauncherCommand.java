package com.github.lkapitman.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FLauncherCommand implements CommandExecutor {

    private String password;
    private String username;
    private String rePassword;
    private String IPAdress;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("flauncher")) {

            if (sender instanceof Player) {
                sender.sendMessage(ChatColor.RED + "Only for server.");
                return false;
            }

            if (args.length == 0) {
                return false;
            }

            if (args[0].equals(" ") || args[0].equals("")) {
                return false;
            }

            if (args[0].equalsIgnoreCase("add")) {
                if (args[1].equals(" ") || args[1].equals("")) {
                    return false;
                }

                if (args[2].equals(" ") || args[2].equals("")) {
                    return false;
                }

                if (args[3].equals(" ") || args[3].equals("")) {
                    return false;
                }

                if (args[4].equals(" ") || args[4].equals("")) {
                    return false;
                }

                username = args[1];
                password = args[2];
                rePassword = args[3];
                IPAdress = args[4];

                return true;
            }

            if(args[0].equalsIgnoreCase("login")) {
                if (args[1].equals(" ") || args[1].equals("")) {
                    return false;
                }

                if (args[2].equals(" ") || args[2].equals("")) {
                    return false;
                }

                if (args[3].equals(" ") || args[3].equals("")) {
                    return false;
                }

                username = args[1];
                password = args[2];
                IPAdress = args[3];

                return true;
            }

        }

        return false;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getRePassword() {
        return rePassword;
    }

    public boolean isPassword() {
        if (password.length() == 0 || password.equals(" ")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isRePassword() {
        if (rePassword.length() == 0 || rePassword.equals(" ")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean passwordIsRepassword() {
        if (password.equalsIgnoreCase(rePassword)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUsername() {
        if (username.length() == 0 || username.equals(" ")) {
            return false;
        } else {
            return true;
        }
    }

    public String getIPAdress() {
        return IPAdress;
    }

    public boolean isIPAdress() {
        if (IPAdress.length() == 0 || IPAdress.equals(" ")) {
            return false;
        } else {
            return true;
        }
    }
}
