package javanetserver;

public class KnockKnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;
    
    
    private static final int NUMJOKES = 5;
    
    private int state = WAITING;
    private int currentJoke = 0;
    
    private String[] clues = {"Turnip","Little Old Lady", "Atch", "Who", "Who"};
    private String[] answers = {"Turnip the heat","I didn't know you could yodel!", "Bless you!",
    "Is there an owl in here?", "Is there an echo in there?"};
    
    public String processInput(String theInput){
        String theOutput = null;
        
        switch (state) {
            case WAITING:
                theOutput = "Knock! Knock!";
                state = SENTKNOCKKNOCK;
                break;
            case SENTKNOCKKNOCK:
                if(theInput.equals(theInput.equalsIgnoreCase("Who's there?"))){
                    theOutput = clues[currentJoke];
                    state = SENTCLUE;
                }else{
                    theOutput = "You're supposed to say \"Who's there?\"! " + "Try again. Knock! Knock!";
                }   break;
            case SENTCLUE:
                if(theInput.equalsIgnoreCase(clues[currentJoke] + " who?")){
                    theOutput = answers[currentJoke] + "Qant another? (y/n)";
                    state = ANOTHER;
                }else{
                    theOutput = "You're supposed to say \"" + clues[currentJoke] +
                            " who?\"" + "! Try again. Knock! Knock!";
                    state = SENTKNOCKKNOCK;
                }   break;
            case ANOTHER:
                if(theInput.equalsIgnoreCase("y")){
                    theOutput = "Knock! Knock!";
                    if(currentJoke == (NUMJOKES-1))
                        currentJoke = 0;
                    else
                        currentJoke++;
                    state = SENTKNOCKKNOCK;
                }else{
                    theOutput = "Bye.";
                    state = WAITING;
                }   break;
            default:
                break;
        }
        
        return theOutput;
        
    }
}
