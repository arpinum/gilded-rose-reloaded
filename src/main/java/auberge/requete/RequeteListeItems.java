package auberge.requete;

import auberge.metier.Item;

import java.util.*;

public class RequeteListeItems {

    public RequeteListeItems(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public List<Item> execute() {
        return dataStore.get(Item.class);
    }

    private DataStore dataStore;
}
