package RuneMate.Creative_Cooks_Assistant;


import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.queries.NpcQueryBuilder;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.util.StopWatch;
import com.runemate.game.api.client.embeddable.EmbeddableUI;
import com.runemate.game.api.hybrid.util.Resources;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.LoopingScript;
import com.runemate.game.api.script.framework.listeners.InventoryListener;
import com.runemate.game.api.script.framework.listeners.MoneyPouchListener;
import com.runemate.game.api.script.framework.listeners.events.MoneyPouchEvent;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class CooksAssistant extends LoopingScript implements InventoryListener{

    private NpcQueryBuilder getCook = Npcs.newQuery().names("Cook");
    private NpcQueryBuilder getMillie = Npcs.newQuery().names("Millie Miller");
    private final static Coordinate milkLocation = new Coordinate(1,2); //TODO: find Cow farm coordinates.
    private final static Coordinate eggLocation  = new Coordinate(3,4); //TODO: find Egg farm coordinates.
    private final static Coordinate wheatLocation = new Coordinate(5,6); //TODO: find Wheat farm coordinates.
    private final static Coordinate millLocation = new Coordinate(7,8); //TODO: find Mill coordinates.


    // @Override
    public void execute(){

        private void getMilk(){
            final WebPath milkPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(milkLocation);
            GameObject bucket = GameObject.newQuery().names("Bucket").actions("Take").nearest();
            GameObject cow = GameObject.newQuery().names("Prized dairy cow").actions("Milk").nearest();

            if(milkPath != null){
                milkPath.step();
                System.out.println("Walking to Milk...");
            }

            if(bucket.isVisible()) {
                bucket.interact("Take");
            }
            else{
                Camera.turnTo(bucket);
            }

            if(cow.isVisible()){
                cow.interact("Milk");
            }
            else{
                Camera.turnTo(cow);
            }

        }

    private void getEgg(){
        final WebPath eggPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(eggLocation);
        GameObject egg = GameObject.newQuery().names("Super large egg").actions("Take").nearest();

        if(eggPath != null){
            eggPath.step();
            System.out.println("Walking to Milk...");
        }

        if(egg.isVisible()) {
            egg.interact("Take");
        }
        else{
            Camera.turnTo(egg);
        }

    }

    private void getFlour(){
        GameObject wheat = GameObject.newQuery().names("Wheat").actions("Pick").nearest();
        final WebPath wheatPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(wheatLocation);
        final WebPath millPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(millLocation);

        if(wheatPath != null){
            wheatPath.step();
            System.out.println("Walking to Wheat...");
        }

        if(wheat.isVisible()){
            wheat.interact("Pick");
        }
        else{
            Camera.turnTo(wheat);
        }

        if(millPath != null){
            millPath.step();
            System.out.println("Walking to Mill...");
        }




    }


}



}

/*
 Logic:
        Pre-req:
         - Are you logged in?
         - Is your inventory Empty?
     Quest:
        Phase 1:
            - Talk to "Cook"
            - Accept Quest
            - Take "Empty pot"
        Phase 2:
            Milk:
                - Walk to Cow area
                - Interact with gate/check gate
                - Take "Bucket"
                - Use "Bucket" > "prized dairy cow"
                - Check if "top-quality milk" exists in inventory
            Egg:
                - Walk to Chicken Farm
                - Interact with gate/check gate
                - Take "super large egg"
                - Check if "super large egg" exists in inventory
            Flour:
                - Walk to Wheat farm
                - Interact with gate/check gate
                - Pick "Wheat"
                - Walk to Mill Lane Mill
                - Talk to "Millie Miller"
                - Climb to top-floor (interact with stairs)
                - Use "Wheat" > hopper + operate hopper control
                - Return downstairs + "Empty flour bin"
                - Check if "Extra fine flour" exists in inventory
        Phase 3:
            Return:
                - Final Check
                - Does "Top-quality milk" exist?
                - Does "Super large egg" exist?
                - Does "Extra fine flour" exist?
                - Return to Cook
                - Quest Complete
                - Log Out
 */