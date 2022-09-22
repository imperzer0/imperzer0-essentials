package com.imperzer0.essentials;


import com.imperzer0.essentials.commands.*;
import com.imperzer0.essentials.crafts.DebugStickCraft;
import com.imperzer0.essentials.crafts.EmeraldCrafts;
import com.imperzer0.essentials.crafts.EnchantedGoldenAppleCraft;
import com.imperzer0.essentials.crafts.MapCraft;
import com.imperzer0.essentials.listeners.BagListener;
import com.imperzer0.essentials.listeners.OwnerEnchantedKitListener;
import com.imperzer0.essentials.listeners.RetListener;
import com.imperzer0.essentials.utils.Loger;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	private final Loger loger;
	
	public Main() { this.loger = new Loger(this); }
	
	/// Before enabled
	@Override
	public void onLoad()
	{
		getLogger().info("====================== Loading plugin " + getName() + " v" + getDescription().getVersion() +
		                 " ... ======================");
	}
	
	/// When enabled
	@Override
	public void onEnable()
	{
		getLogger().info("======================== Enabled plugin " + getName() + " v" + getDescription().getVersion() +
		                 " ========================");
		
		// Listeners
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new BagListener(this), this);
		manager.registerEvents(new OwnerEnchantedKitListener(loger), this);
		manager.registerEvents(new RetListener(this), this);
		
		
		// Commands
		new Give(loger);
		new Fly(loger);
		new OwnerEnchantedKit(loger);
		new RemoveOwnerEnchantedKit(loger);
		new Gamemode(loger);
		new MkStack(loger);
		new Bag(loger);
		new GetUUID(loger);
		new Ret(loger);
		
		// Craft recipes
		new MapCraft(this);
		new EnchantedGoldenAppleCraft(this);
		new EmeraldCrafts(this);
		new DebugStickCraft(this);
	}
	
	/// When disabled
	@Override
	public void onDisable()
	{
		getLogger().info("========================= Disabled plugin " + getName() + " v" + getDescription().getVersion() +
		                 " =======================");
	}
	
	@Override
	public void saveConfig()
	{
		this.getConfig().options().copyDefaults(true);
		super.saveConfig();
	}
}
