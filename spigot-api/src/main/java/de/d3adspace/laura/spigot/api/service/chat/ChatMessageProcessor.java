package de.d3adspace.laura.spigot.api.service.chat;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public interface ChatMessageProcessor {

    /**
     * Process the given chat message in the given context.
     *
     * @param chatMessageContext The context of the message.
     * @param chatMessageContent The content of the message.
     */
    void processChatMessage(ChatMessageContext chatMessageContext, String chatMessageContent);
}
