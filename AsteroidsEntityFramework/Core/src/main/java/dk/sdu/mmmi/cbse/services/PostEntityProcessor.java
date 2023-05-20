package dk.sdu.mmmi.cbse.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.util.SPILocator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postEntityProcessor")
public class PostEntityProcessor implements Processor{
    @Override
    public void process(GameData gameData, World world) {
        List<IPostEntityProcessingService> plugins = SPILocator.locateAll(IPostEntityProcessingService.class);
        for (IPostEntityProcessingService plugin : plugins) {
            plugin.process(gameData, world);
        }
    }
}
