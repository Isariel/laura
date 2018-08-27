package de.d3adspace.laura.spigot.service.chat;

import de.d3adspace.laura.spigot.api.service.chat.ChatMessageContext;
import de.d3adspace.laura.spigot.api.service.chat.ChatMessageProcessor;
import de.d3adspace.laura.spigot.api.service.chat.ChatService;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Default implementation of the {@link ChatService}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Singleton
public class ChatServiceImpl implements ChatService {

    /**
     * The current chat message processor.
     */
    private ChatMessageProcessor chatMessageProcessor;

    /**
     * Create a new chat service by its underlying chat message processor.
     *
     * @param chatMessageProcessor The chat message processor.
     */
    @Inject
    public ChatServiceImpl(ChatMessageProcessor chatMessageProcessor) {
        this.chatMessageProcessor = chatMessageProcessor;
    }

    @Override
    public void setChatMessageProcessor(ChatMessageProcessor chatMessageProcessor) {

        this.chatMessageProcessor = chatMessageProcessor;
    }

    @Override
    public void processChat(AsyncPlayerChatEvent playerChatEvent) {

        String chatMessageContent = playerChatEvent.getMessage();
        ChatMessageContext chatMessageContext = DefaultChatMessageContext.from(playerChatEvent);
        chatMessageProcessor.processChatMessage(chatMessageContext, chatMessageContent);

        boolean isEventCancelled = !chatMessageContext.isMessageOk();
        playerChatEvent.setCancelled(isEventCancelled);
        playerChatEvent.setMessage(chatMessageContent);
        playerChatEvent.setFormat(chatMessageContext.getFormat());
    }
}
