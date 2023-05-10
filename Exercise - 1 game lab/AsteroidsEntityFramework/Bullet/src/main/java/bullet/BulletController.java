package bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.*;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Timer;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class BulletController implements IEntityProcessingService{
    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity : world.getEntities()) {
            BulletPart bulletPart = entity.getPart(BulletPart.class);
            PositionPart positionPart = entity.getPart(PositionPart.class);

            if (bulletPart != null) {
                if (bulletPart.canShoot()){
                    float x = positionPart.getX();
                    float y = positionPart.getY();
                    float rads = positionPart.getRadians();
                    spawnBullet(world, (float) (x + Math.cos(rads) * 15), (float) (y + Math.sin(rads) * 15 ), rads);
                    bulletPart.resetTimer();
                } else {bulletPart.timer();}
            }
        }

        for (Entity bullet : world.getEntities(Bullet.class)) {

            PositionPart positionPart = bullet.getPart(PositionPart.class);
            MovingPart movingPart = bullet.getPart(MovingPart.class);
            TimerPart timerPart = bullet.getPart(TimerPart.class);
            movingPart.setUp(true);

            timerPart.reduceExpiration(0.5f);
            if(timerPart.getExpiration() <= 0){
                world.removeEntity(bullet);
            }
            timerPart.process(gameData,bullet);
            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);

            updateShape(bullet);
        }
    }

    private void spawnBullet(World world, float x, float y, float rotation) {
        Bullet bullet = new Bullet();
        MovingPart movingPart = new MovingPart(0, 500, 500, 0);
        movingPart.setUp(true);
        bullet.add(movingPart);
        bullet.add(new LifePart(1, 1));
        bullet.add(new PositionPart(x, y, rotation));
        bullet.add(new TimerPart(20));

        world.addEntity(bullet);
    }

    private void updateShape(Entity entity) {
        float[] shapeX = entity.getShapeX();
        float[] shapeY = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapeX[0] = (float) (x + Math.cos(radians) * 1);
        shapeY[0] = (float) (y + Math.sin(radians) * 1);

        shapeX[1] = (float) (x + Math.cos(radians) * 0);
        shapeY[1] = (float) (y + Math.sin(radians) * 0);

        shapeX[2] = (float) (x + Math.cos(radians) * 2);
        shapeY[2] = (float) (y + Math.sin(radians) * 2);

        shapeX[3] = (float) (x + Math.cos(radians) * -2);
        shapeY[3] = (float) (y + Math.sin(radians) * -2);

        entity.setShapeX(shapeX);
        entity.setShapeY(shapeY);
    }
}
