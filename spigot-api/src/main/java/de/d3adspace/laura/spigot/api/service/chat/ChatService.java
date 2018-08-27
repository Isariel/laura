package de.d3adspace.laura.spigot.api.service.chat;

import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public interface ChatService {

    /**
     * Set the chat message processor.
     *
     * @param chatMessageProcessor The chat message processor.
     */
    void setChatMessageProcessor(ChatMessageProcessor chatMessageProcessor);

    /**
     * Process the given chat event.
     *
     * @param playerChatEvent The chat event.
     */
    void processChat(AsyncPlayerChatEvent playerChatEvent);
}
