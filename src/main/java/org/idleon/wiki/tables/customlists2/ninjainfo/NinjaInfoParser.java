package org.idleon.wiki.tables.customlists2.ninjainfo;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.parser.DataTableParser;
import org.idleon.wiki.tables.common.LabMainBonus;
import org.idleon.wiki.tables.customlists2.ninjainfo.NinjaInfoTable.BeanstalkFood;
import org.idleon.wiki.tables.customlists2.ninjainfo.NinjaInfoTable.FloorInfo;

import java.util.ArrayList;
import java.util.List;

public class NinjaInfoParser extends DataTableParser<List<List<String>>, NinjaInfoTable> {

    /**
     * The number of floors in the ninja tower.
     */
    private static final int NUM_FLOORS = 12;

    /**
     * The starting index for drop tables.
     */
    private static final int DROP_TABLE_START_INDEX = 12;

    /**
     * The number of lab nodes added by sneaking.
     */
    private static final int NUM_LAB_NODES = 4;

    /**
     * The index of the first lab node.
     */
    private static final int LAB_NODE_START_INDEX = 25;

    /**
     * The index of the golden food beanstalk items.
     */
    private static final int GOLD_FOOD_BEANSTALK_INDEX = 29;

    /**
     * The index of the death node boss mobs.
     */
    private static final int DEATH_NOTE_MOBS_INDEX = 30;

    /**
     * The index of the crop depot bonuses.
     */
    private static final int CROP_DEPOT_BONUSES_INDEX = 31;

    private static final int TOME_BONUSES_INDEX = 33;

    public NinjaInfoParser() {
        super("scripts.CustomLists2", "NinjaInfo");
    }

    @Override
    protected NinjaInfoTable parseData(@NonNull List<List<String>> input) {
        final var floors = parseFloors(input);
        final var labNodes = parseLabNodes(input);
        final var beanstalkFoods = parseBeanstalkFoods(input.get(GOLD_FOOD_BEANSTALK_INDEX));
        final var deathNoteBossMobs = input.get(DEATH_NOTE_MOBS_INDEX);
        final var cropDepotBonuses = parseCropDepotBonuses(input.get(CROP_DEPOT_BONUSES_INDEX));
        final var tomeBonuses = parseTomeBonuses(input.get(TOME_BONUSES_INDEX));
        final var x4 = parseIntegerList(input.get(4));
        final var x5 = parseIntegerList(input.get(5));
        final var x24 = parseIntegerList(input.get(24));
        final var x32 = parseIntegerList(input.get(32));
        return new NinjaInfoTable(floors, labNodes, beanstalkFoods, deathNoteBossMobs, cropDepotBonuses, tomeBonuses, x4, x5, x24, x32);
    }

    private List<FloorInfo> parseFloors(@NonNull List<List<String>> input) {
        final var floors = new ArrayList<FloorInfo>();
        for (var i = 0; i < NUM_FLOORS; i++) {
            final var floor = parseFloor(input, i);
            floors.add(floor);
        }
        return floors;
    }

    private FloorInfo parseFloor(@NonNull List<List<String>> input, int floor) {
        final var x0 = Integer.parseInt(input.get(0).get(floor));
        final var x1 = Integer.parseInt(input.get(1).get(floor));
        final var x2 = Integer.parseInt(input.get(2).get(floor));
        final var doorDurability = (long) Double.parseDouble(input.get(3).get(floor));
        final var x6 = Integer.parseInt(input.get(6).get(floor));
        final var x7 = Integer.parseInt(input.get(7).get(floor));
        final var x8 = (int) Double.parseDouble(input.get(8).get(floor));
        final var baseStealth = Double.parseDouble(input.get(9).get(floor));
        final var baseJadeGain = (int) Double.parseDouble(input.get(10).get(floor));
        final var baseExperience = (int) Double.parseDouble(input.get(11).get(floor));
        final var dropTable = parseDropTable(input.get(DROP_TABLE_START_INDEX + floor));
        return new FloorInfo(doorDurability, baseStealth, baseJadeGain, baseExperience, dropTable, x0, x1, x2, x6, x7, x8);
    }

    private List<NinjaInfoTable.NinjaDropTableEntry> parseDropTable(@NonNull List<String> table) {
        final var dropTable = new ArrayList<NinjaInfoTable.NinjaDropTableEntry>();
        for (var i = 0; i < table.size(); i += 2) {
            final var item = table.get(i);
            final var chance = Double.parseDouble(table.get(i + 1));
            final var entry = new NinjaInfoTable.NinjaDropTableEntry(item, chance);
            dropTable.add(entry);
        }
        return dropTable;
    }

    private List<LabMainBonus> parseLabNodes(@NonNull List<List<String>> input) {
        final var labNodes = new ArrayList<LabMainBonus>(NUM_LAB_NODES);
        for (var i = 0; i < NUM_LAB_NODES; i++) {
            labNodes.add(LabMainBonus.parse(input.get(LAB_NODE_START_INDEX + i)));
        }
        return labNodes;
    }

    private List<BeanstalkFood> parseBeanstalkFoods(@NonNull List<String> input) {
        final var foods = new ArrayList<BeanstalkFood>(input.size() / 3);
        for (var i = 0; i < input.size(); i += 3) {
            final var x = Integer.parseInt(input.get(i));
            final var y = Integer.parseInt(input.get(i + 1));
            final var item = input.get(i + 2);
            foods.add(new BeanstalkFood(item, x, y));
        }
        return foods;
    }

    private List<String> parseCropDepotBonuses(@NonNull List<String> input) {
        return input.stream()
                .filter(bonus -> !bonus.equals("none"))
                .map(bonus -> bonus.replace('{', '#'))
                .toList();
    }

    private List<String> parseTomeBonuses(@NonNull List<String> input) {
        return input.stream()
                .map(bonus -> bonus.replace('{', '#'))
                .toList();
    }

    private List<Integer> parseIntegerList(@NonNull List<String> input) {
        return input.stream().map(Integer::parseInt).toList();
    }

}
