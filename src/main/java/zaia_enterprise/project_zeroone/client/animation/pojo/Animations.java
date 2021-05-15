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

	public void setAnimationLength(Double animationLength) {
		this.animationLength = animationLength;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public void setOverride_previous_animation(boolean override_previous_animation) {
		this.override_previous_animation = override_previous_animation;
	}

	public void setBoneAnimations(HashMap<String, BoneAnimation> boneAnimations) {
		this.boneAnimations = boneAnimations;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Animation{"+
				"animation_length = '"+animationLength+ '\'' +
				",loop = '"+loop+ '\'' +
				",override_previous_animation = '"+override_previous_animation+ '\'' +
				",bones = '"+boneAnimations+'\'' + "}"
				;
	}
}
