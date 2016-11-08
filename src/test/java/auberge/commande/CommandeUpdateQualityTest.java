package auberge.commande;


import auberge.infrastructure.datastore.memory.MemoireDataStore;
import auberge.metier.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandeUpdateQualityTest {

    @Test
    public void peut_mettre_a_jour_la_qualité() throws Exception {
        MemoireDataStore memoireDataStore = new MemoireDataStore();
        Item veste = new Item("+5 Dexterity Vest", 10, 20);
        memoireDataStore.add(veste);
        CommandeUpdateQuality command = new CommandeUpdateQuality(memoireDataStore);

        command.execute();

        assertEquals(9, veste.getSellIn());
        assertEquals(19, veste.getQuality());
    }
}
