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
	
	// Position trajectory
	private int[][] posTraj = null;
	
	/**
	 * Constructor
	 * @param s Desired amino acid sequence
	 * @param d Starting direction trajectory
	 */
	public Protein(String s, int[] d) {
		sequence = s;
		dirTraj = d;
	}
	
	/**
	 * Deep-copy constructor
	 * @param p Protein object whose parameters will be copied
	 */
	public Protein(Protein p) {
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
	
	/**
	 * copyArray
	 * @param target array
	 * @return new independent copy of param array
	 */
	public int[] copyArray(int[] a) {
		int[] copy = new int[a.length];
		
		for(int i = 0; i < a.length; i++) {
			copy[i] = a[i];
		}
		
		return copy;
	}
	
	/**
	 * getPosition
	 * @return array of position vectors for this conformation
	 */
	public int[][] getPosition() {
		// Dynamic approach
		if (posTraj == null) {
			// Contains n = |dirTraj| + 1 position vectors in 3-D space 
			int[][] positions = new int[3][dirTraj.length + 1];
			
			int[] x = new int[dirTraj.length + 1];
			int[] y = new int[dirTraj.length + 1];
			int[] z = new int[dirTraj.length + 1];
			
			/*
			 * A : -y
			 * B : +x
			 * C : +y
			 * D : -x
			 * E : +z
			 * F : -z
			 */
			for (int i = 0; i < dirTraj.length; i++) {
				if (dirTraj[i] == 'A') {
					for (int j = i; j < dirTraj.length; j++) { // -y
						y[j + 1] = y[j + 1] - 1;
					}
				}
				else if (dirTraj[i] == 'B') {
					for (int j = i; j < dirTraj.length; j++) { // +x
						x[j + 1] = x[j + 1] + 1;
					}
				}
				else if (dirTraj[i] == 'C') {
					for (int j = i; j < dirTraj.length; j++) { // +y
						y[j + 1] = y[j + 1] + 1;
					}
				}
				else if (dirTraj[i] == 'D') {
					for (int j = i; j < dirTraj.length; j++) { // -x
						x[j + 1] = x[j + 1] - 1;
					}
				}
				else if (dirTraj[i] == 'E') {
					for (int j = i; j < dirTraj.length; j++) { // +z
						z[j + 1] = z[j + 1] + 1;
					}
				} else {
					for (int j = i; j < dirTraj.length; j++) { // -z
						z[j + 1] = z[j + 1] - 1;
					}
				}
			}
			
			positions[0] = x;
			positions[1] = y;
			positions[2] = z;
			posTraj = positions;
		}
		return posTraj;
	}
}
