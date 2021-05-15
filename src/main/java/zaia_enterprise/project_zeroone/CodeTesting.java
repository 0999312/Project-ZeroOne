package zaia_enterprise.project_zeroone;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonIOException;

import zaia_enterprise.project_zeroone.client.animation.pojo.Animations;
import zaia_enterprise.project_zeroone.client.animation.pojo.BoneAnimation;
import zaia_enterprise.project_zeroone.client.animation.pojo.CustomAnimationPOJO;
import zaia_enterprise.project_zeroone.utils.JsonCreator;

public class CodeTesting {
	public CustomAnimationPOJO animation = new CustomAnimationPOJO();
	public Animations test = new Animations();
	public BoneAnimation bone = new BoneAnimation();
	public List<String> X_Y_Z = Lists.newArrayList("1","1","tan(90)");
	public HashMap<Double,List<String>> TIME = Maps.newHashMap();
	public HashMap<String, BoneAnimation> BONNNE = Maps.newHashMap();
	public HashMap<String, Animations> BON2NNE = Maps.newHashMap();
	public CodeTesting() {
		test.setAnimationLength(9.0D);
		TIME.put(0.0, X_Y_Z);
		TIME.put(0.5, X_Y_Z);
		TIME.put(0.9, X_Y_Z);
		bone.setPosition(TIME);
		bone.setRotation(TIME);
		bone.setScale(TIME);
		BONNNE.put("bone", bone);
		test.setBoneAnimations(BONNNE);
		animation.setFormatVersion("test_ver");
		BON2NNE.put("ttttt", test);
		animation.setAnimations(BON2NNE);
		
		try {
			File fileDir = new File("json_create");
	        if(!fileDir.exists()){
	            fileDir.mkdirs();
	        }
	        Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\testing.json"), "UTF-8");
			JsonCreator.gson.toJson(animation, writer);
			writer.close();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
