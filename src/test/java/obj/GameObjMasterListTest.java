package obj;

import com.sxt.obj.BossBullet;
import com.sxt.obj.BossObj;
import com.sxt.obj.GameObj;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
Ensures that the self management of the objects show correct mapping for our GameObjs using masterlist.
Should be further refactored to disconnect with GameUtils - K
 */
public class GameObjMasterListTest {

    @Test
    public void testBossBullet() {
        //Add BossBullet To our list
        GameObj bossBullet =  new BossBullet(null, 0, 0, 50, 900, 0, null);
        GameUtils.masterList.put(GameObjType.BOSSBULLET, new ArrayList<>());
        GameUtils.masterList.put(GameObjType.EXPLODEOBJ, new ArrayList<>());
        GameUtils.masterList.get(GameObjType.BOSSBULLET).add(bossBullet);

        //force damage
        bossBullet.damage(1, null);

        //It should no longer exist in our system.
        assertFalse(GameUtils.masterList.get(GameObjType.BOSSBULLET).contains(bossBullet));
    }

    @Test
    public void testBossObj() {
        //Add BossBullet To our list
        BossObj BossObj =  new BossObj(null, 0, 0, 50, 900, 0, null);
        GameUtils.masterList.put(GameObjType.BOSS, new ArrayList<>());
        GameUtils.masterList.put(GameObjType.EXPLODEOBJ, new ArrayList<>());
        GameUtils.masterList.get(GameObjType.BOSS).add(BossObj);

        //force damage
        BossObj.damage(1, null);

        //Should still be alive
        assertTrue(GameUtils.masterList.get(GameObjType.BOSS).contains(BossObj));

        //force damage on remaining health
        for (int i = 0; i < 29; i++) //30 damage
        BossObj.damage(1, null);

        //It should no longer exist in our system.
        assertFalse(GameUtils.masterList.get(GameObjType.BOSS).contains(BossObj));
    }

}
