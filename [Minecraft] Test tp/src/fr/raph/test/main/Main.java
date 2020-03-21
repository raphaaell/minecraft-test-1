package fr.raph.test.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import fr.raph.test.cmd.Commands;

public class Main extends JavaPlugin implements Listener{
	
	private static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		getCommand("teleportationgame").setExecutor(new Commands());
		getCommand("game").setExecutor(new Commands());
		cmdhb(true);
	}
	
	@Override
	public void onDisable() {
		cmdhb(false);
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public static String cmdhb(boolean etat) {
		PluginDescriptionFile pdf = Main.getInstance().getDescription();
		String str;
		if(etat)
			str = "[" + pdf.getName() + "] ON Version : " + pdf.getVersion() + "]";
		else
			str = "[" + pdf.getName() + "] OFF Version : " + pdf.getVersion() + "]";
		return str;
	}

}