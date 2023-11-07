package net.laz.create_lazloneering;

import net.laz.create_lazloneering.railway.CLBogeyStyles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LazloneeringClient {

    public static void init(){

        CLBogeyStyles.registerClient();
    }
}
