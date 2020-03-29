package org.godsboss.minecraft.mods;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.godsboss.minecraft.mods.init.Recipes;

@Mod(
	modid = ThermalExpansionPlusEmbersMod.MODID,
	name = ThermalExpansionPlusEmbersMod.NAME,
	version = ThermalExpansionPlusEmbersMod.VERSION
)
public class ThermalExpansionPlusEmbersMod
{
    public static final String MODID = "thermalexpansionplusembers";
    public static final String NAME = "Thermal Expansion plus Embers";
    public static final String VERSION = "1.0.0";

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Recipes.init();
	}
}
