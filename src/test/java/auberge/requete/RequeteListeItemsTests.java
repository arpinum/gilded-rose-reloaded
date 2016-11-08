package auberge.requete;

import auberge.infrastructure.datastore.memory.MemoireDataStore;
import auberge.metier.Item;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RequeteListeItemsTests {


    @Test
    public void peut_retourner_aucun_item() throws Exception {
        RequeteListeItems requête = new RequeteListeItems(new MemoireDataStore());

        List<Item> items = requête.execute();

        assertEquals(0, items.size());
    }

    @Test
    public void peut_retourner_des_items() throws Exception {
        MemoireDataStore dataStore = new MemoireDataStore();
        dataStore.add(new Item("nom", 0, 0));
        RequeteListeItems requete = new RequeteListeItems(dataStore);

        List<Item> items = requete.execute();

        assertEquals(1, items.size());
        assertEquals("nom", items.get(0).name);
    }

}
