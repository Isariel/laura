package de.d3adspace.laura.spigot.modules.protocol;

import com.comphenix.protocol.ProtocolConfig;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.google.inject.AbstractModule;
import de.d3adspace.laura.spigot.modules.protocol.annotation.ProtocolLib;
import org.bukkit.plugin.Plugin;

/**
 * Binding module for {@link ProtocolLibrary}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class ProtocolLibModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(Plugin.class).annotatedWith(ProtocolLib.class).toInstance(ProtocolLibrary.getPlugin());
        bind(ProtocolManager.class).toInstance(ProtocolLibrary.getProtocolManager());
        bind(ProtocolConfig.class).toInstance(ProtocolLibrary.getConfig());
    }
}
