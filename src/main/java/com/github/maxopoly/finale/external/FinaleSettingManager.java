package com.github.maxopoly.finale.external;

import java.util.UUID;

import com.github.maxopoly.finale.Finale;

import vg.civcraft.mc.civmodcore.playersettings.PlayerSettingAPI;
import vg.civcraft.mc.civmodcore.playersettings.gui.MenuSection;
import vg.civcraft.mc.civmodcore.playersettings.impl.BooleanSetting;

public class FinaleSettingManager {

	private BooleanSetting vanillaPearlCooldown;
	private BooleanSetting actionBarPearlCooldown;
	private BooleanSetting sideBarPearlCooldown;

	public FinaleSettingManager() {
		initSettings();
	}

	public void initSettings() {
		Finale plugin = Finale.getPlugin();
		MenuSection menu = PlayerSettingAPI.getMainMenu().createMenuSection("Combat",
				"Combat and Finale related settings");
		vanillaPearlCooldown = new BooleanSetting(plugin, false, "Use vanilla pearl cooldown",
				"finaleVanillaPearlCooldown",
				"Should pearl cooldown be shown as an overlay on the item, the way it is done in vanilla");
		PlayerSettingAPI.registerSetting(vanillaPearlCooldown, menu);
		actionBarPearlCooldown = new BooleanSetting(plugin, true, "Show pearl cooldown on action bar",
				"finaleActionBarPearlCooldown",
				"Should pearl cooldown be shown on the action bar at the bottom of your screen");
		PlayerSettingAPI.registerSetting(actionBarPearlCooldown, menu);
		sideBarPearlCooldown = new BooleanSetting(plugin, false, "Show pearl cooldown in side bar",
				"finaleSideBarPearlCooldown",
				"Should pearl cooldown be shown on the sidebar");
		PlayerSettingAPI.registerSetting(sideBarPearlCooldown, menu);
	}
	
	public boolean setVanillaPearlCooldown(UUID uuid) {
		return vanillaPearlCooldown.getValue(uuid);
	}
	
	public boolean sideBarPearlCooldown(UUID uuid) {
		return sideBarPearlCooldown.getValue(uuid);
	}
	
	public boolean actionBarPearlCooldown(UUID uuid) {
		return actionBarPearlCooldown.getValue(uuid);
	}

}
