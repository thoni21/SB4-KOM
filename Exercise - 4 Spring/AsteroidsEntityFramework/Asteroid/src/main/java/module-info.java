import dk.sdu.mmmi.cbse.common.services.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    exports asteroid;


    provides IGamePluginService with asteroid.AsteroidPlugin;
    provides IEntityProcessingService with asteroid.AsteroidController;
    provides IAsteroidSplitter with asteroid.AsteroidSplitter;
}