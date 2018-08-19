package de.d3adspace.laura.spigot.extension;

import com.google.inject.Binder;
import de.d3adspace.isabelle.spigot.governator.IsabelleSpigotExtension;
import de.d3adspace.laura.spigot.api.LauraSpigot;
import de.d3adspace.laura.spigot.api.service.TabListService;
import de.d3adspace.laura.spigot.api.service.TitleService;
import de.d3adspace.laura.spigot.api.util.TimedSection;
import de.d3adspace.laura.spigot.module.LauraModule;
import de.d3adspace.laura.spigot.modules.LauraModules;
import de.d3adspace.laura.spigot.util.Timings;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Central extension endpoint.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LauraSpigotExtension extends IsabelleSpigotExtension implements LauraSpigot {

    @Inject
    Timings timings;

    /**
     * Services manager needed to expose services over the boundaries of a single plugin.
     */
    @Inject
    private ServicesManager servicesManager;

    /**
     * The tab list service.
     */
    @Inject
    private TabListService tabListService;

    /**
     * The title service.
     */
    @Inject
    private TitleService titleService;

    /**
     * The plugin manager needed for listener registrations.
     */
    @Inject
    private PluginManager pluginManager;

    @Override
    public void configure(Binder binder) {

        // Internal module with initial service bindings.
        binder.install(new LauraModule());

        // ProtocolLib bindings.
        binder.install(LauraModules.createProtocolModule());
    }

    @PostConstruct
    public void onPostConstruct() {

        try (TimedSection ignored = timings.of("Service Registration")) {

            doServiceRegistrations();
        }

        try (TimedSection ignored = timings.of("Listener Registration")) {

            doListenerRegistrations();
        }

        try (TimedSection ignored = timings.of("Command Registration")) {

            doCommandRegistrations();
        }
    }

    /**
     * Do the internal service bindings to the {@link ServicesManager}.
     */
    private void doServiceRegistrations() {

        // Bind utility services.
        servicesManager.register(TabListService.class, tabListService, this, ServicePriority.High);
        servicesManager.register(TitleService.class, titleService, this, ServicePriority.High);

        // Bind own plugin instance as a service.
        servicesManager.register(LauraSpigot.class, this, this, ServicePriority.High);
    }

    /**
     * Do the listener registrations with the {@link PluginManager}.
     */
    private void doListenerRegistrations() {


    }

    /**
     * Register all commands.
     */
    private void doCommandRegistrations() {


    }
}
