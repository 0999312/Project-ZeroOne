package zaia_enterprise.project_zeroone.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityMotor extends BoatEntity {
	private static final String TAG_PITCH = "pitch";
	private static final String TAG_ROTATION = "rotation";
	private static final DataParameter<Float> PITCH = EntityDataManager.defineId(EntityMotor.class,
			DataSerializers.FLOAT);
	private static final DataParameter<Float> ROTATION = EntityDataManager.defineId(EntityMotor.class,
			DataSerializers.FLOAT);
    public int ridingTicks = 0;
	public EntityMotor(EntityType<? extends EntityMotor> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
		this.blocksBuilding = true;
	}

	public EntityMotor(World worldIn, double x, double y, double z) {
		super(EntityRegister.RISE_HOPPER.get(), worldIn);
		this.setPos(x, y, z);
		this.setDeltaMovement(0, 0, 0);
		this.xOld = x;
		this.yOld = y;
		this.zOld = z;
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public double getPassengersRidingOffset() {
		return 1.435D;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ROTATION, 0F);
		this.entityData.define(PITCH, 0F);
	}

	@Override
	public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
		return super.hurt(p_70097_1_, p_70097_2_);
	}

	@Override
	public Item getDropItem() {
		return super.getDropItem();
	}

	@Override
	public void push(Entity p_70108_1_) {
		if (p_70108_1_ instanceof BoatEntity) {
			if (p_70108_1_.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.push(p_70108_1_);
			}
		} else if (p_70108_1_.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.push(p_70108_1_);
		}

	}
	
	
	
	@Override
	public void tick() {
		super.tick();
		
        float speed = 1.65F;
        double mx = (double) (-MathHelper.sin(this.yRot / 180.0F * (float) Math.PI)
                * MathHelper.cos(this.xRot / 180.0F * (float) Math.PI) * speed);
        double mz = (double) (MathHelper.cos(this.yRot / 180.0F * (float) Math.PI)
                * MathHelper.cos(this.xRot / 180.0F * (float) Math.PI) * speed);
        if(this.inputUp){
            this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY() + 1.2D, this.getZ(), -mx, 0.15F, -mz);
        }

        if (this.inputRight) {
            setRotation(-7.5F);
        } else if (this.inputLeft) {
            setRotation(7.5F);
        } else {
            setRotation(0);
            setPitch(0);
        }

        ridingTicks++;

        if (this.inputUp && this.horizontalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().x, this.getDeltaMovement().y+0.08f, this.getDeltaMovement().z);
        }
	}


	@Override
	public Status getStatus() {
		BoatEntity.Status boatentity$status = this.isUnderwater();
		if (boatentity$status != null) {
			this.waterLevel = this.getBoundingBox().maxY;
			return boatentity$status;
		} else if (this.checkInWater()) {
			return BoatEntity.Status.IN_WATER;
		} else {
			float f = this.getGroundFriction();
			if (f > 0.0F) {
				this.landFriction = f;
				return BoatEntity.Status.ON_LAND;
			} else {
				return BoatEntity.Status.IN_AIR;
			}
		}
	}

	@Override
	public void controlBoat() {
		if (this.isVehicle()) {
			float f = 0.0F;
			if (this.inputLeft) {
				--this.deltaRotation;
			}

			if (this.inputRight) {
				++this.deltaRotation;
			}

			if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown) {
				f += 0.005F;
			}

			this.yRot += this.deltaRotation;
			if (this.inputUp) {
				f += 0.05F * 1.5F;
			}

			if (this.inputDown) {
				f -= 0.006F;
			}

			this.setDeltaMovement(
					this.getDeltaMovement().add((double) (MathHelper.sin(-this.yRot * ((float) Math.PI / 180F)) * f),
							0.0D, (double) (MathHelper.cos(this.yRot * ((float) Math.PI / 180F)) * f)));
			this.setPaddleState(this.inputRight && !this.inputLeft || this.inputUp,
					this.inputLeft && !this.inputRight || this.inputUp);
		}
	}
	
	@Override
	public void floatBoat() {
        double d0 = -0.03999999910593033D;
        double d1 = this.isNoGravity() ? 0.0D : d0;
        double d2 = 0.0D;
        this.invFriction = 0.05F;

        if (this.oldStatus == BoatEntity.Status.IN_AIR && this.status != BoatEntity.Status.IN_AIR && this.status != BoatEntity.Status.ON_LAND) {
            this.waterLevel = this.getBoundingBox().minY + (double)this.getBbHeight();
            this.setPos(this.getX(), (double)(this.getWaterLevelAbove() - this.getBbHeight()) + 0.101D, this.getZ());
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
            this.lastYd = 0.0D;
            this.status = BoatEntity.Status.IN_WATER;
        } else {
            if (this.status == BoatEntity.Status.IN_WATER) {
                d2 = (this.waterLevel - this.getBoundingBox().minY + 0.1D) / (double)this.getBbHeight();
                this.invFriction = 0.9F;
            } else if (this.status == BoatEntity.Status.UNDER_FLOWING_WATER) {
                d1 = -7.0E-4D;
                this.invFriction = 0.9F;
            } else if (this.status == BoatEntity.Status.UNDER_WATER) {
                d2 = 0.009999999776482582D;
                this.invFriction = 0.8F;
            } else if (this.status == BoatEntity.Status.IN_AIR) {
                this.invFriction = 0.9F;
            } else if (this.status == BoatEntity.Status.ON_LAND) {
                this.invFriction = 0.9F;
                if (this.getControllingPassenger() instanceof PlayerEntity) {
                    this.landFriction /= 2.0F;
                }
            }

            Vector3d vec3d = this.getDeltaMovement();
            this.setDeltaMovement(vec3d.x * (double)this.invFriction, vec3d.y + d1, vec3d.z * (double)this.invFriction);
            this.deltaRotation *= this.invFriction;
            if (d2 > 0.0D) {
                Vector3d vec3d1 = this.getDeltaMovement();
                this.setDeltaMovement(vec3d1.x, (vec3d1.y + d2 * 0.06153846016296973D) * 0.75D, vec3d1.z);
            }
        }
	}
	
	@Override
	protected void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		setRotation(compound.getFloat(TAG_ROTATION));
		setPitch(compound.getFloat(TAG_PITCH));
	}

	@Override
	protected void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putFloat(TAG_ROTATION, getRotation());
		compound.putFloat(TAG_PITCH, getPitch());
	}

	public float getRotation() {
		return entityData.get(ROTATION);
	}

	public void setRotation(float rot) {
		entityData.set(ROTATION, rot);
	}

	public float getPitch() {
		return entityData.get(PITCH);
	}

	public void setPitch(float rot) {
		entityData.set(PITCH, rot);
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		// TODO Auto-generated method stub
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
