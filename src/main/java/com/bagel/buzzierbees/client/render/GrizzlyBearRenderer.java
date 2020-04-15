package com.bagel.buzzierbees.client.render;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.bagel.buzzierbees.client.model.BearModel;
import com.bagel.buzzierbees.common.entities.GrizzlyBearEntity;
import com.bagel.buzzierbees.core.BuzzierBees;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;

public class GrizzlyBearRenderer extends MobRenderer<GrizzlyBearEntity, BearModel<GrizzlyBearEntity>> {	
	private static final Map<List<String>, String> NAMES = Util.make(Maps.newHashMap(), (skins) -> {
		skins.put(Arrays.asList("derp", "byper"), "derp");
	});

	public GrizzlyBearRenderer(EntityRendererManager renderManager) {
		super(renderManager, new BearModel<>(), 0.9F);
	}

	@Override
	public ResourceLocation getEntityTexture(GrizzlyBearEntity bear) {
		String textureSuffix = "";
		
		if(bear.hasCustomName()) {
			String name = bear.getName().getString().toLowerCase().trim();
			for(Map.Entry<List<String>, String> entries : NAMES.entrySet()) {
				if(entries.getKey().contains(name)) {
					textureSuffix = "_" + entries.getValue();
				}
			}
		}
		return new ResourceLocation(BuzzierBees.MODID, "textures/entity/bear/grizzly_bear" + textureSuffix + ".png");
	}
	
	@Override
	protected void preRenderCallback(GrizzlyBearEntity bear, MatrixStack matrixStack, float partialTickTime) {
		matrixStack.scale(1.3f, 1.3f, 1.3f);
		if(bear.isChild()) {
	        matrixStack.scale(0.65F, 0.65F, 0.65F);
	    }	
	}
}
