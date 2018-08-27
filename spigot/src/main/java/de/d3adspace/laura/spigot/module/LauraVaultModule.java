package de.d3adspace.laura.spigot.module;

import com.google.inject.AbstractModule;
import de.d3adspace.laura.spigot.api.service.chat.ChatMessageProcessor;
import de.d3adspace.laura.spigot.service.chat.vault.VaultChatMessageProcessor;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LauraVaultModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(ChatMessageProcessor.class).to(VaultChatMessageProcessor.class);
    }
}
