package dev.arcana;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Right-click: Arcane Pulse.
 * Sneak + right-click: I AM ATOMIC.
 *
 * All gameplay effects are executed on the logical server. The large spell
 * uses particles and entity effects only; it does not destroy terrain.
 */
public final class ArcaneCoreItem extends Item {
    public ArcaneCoreItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide && !player.getCooldowns().isOnCooldown(this)) {
            if (player.isShiftKeyDown()) {
                ArcanaSpells.castAtomic(level, player);
                player.getCooldowns().addCooldown(this, 20 * 18);
            } else {
                ArcanaSpells.castPulse(level, player);
                player.getCooldowns().addCooldown(this, 20 * 3);
            }
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }
}
