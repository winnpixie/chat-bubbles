package io.github.winnpixie.chatbubbles;

import io.github.winnpixie.chatbubbles.bubbles.BubbleController;
import io.github.winnpixie.chatbubbles.listeners.ConnectionListener;
import io.github.winnpixie.chatbubbles.listeners.PlayerActionListener;
import io.github.winnpixie.commons.spigot.SpigotHelper;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatBubblesPlugin extends JavaPlugin {
    public final BubbleController bubbleController = new BubbleController();

    @Override
    public void onEnable() {
        bubbleController.load(this);

        SpigotHelper.addListener(new ConnectionListener(this));
        SpigotHelper.addListener(new PlayerActionListener(this));
    }
}
