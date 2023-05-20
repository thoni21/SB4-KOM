package dk.sdu.mmmi.cbse.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.util.SPILocator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("plugin")
public class Plugin {

    public void startPlugins(GameData gameData, World world) {
        List<IGamePluginService> plugins = SPILocator.locateAll(IGamePluginService.class);
        for (IGamePluginService plugin : plugins) {
            plugin.start(gameData, world);
        }
    }
}
