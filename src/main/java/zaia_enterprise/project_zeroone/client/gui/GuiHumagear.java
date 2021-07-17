package zaia_enterprise.project_zeroone.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import zaia_enterprise.project_zeroone.Versions;

public class GuiHumagear extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(Versions.MODID, "textures/gui/humagear_hud_bg.png");
    private MatrixStack matrixStack;

    public GuiHumagear(MatrixStack matrixStack) {
        this.width = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        this.height = Minecraft.getInstance().getWindow().getGuiScaledHeight();
        this.minecraft = Minecraft.getInstance();
        this.matrixStack = matrixStack;
    }

    public void setMatrixStack(MatrixStack stack) {
        this.matrixStack = stack;
    }

    public void render() {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, width / 2 - 16, height / 2 - 64, 0, 0, 32, 32, 32, 32);
    }
}
