package RuneMate.Creative_Seren_Miner;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.LoopingScript;

import java.util.function.Predicate;

public class SerenMiner extends LoopingScript{

    private enum State{
        MINE,WAIT
    }
    GameObject stone;

    @Override
    public void onStart(String...args){
        setLoopDelay(120,500);
    }

    @Override
    public void onLoop() {
        switch(getCurrentState()) {
            case MINE:
                stone = GameObjects.newQuery().names("Seren Stone").results().nearest();
                if (stone != null && stone.getDefinition() != null) {
                    if (!stone.isVisible()) {
                        Camera.turnTo(stone);
                    }
                    if (stone.interact("Mine")) {
                        Execution.delayUntil(() -> Players.getLocal().getAnimationId() != -1, 500, 3500);
                    }

                }
                break;
            case WAIT:
                GameObject nextStone = GameObjects.newQuery().names("Seren Stone").filter(new Predicate <GameObject>(){
                    @Override
                    public boolean test(GameObject gameObject){
                        return !gameObject.equals(stone);
                    }
                }).results().nearest();
                if(nextStone != null && nextStone.isVisible()){
                    nextStone.hover();
                }
                break;
        }
    }

    public void onStop(){
    }

    private State getCurrentState(){
        if(Players.getLocal().getAnimationId() == -1 || stone == null || !stone.isValid()){
            return State.MINE;
        }
        else{
            return State.WAIT;
        }
    }
}
