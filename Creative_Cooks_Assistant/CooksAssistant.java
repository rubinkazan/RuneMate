package RuneMate.Creative_Cooks_Assistant;

public class CooksAssistant {

    private NpcQueryBuilder getCook = Npcs.newQuery().names("Cook");
    private StopWatch runningTime = new StopWatch();
    private Coordinate startPosition;




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