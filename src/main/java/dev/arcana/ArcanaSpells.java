package dev.arcana;

import java.util.List;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.server.level.ServerLevel;

/**
 * First playable spell set for ARCANA.
 * Visuals are intentionally particle-based so no external animation library
 * or additional dependency is required.
 */
public final class ArcanaSpells {
    private ArcanaSpells() {
    }

    public static void castPulse(Level level, Player caster) {
        if (!(level instanceof ServerLevel server)) return;

        double cx = caster.getX();
        double cy = caster.getY() + 0.9;
        double cz = caster.getZ();

        ring(server, cx, cy, cz, 3.5, 64, ParticleTypes.END_ROD);
        ring(server, cx, cy + 0.35, cz, 2.5, 48, ParticleTypes.WITCH);
        server.sendParticles(ParticleTypes.PORTAL, cx, cy, cz, 90, 1.2, 0.8, 1.2, 0.18);
        server.playSound(null, caster.blockPosition(), SoundEvents.EVOKER_CAST_SPELL,
                SoundSource.PLAYERS, 0.9F, 1.25F);

        List<LivingEntity> targets = level.getEntitiesOfClass(
                LivingEntity.class,
                caster.getBoundingBox().inflate(4.5),
                entity -> entity != caster && entity.isAlive()
        );

        for (LivingEntity target : targets) {
            target.hurt(level.damageSources().magic(), 6.0F);
            target.knockback(0.8, caster.getX() - target.getX(), caster.getZ() - target.getZ());
        }
    }

    public static void castAtomic(Level level, Player caster) {
        if (!(level instanceof ServerLevel server)) return;

        double cx = caster.getX();
        double cy = caster.getY() + 0.08;
        double cz = caster.getZ();

        // Three expanding-looking rune circles at different heights.
        ring(server, cx, cy, cz, 3.0, 72, ParticleTypes.END_ROD);
        ring(server, cx, cy + 0.55, cz, 5.0, 96, ParticleTypes.WITCH);
        ring(server, cx, cy + 1.1, cz, 7.0, 112, ParticleTypes.PORTAL);

        // Violet-looking columns rising around the caster.
        for (int column = 0; column < 24; column++) {
            double angle = (Math.PI * 2.0 * column) / 24.0;
            double x = cx + Math.cos(angle) * 5.5;
            double z = cz + Math.sin(angle) * 5.5;
            for (int y = 0; y <= 6; y++) {
                server.sendParticles(ParticleTypes.END_ROD, x, cy + y, z,
                        2, 0.12, 0.12, 0.12, 0.015);
                if (y % 2 == 0) {
                    server.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, cy + y + 0.25, z,
                            1, 0.08, 0.08, 0.08, 0.01);
                }
            }
        }

        server.sendParticles(ParticleTypes.FLASH, cx, cy + 2.0, cz, 1, 0, 0, 0, 0);
        server.sendParticles(ParticleTypes.PORTAL, cx, cy + 1.0, cz, 260, 4.0, 2.0, 4.0, 0.22);
        server.sendParticles(ParticleTypes.WITCH, cx, cy + 0.5, cz, 180, 3.5, 1.0, 3.5, 0.08);
        server.playSound(null, caster.blockPosition(), SoundEvents.WITHER_SPAWN,
                SoundSource.PLAYERS, 0.75F, 1.35F);

        List<LivingEntity> targets = level.getEntitiesOfClass(
                LivingEntity.class,
                new AABB(cx - 10, cy - 4, cz - 10, cx + 10, cy + 8, cz + 10),
                entity -> entity != caster && entity.isAlive()
        );

        for (LivingEntity target : targets) {
            target.hurt(level.damageSources().magic(), 18.0F);
            target.knockback(1.8, cx - target.getX(), cz - target.getZ());
        }
    }

    private static void ring(ServerLevel level, double cx, double cy, double cz,
                             double radius, int points,
                             net.minecraft.core.particles.ParticleOptions particle) {
        for (int i = 0; i < points; i++) {
            double angle = (Math.PI * 2.0 * i) / points;
            double x = cx + Math.cos(angle) * radius;
            double z = cz + Math.sin(angle) * radius;
            level.sendParticles(particle, x, cy, z, 1, 0, 0, 0, 0);
        }
    }
}
