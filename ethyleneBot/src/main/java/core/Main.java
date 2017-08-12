package core;

import commands.cmdTest;
import listeners.commandListener;
import listeners.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import utils.Secret;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        // Getting token + Auto reconnect
        builder.setToken(Secret.TOKEN);
        builder.setAutoReconnect(true);

        // Availability
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);

        addListeners();
        addCommands();

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }

    }

    public static void addCommands() {

        // Implementation of Commands
        commandHandler.commands.put("test", new cmdTest());
    }

    public static void addListeners() {

        // Listeners
        builder.addListener(new readyListener());
        builder.addListener(new commandListener());
    }

}
