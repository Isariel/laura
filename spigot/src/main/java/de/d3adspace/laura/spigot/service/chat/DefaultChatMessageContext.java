package de.d3adspace.laura.spigot.service.chat;

import de.d3adspace.laura.spigot.api.service.chat.ChatMessageContext;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Set;

/**
 * A default {@link ChatMessageContext} wrapping around the most important arguments of the
 * {@link AsyncPlayerChatEvent}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class DefaultChatMessageContext implements ChatMessageContext {

    /**
     * The player that sent the text message.
     */
    private final Player player;

    /**
     * The recipients of the text message.
     */
    private final Set<Player> recipients;

    /**
     * If the message is ok to be sent.
     */
    private boolean messageOk = true;

    /**
     * The format of the whole message including player name and potential suffixes.
     */
    private String format;

    /**
     * Create a default message context instance.
     *
     * @param player The player.
     * @param recipients The recipients.
     * @param format The format.
     */
    private DefaultChatMessageContext(Player player, Set<Player> recipients, String format) {
        this.player = player;
        this.recipients = recipients;
        this.format = format;
    }

    /**
     * Create a message context instance by a chat event.
     *
     * @param playerChatEvent The player chat event.
     * @return The context instance.
     */
    static ChatMessageContext from(AsyncPlayerChatEvent playerChatEvent) {

        return new DefaultChatMessageContext(playerChatEvent.getPlayer(), playerChatEvent.getRecipients(), playerChatEvent.getFormat());
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Set<Player> getRecipients() {
        return recipients;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean isMessageOk() {
        return messageOk;
    }

    @Override
    public void setMessageOk(boolean messageOk) {
        this.messageOk = messageOk;
    }
}
