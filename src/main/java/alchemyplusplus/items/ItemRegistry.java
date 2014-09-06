package alchemyplusplus.items;

import alchemyplusplus.items.FoodTemplate;
import alchemyplusplus.items.PotionTemplate;
import alchemyplusplus.items.FishOil;
import alchemyplusplus.items.MixingFilter;
import alchemyplusplus.items.ItemTemplate;
import alchemyplusplus.tileentities.potioncontainer.ItemPotionBottle;
import alchemyplusplus.tileentities.mixer.ItemLiquidMixer;
import alchemyplusplus.tileentities.extractor.ItemExtractor;
import alchemyplusplus.tileentities.distillery.ItemDistillery;
import alchemyplusplus.tileentities.diffuser.ItemDiffuser;
import alchemyplusplus.utility.ConfigManager;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class ItemRegistry
{

    public static final Item appItemConfusion = new ItemTemplate("AlchemyPlusPlus:confusion").setUnlocalizedName("confusion").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemDiffuser = new ItemDiffuser(ConfigManager.appItemDiffuser, "AlchemyPlusPlus:Diffuser").setUnlocalizedName("diffuserItem").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemDistillery = new ItemDistillery(ConfigManager.appItemDistillery, "AlchemyPlusPlus:Distillery").setUnlocalizedName("distilleryItem").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemExtractor = new ItemExtractor(ConfigManager.appItemExtractor, "AlchemyPlusPlus:Extractor").setUnlocalizedName("extractorItem").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemFesteringFlesh = new FoodTemplate(ConfigManager.appItemFesteringFlesh, "AlchemyPlusPlus:FesteringFlesh", 7, 100, 20).setUnlocalizedName("flesh").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemFilter = new MixingFilter(ConfigManager.appItemFilter, "AlchemyPlusPlus:AlchemicalFilter", 600).setUnlocalizedName("filter");
    public static final Item appItemFishOil = new FishOil(ConfigManager.appItemFishOil).setUnlocalizedName("fishoil").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemIronPowder = new ItemTemplate("AlchemyPlusPlus:ironDust").setUnlocalizedName("obsidian").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemLiquidMixer = new ItemLiquidMixer(ConfigManager.appItemLiquidMixer, "AlchemyPlusPlus:Mixer").setUnlocalizedName("mixerItem").setCreativeTab(ConfigManager.appCreativeTab);
    public static Item appItemPotion = null;
    public static final Item appItemPotionBottle = new ItemPotionBottle(ConfigManager.appItemPotionBottle).setUnlocalizedName("potionBottle").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemSpringyCord = new ItemTemplate("AlchemyPlusPlus:spring").setUnlocalizedName("spring").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appItemSquidEye = new ItemTemplate("AlchemyPlusPlus:SquidEye").setUnlocalizedName("squidEye").setCreativeTab(ConfigManager.appCreativeTab);
    public static final Item appPotionWoodAlcohol = new MixingFilter(ConfigManager.appPotionWoodAlcohol, "AlchemyPlusPlus:WoodAlcohol", 600).setUnlocalizedName("woodalcohol");

    public static void registerHardcoreRecipes()
    {

        System.out.println("Alchemy++ is registering its hardcore recipes! This requires modifyng vanilla recipe list.");

        // first remove the standard vanilla ones!
        ArrayList list = (ArrayList) CraftingManager.getInstance().getRecipeList();

        for (int i = 0; i < list.size(); i++)
        {
            if (ItemStack.areItemStacksEqual(((IRecipe) list.get(i)).getRecipeOutput(), new ItemStack(Items.speckled_melon)))
            {
                System.out.println("Alchemy++ removes \"speckeledMelon\" recipe from the recipe list! Be advised!");
                list.remove(i);
            }

        }

        GameRegistry.addRecipe(new ItemStack(Items.speckled_melon), "ggg", "gmg", "ggg", 'g', new ItemStack(Items.gold_ingot), 'm', new ItemStack(Items.melon));

    }

    public static void registerItemRecipes()
    {

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(appItemPotionBottle), "gwg", "o o", "gog", 'g', new ItemStack(Blocks.glass_pane), 'w', "logWood", 'o', Blocks.iron_block));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(appItemFilter), " og", "oDo", "go ", 'g', new ItemStack(Blocks.glass_pane), 'D', new ItemStack(Items.diamond), 'o', Blocks.iron_block));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(appItemFilter), "go ", "oDo", " og", 'g', new ItemStack(Blocks.glass_pane), 'D', new ItemStack(Items.diamond), 'o', Blocks.iron_block));
        GameRegistry.addShapelessRecipe(new ItemStack(appItemFishOil, 1, 0), new ItemStack(Items.fish), new ItemStack(Items.glass_bottle));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(appItemLiquidMixer), "x x", "xix", "oOo", 'x', new ItemStack(Blocks.glass_pane), 'i', new ItemStack(Items.iron_ingot), 'o', Blocks.iron_block, 'O', new ItemStack(Blocks.iron_block)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(appItemExtractor), "iGi", "I O", "oOo", 'i', new ItemStack(Blocks.gold_block), 'I', new ItemStack(Blocks.iron_block), 'g', new ItemStack(Items.gold_ingot), 'o', Blocks.iron_block, 'O', new ItemStack(Blocks.iron_block)));
        GameRegistry.addRecipe(new ItemStack(appItemDistillery, 1, 0), new Object[]
        {
            "Bi-", "C-P", "F-S", Character.valueOf('B'), Items.brewing_stand, Character.valueOf('i'), Items.iron_ingot, Character.valueOf('C'), Items.cauldron, Character.valueOf('P'), appItemPotionBottle, Character.valueOf('F'), Blocks.furnace, Character.valueOf('S'), Items.iron_ingot
        });

        // GameRegistry.addRecipe(new ItemStack(appItemDiffuser, 1, 0), new Object[] { "--s", "-b-", "w--", Character.valueOf('s'), Item.silk, Character.valueOf('b'), Item.glassBottle, Character.valueOf('w'), Item.bowlEmpty });
    }

    /*
     * public static final int digSpeedID = APPIDManager.nextItemID();
     * //placeholder public static final int digSlowdownID =
     * APPIDManager.nextItemID(); //placeholder public static final int
     * healthBoost = APPIDManager.nextItemID(); //placeholder public static
     * final int absorption = APPIDManager.nextItemID(); //placeholder public
     * static final int health = APPIDManager.nextItemID(); //placeholder
     */
    public static void registerItems()
    {

        GameRegistry.registerItem(appItemFilter, "Filter");
        LanguageRegistry.addName(appItemFilter, "Filter");

        GameRegistry.registerItem(appPotionWoodAlcohol, "woodAlcohol");
        LanguageRegistry.addName(appPotionWoodAlcohol, "Wood Alcohol");

        GameRegistry.registerItem(appItemFesteringFlesh, "festeringFlesh");
        LanguageRegistry.addName(appItemFesteringFlesh, "Festering Flesh");

        GameRegistry.registerItem(appItemSquidEye, "squidEye");
        LanguageRegistry.addName(appItemSquidEye, "Squid's Eye");

        GameRegistry.registerItem(appItemConfusion, "confusion");
        LanguageRegistry.addName(appItemConfusion, "Awkward Feeling");

        GameRegistry.registerItem(appItemSpringyCord, "spring");
        LanguageRegistry.addName(appItemSpringyCord, "Springy Cord");

        GameRegistry.registerItem(appItemIronPowder, "obsidian");
        LanguageRegistry.addName(appItemIronPowder, "Iron Powder");

        GameRegistry.registerItem(appItemFishOil, "fishOil");
        LanguageRegistry.addName(appItemFishOil, "Fish Oil");

        GameRegistry.registerItem(appItemPotionBottle, "potionBottle");
        LanguageRegistry.addName(appItemPotionBottle, "Potion Bottle");

        GameRegistry.registerItem(appItemExtractor, "extractorItem");
        LanguageRegistry.addName(appItemExtractor, "Essence Extractor");

        GameRegistry.registerItem(appItemDistillery, "distilleryItem");
        LanguageRegistry.addName(appItemDistillery, "Distillery");

        GameRegistry.registerItem(appItemDiffuser, "diffuserItem");
        LanguageRegistry.addName(appItemDiffuser, "Diffuser");

        GameRegistry.registerItem(appItemLiquidMixer, "mixerItem");
        LanguageRegistry.addName(appItemLiquidMixer, "Liquid Mixer");

        // work in progress: override vanilla potions
        if (ConfigManager.appVanillaPotionOverride)
        {
            // @TODO - see if this is even still possible...maybe check how Railcraft does it?
//            ItemPotion potion = Items.potionitem;
//            Item.itemRegistry = null;
//            appItemPotion = new PotionTemplate(potion).setUnlocalizedName("potion").setTextureName("potion");
//            Items.potionitem = (ItemPotion) appItemPotion;
//            GameRegistry.registerItem(appItemPotion, "potion");
        }

    }

}
