package de.d3adspace.laura.spigot.module;

import com.google.inject.AbstractModule;
import de.d3adspace.laura.spigot.api.service.TabListService;
import de.d3adspace.laura.spigot.modules.service.provider.BukkitServiceProvider;
import de.d3adspace.laura.spigot.service.TabListServiceImpl;
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
    }
}
