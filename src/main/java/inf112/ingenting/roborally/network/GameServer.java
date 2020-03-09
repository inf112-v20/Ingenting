package inf112.ingenting.roborally.network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.util.HashSet;

public class GameServer {
    Server server;
    HashSet<Player> loggedIn = new HashSet<Player>();

    public GameServer() throws IOException{
        server = new Server(){
            @Override
            protected Connection newConnection() {
                return new PlayerConnection();
            }
        };
        Network.register(server);
        server.addListener(new Listener() {
            @Override
            public void received(Connection c, Object object) {
                PlayerConnection connection = (PlayerConnection)c;
                Player player = connection.player;

                if(object instanceof Network.Login){
                    // If player already is logged in.
                    if (player != null) return;
                    for (Player p: loggedIn) {
                        if(p.name.equals(player.name)) {
                            c.close();
                            return;
                        }
                    }
                }
            }
        });
    }

    private void loggedIn (PlayerConnection c, Player player){
        c.player = player;
        // Add existing players to new connection.
        for (Player p: loggedIn) {
        }
    }

    static class PlayerConnection extends Connection {
        Player player;
    }
}
