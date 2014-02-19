class Candidate {
    /* VARIABLES */
    private int enlightenment; // per hour
    private int energy; // per hour
    private int max; //times per day
    private char[] prerequisite;
    private int strength;
    private int charm;
    private int brain;
    
    public Candidate(int enlightenment, int energy, int max, char[] prereq,
			int strength, int charm, int brain){
        this.enlightenment = enlightenment;
        this.energy = energy;
        this.max = max;
        this.prerequisite = prereq;
        this.strength = strength;
        this.charm = charm;
        this.brain = brain;
    }
    
    /* GETTERS & SETTERS */
    public int getEnlightenment() {return enlightenment;}
    public int getEnergy() {return energy;}
    public int getMax() {return max;}
    public int getStrength() {return strength;}
    public int getCharm() {return charm;}
    public int getBrain() {return brain;}

    public void setEnlightenment(int enlightenment) {this.enlightenment = enlightenment;}
    public void setEnergy(int energy) {this.energy = energy;}
    public void setMax(int max) {this.max = max;}
    public void setStrength(int strength) {this.strength = strength;}
    public void setCharm(int charm) {this.charm = charm;}
    public void setBrain(int brain) {this.brain = brain;}
    
    /* METHODS */
    public void print(){
        System.out.println(enlightenment);
        System.out.println(energy);
        System.out.println(max);
        System.out.println(prerequisite);
        System.out.println(strength);
        System.out.println(charm);
        System.out.println(brain);
    }
}
