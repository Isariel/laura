package de.d3adspace.laura.spigot.modules.service.provider;

import org.bukkit.plugin.ServicesManager;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Generic service provider that will load an arbitrary service from bukkit {@link ServicesManager}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class BukkitServiceProvider<ServiceType> implements Provider<ServiceType> {

    /**
     * The services manager of bukkit.
     */
    private final ServicesManager servicesManager;

    /**
     * The class of the service to load.
     */
    private final Class<? extends ServiceType> serviceClazz;

    /**
     * Create a new bukkit service provider by the services manager and the class to load as a service.
     *
     * @param servicesManager The services manager.
     * @param serviceClazz    The class of the service.
     */
    @Inject
    public BukkitServiceProvider(ServicesManager servicesManager, Class<? extends ServiceType> serviceClazz) {
        this.servicesManager = servicesManager;
        this.serviceClazz = serviceClazz;
    }

    @Override
    public ServiceType get() {

        return servicesManager.load(serviceClazz);
    }
}
