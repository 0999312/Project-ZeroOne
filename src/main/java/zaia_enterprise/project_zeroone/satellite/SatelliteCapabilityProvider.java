package zaia_enterprise.project_zeroone.satellite;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class SatelliteCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT>{

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
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		// TODO Auto-generated method stub
		return null;
	}

}
