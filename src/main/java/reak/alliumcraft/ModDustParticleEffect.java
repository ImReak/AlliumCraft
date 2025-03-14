package reak.alliumcraft;

import net.minecraft.particle.AbstractDustParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

public class ModDustParticleEffect extends AbstractDustParticleEffect {
    public static final Vector3f AlliumColor = Vec3d.unpackRgb(11812859).toVector3f();
    public static final net.minecraft.particle.DustParticleEffect AlliumOreColor;

    public ModDustParticleEffect(float scale) {
        super(scale);
    }
    public ParticleType<net.minecraft.particle.DustParticleEffect> getType() {
        return ParticleTypes.DUST;
    }
    static {
        AlliumOreColor = new net.minecraft.particle.DustParticleEffect(AlliumColor, 1.0F);
    }
}