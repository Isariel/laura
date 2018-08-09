package de.d3adspace.laura.spigot.modules;

import com.google.inject.Module;
import de.d3adspace.laura.spigot.modules.protocol.ProtocolLibModule;
import de.d3adspace.laura.spigot.modules.service.LauraServiceModule;

/**
 * Contains some factory methods for popular modules, that are widely used.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LauraModules {

    /**
     * Create a module that provides bindings for ProtocolLib.
     *
     * @return The module instance.
     *
     * @see ProtocolLibModule The module.
     */
    public static Module createProtocolModule() {

        return new ProtocolLibModule();
    }

    /**
     * Create a module that provides bindings for the standard services under
     * {@link de.d3adspace.laura.spigot.api.service}.
     *
     * @return The module instance.
     *
     * @see LauraServiceModule The module.
     */
    public static Module createServiceModule() {

        return new LauraServiceModule();
    }
}
