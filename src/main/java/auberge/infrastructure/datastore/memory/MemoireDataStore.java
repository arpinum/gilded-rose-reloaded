package auberge.infrastructure.datastore.memory;

import auberge.requete.DataStore;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MemoireDataStore implements DataStore {

    @Override
    public <T> List<T> get(Class<T> type) {
        return store.getOrDefault(type, Collections.emptyList())
                .stream().map(e -> (T)e)
                .collect(Collectors.toList());
    }

    @Override
    public void add(Object object) {
        if(!store.containsKey(object.getClass())) {
            store.put(object.getClass(), new ArrayList<>());
        }
        store.get(object.getClass()).add(object);
    }

    private Map<Class<?>, List<Object>> store = new ConcurrentHashMap<>();
}
