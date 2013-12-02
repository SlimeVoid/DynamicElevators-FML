package slimevoid.elevators.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import slimevoid.elevators.blocks.BlockElevator;
import slimevoid.elevators.core.lib.ConfigurationLib;
import slimevoid.elevators.entities.EntityElevator;

public class RenderElevator extends Render {

	public RenderElevator() {
		shadowSize = 0.5F;
	}

	public void renderElevatorEntity(Block elevator, World world, int x, int y, int z, Icon[] textureData) {
		this.renderBlocks.setRenderBoundsFromBlock(elevator);

		float f1 = 0.5F;
		float f2 = 1.0F;
		float f3 = 0.8F;
		float f4 = 0.6F;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setBrightness(elevator.getMixedBrightnessForBlock(	world,
																		x,
																		y,
																		z));
		float f5 = 1.0F;
		float f6 = 1.0F;

		if (f6 < f5) {
			f6 = f5;
		}

		tessellator.setColorOpaque_F(	f1 * f6,
										f1 * f6,
										f1 * f6);
		this.renderBlocks.renderFaceYNeg(	elevator,
											-0.5D,
											-0.5D,
											-0.5D,
											textureData[0]);
		f6 = 1.0F;

		if (f6 < f5) {
			f6 = f5;
		}

		tessellator.setColorOpaque_F(	f2 * f6,
										f2 * f6,
										f2 * f6);
		this.renderBlocks.renderFaceYPos(	elevator,
											-0.5D,
											-0.5D,
											-0.5D,
											textureData[1]);
		f6 = 1.0F;

		if (f6 < f5) {
			f6 = f5;
		}

		tessellator.setColorOpaque_F(	f3 * f6,
										f3 * f6,
										f3 * f6);
		this.renderBlocks.renderFaceXPos(	elevator,
											-0.5D,
											-0.5D,
											-0.5D,
											textureData[2]);
		f6 = 1.0F;

		if (f6 < f5) {
			f6 = f5;
		}

		tessellator.setColorOpaque_F(	f3 * f6,
										f3 * f6,
										f3 * f6);
		this.renderBlocks.renderFaceXNeg(	elevator,
											-0.5D,
											-0.5D,
											-0.5D,
											textureData[2]);
		f6 = 1.0F;

		if (f6 < f5) {
			f6 = f5;
		}

		tessellator.setColorOpaque_F(	f4 * f6,
										f4 * f6,
										f4 * f6);
		this.renderBlocks.renderFaceZNeg(	elevator,
											-0.5D,
											-0.5D,
											-0.5D,
											textureData[2]);
		f6 = 1.0F;

		if (f6 < f5) {
			f6 = f5;
		}

		tessellator.setColorOpaque_F(	f4 * f6,
										f4 * f6,
										f4 * f6);
		this.renderBlocks.renderFaceZPos(	elevator,
											-0.5D,
											-0.5D,
											-0.5D,
											textureData[2]);
		tessellator.draw();
	}

	public void doRenderElevator(EntityElevator elevator, double d, double d1, double d2, float f, float f1) {
		GL11.glPushMatrix();
		BlockElevator block = (BlockElevator) ConfigurationLib.Elevator;
		World world = elevator.getWorld();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef(	(float) d,
							(float) d1,
							(float) d2);
		// GL11.glScalef(-1F, -1F, 1.0F); - ceilings?
		loadTexture("/terrain.png");

		// int textureData[] = elevator.getTextureData();
		Icon textureData[] = {
				block.sideTexture,
				block.sideTexture,
				block.sideTexture };

		// Bottom
		textureData[0] = elevator.isCeiling() ? block.topTexture : block.sideTexture;
		// Top
		textureData[1] = elevator.isCeiling() ? block.sideTexture : block.topTexture;
		// Sides
		textureData[2] = block.sideTexture;

		renderElevatorEntity(	block,
								world,
								MathHelper.floor_double(elevator.posX),
								MathHelper.floor_double(elevator.posY),
								MathHelper.floor_double(elevator.posZ),
								textureData);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
		doRenderElevator(	(EntityElevator) entity,
							d,
							d1,
							d2,
							f,
							f1);
	}
}
