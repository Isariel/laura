package de.d3adspace.laura.spigot.api.service.chat;

import org.bukkit.entity.Player;

import java.util.Set;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public interface ChatMessageContext {

    Player getPlayer();

    Set<Player> getRecipients();

    String getFormat();

    void setFormat(String format);

    boolean isMessageOk();

    void setMessageOk(boolean messageOk);
}
