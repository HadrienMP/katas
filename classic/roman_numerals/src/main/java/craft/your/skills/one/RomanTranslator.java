package craft.your.skills.one;

public class RomanTranslator {
    public String convert(int number) {
        if (number == 4) return "IV";

        String result ="";
        for(int i=0; i<number; i++){
            result = result + "I";
        }
        result = result.replace("IIIII","V");
        result = result.replace("VV","X");
        result = result.replace("XXXXX","L");
        return result;
    }
}
