package de.d3adspace.laura.spigot.service.chat.vault;

import com.netflix.governator.annotations.Configuration;
import de.d3adspace.laura.spigot.api.service.chat.ChatMessageContext;
import de.d3adspace.laura.spigot.api.service.chat.ChatMessageProcessor;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.World;
import org.bukkit.entity.Player;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.text.MessageFormat;

/**
 * A {@link ChatMessageProcessor} based on Vault's {@link Chat}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Singleton
public class VaultChatMessageProcessor implements ChatMessageProcessor {

    @Configuration("chat.vault.format")
    private String vaultFormat = "{0}%s{1}: %s";

    /**
     * The vault chat used for prefix and suffix retrival and so on.
     */
    private final Chat vaultChat;

    /**
     * Create a new vault based chat message processor by the underlying vault chat.
     *
     * @param vaultChat The vault chat.
     */
    @Inject
    public VaultChatMessageProcessor(Chat vaultChat) {

        this.vaultChat = vaultChat;
    }

    @Override
    public void processChatMessage(ChatMessageContext chatMessageContext, String chatMessageContent) {

        Player player = chatMessageContext.getPlayer();
        World world = player.getWorld();

        String playerPrefix = vaultChat.getPlayerPrefix(world.getName(), player);
        String playerSuffix = vaultChat.getPlayerSuffix(world.getName(), player);

        chatMessageContext.setFormat(MessageFormat.format(vaultFormat, playerPrefix, playerSuffix));
    }
}
