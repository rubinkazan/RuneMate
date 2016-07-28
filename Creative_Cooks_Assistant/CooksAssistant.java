package RuneMate.Creative_Cooks_Assistant;


import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.queries.NpcQueryBuilder;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.util.StopWatch;

public class CooksAssistant {

    private NpcQueryBuilder getCook = Npcs.newQuery().names("Cook");
    private NpcQueryBuilder getMillie = Npcs.newQuery().names("Millie Miller");
    private StopWatch runningTime = new StopWatch();
    private Coordinate startPosition;
    private final static Coordinate milkLocation = new Coordinate(1,2); //TODO: find Cow farm coordinates.
    private final static Coordinate eggLocation  = new Coordinate(3,4); //TODO: find Egg farm coordinates.
    private final static Coordinate wheatLocation = new Coordinate(5,6); //TODO: find Wheat farm coordinates.
    private final static Coordinate millLocation = new Coordinate(7,8); //TODO: find Mill coordinates.



    //x + y being cowpen

    public void execute(){
        final WebPath milkPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(milkLocation);
        final WebPath eggPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(eggLocation);
        final WebPath wheatPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(wheatLocation);
        final WebPath millPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(millLocation);

        if(milkPath != null){
            milkPath.step();
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