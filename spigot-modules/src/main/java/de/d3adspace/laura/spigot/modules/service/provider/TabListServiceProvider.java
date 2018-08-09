package de.d3adspace.laura.spigot.modules.service.provider;

import de.d3adspace.laura.spigot.api.service.TabListService;
import org.bukkit.plugin.ServicesManager;

import javax.inject.Inject;

/**
 * An {@link BukkitServiceProvider} for the {@link TabListService}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class TabListServiceProvider extends BukkitServiceProvider<TabListService> {

    /**
     * Create a new tab list service provider by the {@link ServicesManager} the service should be loaded from.
     *
     * @param servicesManager The services manager.
     */
    @Inject
    public TabListServiceProvider(ServicesManager servicesManager) {
        super(servicesManager, TabListService.class);
    }
}
