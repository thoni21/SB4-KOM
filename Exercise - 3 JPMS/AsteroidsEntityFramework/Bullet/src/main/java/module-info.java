import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;
    exports bullet;


    provides IGamePluginService with bullet.BulletPlugin;
    provides IEntityProcessingService with bullet.BulletController;

}