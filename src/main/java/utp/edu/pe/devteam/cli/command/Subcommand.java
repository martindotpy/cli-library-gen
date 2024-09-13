package utp.edu.pe.devteam.cli.command;

import java.util.List;
import java.util.Map;

import utp.edu.pe.devteam.cli.util.ValueParser;

/**
 * Represents a subcommand that can be used in the command line interface.
 * 
 * <p>
 * The behavior of the subcommand is like gnu subcommands, it has a name, a
 * description, flags and an action that is executed when the
 * subcommand is found in the command line.
 * </p>
 * 
 * <p>
 * The subcommand has the next structure:
 * </p>
 * 
 * <ul>
 * <li>Name: <code>&lt;command&gt; &lt;subcommand&gt; &lt;flags&gt;</code></li>
 * </ul>
 */
public final class Subcommand {
    private String name;
    private String description;
    private Flag<?>[] flags;

    public Subcommand(String name, String description, Flag<?>[] flags) {
        this.name = name;
        this.description = description;
        this.flags = flags;
    }

    /**
     * Runs the action of the subcommand with the given values.
     * 
     * @param value The values of the flags in a string
     * @return The result of the action
     */
    public String runAction(String value) {
        StringBuilder result = new StringBuilder();
        List<String> list = ValueParser.parseList(value);
        Map<Flag<?>, String> parsedFlags = parseFlags(list);

        for (Flag<?> flag : flags) {
            String flagValue = parsedFlags.get(flag);

            if (flagValue != null) {
                result.append(flag.runAction(flagValue));
            }
        }

        return result.toString();
    }

    private Map<Flag<?>, String> parseFlags(List<String> list) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private Flag<?> findFlag(String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
