
package net.foxyas.changedaddon.client.renderer;

import net.foxyas.changedaddon.client.model.BioSynthSnowLeopardFemaleModel;
import net.foxyas.changedaddon.entity.SnowLeopardFemaleOrganicEntity;
import net.ltxprogrammer.changed.client.renderer.LatexHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexFemaleCatModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.foxyas.changedaddon.entity.SnowLeopardFemaleOrganicEntity;

public class SnowLeopardFemaleOrganicRenderer extends LatexHumanoidRenderer<SnowLeopardFemaleOrganicEntity, BioSynthSnowLeopardFemaleModel, ArmorLatexFemaleCatModel<SnowLeopardFemaleOrganicEntity>> {
	public SnowLeopardFemaleOrganicRenderer(EntityRendererProvider.Context context) {
		super(context, new BioSynthSnowLeopardFemaleModel(context.bakeLayer(BioSynthSnowLeopardFemaleModel.LAYER_LOCATION)),
				ArmorLatexFemaleCatModel::new, ArmorLatexFemaleCatModel.INNER_ARMOR, ArmorLatexFemaleCatModel.OUTER_ARMOR, 0.5f);
		this.addLayer(new LatexParticlesLayer<>(this, getModel()));
		this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new CustomCoatLayer<>(this, this.getModel(), new ResourceLocation("changed_addon:textures/entities/female_snep_hair")));
		this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor,CustomEyesLayer::glowingIrisColorLeft,CustomEyesLayer::glowingIrisColorRight));
		this.addLayer(new GasMaskLayer<>(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(SnowLeopardFemaleOrganicEntity entity) {
		return new ResourceLocation("changed_addon:textures/entities/snowleopardfemaleorganic.png");
	}
}