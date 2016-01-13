package org.silvercatcher.reforged.proxy;

import org.silvercatcher.reforged.ReforgedRegistry;
import org.silvercatcher.reforged.ReforgedMod;
import org.silvercatcher.reforged.entities.EntityBoomerang;
import org.silvercatcher.reforged.entities.EntityBulletMusket;
import org.silvercatcher.reforged.entities.EntityJavelin;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		
		ReforgedRegistry.createItems();
		ReforgedRegistry.registerItems();
		registerEntities();
		//Version Checker
		FMLInterModComms.sendRuntimeMessage(ReforgedMod.ID, "VersionChecker", "addVersionCheck",
				"https://raw.githubusercontent.com/ThexXTURBOXx/Reforged/master/version.json");
	}

	public void init(FMLInitializationEvent event) {
		
		ReforgedRegistry.registerRecipes();
	}
	
	protected void registerItemRenderers() {}
	
	protected void registerEntityRenderers(RenderManager manager) {}
	
	private void registerEntities() {
		int count = 1;
		ReforgedRegistry.registerEntity(EntityBoomerang.class, "Boomerang", count++);
		ReforgedRegistry.registerEntity(EntityJavelin.class, "Javelin", count++);
		ReforgedRegistry.registerEntity(EntityBulletMusket.class, "BulletMusket", count++);

	}
}
