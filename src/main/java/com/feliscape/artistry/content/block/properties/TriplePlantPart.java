package com.feliscape.artistry.content.block.properties;

import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;

import java.util.Arrays;
import java.util.List;

public enum TriplePlantPart implements StringRepresentable {
    BASE("base", Direction.UP),
    MIDDLE("middle", Direction.UP, Direction.DOWN),
    TIP("tip", Direction.DOWN);

    private final List<Direction> otherDirections;
    private final String name;

    TriplePlantPart(String name, Direction... directions) {
        this.otherDirections = Arrays.asList(directions);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getSerializedName();
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public List<Direction> getOtherDirections() {
        return otherDirections;
    }

    public boolean isBelow(TriplePlantPart other) {
        return other.ordinal() > this.ordinal();
    }
    public boolean isAbove(TriplePlantPart other) {
        return other.ordinal() < this.ordinal();
    }

    public int distanceToBase() {
        return ordinal();
    }
    public int distanceToTip() {
        return 2 - ordinal();
    }
    public int distanceToMiddle() {
        return -(ordinal() - 1);
    }
}
