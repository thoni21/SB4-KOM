package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class BulletPart implements EntityPart{

    int shootingTimer;
    int timer = 0;

    public BulletPart(int shootingTimer){
        this.shootingTimer = shootingTimer;
    }

    public boolean canShoot(){
        return timer > shootingTimer;
    }

    public void timer(){
        timer++;
    }

    public void resetTimer(){
        timer = 0;
    }

    @Override
    public void process(GameData gameData, Entity entity) {

    }
}
