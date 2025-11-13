package dev.lofiz.pride.blocks.flag;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class StandingFlagBlock extends HorizontalDirectionalBlock {

    private static final MapCodec<StandingFlagBlock> CODEC = simpleCodec(StandingFlagBlock::new);

    private static final EnumProperty<Direction> FACING;

    public StandingFlagBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    static {
        FACING = BlockStateProperties.FACING;
    }
}
