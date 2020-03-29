package org.godsboss.minecraft.mods.init;

import cofh.thermalexpansion.util.managers.machine.CentrifugeManager;
import cofh.thermalexpansion.util.managers.machine.SmelterManager;
import cofh.thermalfoundation.item.ItemMaterial;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import static java.util.Arrays.asList;

public class Recipes {
    public static final String EMBERS_MODID = "embers";

	public static void init(Logger logger) {
		initCentrifuge();
		initRecycling(logger);
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

	private static void initRecycling(Logger logger) {
		// Same as the existing recycling recipes.
		int energy = SmelterManager.DEFAULT_ENERGY * 3 / 2;

		ItemStack sand = new ItemStack(Blocks.SAND);

		// Some materials can be disabled via config. Instead of checking the config,
		// we just if the corresponding items exist. If they do, add the recipe, else
		// skip it.
		String[] materials = {
			"copper",
			"lead",
			"silver",
			"dawnstone",
			"aluminum",
			"bronze",
			"electrum",
			"nickel",
			"tin"
		};

		// Of course tools and armor have to be handled differently, because tool IDs
		// are <tool>_<material>, while armor IDs are <name>_<slot>.
		String[] itemTypes = {
			"pickaxe",
			"axe",
			"shovel",
			"sword",
			"hoe",
		};

		for(String material: materials) {
			String ingotID = EMBERS_MODID + ":ingot_" + material;
			Item ingot = ForgeRegistries.ITEMS.getValue(new ResourceLocation(ingotID));
			if (ingot == null) {
				logger.debug("{} not found, skip it.", ingotID);
				continue;
			}
			for (String itemType: itemTypes) {
				String itemID = EMBERS_MODID + ":" + itemType + "_" + material;
				Item tool = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemID));
				if (tool == null) {
					logger.debug("{} not found, skip it.", itemID);
					continue;
				}
				logger.debug("Add recipe for recycling {} into {}", itemID, ingotID);
				SmelterManager.SmelterRecipe recipe = SmelterManager.addRecipe(
					energy,
					new ItemStack(tool),
					sand,
					new ItemStack(ingot),
					ItemMaterial.crystalSlag,
					10
				);
				if (recipe == null) {
					logger.debug("Recipe for recycling {} into {} not added for unknown reasons", itemID, ingotID);
				}
			}
		}
	}
}
