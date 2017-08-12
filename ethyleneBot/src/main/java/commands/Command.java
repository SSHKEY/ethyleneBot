package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sun.plugin2.message.Message;

public interface Command {

    boolean called(String[] args, MessageReceivedEvent event);
    void action(String[] args, MessageReceivedEvent event);
    void executed(boolean success, MessageReceivedEvent event);
    String help();

}
