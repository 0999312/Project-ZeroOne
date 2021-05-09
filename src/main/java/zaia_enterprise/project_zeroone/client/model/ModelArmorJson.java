package zaia_enterprise.project_zeroone.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.model.ModelRenderer;
import zaia_enterprise.project_zeroone.client.model.pojo.CustomModelPOJO;

public class ModelArmorJson extends ModelBipedJson {

	public ModelArmorJson(CustomModelPOJO pojo) {
		super(pojo);
    	this.leftArm.setPos(0, 0, 0);
    	this.leftLeg.setPos(0, 0, 0);
    	this.rightArm.setPos(0, 0, 0);
    	this.rightLeg.setPos(0, 0, 0);
	}
	@Override
	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_,
			float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        for (ModelRenderer model : shouldRender) {
            model.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        }
	}

}
