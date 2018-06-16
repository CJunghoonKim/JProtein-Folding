import java.util.HashMap;
import java.util.Map;

public class AminoIndex {
	/**
	 * Amino acid abbreviations
	 */
	public static char[] acidIndex = {'C', 'M', 'F', 'I', 'L', 'V', 'W', 'Y', 'A', 'G',
									  'T', 'S', 'N', 'Q', 'D', 'E', 'H', 'R', 'K', 'P'};
	
	/**
	 * Acid-Weight Map
	 */
	public static Map<Character, Double> weightMap = new HashMap<Character, Double>();
	
	public static void defineWeightMap() {
		weightMap.put('A', 89.094);
		weightMap.put('R', 174.203);
		weightMap.put('N', 132.119);
		weightMap.put('D', 133.104);
		weightMap.put('C', 121.154);
		weightMap.put('E', 147.131);
		weightMap.put('Q', 146.146);
		weightMap.put('G', 75.067);
		weightMap.put('H', 155.156);
		weightMap.put('I', 131.175);
		weightMap.put('L', 131.175);
		weightMap.put('K', 146.189);
		weightMap.put('M', 149.208);
		weightMap.put('F', 165.192);
		weightMap.put('P', 115.132);
		weightMap.put('S', 105.093);
		weightMap.put('T', 119.119);
		weightMap.put('W', 204.228);
		weightMap.put('Y', 181.191);
		weightMap.put('V', 117.148);
	}
}
