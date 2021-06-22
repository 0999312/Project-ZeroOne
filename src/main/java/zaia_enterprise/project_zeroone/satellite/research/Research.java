package zaia_enterprise.project_zeroone.satellite.research;

public class Research {
	private final String name;
	private final String key;
	private final String info;
//	private List<String> parents = Lists.newArrayList();

	public Research(String key) {
		StringBuilder builder = new StringBuilder("reseach.");
		this.key = key;
		this.name = builder.append(key).append(".name").toString();
		this.info = builder.append(key).append(".info").toString();
	}

	public Research(String key, String name, String info) {
		this.key = key;
		this.name = name;
		this.info = name;
	}

	public enum EnumResearchStatus {
		UNKNOWN, COMPLETE, IN_PROGRESS;
	}

	public String getName() {
		return name;
	}

	public String getKey() {
		return key;
	}

//	public List<String> getParents() {
//		return parents;
//	}
//
//	public void addParent(String parent) {
//		this.parents.add(parent);
//	}
//
//	public void addParents(String... parents) {
//		for (String parent : parents)
//			this.parents.add(parent);
//	}
}
