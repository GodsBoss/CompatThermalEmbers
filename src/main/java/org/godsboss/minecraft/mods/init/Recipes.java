package org.godsboss.minecraft.mods.init;

import cofh.thermalexpansion.util.managers.machine.CentrifugeManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static java.util.Arrays.asList;

public class Recipes {
    public static final String EMBERS_MODID = "embers";

	public static void init() {
		initCentrifuge();
	}

	private static void initCentrifuge() {
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
