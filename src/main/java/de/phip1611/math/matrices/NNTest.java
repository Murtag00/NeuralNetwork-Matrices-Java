package main.java.de.phip1611.math.matrices;


public class NNTest {

	public static void main(String[] args) {
		try {
			NeuralNetwork nn = new NeuralNetwork("E:\\Users\\Murtag\\eclipse-workspace\\TicTacToeAi\\3_[27, 10, 18].txt");
			
			nn.displayNet();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
