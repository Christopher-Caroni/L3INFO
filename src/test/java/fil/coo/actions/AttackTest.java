package fil.coo.actions;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.beings.Monster;
import fil.coo.structures.Room;
import fil.coo.structures.RoomFactory;

import java.util.ArrayList;
import java.util.List;

public class AttackTest extends ActionTest {

    @Override
    protected GamePlayer setupPlayerWhenOK() {
        Room currentRoom = new RoomFactory().generateRoom(0, 0);
        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(new Monster());
        currentRoom.addMonsters(monsterList);

        GamePlayer player = new GamePlayer();
        player.setCurrentRoom(currentRoom);
        player.setRoomRevealed(true);

        return player;
    }

    @Override
    protected GamePlayer setupPlayerWhenNotOK() {
        Room currentRoom = new RoomFactory().generateRoom(0, 0);

        GamePlayer player = new GamePlayer();
        player.setCurrentRoom(currentRoom);

        return player;
    }

    @Override
    protected Action getAction() {
        return new Attack();
    }
}