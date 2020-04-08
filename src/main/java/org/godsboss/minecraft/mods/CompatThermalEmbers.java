package org.godsboss.minecraft.mods;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Logger;
import org.godsboss.minecraft.mods.init.Recipes;

@Mod(
	modid = CompatThermalEmbers.MODID,
	name = CompatThermalEmbers.NAME,
	version = CompatThermalEmbers.VERSION,
	dependencies = "required-after:thermalexpansion"
)
public class CompatThermalEmbers
{
    public static final String MODID = "compatthermalembers";
    public static final String NAME = "Compatibility Thermal Expansion and Embers";
    public static final String VERSION = "1.0.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Recipes.init(logger);
	}
}
