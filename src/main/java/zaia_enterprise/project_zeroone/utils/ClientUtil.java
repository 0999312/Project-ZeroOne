package zaia_enterprise.project_zeroone.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import org.apache.commons.io.IOUtils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import zaia_enterprise.project_zeroone.Main;
import zaia_enterprise.project_zeroone.client.model.ModelBaseJson;
import zaia_enterprise.project_zeroone.client.model.ModelBipedJson;
import zaia_enterprise.project_zeroone.client.model.pojo.CustomModelPOJO;

@OnlyIn(Dist.CLIENT)
public class ClientUtil {
	public static final Cache<ResourceLocation, Model> model_cache = CacheBuilder.newBuilder()
			.expireAfterAccess(5, TimeUnit.MINUTES).build();

	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static CustomModelPOJO loadModel(ResourceLocation modelLocation) {
		InputStream input = null;
		try {
			input = Minecraft.getInstance().getResourceManager().getResource(modelLocation).getInputStream();
			CustomModelPOJO pojo = JsonCreator.gson.fromJson(new InputStreamReader(input, StandardCharsets.UTF_8),
					CustomModelPOJO.class);

			// 先判断是不是 1.10.0 版本基岩版模型文件
			if (!pojo.getFormatVersion().equals("1.10.0")) {
				Main.getLogger().warn("{} model version is not 1.10.0", modelLocation);
				// TODO: 2019/7/26 添加对高版本基岩版模型的兼容
				return null;
			}

			// 如果 model 字段不为空
			if (pojo.getGeometryModel() != null) {
				return pojo;
			}
			// 否则日志给出提示
			Main.getLogger().warn("{} model file don't have model field", modelLocation);
		} catch (IOException ioe) {
			// 可能用来判定错误，打印下
			Main.getLogger().warn("Failed to load model: {}", modelLocation);
			ioe.printStackTrace();
		} finally {
			// 关闭输入流
			IOUtils.closeQuietly(input);
		}

		// 如果前面出了错，返回 Null
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	public static Model getModelBaseFromJSON(ResourceLocation modelLocation) {
		if (model_cache.getIfPresent(modelLocation) != null)
			return model_cache.getIfPresent(modelLocation);
		Model model = new ModelBaseJson(loadModel(modelLocation));
		model_cache.put(modelLocation, model);
		return model;
	}

	@OnlyIn(Dist.CLIENT)
	public static BipedModel<?> getModelBipedFromJSON(ResourceLocation modelLocation) {
		if (model_cache.getIfPresent(modelLocation) != null)
			if (model_cache.getIfPresent(modelLocation) instanceof BipedModel)
				return (BipedModel<?>) model_cache.getIfPresent(modelLocation);
		BipedModel<LivingEntity> model = new ModelBipedJson(loadModel(modelLocation));
		model_cache.put(modelLocation, model);
		return model;
	}
}
