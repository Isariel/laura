package de.d3adspace.laura.spigot.extension;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import de.d3adspace.isabelle.spigot.governator.IsabelleSpigotExtension;
import de.d3adspace.laura.spigot.api.LauraSpigot;
import de.d3adspace.laura.spigot.api.service.chat.ChatService;
import de.d3adspace.laura.spigot.api.service.tablist.TabListService;
import de.d3adspace.laura.spigot.api.service.title.TitleService;
import de.d3adspace.laura.spigot.api.util.TimedSection;
import de.d3adspace.laura.spigot.listener.AsyncPlayerChatListener;
import de.d3adspace.laura.spigot.module.LauraModule;
import de.d3adspace.laura.spigot.module.LauraVaultModule;
import de.d3adspace.laura.spigot.modules.LauraModules;
import de.d3adspace.laura.spigot.util.Timings;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.logging.Level;

/**
 * Central extension endpoint.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LauraSpigotExtension extends IsabelleSpigotExtension implements LauraSpigot {

    private static final String VAULT_PLUGIN_NAME = "Vault";

    /**
     * The timings module.
     */
    @Inject
    private Timings timings;

    /**
     * The chat listener.
     */
    @Inject
    private AsyncPlayerChatListener playerChatListener;

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
     * The chat service.
     */
    @Inject
    private ChatService chatService;

    /**
     * The plugin manager needed for listener registrations.
     */
    @Inject
    private PluginManager pluginManager;

    @Override
    public void configure(Binder binder) {

        // Internal module with initial service bindings.
        Module generalLauraModule = new LauraModule();

        // ProtocolLib bindings.
        binder.install(LauraModules.createProtocolModule());

        // Vault bindings of vault is enabled.
        if (Bukkit.getPluginManager().isPluginEnabled(VAULT_PLUGIN_NAME)) {

            getLogger().log(Level.INFO, "Found Vault. Installing bindings and hooking into Vault...");

            // General vault module of laura library.
            binder.install(LauraModules.createVaultModule());

            // Internal laura vault module overridden with possible vault bindings.
            generalLauraModule = Modules.override(generalLauraModule).with(new LauraVaultModule());
        }

        // Install general module
        binder.install(generalLauraModule);
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
        servicesManager.register(ChatService.class, chatService, this, ServicePriority.High);

        // Bind own plugin instance as a service.
        servicesManager.register(LauraSpigot.class, this, this, ServicePriority.High);
    }

    /**
     * Do the listener registrations with the {@link PluginManager}.
     */
    private void doListenerRegistrations() {

        pluginManager.registerEvents(playerChatListener, this);
    }

    /**
     * Register all commands.
     */
    private void doCommandRegistrations() {


    }
}
