package zaia_enterprise.project_zeroone.client.animation.pojo;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BoneAnimation {
	@SerializedName("rotation")
	private HashMap<Double,List<String>> rotation;
	
	@SerializedName("position")
	private HashMap<Double,List<String>> position;
	
	@SerializedName("scale")
	private HashMap<Double,List<String>> scale;

	public HashMap<Double, List<String>> getRotation() {
		return rotation;
	}

	public HashMap<Double, List<String>> getPosition() {
		return position;
	}

	public HashMap<Double, List<String>> getScale() {
		return scale;
	}

	public void setRotation(HashMap<Double, List<String>> rotation) {
		this.rotation = rotation;
	}

	public void setPosition(HashMap<Double, List<String>> position) {
		this.position = position;
	}

	public void setScale(HashMap<Double, List<String>> scale) {
		this.scale = scale;
	}
	@Override
	public String toString() {
		return "BoneAnimation{"+
		"rotation = '"+rotation+ '\'' +
		",position = '"+position+ '\'' +
		",scale = '"+scale+ '\'' + "}"
		;
	}
}
