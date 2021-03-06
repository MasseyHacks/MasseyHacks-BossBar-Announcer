package ca.masseyhacks.bossbarannouncer.listeners;

import ca.masseyhacks.bossbarannouncer.BossBarAnnouncer;
import ca.masseyhacks.bossbarannouncer.util.MessageManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnConnect implements Listener {
    private BossBarAnnouncer plugin;
    public OnConnect(BossBarAnnouncer plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent event){
        Player player = event.getPlayer();

        plugin.playerBossBars.put(player.getUniqueId(), new MessageManager(plugin));
        if(plugin.getConfig().getStringList("enabledWorlds").contains(player.getWorld().getName())){
            plugin.playerBossBars.get(player.getUniqueId()).bossBar.addPlayer(player);
        }

    }
}
