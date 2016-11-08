import auberge.infrastructure.datastore.memory.MemoireDataStore;
import auberge.metier.Item;
import auberge.requete.RequeteListeItems;
import ratpack.registry.Registry;
import ratpack.server.*;

public class Main {

    public static void main(String[] args) throws Exception {
        MemoireDataStore memoireDataStore = initializeGraine();
        RatpackServer.of(spec -> {
            spec.serverConfig(ServerConfig.embedded().port(8000));
            spec.registry(Registry.single(new RequeteListeItems(memoireDataStore)));
            spec.handlers(chain -> {
                chain.path("items", new ItemsRessource());
            });
        }).start();
    }

    private static MemoireDataStore initializeGraine() {
        MemoireDataStore memoireDataStore = new MemoireDataStore();
        memoireDataStore.add(new Item("un bel item", 0, 0));
        return memoireDataStore;
    }
}
