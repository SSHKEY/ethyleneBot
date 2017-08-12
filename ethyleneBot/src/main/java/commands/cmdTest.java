package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdTest implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {

        if (!event.getMember().getNickname().equals("Ethylene"))
            return true;
        else
            return false;

    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Success, you made me talk!").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
        System.out.println("[INFO] The correct usage is '-test'");
    }

    @Override
    public String help() {
        return null;
    }
}
