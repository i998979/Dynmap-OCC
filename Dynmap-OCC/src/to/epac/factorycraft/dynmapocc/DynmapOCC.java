package to.epac.factorycraft.dynmapocc;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.dynmap.DynmapAPI;
import org.dynmap.markers.Marker;
import org.dynmap.markers.MarkerSet;

import com.bergerkiller.bukkit.tc.controller.MinecartGroup;
import com.bergerkiller.bukkit.tc.controller.MinecartGroupStore;
import com.bergerkiller.bukkit.tc.properties.TrainProperties;

import to.epac.factorycraft.dynmapocc.commands.Commands;

public class DynmapOCC extends JavaPlugin {
	
	public static DynmapOCC inst;
	
	public static DynmapAPI dapi = null;
	
	public static BukkitRunnable runnable;
	
	public void onEnable() {
		
		inst = this;
		
		// Copy default config if not exist
		File configFile;
		configFile = new File(getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			getServer().getConsoleSender().sendMessage( "¡±cConfiguration not found. Generating the default one.");
			
			getConfig().options().copyDefaults(true);
			saveConfig();
		}	
		
		// Load DynmapAPI
		dapi = (DynmapAPI) Bukkit.getServer().getPluginManager().getPlugin("dynmap");
	    if (dapi == null)
	    	Bukkit.getServer().getPluginManager().disablePlugin(this);
	    
	    
		
	    // Get/Create MarkerSet
		MarkerSet cartSet = dapi.getMarkerAPI().getMarkerSet("traincarts");
		if (cartSet == null)
			cartSet = dapi.getMarkerAPI().createMarkerSet("traincarts", "TrainCarts", dapi.getMarkerAPI().getMarkerIcons(), false);
		
		
		
		int i = 0;
		// Loop through all TrainCarts and set marker with description
		for (MinecartGroup group : MinecartGroupStore.getGroups()) {
			
			String world = group.getWorld().getName();
			TrainProperties prop = group.getProperties();
			Location loc = prop.getLocation().getLocation();
			String name = prop.getTrainName();
			
			Marker mker = cartSet.createMarker("TC_Cart" + i, "Train " + name, true,
					world, loc.getX(), loc.getY(), loc.getZ(), dapi.getMarkerAPI().getMarkerIcon("vehicles.minecart"), false);
			
			String desc = getConfig().getString("Dynmap-OCC.Description");
			
			desc = desc.replace("%train_id%", prop.getTrainName())
					.replace("%train_dest%", prop.getDestination())
					.replace("%train_target_speed%", prop.getSpeedLimit() + "")
					.replace("%train_wait_distance%", prop.getWaitDistance() + "");
			
			// Bukkit.broadcastMessage(desc);
			
			mker.setDescription(desc);
			
			i++;
		}
		
		// Schedule marker refresh in order to make it move on Dynmap
		scheduleRefreshMarkers();
		
		
		
		getCommand("DynmapOCC").setExecutor(new Commands());
		
	}
	
	public void onDisable() {
		
		inst = null;
		
		dapi.getMarkerAPI().getMarkerSet("traincarts").deleteMarkerSet();
		
		
		
		
	}
	
	
	
	public static void scheduleRefreshMarkers() {
		
		// Delete all old marker
		/*for (Marker mker : dapi.getMarkerAPI().getMarkerSet("traincarts").getMarkers()) {
			mker.deleteMarker();
		}*/
		
		// Cancel running scheduler
		if (runnable != null && !runnable.isCancelled()) runnable.cancel();
		
		// Reschedule runnable in order to make it move again
		runnable = new BukkitRunnable() {
			@Override
			public void run() {
				
				int i = 0;
				for (MinecartGroup group : MinecartGroupStore.getGroups()) {
					
					String world = group.getWorld().getName();
					TrainProperties prop = group.getProperties();
					Location loc = prop.getLocation().getLocation();
					String name = prop.getTrainName();
					
					// Bukkit.broadcastMessage("Looping traincarts");
					
					for (Marker mker : dapi.getMarkerAPI().getMarkerSet("traincarts").getMarkers()) {
						// Bukkit.broadcastMessage(mker.getMarkerID() + "    TC_Cart" + j);
						
						if (mker.getMarkerID().equals("TC_Cart" + i)) {
							// Bukkit.broadcastMessage("¡±aUpdating marker " + mker.getMarkerID());
							mker.setLocation(world, loc.getX(), loc.getY(), loc.getZ());
						}
					}
					i++;
				}
			}
		};
		runnable.runTaskTimer(DynmapOCC.inst, 0, 20);
	}
}
