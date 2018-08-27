package de.d3adspace.laura.spigot.module;

import com.google.inject.AbstractModule;
import de.d3adspace.laura.spigot.api.service.chat.ChatMessageProcessor;
import de.d3adspace.laura.spigot.api.service.chat.ChatService;
import de.d3adspace.laura.spigot.api.service.tablist.TabListService;
import de.d3adspace.laura.spigot.api.service.title.TitleService;
import de.d3adspace.laura.spigot.modules.service.provider.BukkitServiceProvider;
import de.d3adspace.laura.spigot.service.chat.ChatServiceImpl;
import de.d3adspace.laura.spigot.service.chat.DefaultChatMessageProcessor;
import de.d3adspace.laura.spigot.service.tablist.TabListServiceImpl;
import de.d3adspace.laura.spigot.service.title.TitleServiceImpl;
import org.bukkit.plugin.ServicesManager;

/**
 * Lauras internal module that will bind some service. While the {@link BukkitServiceProvider} can only load services
 * after they're registered via {@link ServicesManager} we have to do one initial binding for services.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LauraModule extends AbstractModule {

    @Override
    protected void configure() {

        // Services
        bind(TabListService.class).to(TabListServiceImpl.class);

        bind(TitleService.class).to(TitleServiceImpl.class);

        bind(ChatService.class).to(ChatServiceImpl.class);
        bind(ChatMessageProcessor.class).to(DefaultChatMessageProcessor.class);
    }
}
