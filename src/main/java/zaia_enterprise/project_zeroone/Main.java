package zaia_enterprise.project_zeroone;

import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import zaia_enterprise.project_zeroone.item.ItemRegister;
import zaia_enterprise.project_zeroone.item.ZeroOneGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.mcmod_mmf.mmlib.utils.ClientUtil;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("project_zeroone")
public class Main {
	public static final ItemGroup ZERO_ONE_GROUP = new ZeroOneGroup();
	private static final Logger LOGGER = LogManager.getLogger();

	public Main() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		// Register the doClientStuff method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		
		ItemRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		
	}

	private void setup(final FMLCommonSetupEvent event) {
		// some preinit code
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		ClientUtil.loadModel(new ResourceLocation(Versions.MODID, "models/entity/security_izu.json"));
		ClientUtil.loadModel(new ResourceLocation(Versions.MODID, "models/entity/test_armor.json"));
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
	}

	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods

	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		// do something when the server starts
	}

//	// You can use EventBusSubscriber to automatically subscribe events on the
//	// contained class (this is subscribing to the MOD
//	// Event bus for receiving Registry Events)
//	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//	public static class RegistryEvents {
//		@SubscribeEvent
//		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//			// register a new block here
//			LOGGER.info("HELLO from Register Block");
//		}
//	}

	public static Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}
}
