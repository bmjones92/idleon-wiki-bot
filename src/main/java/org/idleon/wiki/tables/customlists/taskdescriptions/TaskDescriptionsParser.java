package org.idleon.wiki.tables.customlists.taskdescriptions;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.parser.transformer.TextTransformers;
import org.idleon.wiki.tables.customlists.taskdescriptions.TaskDescriptionsTable.TaskDescription;

import java.util.*;

public class TaskDescriptionsParser extends DataTableParser<List<List<List<String>>>, TaskDescriptionsTable> {

    public TaskDescriptionsParser() {
        super("scripts.CustomLists", "TaskDescriptions");
    }

    @Override
    protected TaskDescriptionsTable parseData(@NonNull List<List<List<String>>> input) {
        return new TaskDescriptionsTable(input.stream().map(this::parseTaskSet).toList());
    }

    private List<TaskDescription> parseTaskSet(@NonNull List<List<String>> tasks) {
        return tasks.stream().map(this::parseTask).toList();
    }

    private static final Set<String> NULL_COMPLETION_TEXT = Set.of("Filler_lol");

    private TaskDescription parseTask(@NonNull List<String> task) {
        final var name = TextTransformers.SPACES.transform(task.get(0));
        final var descriptions = parseTaskDescriptions(task);
        final var reward = Integer.parseInt(task.get(task.size() == 15 ? 3 : 2));

        var x0 = 0;
        boolean x1 = false;
        String completionDescription = null;

        final var tokens = task.get(task.size() == 15 ? 4 : 3).split("\\|");
        if (tokens.length == 3) {
            x0 = Integer.parseInt(tokens[0]);
            x1 = TextTransformers.parseBoolean(tokens[1]);
            if (!NULL_COMPLETION_TEXT.contains(tokens[2])) {
                completionDescription = TextTransformers.SENTENCE.transform(tokens[2]);
            }
        }

        return new TaskDescription(name, descriptions, completionDescription, reward, x0, x1);
    }

    private List<String> parseTaskDescriptions(@NonNull List<String> task) {
        final var template = TextTransformers.SENTENCE.transform(task.get(1));

        final var hasQuantities = template.contains("{");
        final var hasFlavors = template.contains("}");
        if (!hasQuantities && !hasFlavors) {
            return List.of(template);
        }

        // Get the list of flavor text for the task.
        final var flavors = hasFlavors && task.size() == 15
                ? parseTemplateFlavors(task.get(2))
                : Collections.<String>emptyList();

        // Get the list of quantity requirements for this task.
        final var quantities = hasQuantities
                ? parseTemplateQuantities(task.subList(task.size() - 10, task.size()))
                : Collections.<String>emptyList();

        // Calculate the number of variants of this text.
        final var numVariants = Math.min(
                hasFlavors ? flavors.size() : Integer.MAX_VALUE,
                hasQuantities ? quantities.size() : Integer.MAX_VALUE);

        final var descriptions = new ArrayList<String>(numVariants);
        for (var i = 0; i < numVariants; i++) {
            var description = template;

            if (hasQuantities) {
                description = description.replaceAll("\\{", quantities.size() > i ? quantities.get(i) : "");
            }
            if (hasFlavors) {
                description = description.replaceAll("}", flavors.size() > i ? flavors.get(i) : "");
            }
            descriptions.add(description);
        }
        return descriptions;
    }

    private List<String> parseTemplateFlavors(@NonNull String line) {
        if (line.equals("Blank420q")) {
            return Collections.emptyList();
        }
        return Arrays.stream(line.split("\\|")).map(TextTransformers.SPACES::transform).toList();
    }

    private List<String> parseTemplateQuantities(@NonNull List<String> quantities) {
        if (quantities.get(0).equals("_")) {
            return Collections.emptyList();
        }
        return quantities.stream().map(q -> q.equals("_") ? null : q).filter(Objects::nonNull).toList();
    }

}
