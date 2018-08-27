package de.d3adspace.laura.spigot.modules.service.provider;

import de.d3adspace.laura.spigot.api.service.title.TitleService;
import org.bukkit.plugin.ServicesManager;

import javax.inject.Inject;

/**
 * An {@link BukkitServiceProvider} for the {@link TitleService}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class TitleServiceProvider extends BukkitServiceProvider<TitleService> {

    /**
     * Create a new title service provider by the {@link ServicesManager} the service should be loaded from.
     *
     * @param servicesManager The services manager.
     */
    @Inject
    public TitleServiceProvider(ServicesManager servicesManager) {
        super(servicesManager, TitleService.class);
    }
}
