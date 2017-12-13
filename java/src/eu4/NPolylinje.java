package eu4;

import java.util.Iterator;

/**
 * Created by Linus on 2017-12-13.
 */
public class NPolylinje implements Polylinje {

    private static class Nod
    {
        public Punkt horn;
        public Nod nastaNod;
        public Nod (Punkt horn)
        {
            this.horn = horn;
            nastaNod = null;
        }
    }
    private Nod horn;
    private String farg = "svart";
    private int bredd = 1; // pixlar
    public NPolylinje ()
    {
        this.horn = null;
    }
    public NPolylinje (Punkt[] horn)
    {
        if (horn.length > 0)
        {
            Nod nod = new Nod (new Punkt (horn[0]));
            this.horn = nod;
            int pos = 1;
            while (pos < horn.length)
            {
                nod.nastaNod = new Nod (new Punkt (horn[pos++]));
                nod = nod.nastaNod;
            }
        }
    }

    public int hornLangd(){
        int l = 0;

        Nod current = this.horn;
        while (current.nastaNod != null){
            l++;
            current = current.nastaNod;
        }

        return l;
    }


    @Override
    public Punkt[] getHorn() {
        Punkt[] h = new Punkt[this.hornLangd()];

        int pos = 0;
        Nod current = this.horn;
        while (current.nastaNod != null)
        {
            h[pos++] = current.horn;
            current = current.nastaNod;
        }

        return h;
    }

    @Override
    public String getFarg() {
        return this.farg;
    }

    @Override
    public int getBredd() {
        return 0;
    }

    @Override
    public double langd() {
        double l = 0;
        Nod current = this.horn;
        while (current.nastaNod != null){
            l += current.horn.avstand(current.nastaNod.horn);
            current = current.nastaNod;
        }

        return l;
    }

    @Override
    public void setFarg(String farg) {
        this.farg = farg;
    }

    @Override
    public void setBredd(int bredd) {

    }

    @Override
    public void laggTill(Punkt horn) {
        Nod current = this.horn;
        Nod n = new Nod(horn);

        if(current == null){
            this.horn = n;
        }else{
            while (current.nastaNod != null){
                current = current.nastaNod;
            }

            if(current != null){
                current.nastaNod = n;
            }
        }
    }

    @Override
    public void laggTillFramfor(Punkt horn, String hornNamn) {

    }

    @Override
    public void taBort(String hornNamn) {

    }

    @Override
    public String toString() {
        String hornStr = "";

        Nod current = this.horn;
        while(current != null){
            hornStr += "(" + current.horn + ") ";
            current = current.nastaNod;
        }

        return "{[" + hornStr + "], " + this.farg + ", " + this.bredd + "}";
    }

    @Override
    public Iterator<Punkt> iterator() {
        return new Iterator<Punkt>() {
            private int i = -1;
            private Nod current = null;

            @Override
            public boolean hasNext() {
                return i < NPolylinje.this.hornLangd() - 1;
            }

            private void forward(){

                if (this.current == null){
                    this.current = NPolylinje.this.horn;
                }
                else if(this.hasNext()){
                    this.current = this.current.nastaNod;
                    i++;
                } else{
                    this.current = null;
                    i = -1;
                }
            }

            @Override
            public Punkt next() {
                forward();
                return current.horn;
            }
        };
    }

}
