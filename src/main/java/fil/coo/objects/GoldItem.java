package fil.coo.objects;

import fil.coo.other.Selectable;
import fil.coo.other.Spawnable;

import java.util.ArrayList;
import java.util.List;

public class GoldItem extends Spawnable implements Item, Selectable {

    @Override
    public void use() {
        // TODO
    }

    @Override
    public int getMenuDescription() {
        return 0;
    }


    /**
     * @return a random spawn of {@link GoldItem}
     */
    @Override
    public List<? extends Spawnable> getRandomSpawn() {
        int spawnAmount = Spawnable.getSpawnAmount(Types.GOLD);

        List<GoldItem> goldItems = new ArrayList<>();
        for (int i = 0; i < spawnAmount; i++) {
            GoldItem goldItem = new GoldItem();
            goldItems.add(goldItem);
        }
        return goldItems;
    }
}
