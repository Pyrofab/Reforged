package org.silvercatcher.reforged.items.weapons;

import org.silvercatcher.reforged.api.AReloadable;
import org.silvercatcher.reforged.api.ReforgedAdditions;
import org.silvercatcher.reforged.entities.EntityBulletBlunderbuss;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBlunderbuss extends AReloadable {

	public ItemBlunderbuss() {
		super("blunderbuss", "shotgun_shoot");
	}

	@Override
	public float getHitDamage() {
		return 2f;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {

		return (repair.getItem() == Items.IRON_INGOT);
	}

	@Override
	public int getItemEnchantability() {

		return ToolMaterial.IRON.getEnchantability();
	}

	@Override
	public int getItemEnchantability(ItemStack stack) {
		return ToolMaterial.IRON.getEnchantability();
	}

	@Override
	public int getReloadTotal() {

		return 40;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		setAmmo(ReforgedAdditions.BLUNDERBUSS_SHOT);
		return super.onItemRightClick(worldIn, playerIn, hand);
	}

	@Override
	public void shoot(World worldIn, EntityLivingBase playerIn, ItemStack stack) {

		for (int i = 1; i < 12; i++) {
			worldIn.spawnEntity(new EntityBulletBlunderbuss(worldIn, playerIn, stack));
		}
	}
}