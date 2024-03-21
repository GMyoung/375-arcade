package obj;

import com.sxt.obj.BgObj;
import com.sxt.obj.GameObj;
import org.junit.Test;

import static org.junit.Assert.*;

public class BgObjTest {

    @Test
    public void testIsRectangle(){

        GameObj bg = new BgObj();
        assertTrue(bg.getRec() != null);

    }
}
