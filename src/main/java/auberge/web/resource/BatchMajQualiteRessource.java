package auberge.web.resource;

import auberge.commande.CommandeUpdateQuality;
import ratpack.handling.*;

public class BatchMajQualiteRessource implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.byMethod(spec -> {
            spec.post(() -> this.post(ctx));
        });
    }

    private void post(Context ctx) {
        CommandeUpdateQuality commande = ctx.get(CommandeUpdateQuality.class);
        commande.execute();
    }
}
