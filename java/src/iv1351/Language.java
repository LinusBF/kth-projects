package iv1351;

import java.util.ArrayList;
import java.util.Objects;

public class Language {
    public String name;
    private Boolean changed;

    public Language(String name) {
        this.name = name;
        this.changed = true;
    }

    private Language(String name, Boolean changed){
        this.name = name;
        this.changed = changed;
    }

    private static String[] getMockLangs(){
        return new String[]{"Svenska", "Engelska", "Tyska", "Franska", "Spanska"};
    }

    public static ArrayList<Language> getLangs(){
        ArrayList<Language> langs = new ArrayList<>();

        for (String lang : Language.getMockLangs()) {
            langs.add(new Language(lang, false));
        }

        return langs;
    }

    public void save(){

    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(name, language.name);
    }
}
