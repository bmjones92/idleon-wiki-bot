package org.idleon.wiki.tables.customlists.postofficepossibleorders;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.postofficepossibleorders.PostOfficePossibleOrdersTable.PostOfficeRequest;
import org.idleon.wiki.tables.customlists.postofficepossibleorders.PostOfficePossibleOrdersTable.PostOfficeReward;
import org.idleon.wiki.tables.customlists.postofficepossibleorders.PostOfficePossibleOrdersTable.PostOfficeUnknown;

import java.util.List;

public class PostOfficePossibleOrdersParser extends DataTableParser<List<List<List<List<String>>>>, PostOfficePossibleOrdersTable> {

    public PostOfficePossibleOrdersParser() {
        super("scripts.CustomLists", "PostOfficePossibleOrders");
    }

    @Override
    protected PostOfficePossibleOrdersTable parseData(@NonNull List<List<List<List<String>>>> input) {
        return new PostOfficePossibleOrdersTable(input.stream().map(this::parseCarrier).toList());
    }

    private PostOfficePossibleOrdersTable.Carrier parseCarrier(@NonNull List<List<List<String>>> carrier) {
        final var requests = carrier.get(0).stream()
                .map(this::parseRequest).toList();
        final var rewards = carrier.get(1).subList(1, carrier.get(1).size()).stream()
                .map(this::parseReward).toList();
        final var unknown = parseUnknown(carrier.get(1).get(0));

        return new PostOfficePossibleOrdersTable.Carrier(requests, rewards, unknown);
    }

    private PostOfficeRequest parseRequest(@NonNull List<String> request) {
        final var item = request.get(0);
        final var baseQuantity = Integer.parseInt(request.get(1));
        final var x2 = Double.parseDouble(request.get(2));
        return new PostOfficeRequest(item, baseQuantity, x2);
    }

    private PostOfficeReward parseReward(@NonNull List<String> reward) {
        final var item = reward.get(0);
        final var baseQuantity = Integer.parseInt(reward.get(1));
        final var x2 = Integer.parseInt(reward.get(2));
        return new PostOfficeReward(item, baseQuantity, x2);
    }

    private PostOfficeUnknown parseUnknown(@NonNull List<String> unknown) {
        final var x0 = Integer.parseInt(unknown.get(0));
        final var x1 = Integer.parseInt(unknown.get(1));
        final var x2 = Integer.parseInt(unknown.get(2));
        final var x3 = Integer.parseInt(unknown.get(3));
        final var x4 = Integer.parseInt(unknown.get(4));
        return new PostOfficeUnknown(x0, x1, x2, x3, x4);
    }

}
