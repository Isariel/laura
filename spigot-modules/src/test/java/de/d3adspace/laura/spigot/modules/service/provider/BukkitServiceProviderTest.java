package de.d3adspace.laura.spigot.modules.service.provider;

import org.bukkit.plugin.ServicesManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
@ExtendWith(MockitoExtension.class)
class BukkitServiceProviderTest {

    @Mock
    private ServicesManager servicesManager;

    private ExampleService exampleService = new ExampleService();
    private BukkitServiceProvider<ExampleService> exampleServiceProvider;

    @BeforeEach
    void setUp() {

        exampleServiceProvider = new BukkitServiceProvider<>(servicesManager, exampleService.getClass());
    }

    @Test
    void get() {

        // given
        doReturn(exampleService).when(servicesManager).load(exampleService.getClass());

        // when
        ExampleService exampleService = exampleServiceProvider.get();

        // then
        verify(servicesManager).load(exampleService.getClass());
        assertNotNull(exampleService, "Example service should not be null.");
        assertEquals(this.exampleService, exampleService, "Example service instance differs.");
    }

    private static final class ExampleService {


    }
}