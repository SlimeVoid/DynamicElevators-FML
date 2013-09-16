package slimevoid.elevators.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;

import org.lwjgl.opengl.GL11;

import slimevoid.elevators.core.lib.ResourceLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiElevatorRadialButton extends GuiButton {

	// ID, left, top, display string
	public GuiElevatorRadialButton(int i, int j, int k, String s) {
		super(i, j, k, 35, 16, s);
	}

	@Override
	public void drawButton(Minecraft minecraft, int i, int j) {
		if (!this.drawButton) {
			return;
		}
		FontRenderer fontrenderer = minecraft.fontRenderer;
		/**GL11.glBindTexture(
				GL11.GL_TEXTURE_2D,
				minecraft.renderEngine.getTexture("/gui/elevatorgui.png"));**/
		minecraft.renderEngine.bindTexture(ResourceLib.GUI_ELEVATOR);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		int k = (enabled) ? 0 : 1;
		drawTexturedModalRect(xPosition, yPosition, 215, 42 + k * 13, 13, 13);

		int color = enabled ? 0x000000 : 0x3D3D3D;
		fontrenderer.drawString(
				displayString,
				xPosition + 13 + 1,
				yPosition + height / 2 - 4,
				color);
	}

	@Override
	protected void mouseDragged(Minecraft minecraft, int i, int j) {
	}

	@Override
	public void mouseReleased(int i, int j) {
	}

	@Override
	public boolean mousePressed(Minecraft minecraft, int i, int j) {
		if (!drawButton) {
			return false;
		}
		// mod_ExpandedArt.say((new
		// StringBuilder()).append(i).append(", ").append(j).toString());
		// mod_ExpandedArt.say((new
		// StringBuilder()).append(xPosition).append(", ").append(yPosition).append(": ").append(width).append(", ").append(height).toString());
		if (i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height) {
			enabled = !enabled;
			return true;
		}
		return false;
	}
}
