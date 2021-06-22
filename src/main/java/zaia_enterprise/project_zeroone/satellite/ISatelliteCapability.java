package zaia_enterprise.project_zeroone.satellite;

import java.util.Set;

import javax.annotation.Nonnull;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import zaia_enterprise.project_zeroone.satellite.research.Research;

public interface ISatelliteCapability extends INBTSerializable<CompoundNBT>{
	  void clear();
	  
	  Research.EnumResearchStatus getResearchStatus(@Nonnull String paramString);
	  
	  boolean isResearchComplete(String paramString);
	  
	  boolean isResearchKnown(String paramString);
	  
//	  int getResearchStage(@Nonnull String paramString);
	  
	  boolean addResearch(@Nonnull String paramString);
	  
//	  boolean setResearchStage(@Nonnull String paramString, int paramInt);
	  
	  boolean removeResearch(@Nonnull String paramString);
	  
	  @Nonnull
	  Set<String> getResearchList();
	  
//	  void sync(ServerPlayerEntity paramEntityPlayerMP);
	  

	  
}
