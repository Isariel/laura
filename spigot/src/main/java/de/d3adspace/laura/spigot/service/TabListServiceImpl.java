package de.d3adspace.laura.spigot.service;

import com.comphenix.packetwrapper.WrapperPlayServerPlayerListHeaderFooter;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import de.d3adspace.laura.spigot.api.service.TabListService;
import org.bukkit.entity.Player;

import javax.inject.Singleton;

/**
 * Default implementation of the {@link TabListService}. It's based on using the
 * {@link WrapperPlayServerPlayerListHeaderFooter} packet wrapper and constructs it in
 * {@link #constructPacket(WrappedChatComponent, WrappedChatComponent)} from its underlying components.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Singleton
public class TabListServiceImpl implements TabListService {

    @Override
    public void broadcastHeaderFooter(WrappedChatComponent headerComponent, WrappedChatComponent footerComponent) {

        WrapperPlayServerPlayerListHeaderFooter wrapper = constructPacket(headerComponent, footerComponent);
        wrapper.broadcastPacket();
    }

    @Override
    public void sendHeaderFooter(Player player, WrappedChatComponent headerComponent, WrappedChatComponent footerComponent) {

        WrapperPlayServerPlayerListHeaderFooter wrapper = constructPacket(headerComponent, footerComponent);
        wrapper.sendPacket(player);
    }

    /**
     * Construct a packet using a the {@link WrapperPlayServerPlayerListHeaderFooter} around the packet.
     *
     * @param headerComponent The header component.
     * @param footerComponent The footer component.
     *
     * @return The wrapper instance.
     */
    private WrapperPlayServerPlayerListHeaderFooter constructPacket(WrappedChatComponent headerComponent, WrappedChatComponent footerComponent) {

        WrapperPlayServerPlayerListHeaderFooter wrapper = new WrapperPlayServerPlayerListHeaderFooter();
        wrapper.setHeader(headerComponent);
        wrapper.setFooter(footerComponent);
        return wrapper;
    }
}
