package dataStructures;
import java.util.ArrayList;
import java.util.Arrays;
public class Network 
{
	InputLayer input;
	HiddenLayer[] hiddens;
	OutputLayer output;
	public Network(int[] structure)
	{
		int inputLayer = structure[0];
		structure[0] = 0;
		int outputLayer = structure[structure.length-1];
		structure[structure.length-1] = 0;
		int[] hiddenLayers = getHiddenLayers(structure);
		input = new InputLayer(inputLayer,hiddenLayers[0]);
		hiddens = new HiddenLayer[hiddenLayers.length];
		if(hiddenLayers.length==1)
		{
			hiddens[0] = new HiddenLayer(hiddenLayers[0],outputLayer);
		}
		else
		{
			for (int i = 0; i<hiddens.length;i++)
			{
				if(i==hiddens.length-1)
				{
					hiddens[i] = new HiddenLayer(hiddenLayers[i],outputLayer);
				}
				else
				{
					hiddens[i] = new HiddenLayer(hiddenLayers[i],hiddenLayers[i+1]);
				}
			}
		}
		output = new OutputLayer(outputLayer);
	}
	public Network(int[] structure,double[] weights)
	{
		
	}
	public int[] getHiddenLayers(int[] structure)
	{
		int arrayCount = 0;
		for (int i = 0; i<structure.length;i++)
		{
			if(structure[i]!=0)
			{
				arrayCount++;
			}
		}
		int[] newArray = new int[arrayCount];
		arrayCount = 0;
		for (int i = 0; i<structure.length;i++)
		{
			if(structure[i]!=0)
			{
				newArray[arrayCount] = structure[i];
				arrayCount++;
			}
		}
		return newArray;
	}
	public String toString()
	{
		String output = "";
		output+=input;
		for (int i = 0; i<this.hiddens.length;i++)
		{
			output+=this.hiddens[i];
		}
		output+=this.output;
		return output;
	}
	public double[] getWeights()
	{
		double[] inputWeights = input.getWeights();
		ArrayList<Double> weights = new ArrayList<Double>();
		for (int i = 0; i<inputWeights.length; i++)
		{
			weights.add(inputWeights[i]);
		}
		for (int i =0 ; i<hiddens.length;i++)
		{
			double[] newLayer = hiddens[i].getWeights();
			for (int j = 0; j<newLayer.length;j++)
			{
				weights.add(newLayer[i]);
			}
		}
		Object[] getWeights = weights.toArray();
		double[] realWeights = new double[getWeights.length];
		for (int i =0 ; i<realWeights.length;i++)
		{
			realWeights[i] = Double.parseDouble(getWeights[i].toString());
		}
		return realWeights;
		
	}
	public double[] procedure(double[] inputs)
	{
		double[] activations = new double[1];
		activations[0] = 0.0;
		if (inputs.length!=input.values.length)
		{
			System.out.println("Shape mismatch");
			return activations;
		}
		activations = inputs;
		input.setValues(inputs);
		activations = input.feedForward();
		hiddens[0].setValues(activations);
		if(hiddens.length==1)
		{
			activations = hiddens[0].feedForward();
		}
		else
		{
			for (int i = 0; i<hiddens.length;i++)
			{
				hiddens[i].setValues(activations);
				activations = hiddens[i].feedForward();
			}
		}
		this.output.setValues(activations);
		return activations;
	}
	public double cost(double[]observedValues, double[] predictedValues)
	{
		double cost = 0.0;
		for (int i  =0; i<observedValues.length;i++)
		{
			cost+=Math.pow(observedValues[i]-predictedValues[i], 2);
		}
		cost/=observedValues.length;
		return cost;
	}
	public static void main(String[] args)
	{
		int[] layers = {2,3,3,1};
		Network network = new Network(layers);
		System.out.println(network);
		double[] inputs = {1.0,2.0};
		double[] activations = network.procedure(inputs);
		System.out.println(activations[0]);
		
	}
}
