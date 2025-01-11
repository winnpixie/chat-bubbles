package io.github.winnpixie.chatbubbles.listeners;

import io.github.winnpixie.chatbubbles.ChatBubblesPlugin;
import io.github.winnpixie.commons.spigot.listeners.EventListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerActionListener extends EventListener<ChatBubblesPlugin> {
    public PlayerActionListener(ChatBubblesPlugin plugin) {
        super(plugin);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void onChat(AsyncPlayerChatEvent event) {
        getPlugin().bubbleController.getBubble(event.getPlayer())
                .setText(event.getMessage());
    }
}
