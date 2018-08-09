package de.d3adspace.laura.spigot.api.util;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A timed section that can be used to print the time a specific section needed between the instantiation of the timed
 * section and the closing via {@link AutoCloseable#close()}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class TimedSection implements AutoCloseable {

    /**
     * The format of the result message in the console.
     */
    private static final String FORMAT = "Timing :: %s took: %sms.";

    /**
     * When the timed section began.
     */
    private final long start = System.currentTimeMillis();
    /**
     * The logger the result will be printed to.
     */
    private final Logger logger;
    /**
     * The name of the timed section.
     */
    private final String name;
    /**
     * When the timed section ended.
     */
    private long end;

    /**
     * Create a new timed section by its name.
     *
     * @param name The name.
     */
    public TimedSection(Logger logger, String name) {
        this.logger = logger;
        this.name = name;
    }

    public static void main(String[] args) {
        TextComponent textComponent = new TextComponent("You may click ");

        TextComponent clickableTextComponent = new TextComponent("here");
        clickableTextComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, ""));

        TextComponent assembledComponent = new TextComponent(textComponent, clickableTextComponent);
    }

    @Override
    public void close() {

        end = System.currentTimeMillis();
        printTime();
    }

    /**
     * Print the time to the logger.
     */
    private void printTime() {

        String result = String.format(FORMAT, name, (end - start));
        logger.log(Level.INFO, result);
    }
}
