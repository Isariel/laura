package de.d3adspace.laura.spigot.modules.service;

import com.google.inject.AbstractModule;
import de.d3adspace.laura.spigot.api.service.TabListService;
import de.d3adspace.laura.spigot.modules.service.provider.TabListServiceProvider;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LauraServiceModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(TabListService.class).toProvider(TabListServiceProvider.class);
    }
}
