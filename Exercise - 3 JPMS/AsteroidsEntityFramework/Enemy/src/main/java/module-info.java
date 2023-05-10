import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Enemy {
    requires Common;
    exports enemysystem;


    provides IGamePluginService with enemysystem.EnemyPlugin;
    provides IEntityProcessingService with enemysystem.EnemyController;

}