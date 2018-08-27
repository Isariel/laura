package de.d3adspace.laura.spigot.service.chat;

import com.netflix.governator.annotations.Configuration;
import de.d3adspace.laura.spigot.api.service.chat.ChatMessageContext;
import de.d3adspace.laura.spigot.api.service.chat.ChatMessageProcessor;

import javax.inject.Singleton;

/**
 * The default {@link ChatMessageProcessor} that will use a message format specified by the plugins configuration.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Singleton
public class DefaultChatMessageProcessor implements ChatMessageProcessor {

    /**
     * The chat format.
     */
    @Configuration(value = "chat.format")
    private String chatFormat = "%s: %s";

    @Override
    public void processChatMessage(ChatMessageContext chatMessageContext, String chatMessageContent) {

        // Use the chat format
        chatMessageContext.setFormat(chatFormat);
    }
}
