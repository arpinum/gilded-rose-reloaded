import auberge.metier.Item;
import auberge.requete.*;
import ratpack.handling.*;

import java.util.List;
import java.util.stream.Collectors;

class ItemsRessource implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.byMethod(spec -> {
            spec.get(() -> this.get(ctx));
        });
    }

    private void get(Context ctx) {
        RequeteListeItems requeteListeItems = ctx.get(RequeteListeItems.class);
        List<Item> execute = requeteListeItems.execute();
        String collect = execute.stream()
                .map(Item::getName)
                .collect(Collectors.joining());
        ctx.render(collect);
    }

}
