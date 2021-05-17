package zaia_enterprise.project_zeroone.client.animation;

import java.util.List;

import com.google.common.collect.Lists;

import zaia_enterprise.project_zeroone.client.animation.pojo.Animations;

public class AnimationBase {
	//TODO:一个能够正常播放的动画。
	private float lastTickValue = -1;
	private List<AnimationKeyFrame> KeyFrame = Lists.newArrayList();
	public AnimationBase(Animations animation) {
//		animation.getBoneAnimations()
//		for()
	}
	
	public void setupAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(ageInTicks == lastTickValue){
			return;
		}
		lastTickValue = ageInTicks;
		
	}
}
