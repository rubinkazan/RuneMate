package RuneMate.Creative_Cooks_Assistant;

public class CooksAssistant {

    private NpcQueryBuilder getCook = Npcs.newQuery().names("Cook");
    private StopWatch runningTime = new StopWatch();
    private Coordinate startPosition;

    /*
    Logic:
        pre-req:
         - Are you logged in?
         - Is your inventory Empty?
     Quest:
        Phase 1:
            - Talk to Chef
            - Accept Quest
            - Take "empty pot"
        Phase 2:
            Milk:
                - Walk to Cow area
                - Interact with gate/check gate
                - Take "bucket"
                - Use "bucket" > "prized dairy cow"
                - Check if "top-quality milk" exists in inventory
            Egg:
                - Walk to Chicken Farm
                - Interact with gate/check gate
                - Take "super large egg"
                - Check if "super large egg" exists in inventory
            Flour:
                -





     */




}
