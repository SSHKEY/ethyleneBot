package listeners;

import core.commandHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import utils.Static;
import core.*;

public class commandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContent().startsWith(Static.PREFIX) && event.getMessage().getAuthor().getId() !=event.getJDA().getSelfUser().getId()) {
            commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContent(),event));
        }

    }

}
