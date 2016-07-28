package RuneMate.Creative_Cooks_Assistant;


import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.queries.NpcQueryBuilder;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.util.StopWatch;

public class CooksAssistant {

    private NpcQueryBuilder getCook = Npcs.newQuery().names("Cook");
    private StopWatch runningTime = new StopWatch();
    private Coordinate startPosition;
    private final static Coordinate milkLocation = new Coordinate(4,5); //TODO: find cow pen coordinates.
    private final static Coordinate eggLocation  = new Coordinate(x,y); //TODO: find egg farm coordinates.
    private final static Coordinate wheatLocation = new Coordinate(x,y); //TODO: find wheat farm coordinates.


    //x + y being cowpen

    public void execute(){
        final WebPath path = Traversal.getDefaultWeb().getPathBuilder().buildTo(milkLocation);
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