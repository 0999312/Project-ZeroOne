package zaia_enterprise.project_zeroone.satellite;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.collect.Sets;

import net.minecraft.nbt.CompoundNBT;
import zaia_enterprise.project_zeroone.satellite.research.Research.EnumResearchStatus;

public class SatelliteCapability implements ISatelliteCapability {

	private final HashSet<String> research = Sets.newHashSet();

	@Override
	public CompoundNBT serializeNBT() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		this.research.clear();
	}

	@Override
	public EnumResearchStatus getResearchStatus(@Nonnull String res) {
	      if (!isResearchKnown(res))
	          return EnumResearchStatus.UNKNOWN; 
//	        Research entry = ResearchCategories.getResearch(res);
//	        if (entry == null || entry.getStages() == null || getResearchStage(res) > (entry.getStages()).length)
//	          return IPlayerKnowledge.EnumResearchStatus.COMPLETE; 
	      return EnumResearchStatus.COMPLETE;
	}

	@Override
	public boolean isResearchComplete(@Nonnull String res) {
		return getResearchStatus(res) == EnumResearchStatus.COMPLETE;
	}

	@Override
	public boolean isResearchKnown(@Nonnull String res) {
		if (res == null)
			return false;
		if (res.equals(""))
			return true;
//	      String[] ss = res.split("@");
//	      if (ss.length > 1 && getResearchStage(ss[0]) < MathHelper.getInt(ss[1], 0))
//	        return false; 
		return this.research.contains(res);
	}

//	@Override
//	public int getResearchStage(String paramString) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public boolean addResearch(@Nonnull String res) {
		if (!isResearchKnown(res)) {
			this.research.add(res);
			return true;
		}
		return false;
	}

//	@Override
//	public boolean setResearchStage(String paramString, int paramInt) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean removeResearch(@Nonnull String res) {
		if (isResearchKnown(res)) {
			this.research.remove(res);
			return true;
		}
		return false;
	}

	@Override
	public Set<String> getResearchList() {
		return Collections.unmodifiableSet(this.research);
	}

//	@Override
//	public void sync(ServerPlayerEntity paramEntityPlayerMP) {
//		// TODO Auto-generated method stub
//
//	}

}
