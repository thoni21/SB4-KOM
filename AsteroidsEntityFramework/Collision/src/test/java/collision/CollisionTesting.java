package collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CollisionTesting {
    private GameData mockGameData;
    private World mockWorld;
    private CollisionDetection collisionDetection;

    @BeforeEach
    void setUp(){
        collisionDetection = new CollisionDetection();
        mockGameData = mock(GameData.class);
        mockWorld = mock(World.class);
    }


    Entity CreateEntity(){
        Entity entity = new Entity();
        entity.add(new PositionPart(5,5,0));
        entity.setRadius(100);

        return entity;
    }

    @Test
    void CollisionTest(){
        Entity entity1 = CreateEntity();
        Entity entity2 = CreateEntity();

        assertTrue(collisionDetection.collides(entity1,entity2));
    }
}
