public class PDA {
    public String currentState;
    public String nextState;
    public String currentTerminal;
    public String stackTop;
    public String stackPush;

    public PDA(String currentState, String nextState, String currentCharacter, String stackTop, String stackPush) {
        this.currentState = currentState;
        this.nextState = nextState;
        this.currentTerminal = currentCharacter;
        this.stackTop = stackTop;
        this.stackPush = stackPush;
    }
    public String getFunction(){
        String statement;
        statement = "δ(" + this.currentState + "," + this.currentTerminal + "," + this.stackTop + ") = {(" + this.nextState + "," + this.stackPush + ")}";
        return statement;
    }
}
