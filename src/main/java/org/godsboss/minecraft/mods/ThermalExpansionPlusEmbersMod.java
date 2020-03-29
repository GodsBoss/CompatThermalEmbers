package org.godsboss.minecraft.mods;

import cofh.thermalexpansion.util.managers.machine.CentrifugeManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static java.util.Arrays.asList;

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

    public static final String EMBERS_MODID = "embers";

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Item archaicBrick = ForgeRegistries.ITEMS.getValue(new ResourceLocation(EMBERS_MODID + ":archaic_brick"));
		Item ancientMotiveCore = ForgeRegistries.ITEMS.getValue(new ResourceLocation(EMBERS_MODID + ":ancient_motive_core"));

		CentrifugeManager.addDefaultMobRecipe(
				EMBERS_MODID + ":ancient_golem",
				asList(
					new ItemStack(archaicBrick, 8),
					new ItemStack(ancientMotiveCore, 1)
				),
				asList(75, 100),
				10
		);
	}
}
