package io.github.winnpixie.chatbubbles.bubbles;

import io.github.winnpixie.chatbubbles.ChatBubblesPlugin;
import org.bukkit.entity.Display;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleController {
    private final List<Bubble> bubbles = new CopyOnWriteArrayList<>();

    public void load(ChatBubblesPlugin plugin) {
        plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
            for (Bubble bubble : bubbles) {
                bubble.tick(plugin);
            }
        }, 0, 1);
    }

    public void add(Player player) {
        TextDisplay display = player.getWorld().spawn(player.getLocation(), TextDisplay.class, entity -> {
            entity.setPersistent(false);
            entity.setBillboard(Display.Billboard.CENTER);
            entity.setTeleportDuration(2);
            entity.setInterpolationDuration(1);
        });

        bubbles.add(new Bubble(player.getUniqueId(), display));
    }

    public void remove(Player player) {
        for (int i = bubbles.size(); i > 0; i--) {
            Bubble bubble = bubbles.get(i - 1);
            if (!bubble.getOwner().equals(player.getUniqueId())) continue;

            bubbles.remove(bubble);
            bubble.getEntity().remove();
        }
    }

    public Bubble getBubble(Player player) {
        for (Bubble bubble : bubbles) {
            if (bubble.getOwner().equals(player.getUniqueId())) return bubble;
        }

        return null;
    }
}
