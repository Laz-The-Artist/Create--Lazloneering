package net.laz.create_lazloneering.railway;

import com.railwayteam.railways.content.custom_bogeys.CategoryIcon;
import com.railwayteam.railways.content.custom_bogeys.selection_menu.BogeyCategoryHandlerClient;
import com.railwayteam.railways.registry.CRBlocks;
import com.railwayteam.railways.registry.CRBogeyStyles;
import com.railwayteam.railways.registry.CRTrackMaterials;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllBogeyStyles;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.content.trains.bogey.StandardBogeyRenderer;
import com.simibubi.create.foundation.utility.Components;
import net.laz.create_lazloneering.Lazloneering;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class CLBogeyStyles {

    public static final String DIESEL_CYCLEGROUP = "diesels";

    public static final BogeyStyle DIESEL_DEFAULT = //TODO: custom bogey block and renderer soon tm
            CLBogeyStyles.create("diesel", DIESEL_CYCLEGROUP).commonRenderer(() -> StandardBogeyRenderer.CommonStandardBogeyRenderer::new)
                    .displayName(Components.translatable(Lazloneering.MODID +".bogey.style.diesel"))
                    .size(BogeySizes.SMALL, () -> StandardBogeyRenderer.SmallStandardBogeyRenderer::new, CRBlocks.INVISIBLE_BOGEY)
                    .size(BogeySizes.LARGE, () -> StandardBogeyRenderer.LargeStandardBogeyRenderer::new, AllBlocks.LARGE_BOGEY)
                    .build();

    private static AllBogeyStyles.BogeyStyleBuilder create(String name, String cycleGroup) {
        return create(Lazloneering.asResource(name), Lazloneering.asResource(cycleGroup));
    }

    public static AllBogeyStyles.BogeyStyleBuilder create(ResourceLocation name, ResourceLocation cycleGroup) {
        return new AllBogeyStyles.BogeyStyleBuilder(name, cycleGroup);
    }

    public static void register() {
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerClient() {
        //TODO: custom icon
        BogeyCategoryHandlerClient.registerStyleCategory(DIESEL_CYCLEGROUP, CategoryIcon.standardSupplier("radial_icon"));
    }

}
