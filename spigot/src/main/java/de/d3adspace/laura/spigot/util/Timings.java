package de.d3adspace.laura.spigot.util;

import de.d3adspace.isabelle.spigot.governator.annotation.PluginLogger;
import de.d3adspace.laura.spigot.api.util.TimedSection;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Singleton
public class Timings {

    private final Logger logger;

    @Inject
    public Timings(@PluginLogger Logger logger) {
        this.logger = logger;
    }

    /**
     * Create a new timing auto close able.
     *
     * @param name The name of the section.
     *
     * @return The closeable timing.
     */
    public TimedSection of(String name) {

        return new TimedSection(logger, name);
    }
}
