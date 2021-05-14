package zaia_enterprise.project_zeroone.client.animation.pojo;


import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public class Animations {
    @SerializedName("animation_length")
    private Double animationLength;

	@SerializedName("loop")
    private boolean loop = true;
	
    @SerializedName("override_previous_animation")
    private boolean override_previous_animation = true;
    
    @SerializedName("bones")
	private HashMap<String,BoneAnimation> boneAnimations;
    
    public Double getAnimationLength() {
		return animationLength;
	}

	public boolean isLoop() {
		return loop;
	}

	public boolean isOverride_previous_animation() {
		return override_previous_animation;
	}

	public HashMap<String, BoneAnimation> getBoneAnimations() {
		return boneAnimations;
	}
}
