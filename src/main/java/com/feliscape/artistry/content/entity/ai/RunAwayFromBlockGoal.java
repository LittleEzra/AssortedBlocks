package com.feliscape.artistry.content.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;
import java.util.function.Predicate;

public class RunAwayFromBlockGoal extends Goal {
    protected final PathfinderMob mob;
    private final Predicate<BlockState> predicate;
    private final double speedModifier;
    protected Path path;

    public RunAwayFromBlockGoal(PathfinderMob mob, Predicate<BlockState> predicate, double speedModifier) {
        this.mob = mob;
        this.predicate = predicate;
        this.speedModifier = speedModifier;
    }
    public RunAwayFromBlockGoal(PathfinderMob mob, Block block, double speedModifier) {
        this.mob = mob;
        this.predicate = state -> state.is(block);
        this.speedModifier = speedModifier;
    }
    public RunAwayFromBlockGoal(PathfinderMob mob, TagKey<Block> block, double speedModifier) {
        this.mob = mob;
        this.predicate = state -> state.is(block);
        this.speedModifier = speedModifier;
    }

    public Predicate<BlockState> block(){
        return predicate;
    }

    @Override
    public boolean canUse() {
        Optional<BlockPos> nearestRepellentOptional = nearestBlockToAvoid(5, 3);
        if (nearestRepellentOptional.isEmpty()) return false;
        BlockPos nearestRepellent = nearestRepellentOptional.get();
        Vec3 repellentCenter = nearestRepellent.getBottomCenter();

        Vec3 pos = DefaultRandomPos.getPosAway(mob, 12, 7, repellentCenter);
        if (pos == null)
            return false;

        if (repellentCenter.distanceToSqr(pos) < pos.distanceToSqr(mob.position())){
            return false;
        }

        path = mob.getNavigation().createPath(pos.x, pos.y, pos.z, 0);
        return path != null;
    }

    @Override
    public void start() {
        this.mob.getNavigation().moveTo(this.path, 1.2D);
    }

    @Override
    public void stop() {
        this.path = null;
    }

    private Optional<BlockPos> nearestBlockToAvoid(int horizontalRange, int verticalRange){
        return BlockPos.findClosestMatch(mob.blockPosition(), horizontalRange, verticalRange, pos -> predicate.test(mob.level().getBlockState(pos)));
        /*BlockPos blockPos = mob.blockPosition();
        Level level = mob.level();
        BlockPos.MutableBlockPos mutable = blockPos.mutable();

        double closestDistance = Double.POSITIVE_INFINITY;
        BlockPos bestPos = blockPos;

        for (int x = -horizontalRange; x <= horizontalRange; x++){
            for (int z = -horizontalRange; z <= horizontalRange; z++){
                for (int y = -verticalRange; y <= verticalRange; y++){
                    mutable.setWithOffset(blockPos, x, y, z);
                    BlockState state = level.getBlockState(mutable);
                    if (predicate.test(state)){
                        double d = mob.distanceToSqr(mutable.getCenter());
                        if (d <= runDistance && d < closestDistance){
                            bestPos = new BlockPos(bestPos);
                            closestDistance = d;
                        }
                    }
                }
            }
        }
        return bestPos;*/
    }
}
