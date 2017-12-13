package eu4;

/**
 * Created by Linus on 2017-12-10.
 */
public class Polylinje1 {
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje1 ()
    {
        this.horn = new Punkt[0];
    }

    public Polylinje1 (Punkt[] horn)
    {
        this.horn = horn;
    }

    public String toString () {
        String hornStr = "";

        for (Punkt punkt : this.horn) {
            hornStr += "(" + punkt + ") ";
        }

        return "{[" + hornStr + "], " + this.farg + ", " + this.bredd + "}";
    }

    public Punkt[] getHorn () {
        return this.horn;
    }

    public String getFarg () {
        return this.farg;
    }

    public int getBredd () {
        return this.bredd;
    }

    public void setFarg (String farg) {
        this.farg = farg;
    }

    public void setBredd (int bredd) {
        this.bredd = bredd;
    }

    public double langd () {
        double l = 0;

        for (int i = 0; i < this.horn.length - 1; i++){
            l += Math.sqrt(Math.pow((this.horn[i + 1].getX() - this.horn[i].getX()), 2) + Math.pow(this.horn[i + 1].getY() - this.horn[i].getY(), 2));
        }

        return l;
    }

    public void laggTill (Punkt horn)
    {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = horn;
        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length + 1];

        int i = 0;
        boolean check = false;
        for (int j = 0; j < this.horn.length + 1; j++) {
            if(!check && this.horn[i].getNamn().equals(hornNamn)){
                h[j] = horn;
                i--;
                check = true;
            }
            else{
                h[j] = this.horn[i];
            }
            i++;
        }

        this.horn = h;
    }

    public void taBort (String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length - 1];
        int i = 0;
        for (int j = 0; j < this.horn.length; j++){
            if(this.horn[j].getNamn().equals(hornNamn)){
                i--;
            } else{
                h[i] = this.horn[j];
            }
            i++;
        }
        this.horn = h;
    }
}
