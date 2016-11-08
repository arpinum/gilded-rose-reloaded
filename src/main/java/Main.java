import auberge.commande.CommandeUpdateQuality;
import auberge.infrastructure.datastore.memory.MemoireDataStore;
import auberge.metier.Item;
import auberge.requete.RequeteListeItems;
import auberge.web.resource.*;
import ratpack.server.*;

public class Main {

    public static void main(String[] args) throws Exception {
        MemoireDataStore memoireDataStore = initializeGraine();
        RatpackServer.of(spec -> {
            spec.serverConfig(ServerConfig.embedded().port(8000));
            spec.registryOf(registry-> {
                registry.add(new RequeteListeItems(memoireDataStore));
                registry.add(new CommandeUpdateQuality(memoireDataStore));
            });
            spec.handlers(chain -> {
                chain.path("items", new ItemsRessource());
                chain.path("batch/updatequality", new BatchMajQualiteRessource());
            });
        }).start();
    }

    private static MemoireDataStore initializeGraine() {
        MemoireDataStore memoireDataStore = new MemoireDataStore();
        memoireDataStore.add(new Item("un bel item", 0, 0));
        memoireDataStore.add(new Item("+5 Dexterity Vest", 10, 20));
        memoireDataStore.add(new Item("Aged Brie", 2, 0));
        memoireDataStore.add(new Item("Elixir of the Mongoose", 5, 7));
        memoireDataStore.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        memoireDataStore.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        memoireDataStore.add(new Item("Conjured Mana Cake", 3, 6));
        return memoireDataStore;
    }
}
