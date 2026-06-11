package com.pekar.lymonitehorsearmor.events.params;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class RightClickBlockEvent
{
    private final Player entity;
    private final Level level;
    private final BlockPos pos;
    private boolean canceled;
    private InteractionResult cancellationResult = InteractionResult.PASS;

    public RightClickBlockEvent(Player entity, Level level, BlockPos pos)
    {
        this.entity = entity;
        this.level = level;
        this.pos = pos;
    }

    public Player getEntity()
    {
        return entity;
    }

    public Level getLevel()
    {
        return level;
    }

    public BlockPos getPos()
    {
        return pos;
    }

    public boolean isCanceled()
    {
        return canceled;
    }

    public void setCanceled(boolean canceled)
    {
        this.canceled = canceled;
    }

    public InteractionResult getCancellationResult()
    {
        return cancellationResult;
    }

    public void setCancellationResult(InteractionResult cancellationResult)
    {
        this.cancellationResult = cancellationResult;
    }
}
