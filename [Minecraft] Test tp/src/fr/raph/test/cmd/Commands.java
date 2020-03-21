package fr.raph.test.cmd;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import fr.raph.test.main.Main;

public class Commands implements CommandExecutor {
	
	private static ArrayList<Player> gameP = new ArrayList<Player>();
	private static boolean game;
	private static int i = 0;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			
			if(cmd.getName().equalsIgnoreCase("teleportationgame")) {
				if(args.length == 0) 
					p.sendMessage("La commande est /teleportationgame start/stop");

				else if(args[0].equalsIgnoreCase("start")) {
					p.getInventory().clear();
					p.setHealth(20);
					p.setFoodLevel(20);
					p.giveExpLevels(-999999);
					
					int minute = (int) 1200L;
					System.out.println(minute);
					Bukkit.getScheduler().cancelTasks(Main.getInstance());
					Main.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
						
						
						@Override
						public void run() {
							p.sendMessage("hello");
							
						}
					}, 0L, minute * 5);
					
				}else if(args[0].equalsIgnoreCase("stop")) 
					Bukkit.getScheduler().cancelTasks(Main.getInstance());
					
				else 
					p.sendMessage("La commande est /teleportationgame start/stop");
				
			}else if(cmd.getName().equalsIgnoreCase("game")) {
				if(args.length == 0)
					p.sendMessage("La commande est /game create/join");
				
				else if(args[0].equalsIgnoreCase("create")) {
					String eaf = getP().toString();
					
					if(eaf.contains(p.getName())) {
						p.sendMessage("Vous avez déjà créer une game");
					} else {
						setP(p);
						setGame(true);
					}
				}else if(args[0].equalsIgnoreCase("join")){
					String eaf = getP().toString();
					System.out.println(eaf);
					if(getGame() == true) {
						
						if(args[1] == null || args[1].isEmpty()) 
							System.out.println("error");
						
						if(eaf.contains(args[1])) 
							Main.getInstance().getServer().getPlayer(args[1]).sendMessage("sgsgf");
						
						else 
							System.out.println("shit");

					}else if(getGame() == false) 
						System.out.println("cheh");
					
				}
				
			}
			
		}

		return false;
	}
	
	public static void setP(Player Pl) { gameP.add(i, Pl); i++; }
	
	public static ArrayList<Player> getP() { return gameP; }

	public static boolean getGame() { return game; }
	
	public static void setGame(boolean gamechoix) { game = gamechoix; }

}
