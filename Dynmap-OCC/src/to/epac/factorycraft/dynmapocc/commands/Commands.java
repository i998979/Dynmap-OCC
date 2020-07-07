package to.epac.factorycraft.dynmapocc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.bergerkiller.bukkit.tc.controller.MinecartGroup;
import com.bergerkiller.bukkit.tc.controller.MinecartGroupStore;
import com.bergerkiller.bukkit.tc.properties.TrainProperties;
import com.bergerkiller.bukkit.tc.utils.SlowdownMode;

import to.epac.factorycraft.dynmapocc.DynmapOCC;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length == 0) {
			sender.sendMessage("¡±cNot enough arguments.");
			return false;
		}
		
		if (args.length >= 1) {
			
			if (args[0].equalsIgnoreCase("reload")) {
				DynmapOCC.inst.reloadConfig();
				sender.sendMessage("¡±aConfig reloaded.");
				return true;
			}
			
			if (args[0].equalsIgnoreCase("refresh")) {
				DynmapOCC.dapi.getMarkerAPI().getMarkerSet("traincarts");
				
				
				sender.sendMessage("¡±aConfig reloaded.");
				return true;
			}
			
			
			String trainId = args[0];
			
			for (MinecartGroup group : MinecartGroupStore.getGroups()) {
				TrainProperties prop = group.getProperties();
				
				if (!prop.getTrainName().equals(trainId)) continue;
				
				if (args[1].equalsIgnoreCase("setWaitDistance")) {
					prop.setWaitDistance(Double.parseDouble(args[2]));
				}
				if (args[1].equalsIgnoreCase("setTurboAction")) {
					prop.getHolder().getActions().clear();
					prop.getHolder().head().getActions().addActionLaunch(5, prop.getSpeedLimit());
				}
				if (args[1].equalsIgnoreCase("setSpeedLimit")) {
					prop.setSpeedLimit(Double.parseDouble(args[2]));
				}
				if (args[1].equalsIgnoreCase("setGravity")) {
					prop.setGravity(Double.parseDouble(args[2]));
				}
				if (args[1].equalsIgnoreCase("setSlowingDown")) {
					prop.setSlowingDown(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setSlowingDown2")) {
					prop.setSlowingDown(SlowdownMode.valueOf(args[2]), Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setColliding")) {
					prop.setColliding(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setDisplayName")) {
					prop.setDisplayName(args[2]);
				}
				if (args[1].equalsIgnoreCase("setEnterMessage")) {
					prop.setEnterMessage(args[2]);
				}
				if (args[1].equalsIgnoreCase("setKeepChunksLoaded")) {
					prop.setKeepChunksLoaded(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setSoundEnabled")) {
					prop.setSoundEnabled(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setPickup")) {
					prop.setPickup(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("clearOwners")) {
					prop.clearOwners();;
				}
				if (args[1].equalsIgnoreCase("setEnterMessage")) {
					prop.setEnterMessage(args[2]);
				}
				if (args[1].equalsIgnoreCase("clearOwnerPermissions")) {
					prop.clearOwnerPermissions();
				}
				if (args[1].equalsIgnoreCase("setPlayerTakeable")) {
					prop.setPlayerTakeable(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setBankingStrength")) {
					prop.setBankingStrength(Double.parseDouble(args[2]));
				}
				if (args[1].equalsIgnoreCase("setBankingSmoothness")) {
					prop.setBankingSmoothness(Double.parseDouble(args[2]));
				}
				if (args[1].equalsIgnoreCase("setPublic")) {
					prop.setPublic(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setEnterMessage")) {
					prop.setEnterMessage(args[2]);
				}
				if (args[1].equalsIgnoreCase("setTags")) {
					// TODO - setTags()
					prop.setTags();
				}
				if (args[1].equalsIgnoreCase("clearTags")) {
					prop.clearTags();
				}
				if (args[1].equalsIgnoreCase("addTags")) {
					prop.addTags(args[2]);
				}
				if (args[1].equalsIgnoreCase("removeTags")) {
					prop.removeTags(args[2]);
				}
				if (args[1].equalsIgnoreCase("setPlayersEnter")) {
					prop.setPlayersEnter(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setPlayersExit")) {
					prop.setPlayersExit(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setInvincible")) {
					prop.setInvincible(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setSpawnItemDrops")) {
					prop.setSpawnItemDrops(Boolean.parseBoolean(args[2]));
				}
				if (args[1].equalsIgnoreCase("setDestination")) {
					prop.setDestination(args[2]);
				}
				if (args[1].equalsIgnoreCase("setName")) {
					prop.setName(args[2]);
				}
				if (args[1].equalsIgnoreCase("setLinking")) {
					prop.setLinking(Boolean.parseBoolean(args[2]));
				}
				
				try {
					Bukkit.broadcastMessage("DOCC - " + args[0] + " " + args[1] + " " + args[2]);
				} catch (Exception e) {
					
				}
				break;
				
			}
		}
		
		return false;
	}
}
