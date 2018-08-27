package de.d3adspace.laura.spigot.service.title;

import com.comphenix.packetwrapper.WrapperPlayServerTitle;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import de.d3adspace.laura.spigot.api.service.title.TitleService;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.entity.Player;

import javax.inject.Singleton;

/**
 * Default implementation of the {@link TitleService}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Singleton
public class TitleServiceImpl implements TitleService {

    @Override
    public void sendTitle(Player player, int fadeInDuration, int stayDuration, int fadeOutDuration, BaseComponent titleComponent, BaseComponent subtitleComponent) {

        sendTimings(player, fadeInDuration, stayDuration, fadeOutDuration);

        if (titleComponent != null) {
            sendTitle(player, EnumWrappers.TitleAction.TITLE, titleComponent);
        }

        if (subtitleComponent != null) {
            sendTitle(player, EnumWrappers.TitleAction.SUBTITLE, subtitleComponent);
        }
    }

    @Override
    public void sendTitle(Player player, int fadeInDuration, int stayDuration, int fadeOutDuration, BaseComponent titleComponent) {

        sendTitle(player, fadeInDuration, stayDuration, fadeOutDuration, titleComponent, null);
    }

    /**
     * Send the title packet itself with a title component and a specific action. Usually this action will be
     * {@link EnumWrappers.TitleAction#TITLE} or {@link EnumWrappers.TitleAction#SUBTITLE}.
     *
     * @param player      The player.
     * @param titleAction The title action.
     * @param component   The component.
     */
    private void sendTitle(Player player, EnumWrappers.TitleAction titleAction, BaseComponent component) {
        WrapperPlayServerTitle wrapperPlayServerTitle = new WrapperPlayServerTitle();
        wrapperPlayServerTitle.setAction(titleAction);
        wrapperPlayServerTitle.setTitle(WrappedChatComponent.fromJson(ComponentSerializer.toString(component)));
        wrapperPlayServerTitle.sendPacket(player);
    }

    /**
     * Send the meta packet with the timings marked by the {@link EnumWrappers.TitleAction#TIMES} flag.
     *
     * @param player          The player.
     * @param fadeInDuration  How long the title takes to fade in.
     * @param stayDuration    How long the title takes to stay.
     * @param fadeOutDuration How long the title takes to fade out.
     */
    private void sendTimings(Player player, int fadeInDuration, int stayDuration, int fadeOutDuration) {
        WrapperPlayServerTitle wrapperPlayServerTimes = new WrapperPlayServerTitle();
        wrapperPlayServerTimes.setAction(EnumWrappers.TitleAction.TIMES);
        wrapperPlayServerTimes.setFadeIn(fadeInDuration);
        wrapperPlayServerTimes.setFadeOut(fadeOutDuration);
        wrapperPlayServerTimes.setStay(stayDuration);
        wrapperPlayServerTimes.sendPacket(player);
    }
}
