package zaia_enterprise.project_zeroone.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import cn.mcmod_mmf.mmlib.client.model.EntityModelJson;
import cn.mcmod_mmf.mmlib.client.model.pojo.BedrockModelPOJO;
import net.minecraft.util.math.MathHelper;
import zaia_enterprise.project_zeroone.entity.EntityMotor;

public class EntityModelMotor extends EntityModelJson<EntityMotor> {

	public EntityModelMotor(BedrockModelPOJO pojo) {
		super(pojo);
		
	}
	
	@Override
	public void renderToBuffer(MatrixStack arg0, IVertexBuilder arg1, int arg2, int arg3, float arg4, float arg5,
			float arg6, float arg7) {
		arg0.translate(0.0D, 0D, 1.0D);
		super.renderToBuffer(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}
	
	@Override
	public void setupAnim(EntityMotor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
        if(entity instanceof EntityMotor) {
            EntityMotor motor = (EntityMotor) entity;
            if(motor.getDeltaMovement().length() > 0) {
                this.getModelMap().get("qianlun_zhu").xRot = MathHelper.wrapDegrees(45 * motor.ridingTicks);
                this.getModelMap().get("lun6").xRot = MathHelper.wrapDegrees(45 * motor.ridingTicks);
            }
        }
	};

}
