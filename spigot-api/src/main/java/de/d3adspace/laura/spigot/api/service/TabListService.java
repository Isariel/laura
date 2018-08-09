package de.d3adspace.laura.spigot.api.service;

import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.entity.Player;

/**
 * Service used to decorate the tab list of a server. You may want to set header and footer on the fly and that for
 * a single player or for all online players. You can use
 * {@link #sendHeaderFooter(Player, WrappedChatComponent, WrappedChatComponent)} for single players and
 * {@link #broadcastHeaderFooter(WrappedChatComponent, WrappedChatComponent)} to broadcast the changes to all players.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public interface TabListService {

    /**
     * Broadcast the given header and footer to all players on the server.
     *
     * @param headerComponent The header component.
     * @param footerComponent The footer component.
     */
    void broadcastHeaderFooter(WrappedChatComponent headerComponent, WrappedChatComponent footerComponent);

    /**
     * Send the given header and footer components to the given player.
     *
     * @param player          The player.
     * @param headerComponent The header component.
     * @param footerComponent The footer component.
     */
    void sendHeaderFooter(Player player, WrappedChatComponent headerComponent, WrappedChatComponent footerComponent);
}
