package zaia_enterprise.project_zeroone.client.animation;

public class AnimationKeyFrame {
	private final float KeyFrameTick;
	private final float[] rotation;
	private final float[] position;
	private final float[] scale;

	public AnimationKeyFrame(float tick, float[] rotation, float[] position, float[] scale) {
		this.KeyFrameTick = tick;
		this.rotation = rotation;
		this.position = position;
		this.scale = scale;
	}

	public AnimationKeyFrame(float tick, float rot_x, float rot_y, float rot_z, float pos_x, float pos_y, float pos_z,
			float scale_x, float scale_y, float scale_z) {
		this.KeyFrameTick = tick;
		this.rotation = new float[] {rot_x,rot_y,rot_z};
		this.position = new float[] {pos_x,pos_y,pos_z};
		this.scale    = new float[] {scale_x,scale_y,scale_z};
	}

	public float getKeyFrameTick() {
		return KeyFrameTick;
	}

	public float[] getRotation() {
		return rotation;
	}

	public float[] getPosition() {
		return position;
	}

	public float[] getScale() {
		return scale;
	}
}
