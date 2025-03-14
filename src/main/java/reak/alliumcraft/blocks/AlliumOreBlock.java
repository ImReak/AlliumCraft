package reak.alliumcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import static reak.alliumcraft.ModDustParticleEffect.AlliumOreColor;

public class AlliumOreBlock extends Block {
    public static final BooleanProperty LIT;


    public AlliumOreBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(LIT, false));
    }

    protected void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        light(state, world, pos);
        super.onBlockBreakStart(state, world, pos, player);
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.bypassesSteppingEffects()) {
            light(state, world, pos);
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            spawnParticles(world, pos);
        } else {
            light(state, world, pos);
        }

        return stack.getItem() instanceof BlockItem && (new ItemPlacementContext(player, hand, stack, hit)).canPlace() ? ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION : ItemActionResult.SUCCESS;
    }

    private static void light(BlockState state, World world, BlockPos pos) {
        spawnParticles(world, pos);
        if (!(Boolean)state.get(LIT)) {
            world.setBlockState(pos, state.with(LIT, true), 3);
        }

    }

    protected boolean hasRandomTicks(BlockState state) {
        return state.get(LIT);
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            world.setBlockState(pos, state.with(LIT, false), 3);
        }

    }

    protected void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, tool, dropExperience);
        if (dropExperience) {
            this.dropExperienceWhenMined(world, pos, tool, UniformIntProvider.create(1, 5));
        }

    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            spawnParticles(world, pos);
        }

    }

    private static void spawnParticles(World world, BlockPos pos) {
        Random random = world.random;
        for(Direction direction : Direction.values()) {
            BlockPos blockPos = pos.offset(direction);
            if (!world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
                Axis axis = direction.getAxis();
                double e = axis == Axis.X ? (double)0.5F + (double)0.5625F * (double)direction.getOffsetX() : (double)random.nextFloat();
                double f = axis == Axis.Y ? (double)0.5F + (double)0.5625F * (double)direction.getOffsetY() : (double)random.nextFloat();
                double g = axis == Axis.Z ? (double)0.5F + (double)0.5625F * (double)direction.getOffsetZ() : (double)random.nextFloat();
                world.addParticle(AlliumOreColor, (double)pos.getX() + e, (double)pos.getY() + f, (double)pos.getZ() + g, 0.0F, 0.0F, 0.0F);
            }
        }

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    static {
        LIT = RedstoneTorchBlock.LIT;
    }
}
