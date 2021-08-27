public class State {
    public String name;
    public boolean isInitialState;
    public boolean isFinalState;

    public State(String name, boolean isInitialState, boolean isFinalState) {
        this.name = name;
        this.isInitialState = isInitialState;
        this.isFinalState = isFinalState;
    }
}
