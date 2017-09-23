package tonius.simplyjetpacks.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tonius.simplyjetpacks.SimplyJetpacks;

public class ItemHelper
{
	public static OreDictionaryProxy oreProxy = new OreDictionaryProxy();
	public static ResourceLocation resourceLocation = new ResourceLocation(SimplyJetpacks.MODID);

	private ItemHelper()
	{}

	public static boolean oreNameExists(String oreName)
	{
		return oreProxy.oreNameExists(oreName);
	}

	public static ItemStack cloneStack(Item item, int stackSize)
	{
		if(item == null)
		{
			return null;
		}
		ItemStack stack = new ItemStack(item, stackSize);

		return stack;
	}

	public static ItemStack cloneStack(Block item, int stackSize)
	{
		if(item == null)
		{
			return null;
		}
		ItemStack stack = new ItemStack(item, stackSize);

		return stack;
	}

	public static ItemStack cloneStack(ItemStack stack, int stackSize)
	{
		if(stack == null)
		{
			return null;
		}
		ItemStack retStack = stack.copy();
		retStack.setCount(stackSize);

		return retStack;
	}

	public static ItemStack cloneStack(ItemStack stack)
	{
		if(stack == null)
		{
			return null;
		}
		ItemStack retStack = stack.copy();

		return retStack;
	}

	/* CREATING ItemStacks */
	public static final ItemStack stack(Item t)
	{
		return new ItemStack(t);
	}

	public static final ItemStack stack(Item t, int s)
	{
		return new ItemStack(t, s);
	}

	public static final ItemStack stack(Item t, int s, int m)
	{
		return new ItemStack(t, s, m);
	}

	public static final ItemStack stack(Block t)
	{
		return new ItemStack(t);
	}

	public static final ItemStack stack(Block t, int s)
	{
		return new ItemStack(t, s);
	}

	public static final ItemStack stack(Block t, int s, int m)
	{
		return new ItemStack(t, s, m);
	}

	/* CREATING OreRecipes */
	public static final IRecipe ShapedRecipe(Block result, Object... recipe)
	{
		return new ShapedOreRecipe(resourceLocation, result, recipe);
	}

	public static final IRecipe ShapedRecipe(Item result, Object... recipe)
	{
		return new ShapedOreRecipe(resourceLocation, result, recipe);
	}

	public static final IRecipe ShapedRecipe(ItemStack result, Object... recipe)
	{
		return new ShapedOreRecipe(resourceLocation, result, recipe);
	}

	public static final IRecipe ShapedRecipe(Block result, int s, Object... recipe)
	{
		return new ShapedOreRecipe(resourceLocation, stack(result, s), recipe);
	}

	public static final IRecipe ShapedRecipe(Item result, int s, Object... recipe)
	{
		return new ShapedOreRecipe(resourceLocation, stack(result, s), recipe);
	}

	public static final IRecipe ShapedRecipe(ItemStack result, int s, Object... recipe)
	{
		return new ShapedOreRecipe(resourceLocation, cloneStack(result, s), recipe);
	}

	public static final IRecipe ShapelessRecipe(Block result, Object... recipe)
	{
		return new ShapelessOreRecipe(resourceLocation, result, recipe);
	}

	public static final IRecipe ShapelessRecipe(Item result, Object... recipe)
	{
		return new ShapelessOreRecipe(resourceLocation, result, recipe);
	}

	public static final IRecipe ShapelessRecipe(ItemStack result, Object... recipe)
	{
		return new ShapelessOreRecipe(resourceLocation, result, recipe);
	}

	public static final IRecipe ShapelessRecipe(Block result, int s, Object... recipe)
	{
		return new ShapelessOreRecipe(resourceLocation, stack(result, s), recipe);
	}

	public static final IRecipe ShapelessRecipe(Item result, int s, Object... recipe)
	{
		return new ShapelessOreRecipe(resourceLocation, stack(result, s), recipe);
	}

	public static final IRecipe ShapelessRecipe(ItemStack result, int s, Object... recipe)
	{
		return new ShapelessOreRecipe(resourceLocation, cloneStack(result, s), recipe);
	}

	//RECIPE

	public static void addShapedRecipe(ItemStack out, Object... recipe)
	{
		ForgeRegistries.RECIPES.register(ShapedRecipe(out, recipe));
	}

	public static void addShapedRecipe(Item out, Object... recipe)
	{
		addShapedRecipe(new ItemStack(out), recipe);
	}

	public static void addShapedRecipe(Block out, Object... recipe)
	{
		addShapedRecipe(new ItemStack(out), recipe);
	}

	public static void addShapelessRecipe(ItemStack out, Object... recipe)
	{
		ForgeRegistries.RECIPES.register(ShapelessRecipe(out, recipe));
	}

	public static void addShapelessRecipe(Item out, Object... recipe)
	{
		addShapelessRecipe(new ItemStack(out), recipe);
	}

	public static void addShapelessRecipe(Block out, Object... recipe)
	{
		addShapelessRecipe(new ItemStack(out), recipe);
	}

	public static void addShapedOreRecipe(ItemStack out, Object... recipe)
	{
		ForgeRegistries.RECIPES.register(ShapedRecipe(out, recipe));
	}

	public static void addShapedOreRecipe(Item out, Object... recipe)
	{
		ForgeRegistries.RECIPES.register(ShapedRecipe(out, recipe));
	}

	public static void addShapedOreRecipe(Block out, Object... recipe)
	{
		ForgeRegistries.RECIPES.register(ShapedRecipe(out, recipe));
	}

	public static void addShapelessOreRecipe(ItemStack out, Object... recipe)
	{
		ForgeRegistries.RECIPES.register(ShapedRecipe(out, recipe));
	}

	public static void addShapelessOreRecipe(Item out, Object... recipe)
	{
		ForgeRegistries.RECIPES.register(ShapedRecipe(out, recipe));
	}

	public static void addShapelessOreRecipe(Block out, Object... recipe)
	{
		ForgeRegistries.RECIPES.register(ShapedRecipe(out, recipe));
	}

	//END RECIPE

	//SURROUND

	public static boolean addSurroundRecipe(ItemStack out, ItemStack one, ItemStack eight)
	{
		if(out == null | one == null | eight == null)
		{
			return false;
		}
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(resourceLocation, cloneStack(out), "XXX", "XIX", "XXX", 'X', cloneStack(eight, 1), 'I', cloneStack(one, 1)));
		return true;
	}

	public static boolean addSurroundRecipe(ItemStack out, String one, ItemStack eight)
	{
		if(out == null | eight == null || !oreNameExists(one))
		{
			return false;
		}
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(resourceLocation, out, "XXX", "XIX", "XXX", 'X', eight, 'I', one));
		return true;
	}

	public static boolean addSurroundRecipe(ItemStack out, ItemStack one, String eight)
	{
		if(out == null | one == null || !oreNameExists(eight))
		{
			return false;
		}
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(resourceLocation, out, "XXX", "XIX", "XXX", 'X', eight, 'I', one));
		return true;
	}

	public static boolean addSurroundRecipe(ItemStack out, String one, String eight)
	{
		if(out == null || !oreNameExists(one) || !oreNameExists(eight))
		{
			return false;
		}
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(resourceLocation, out, "XXX", "XIX", "XXX", 'X', eight, 'I', one));
		return true;
	}

	//END SURROUND
}
