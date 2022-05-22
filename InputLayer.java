package dataStructures;

public class InputLayer extends Layer
{
	public InputLayer(int inputSize, int nextLayer)
	{
		super(inputSize,nextLayer);
	}
	public InputLayer(double[] weights, int nextLayer)
	{
		super(weights,nextLayer);
	}
	public String toString()
	{
		String output  = "";
		output+="Input Layer\n---------\n";
		output+="Layer Size: "+this.values.length+"\n";
		output+="Weight Size: "+this.weights.length;
		output+="\nNext Layer Size: "+this.nextLayer;
		output+="\n---------\n";
		return output;
	}
	public double[] getWeights()
	{
		return this.weights;
	}
}

