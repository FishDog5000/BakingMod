/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 FishDog5000
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.fishdog5000.bakingmod.items;

import net.fishdog5000.bakingmod.handler.ConfigManager;
import net.fishdog5000.bakingmod.main.BakingMod;
import net.fishdog5000.core.FishdogsCore;
import net.fishdog5000.core.basestuff.BaseItem;
import net.fishdog5000.core.basestuff.ItemBasicFood;
import net.fishdog5000.core.basestuff.ItemDurability;
import net.fishdog5000.core.basestuff.PotionEffectGroup;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BakingModItems {
    private static final String MODID = BakingMod.MODID;

    public static ItemBasicFood bread_dough,
            cake_batter_unmixed,
            pumpkin_pie_mixture,
            cake_batter,
            disaster,
            cookie_dough,
            buttered_bread,
            butter,
            bread_sammich;

    public static BaseItem mixing_spoon,
            millstone,
            cookie_dough_blob,
            flour;

    public static void init() {
        // create items
        flour = new BaseItem("flour", CreativeTabs.FOOD, MODID);
        bread_dough = new ItemBasicFood("bread_dough", CreativeTabs.FOOD, 3, 0.3F, false, true, MODID);

        cake_batter_unmixed = new ItemBasicFood("cake_batter_unmixed", CreativeTabs.FOOD, 6, 0.5F, false, new PotionEffectGroup[] {
                new PotionEffectGroup(MobEffects.BLINDNESS, 400, 2), new PotionEffectGroup(MobEffects.NAUSEA, 500, 6),
                new PotionEffectGroup(MobEffects.SLOWNESS, 600, 1), new PotionEffectGroup(MobEffects.HUNGER, 400, 3) },
                95.5F, true, MODID);

        cake_batter = new ItemBasicFood("cake_batter", CreativeTabs.FOOD, 6, 0.5F, false, new PotionEffectGroup[] {
                new PotionEffectGroup(MobEffects.BLINDNESS, 400, 2), new PotionEffectGroup(MobEffects.NAUSEA, 400, 5),
                new PotionEffectGroup(MobEffects.SLOWNESS, 600, 1), new PotionEffectGroup(MobEffects.HUNGER, 400, 3) },
                85.5F, true, MODID);

        pumpkin_pie_mixture = new ItemBasicFood("pumpkin_pie_mixture", CreativeTabs.FOOD, 4, 1.0F, false, new PotionEffectGroup[] {
                new PotionEffectGroup(MobEffects.HUNGER, 400, 2), new PotionEffectGroup(MobEffects.NAUSEA, 400, 1) },
                20F, true, MODID);

        mixing_spoon = new ItemDurability("mixing_spoon", CreativeTabs.MISC, 200, true, MODID)
                .setEnchantability(ToolMaterial.WOOD.getEnchantability());

        disaster = new ItemBasicFood("disaster", CreativeTabs.FOOD, 1, 0F, false, new PotionEffectGroup[] {
                new PotionEffectGroup(MobEffects.BLINDNESS, 610, 2), new PotionEffectGroup(MobEffects.NAUSEA, 620, 5),
                new PotionEffectGroup(MobEffects.SLOWNESS, 630, 1), new PotionEffectGroup(MobEffects.HUNGER, 640, 3),
                new PotionEffectGroup(MobEffects.NIGHT_VISION, 630, 1), new PotionEffectGroup(MobEffects.MINING_FATIGUE, 650, 2) },
                87.5F, true, MODID);

        millstone = new ItemDurability("millstone", CreativeTabs.MISC, 50, true, MODID).setEnchantability(ToolMaterial.STONE.getEnchantability());

        butter = new ItemBasicFood("butter", CreativeTabs.FOOD, 2, 0.5F, false, MODID);
        butter.setPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 400, 3), 0.50F);

        cookie_dough_blob = new BaseItem("cookie_dough_blob", CreativeTabs.FOOD, true, MODID);

        cookie_dough = new ItemBasicFood("cookie_dough", CreativeTabs.FOOD, 1, 0F, false, true, MODID);
        cookie_dough.setPotionEffect(new PotionEffect(MobEffects.HUNGER, 400, 3), 0.15F);

        buttered_bread = new ItemBasicFood("buttered_bread", CreativeTabs.FOOD, 10, 2F, false, MODID);

        bread_sammich = new ItemBasicFood("bread_sammich", CreativeTabs.FOOD, 15, 1.9F/* 0.1 extra */, false, MODID);

        // register items
        FishdogsCore.registerItem(flour, MODID);
        FishdogsCore.registerItem(bread_dough, MODID);
        FishdogsCore.registerItem(cake_batter_unmixed, MODID);
        FishdogsCore.registerItem(pumpkin_pie_mixture, MODID);
        FishdogsCore.registerItem(cake_batter, MODID);
        FishdogsCore.registerItem(mixing_spoon, MODID);
        FishdogsCore.registerItem(disaster, MODID);
        FishdogsCore.registerItem(millstone, MODID);
        FishdogsCore.registerItem(butter, MODID);
        FishdogsCore.registerItem(cookie_dough_blob, MODID);
        FishdogsCore.registerItem(cookie_dough, MODID);
        FishdogsCore.registerItem(buttered_bread, MODID);
        FishdogsCore.registerItem(bread_sammich, MODID);

        BakingMod.logger.info("generating multi-textures...");
        String[] locations = new String[] { MODID + ":flour_x32", MODID + ":flour_x16" };
        BakingMod.proxy.registerModel(flour, flour.getName(), locations, MODID + ":flour_x" + Byte.toString(ConfigManager.flour_size));

        locations = new String[] { MODID + ":bread_dough_x32", MODID + ":bread_dough_x16" };
        BakingMod.proxy.registerModel(bread_dough, bread_dough.getName(), locations, MODID + ":bread_dough_x" + Byte.toString(ConfigManager.bread_dough_size));

        locations = new String[] { MODID + ":mixing_spoon_x32", MODID + ":mixing_spoon_x16" };
        BakingMod.proxy.registerModel(mixing_spoon, mixing_spoon.getName(), locations, MODID + ":mixing_spoon_x" + Byte.toString(ConfigManager.mixing_spoon_size));

        locations = new String[] { MODID + ":millstone_x32", MODID + ":millstone_x16" };
        BakingMod.proxy.registerModel(millstone, millstone.getName(), locations, MODID + ":millstone_x" + Byte.toString(ConfigManager.millstone_size));

        locations = new String[] { MODID + ":butter_x32", MODID + ":butter_x16" };
        BakingMod.proxy.registerModel(butter, butter.getName(), locations, MODID + ":butter_x" + Byte.toString(ConfigManager.butter_size));

        locations = new String[] { MODID + ":cookie_dough_blob_x32", MODID + ":cookie_dough_blob_x16" };
        BakingMod.proxy.registerModel(cookie_dough_blob, cookie_dough_blob.getName(), locations, MODID + ":cookie_dough_blob_x" + Byte.toString(ConfigManager.cookie_dough_blob_size));

        locations = new String[] { MODID + ":cookie_dough_x32", MODID + ":cookie_dough_x16" };
        BakingMod.proxy.registerModel(cookie_dough, cookie_dough.getName(), locations, MODID + ":cookie_dough_x" + Byte.toString(ConfigManager.cookie_dough_size));

        locations = new String[] { MODID + ":buttered_bread_x32", MODID + ":buttered_bread_x16" };
        BakingMod.proxy.registerModel(buttered_bread, buttered_bread.getName(), locations, MODID + ":buttered_bread_x" + Byte.toString(ConfigManager.buttered_bread_size));

        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel) {
                if (fuel.getItem() == mixing_spoon)
                    return 425;
                return 0;
            }
        });
    }

    public static void addDisaster() {
        Item[] badRecipies = { cake_batter_unmixed, flour, butter, cookie_dough_blob };

        for (Item item : badRecipies)
            GameRegistry.addSmelting(item, new ItemStack(disaster), 0.3F);
    }

    @SideOnly(Side.CLIENT)
    public static void reloadTextures() {
        BakingMod.logger.info("reloading textures...");

        BakingMod.logger.info("setting mixing_spoon to...mixing_spoon_x" + ConfigManager.mixing_spoon_size);
        mixing_spoon.reloadTexture("mixing_spoon_x" + ConfigManager.mixing_spoon_size);

        BakingMod.logger.info("setting millstone to...millstone_x" + ConfigManager.millstone_size);
        millstone.reloadTexture("millstone_x" + ConfigManager.millstone_size);

        BakingMod.logger.info("setting cookie_dough to...cookie_dough_x" + ConfigManager.cookie_dough_size);
        cookie_dough.reloadTexture("cookie_dough_x" + ConfigManager.cookie_dough_size);

        BakingMod.logger.info("setting cookie_dough_blob to...cookie_dough_blob_x" + ConfigManager.cookie_dough_blob_size);
        cookie_dough_blob.reloadTexture("cookie_dough_blob_x" + ConfigManager.cookie_dough_blob_size);

        BakingMod.logger.info("setting butter to...butter_x" + ConfigManager.butter_size);
        butter.reloadTexture("butter_x" + ConfigManager.butter_size);

        BakingMod.logger.info("setting flour to...flour_x" + ConfigManager.flour_size);
        flour.reloadTexture("flour_x" + Byte.toString(ConfigManager.flour_size));

        BakingMod.logger.info("setting buttered_bread to...buttered_bread_x" + ConfigManager.buttered_bread_size);
        buttered_bread.reloadTexture("buttered_bread_x" + ConfigManager.buttered_bread_size);

        BakingMod.logger.info("setting bread_dough_ to...bread_dough_x" + ConfigManager.bread_dough_size);
        bread_dough.reloadTexture("bread_dough_x" + ConfigManager.bread_dough_size);

        BakingMod.logger.info("Complete!");
    }

}
