package dataStructures;

public class HiddenLayer extends Layer 
{
	public HiddenLayer(int inputSize, int nextLayer)
	{
		super(inputSize,nextLayer);
	}
	public HiddenLayer(double[] weights, int nextLayer)
	{
		super(weights,nextLayer);
	}
	public double[] getWeights()
	{
		return this.weights;
	}
	public String toString()
	{
		String output  = "";
		output+="Hidden Layer\n---------\n";
		output+="Layer Size: "+this.values.length+"\n";
		output+="\nWeight Size: "+this.weights.length;
		output+="\nNext Layer Size: "+this.nextLayer;
		output+="\n---------\n";
		return output;
	}
}
