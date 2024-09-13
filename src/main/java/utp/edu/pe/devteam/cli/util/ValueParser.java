package utp.edu.pe.devteam.cli.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Utility class to parse values from the command line.
 */
public final class ValueParser {
    /**
     * Parses a value from a string to the given type.
     * 
     * @param value The value to parse
     * @param type  The type to parse the value
     * @return The parsed value
     */
    public static Object parseValue(String value, Class<?> type) {
        if (type == String.class) {
            return value;
        } else if (type == Integer.class) {
            return Integer.parseInt(value);
        } else if (type == Double.class) {
            return Double.parseDouble(value);
        } else if (type == Boolean.class) {
            return Boolean.parseBoolean(value);
        } else if (type == List.class) {
            return parseList(value);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }

    /**
     * Parses a list of values from a string.
     * 
     * @param value The value to parse
     * @return The list of values as strings
     */
    public static List<String> parseList(String value) {
        List<String> list = new LinkedList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();

        for (char c : value.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                list.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        list.add(sb.toString());

        return list;
    }
}
