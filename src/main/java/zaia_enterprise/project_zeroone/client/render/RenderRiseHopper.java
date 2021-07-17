package zaia_enterprise.project_zeroone.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import cn.mcmod_mmf.mmlib.client.model.EntityModelJson;
import cn.mcmod_mmf.mmlib.utils.ClientUtil;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import zaia_enterprise.project_zeroone.Versions;
import zaia_enterprise.project_zeroone.entity.EntityMotor;

public class RenderRiseHopper extends EntityRenderer<EntityMotor> {
	private ResourceLocation model_res = new ResourceLocation(Versions.MODID,"models/entity/rise_hopper.json");
	private EntityModel<EntityMotor> entitymodel = new EntityModelJson<EntityMotor>(ClientUtil.getModelPOJO(model_res));
	
	public RenderRiseHopper(EntityRendererManager p_i46179_1_) {
		super(p_i46179_1_);
	}
	

    @Override
    public void render(EntityMotor entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 1.500D, 0.0D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(entityIn.getRotation()));
        matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(entityIn.getPitch()));
        this.entitymodel.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.entitymodel.renderType(this.getTextureLocation(entityIn)));
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        this.entitymodel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

	@Override
	public ResourceLocation getTextureLocation(EntityMotor arg0) {
		return new ResourceLocation(Versions.MODID, "textures/model/rise_hopper.png");
	}
	public ResourceLocation getModelLocation(EntityMotor arg0) {
		return model_res;
	}
}
