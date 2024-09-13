package utp.edu.pe.devteam.cli.command;

import java.util.function.Function;

import utp.edu.pe.devteam.cli.util.ValueParser;

/**
 * Represents a flag that can be used in the command line interface.
 * 
 * <p>
 * The behavior of the flag is like gnu flags, it has a name, a short name, a
 * description, a required flag and an action that is executed when the flag is
 * found in the command line.
 * </p>
 * 
 * <p>
 * The flag has the next structure:
 * </p>
 * 
 * <ul>
 * <li>Name: <code>&lt;command&gt; --&lt;name&gt; &lt;value&gt;</code></li>
 * <li>Short name:
 * <code>&lt;command&gt; -&lt;short-name&gt; &lt;value&gt;</code></li>
 * </ul>
 * 
 * @param <T> The type of the input value of the flag
 */
public final class Flag<T> {
    private String name;
    private String shortName;
    private String description;
    private boolean isRequired;
    private Function<T, String> action;

    public Flag(String name, String shortName, String description, boolean isRequired, Function<T, String> action) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.isRequired = isRequired;
        this.action = action;
    }

    /**
     * Runs the action of the flag with the given value.
     * 
     * @param value The value of the flag
     * @return The result of the action
     */
    public String runAction(String value) {
        @SuppressWarnings("unchecked")
        T parsedValue = (T) ValueParser.parseValue(value, action.getClass());

        return action.apply(parsedValue);
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRequired() {
        return isRequired;
    }
}
