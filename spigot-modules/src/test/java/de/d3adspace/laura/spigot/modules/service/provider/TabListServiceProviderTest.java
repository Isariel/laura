package de.d3adspace.laura.spigot.modules.service.provider;

import de.d3adspace.laura.spigot.api.service.TabListService;
import org.bukkit.plugin.ServicesManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
@ExtendWith(MockitoExtension.class)
class TabListServiceProviderTest {

    private static final Class<TabListService> SERVICE_CLASS = TabListService.class;

    @Mock
    TabListService tabListService;
    @Mock
    private ServicesManager servicesManager;

    private TabListServiceProvider tabListServiceProvider;

    @BeforeEach
    void setUp() {

        tabListServiceProvider = new TabListServiceProvider(servicesManager);
    }

    @Test
    void testGet() {
        // Given
        doReturn(tabListService).when(servicesManager).load(SERVICE_CLASS);

        // When
        TabListService tabListService = tabListServiceProvider.get();

        // Then
        assertNotNull(tabListService, "Tab list service should not be null.");
        assertEquals(this.tabListService, tabListService, "Tab list service instance differs.");
    }
}