package de.d3adspace.laura.spigot.modules.service;

import com.google.inject.AbstractModule;
import de.d3adspace.laura.spigot.api.service.tablist.TabListService;
import de.d3adspace.laura.spigot.api.service.title.TitleService;
import de.d3adspace.laura.spigot.modules.service.provider.TabListServiceProvider;
import de.d3adspace.laura.spigot.modules.service.provider.TitleServiceProvider;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LauraServiceModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(TabListService.class).toProvider(TabListServiceProvider.class);
        bind(TitleService.class).toProvider(TitleServiceProvider.class);
    }
}
