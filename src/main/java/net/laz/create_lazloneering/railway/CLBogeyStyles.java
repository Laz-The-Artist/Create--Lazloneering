package net.laz.create_lazloneering.railway;

import com.railwayteam.railways.Railways;
import com.railwayteam.railways.content.custom_bogeys.CRBogeyRenderer;
import com.railwayteam.railways.content.custom_bogeys.invisible.InvisibleBogeyRenderer;
import com.railwayteam.railways.registry.CRBlocks;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllBogeyStyles;
import com.simibubi.create.Create;
import com.simibubi.create.content.trains.CubeParticleData;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.content.trains.bogey.StandardBogeyRenderer;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.foundation.utility.Pair;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

import static com.simibubi.create.AllBogeyStyles.STANDARD_CYCLE_GROUP;

public class CLBogeyStyles {

    private static final Map<Pair<BogeyStyle, TrackMaterial.TrackType>, BogeyStyle> STYLES_FOR_GAUGES = new HashMap<>();

    // create default
    public static final BogeyStyle STANDARD =
            create("standard", STANDARD_CYCLE_GROUP).commonRenderer(() -> StandardBogeyRenderer.CommonStandardBogeyRenderer::new)
                    .displayName(Components.translatable("create.bogey.style.standard"))
                    .size(BogeySizes.SMALL, () -> StandardBogeyRenderer.SmallStandardBogeyRenderer::new, AllBlocks.SMALL_BOGEY)
                    .size(BogeySizes.LARGE, () -> StandardBogeyRenderer.LargeStandardBogeyRenderer::new, AllBlocks.LARGE_BOGEY)
                    .build();

    //snr "default"
    public static final BogeyStyle INVISIBLE = create("invisible", Create.asResource(STANDARD_CYCLE_GROUP))
            .displayName(Components.translatable("railways.bogeys.styles.invisible"))
            .size(BogeySizes.SMALL, () -> InvisibleBogeyRenderer::new, CRBlocks.INVISIBLE_BOGEY)
            .contactParticle(new CubeParticleData())
            .build();

    //snr narrow
    public static final BogeyStyle
            NARROW_DEFAULT = create("narrow_default", Create.asResource(STANDARD_CYCLE_GROUP))
            .displayName(Components.translatable("railways.bogeys.styles.narrow_default"))
            .size(BogeySizes.SMALL, () -> CRBogeyRenderer.NarrowSmallBogeyRenderer::new, CRBlocks.NARROW_SMALL_BOGEY)
            .size(BogeySizes.LARGE, () -> CRBogeyRenderer.NarrowScotchYokeBogeyRenderer::new, CRBlocks.NARROW_SCOTCH_BOGEY)
            .build();

    private static AllBogeyStyles.BogeyStyleBuilder create(String name, String cycleGroup) {
        return create(Create.asResource(name), Create.asResource(cycleGroup));
    }

    public static AllBogeyStyles.BogeyStyleBuilder create(ResourceLocation name, ResourceLocation cycleGroup) {
        return new AllBogeyStyles.BogeyStyleBuilder(name, cycleGroup);
    }

    public void register (){

    }
}
