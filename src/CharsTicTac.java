public enum CharsTicTac {
    X('X'),
    O('O'),
    Empty('.');

    private char sim;
    CharsTicTac(char sim){
        this.sim = sim;
    }
    public char getSim(){ return sim;}
}
