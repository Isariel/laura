package de.d3adspace.laura.spigot.modules.vault.provider;

import de.d3adspace.laura.spigot.modules.service.provider.BukkitServiceProvider;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.ServicesManager;

import javax.inject.Inject;

/**
 * An {@link BukkitServiceProvider} for Vault's {@link Chat}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class ChatProvider extends BukkitServiceProvider<Chat> {

    /**
     * Create a new chat provider.
     */
    @Inject
    public ChatProvider(ServicesManager servicesManager) {
        super(servicesManager, Chat.class);
    }
}
