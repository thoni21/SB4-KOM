package dk.sdu.mmmi.cbse.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.util.SPILocator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entityProcessor")
public class EntityProcessor implements Processor{
    @Override
    public void process(GameData gameData, World world) {
        List<IEntityProcessingService> plugins = SPILocator.locateAll(IEntityProcessingService.class);
        for (IEntityProcessingService plugin : plugins) {
            plugin.process(gameData, world);
        }
    }
}
