package de.d3adspace.laura.spigot.modules.vault;

import com.google.inject.AbstractModule;
import de.d3adspace.laura.spigot.modules.vault.provider.ChatProvider;
import net.milkbowl.vault.chat.Chat;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class VaultModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(Chat.class).toProvider(ChatProvider.class);
    }
}
