package auberge.requete;

import java.util.List;

public interface DataStore {
    <T> List<T> get(Class<T> type);

    void add(Object object);
}
