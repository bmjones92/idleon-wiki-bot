package org.idleon.wiki.tables.customlists.cauldronp2wbonuses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.customlists.cauldronp2wbonuses.CauldronP2WBonusesTable.Cauldrons;
import org.idleon.wiki.tables.customlists.cauldronp2wbonuses.CauldronP2WBonusesTable.Liquids;
import org.idleon.wiki.tables.customlists.cauldronp2wbonuses.CauldronP2WBonusesTable.Vials;
import org.idleon.wiki.tables.common.LavaMathFunc;

import java.util.List;

import static org.idleon.wiki.tables.customlists.cauldronp2wbonuses.CauldronP2WBonusesTable.*;

public class CauldronP2WBonusesParser extends DataTableParser<List<List<List<String>>>, CauldronP2WBonusesTable> {

    public CauldronP2WBonusesParser() {
        super("scripts.CustomLists", "CauldronP2Wbonuses");
    }

    @Override
    protected CauldronP2WBonusesTable parseData(@NonNull List<List<List<String>>> input) {
        final var cauldrons = parseCauldrons(input.get(0));
        final var liquids = parseLiquids(input.get(1));
        final var vials = parseVials(input.get(2));
        final var player = parsePlayer(input.get(3));
        return new CauldronP2WBonusesTable(cauldrons, liquids, vials, player);
    }

    private Cauldrons parseCauldrons(@NonNull List<List<String>> data) {
        return new Cauldrons(
                LavaMathFunc.parse(data.get(0)),
                LavaMathFunc.parse(data.get(1)),
                LavaMathFunc.parse(data.get(2))
        );
    }

    private Liquids parseLiquids(@NonNull List<List<String>> data) {
        return new Liquids(
                LavaMathFunc.parse(data.get(0)),
                LavaMathFunc.parse(data.get(1))
        );
    }

    public Vials parseVials(@NonNull List<List<String>> data) {
        return new Vials(
                LavaMathFunc.parse(data.get(0)),
                LavaMathFunc.parse(data.get(1))
        );
    }

    public Player parsePlayer(@NonNull List<List<String>> data) {
        return new Player(
                LavaMathFunc.parse(data.get(0)),
                LavaMathFunc.parse(data.get(1))
        );
    }

}
