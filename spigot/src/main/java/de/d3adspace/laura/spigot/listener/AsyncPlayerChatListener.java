package de.d3adspace.laura.spigot.listener;

import de.d3adspace.laura.spigot.api.service.chat.ChatService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import javax.inject.Inject;

/**
 * The listener for the {@link AsyncPlayerChatEvent}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class AsyncPlayerChatListener implements Listener {

    /**
     * The chat service used for formatting and other chat concerns.
     */
    private final ChatService chatService;

    @Inject
    public AsyncPlayerChatListener(ChatService chatService) {
        this.chatService = chatService;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent playerChatEvent) {

        // Let the chat service handle formatting and recipients etc.
        chatService.processChat(playerChatEvent);
    }
}
