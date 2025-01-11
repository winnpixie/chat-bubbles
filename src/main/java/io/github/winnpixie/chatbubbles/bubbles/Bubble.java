package io.github.winnpixie.chatbubbles.bubbles;

import io.github.winnpixie.chatbubbles.ChatBubblesPlugin;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;

import java.util.UUID;

public class Bubble {
    private final UUID owner;
    private final TextDisplay entity;

    private int ticksDisplayed;

    public Bubble(UUID owner, TextDisplay entity) {
        this.owner = owner;
        this.entity = entity;
    }

    public UUID getOwner() {
        return owner;
    }

    public TextDisplay getEntity() {
        return entity;
    }

    public int getTicksDisplayed() {
        return ticksDisplayed;
    }

    public void setText(String message) {
        entity.setText(message);
        entity.setBackgroundColor(Color.BLACK);
        ticksDisplayed = 0;
    }

    public void tick(ChatBubblesPlugin plugin) {
        if (ticksDisplayed < 60) {
            ticksDisplayed++;
        } else if (ticksDisplayed == 60) {
            entity.setText("");
            entity.setBackgroundColor(Color.fromARGB(0x00000000));
            ticksDisplayed = 69; // Haha, nice.
        }

        Player player = plugin.getServer().getPlayer(owner);
        if (player == null) return;

        entity.teleport(player.getLocation().add(0, player.getHeight() + 0.569, 0));
    }
}
