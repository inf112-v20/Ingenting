package inf112.ingenting.roborally.network;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.cards.ProgrammingCard;

// Place to keep things common to both client and server.
public class Network {

    static public void register(EndPoint endPoint){
        Kryo kryo = endPoint.getKryo();
        kryo.register(Board.class);
    }

    static public class Login {
        public String name;
    }

    static public class Register {
        public String name;
    }

    static public class MoveRobot {
        public ProgrammingCard[] cards = new ProgrammingCard[3];
    }

    static public class AddPlayer {
        public Player player;
    }
}
