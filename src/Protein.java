/**
 * Protein.java
 * 
 * Class representation of a protein using the lattice model.
 * Read more at: http://math.mit.edu/classes/18.417/Slides/HP-protein-prediction.pdf
 * 
 * @author Cory
 *
 */
public class Protein {
	
	// Amino acid sequence
	private String sequence;
	
	// Direction trajectory
	private int[] dirTraj;
	
	/**
	 * Constructor
	 * @param s Desired amino acid sequence
	 * @param d Starting direction trajectory
	 */
	public Protein(String s, int[] d) {
		AminoIndex.defineWeightMap();
		
		sequence = s;
		dirTraj = d;
	}
	
	/**
	 * Deep-copy constructor
	 * @param p Protein object whose parameters will be copied
	 */
	public Protein(Protein p) {
		AminoIndex.defineWeightMap();
		
		sequence = p.getSequence();
		dirTraj = this.copyArray(p.getDirTraj());
	}
	
	/**
	 * Mutators and accessors
	 */
	public String getSequence() {
		return sequence;
	}
	
	public int[] getDirTraj() {
		return dirTraj;
	}
	
	/*****************
	 * Methods
	 *****************/
	public int[] copyArray(int[] a) {
		int[] copy = new int[a.length];
		
		for(int i = 0; i < a.length; i++) {
			copy[i] = a[i];
		}
		
		return copy;
	}
}
