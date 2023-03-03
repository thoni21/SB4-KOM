import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createEnemyShip(gameData);
        world.addEntity(asteroid);
    }

    private Entity createEnemyShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 150;
        float maxSpeed = 200;
        float rotationSpeed = 5;
        float x = new Random().nextFloat() * gameData.getDisplayWidth();
        float y = new Random().nextFloat() * gameData.getDisplayHeight();
        float radians = 3.1415f / 2;

        float[] colour = new float[4];
        colour[0] = 1.0f;
        colour[1] = 0.0f;
        colour[2] = 0.0f;
        colour[3] = 1.0f;

        Entity asteroidInSpace = new Asteroid();
        asteroidInSpace.setRadius(8);
        asteroidInSpace.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteroidInSpace.add(new PositionPart(x, y, radians));
        asteroidInSpace.add(new LifePart(1,0));

        return asteroidInSpace;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }
}
