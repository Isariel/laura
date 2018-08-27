package de.d3adspace.laura.spigot.api.service.title;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

/**
 * Service used to display titles on the players screen.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public interface TitleService {

    /**
     * Send a title to the given player and define all parameters.
     *
     * @param player            The player to send the title to.
     * @param fadeInDuration    How long the title should take to fade in.
     * @param stayDuration      How long the title should stay.
     * @param fadeOutDuration   How long the title should take to fade out.
     * @param titleComponent    The component for the title.
     * @param subtitleComponent The component for the subtitle.
     */
    void sendTitle(Player player, int fadeInDuration, int stayDuration, int fadeOutDuration, BaseComponent titleComponent, BaseComponent subtitleComponent);

    /**
     * Send a title ot the given players and just let out the subtitle.
     *
     * @param player          The player to send the title to.
     * @param fadeInDuration  How long the title should take to fade in.
     * @param stayDuration    How long the title should stay.
     * @param fadeOutDuration How long the title should take to fade out.
     * @param titleComponent  The component for the title.
     */
    void sendTitle(Player player, int fadeInDuration, int stayDuration, int fadeOutDuration, BaseComponent titleComponent);
}
