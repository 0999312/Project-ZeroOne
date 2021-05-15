package zaia_enterprise.project_zeroone.client.animation.pojo;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public class CustomAnimationPOJO {
	@SerializedName("format_version")
	private String formatVersion;

	@SerializedName("animations")
	private HashMap<String,Animations> animations;

	public String getFormatVersion() {
		return formatVersion;
	}

	public HashMap<String,Animations> getAnimations() {
		return animations;
	}

	@Override
	public String toString() {
		return "CustomAnimationPOJO{" + "format_version = '" + formatVersion + '\'' + ",animations = '" + animations
				+ '\'' + "}";
	}

	public void setFormatVersion(String formatVersion) {
		this.formatVersion = formatVersion;
	}

	public void setAnimations(HashMap<String, Animations> animations) {
		this.animations = animations;
	}
}
