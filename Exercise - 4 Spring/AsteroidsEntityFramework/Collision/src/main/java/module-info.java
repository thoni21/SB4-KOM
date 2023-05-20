import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    exports collision;

    provides IPostEntityProcessingService with collision.CollisionDetection;
}