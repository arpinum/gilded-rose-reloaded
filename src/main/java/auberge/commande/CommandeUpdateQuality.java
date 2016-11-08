package auberge.commande;

import auberge.metier.*;
import auberge.requete.DataStore;

public class CommandeUpdateQuality {


    public CommandeUpdateQuality(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void execute() {
        new GildedRose(dataStore.get(Item.class)).updateQuality();
    }

    private DataStore dataStore;
}
