import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

import java.util.Arrays;

public class Comrade {

    public static void main(final String[] args) {
        final String token = "ODI2MTAzNzIxNTA2MzczNjYz.YGHnCw.fSO035VPW2DT0youPP5NTBF3Epc";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        assert gateway != null;
        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            final MessageChannel channel = message.getChannel().block();
            assert channel != null;
            String phrase = new Text().phrase;
            double[] chance = {0.075, 1};
            int random = Arrays.binarySearch(chance, Math.random());
            if (random < 0) {
                random = -random - 1;
            }
            switch (random) {
                case 0: {
                    channel.createMessage(phrase).subscribe();
                    break;
                }
                case 1: {
                    random = -random - 1;
                    break;
                }
            }
        });
        gateway.onDisconnect().block();
    }
}
