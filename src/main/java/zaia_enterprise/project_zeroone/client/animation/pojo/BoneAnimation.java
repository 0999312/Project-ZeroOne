package zaia_enterprise.project_zeroone.client.animation.pojo;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BoneAnimation {
	@SerializedName("rotation")
	private HashMap<Integer,List<String>> rotation;
	
	@SerializedName("position")
	private HashMap<Integer,List<String>> position;
	
	@SerializedName("scale")
	private HashMap<Integer,List<String>> scale;

	public HashMap<Integer, List<String>> getRotation() {
		return rotation;
	}

	public HashMap<Integer, List<String>> getPosition() {
		return position;
	}

	public HashMap<Integer, List<String>> getScale() {
		return scale;
	}
}
