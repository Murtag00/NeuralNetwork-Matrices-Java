import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/*
 * Garbarge made exclusivly by me ... Justin Horn :D
 * Email:
*  ju-horn@web.de
*  Web:
*  https://justinhorn.name/
*  this version on GitHub:
*  https://github.com/Murtag00/Matrices_with_simple_Neuralnet
 */

/**
 * <h1> With the help of the book: 978-3960090434 ISBN-13</h1>	
 * @author Justin Horn <br><br>
 * 

*
 * 
 * 
 * NeuronalNetwork that uses {@link Matrix} and {@link Vector} for matrix calculations.<br>
 *	By now it can only learn by Backpropagation of error.<br>
 *	Neuron activation is stored in {@link Vector Vectors}.<br>
 *	Weighted connections between the layers are stored in {@link Matrix}. <br>
 */
public class NeuralNetwork {

	private Matrix[] weights;
	private int[] layers;
	static int count = 0; // I guess we can automize that
	private int id;
	/**
	 * Initializes the net.
	 * Connects very neuron of layer 0 to layer 1...
	 * @param layers int[]
	 */
	public NeuralNetwork(int[] layers) {
		this.layers = layers;
		id = count++;
		weights = new Matrix[layers.length-1];
		for(int i = 0; i < weights.length;i++) {
			int vorderSchicht = layers[i];
			int hinterSchicht = layers[i+1];
			weights[i] = new Matrix(hinterSchicht,vorderSchicht); //richtig so
			weights[i].randomInit(1/Math.sqrt(layers[i]),-1/Math.sqrt(layers[i])/2);
		}
		
	}
	
	/**
	 * 
	 * @return id of net
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Initializes the net by loading it form the file path.<br>
	 * Uses: {@link #readFromFile(String)}
	 * @param path to file+ file name.tag
	 */
	public NeuralNetwork(String path) {
		try {
			id = count++;
			readFromFile(path);
		} catch (Exception e) {
			count--;
			System.out.println("Error: "+path);
			e.printStackTrace();
			throw new IllegalArgumentException("File does not exist or is not readable");
		}
	}
	
	/**
	 * Trains the net by backpropagation of error.
	 * @param inputs {@link Vector} - what shall be calculated
	 * @param target {@link Vector} - what should have been the result
	 * @param learningRate double  - rate at which weights are getting adjusted
	 * @see #calc(Vector) uses calc(Vector)
	 */
	public void train(Vector inputs, Vector target,double learningRate) {
		 Vector[] outputs = calc(inputs.clone());
		 
		 Vector outputError = (Vector) MatrixUtils.sub(target, outputs[outputs.length-1]); 
		 Vector[] errors = new Vector[outputs.length]; 
		 errors[0] = outputError;
		 int invs = weights.length-1;
		 for(int i = 0;  i< weights.length;i++) {
			 errors[i+1] = (Vector) MatrixUtils.mult(MatrixUtils.transpose(weights[invs]), errors[i]);
			 invs--;
		 }
		 
		 invs = errors.length-1;
		 for(int i = 0; i < errors.length-1;i++) { // last error does not matter because it is input layer
			 Vector other =  (Vector) outputs[invs].clone(); // 1-O
			 other.subAll(1);
			 other.multAll(-1);
			 Matrix change = MatrixUtils.mult(errors[i]
					 .multiVector(outputs[invs])
					 .multiVector(other),
							 MatrixUtils.transpose(outputs[invs-1]));
			 change.multAll(learningRate);
			 
			 weights[invs-1] = MatrixUtils.add(weights[invs-1],change);
			 invs--;
		 }
		 
		 
		 
	}
	
	/**
	 * Calculates all activations and returns them.
	 * 
	 * @param inputs {@link Vector}
	 * @return {@link Vector}[] of calculated activations
	 */
	public Vector[] calc(Vector inputs) {
		if(inputs.getRowCount() != layers[0]) {
			System.out.println("NN"+id+": Vector has to much or to few Values for input neurons."); 	
			System.out.println("NN"+id+": Vector rows: "+ inputs.getRowCount()+" input rows: "+ layers[0]); 			
			throw new IllegalArgumentException("NN"+id+":");
		}
		Vector[] v = new Vector[weights.length+1];
		v[0] = inputs;
		for(int i = 0;  i< weights.length;i++) {
			v[i+1] = (Vector) MatrixUtils.mult(weights[i], v[i]);
			v[i+1].sigmoid();
		}
		return v;
	}
	
	/**
	 * Calculates the activation, but only returns the output
	 * @param inputs
	 * @return last activation as vector
	 * @see #calc(Vector) calc(Vector) returns all activations
	 */
	public Vector calcLast(Vector inputs) {
		Vector[] v = new Vector[weights.length+1];
		v[0] = inputs;
		for(int i = 0;  i< weights.length;i++) {
			v[i+1] = (Vector) MatrixUtils.mult(weights[i], v[i]);
			v[i+1].sigmoid();
		}
		return v[weights.length];
	}
	
	/**
	 * displays the net for console debugging. Good luck with that
	 */
	public void displayNet() {
		for(int i = 0; i < layers.length-1;i++) {
			System.out.println("[ "+ layers[i]+" ]");
			System.out.println(weights[i]);
		}
		System.out.println("[ "+ layers[layers.length-1]+" ]");
	}
	
	/**
	 * Codes the neural net to a String.<br>
	 * Coding: L:LayerNumber-NeuronNumberLayer2-...-...M:weightsBetweenLayer1AndLayer2--....
	 * <h1> uses: {@link Matrix#toFile()}</h1>
	 * @return NeuralNet in discriped coding
	 */
	public String toFile() {
		StringBuilder a = new StringBuilder();
		a.append("L:"+layers.length+"-");
		for(int i = 0; i <layers.length;i++) {
			if(i < layers.length-1) {
				a.append(layers[i]+"-");
			} else {
				a.append(layers[i]);
			}
		}
		a.append("M:");
		for(int i = 0; i <weights.length;i++) {
			if(i < weights.length-1) { // damit man es leichter splitten kann
				a.append(weights[i].toFile()+"--");
			} else {
				a.append(weights[i].toFile());
			}
		}
		return a.toString();
	}
	
	/**
	 * Writes the net to a file in path. <br>
	 * Filename: layers.length+"_"+ Arrays.toString(layers)+".txt" <br>
	 * <h1> uses: {@link #toFile()} to code the net</h1>
	 * @param path were the file shall be placed 
	 */
	public void writeToFile(String path) {
		String name = layers.length+"_"+ Arrays.toString(layers)+".txt";
		File f = new File(path+name);
		try {
			if(!(f.exists())) {
				f.createNewFile();
			}
			FileWriter out = new FileWriter(f);
			out.write(toFile());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads net previously coded by {@link #toFile()}. <br>
	 * Initializes net. <br>
	 * <h1> used by {@link #NeuralNetwork(String)} </h1>
	 * @param pathName = path+name to file
	 * @throws Exception in case of pathName does not exist or reading problems.
	 */
	public void readFromFile(String pathName) throws Exception {
		File f = new File(pathName);
		if(!(f.exists())) {
			throw new IllegalArgumentException("NN"+id+": Datei: "+pathName+" existiert nicht");
		} else {
			BufferedReader in = new BufferedReader(new FileReader(f));
			StringBuilder a = new StringBuilder();
			a.append(in.readLine());
			in.close();
			
			String l = a.substring(0,a.indexOf("M:"));
			int index = l.indexOf("L:")+2;
			int layersLength = Integer.parseInt(l.substring(index,l.indexOf("-",index)));
			this.layers = new int[layersLength];
			index = l.indexOf("-",index)+1;
			String[] lengths = l.substring(index).split("-");
			
			for(int i = 0; i < layersLength;i++) {
				layers[i] = Integer.parseInt(lengths[i]);
			}
		
			a.delete(0, a.indexOf("M:")+2);
			String[] gewichtMatrizen = a.toString().split("--");
			int len1 = gewichtMatrizen.length;
			weights = new Matrix[len1];
			for(int i = 0; i < len1;i++ ) {
				String[] gew = gewichtMatrizen[i].split("\\s");
				int len2 = gew.length;
				double[] values = new double[len2];
				for(int j = 0; j < len2;j++ ) {
					values[j] = Double.parseDouble(gew[j]);
				}
				Matrix m = new Matrix(layers[i+1],layers[i]);
				m.init(values);
				weights[i] = m;
			}
			
		}		
	}
	
}
