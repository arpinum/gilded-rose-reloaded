package auberge.web.resource;

import auberge.requete.RequeteListeItems;
import ratpack.handling.*;

import static ratpack.jackson.Jackson.*;

public class ItemsRessource implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.byMethod(spec -> {
            spec.get(() -> this.get(ctx));
        });
    }

    private void get(Context ctx) {
        RequeteListeItems requeteListeItems = requeteur(ctx);
        ctx.render(json(requeteListeItems.execute()));
    }

    private RequeteListeItems requeteur(Context ctx) {
        return ctx.get(RequeteListeItems.class);
    }

}
