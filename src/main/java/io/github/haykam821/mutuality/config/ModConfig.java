package io.github.haykam821.mutuality.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "mutuality")
@Config.Gui.Background("minecraft:textures/block/obsidian.png")
public class ModConfig implements ConfigData {
	@ConfigEntry.Gui.Tooltip
	public boolean protectionMutuality = true;
}