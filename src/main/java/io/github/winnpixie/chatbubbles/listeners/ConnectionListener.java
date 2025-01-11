package io.github.winnpixie.chatbubbles.listeners;

import io.github.winnpixie.chatbubbles.ChatBubblesPlugin;
import io.github.winnpixie.commons.spigot.listeners.EventListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener extends EventListener<ChatBubblesPlugin> {
    public ConnectionListener(ChatBubblesPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        getPlugin().bubbleController.add(event.getPlayer());
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        getPlugin().bubbleController.remove(event.getPlayer());
    }
}
