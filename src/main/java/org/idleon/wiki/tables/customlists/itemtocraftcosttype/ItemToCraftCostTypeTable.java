package org.idleon.wiki.tables.customlists.itemtocraftcosttype;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.idleon.wiki.tables.ArrayGameTable;
import org.idleon.wiki.tables.common.ItemQuantityPair;

import java.util.Collection;
import java.util.List;

public class ItemToCraftCostTypeTable extends ArrayGameTable<List<List<ItemQuantityPair>>> {

    public ItemToCraftCostTypeTable(@NonNull Collection<List<List<ItemQuantityPair>>> items) {
        super(items);
    }

    public List<List<ItemQuantityPair>> getAnvilTab(int tab) {
        return get(tab);
    }

    public List<ItemQuantityPair> getIngredients(int tab, int item) {
        return getAnvilTab(tab).get(item);
    }

    public ItemQuantityPair getIngredient(int tab, int item, int ingredient) {
        return getIngredients(tab, item).get(ingredient);
    }

}
