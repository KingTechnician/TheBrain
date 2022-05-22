package dataStructures;

public class Layer 
{
	double[] values;
	int nextLayer;
	double[] weights;
	double[] nextLayers;
	public Layer(int inputSize,int nextLayer)
	{
		this.values = new double[inputSize];
		this.nextLayer = nextLayer;
		this.weights = new double[inputSize*nextLayer];
		this.weights = getRandomizedWeights(this.weights, inputSize*nextLayer);
	}
	public Layer(double[] weights, int nextLayer)
	{
		this.weights = weights;
		this.nextLayer = nextLayer;
	}
	public void setWeights(double[] theseWeights)
	{
		this.weights = theseWeights;
	}
	public double[] getRandomizedWeights(double[] weights, int weightSize)
	{
		double[] randomWeights = new double[weightSize];
		for (int i = 0; i<randomWeights.length;i++)
		{
			randomWeights[i] = Math.random();
		}
		return randomWeights;
	}
	public void setValues(double[] newValues)
	{
		if(newValues.length!=this.values.length)
		{
			System.out.println("Inner layer shape mismatch");
			return;
		}
		this.values = newValues;
	}
	public double sigmoid(double number)
	{
		double sigmoid = 1/(1+Math.exp(-1*number));
		return sigmoid;
	}
	public double[] feedForward()
	{
		double[] nextLayers = new double[this.nextLayer];
		for (int i = 0; i<this.nextLayer;i++)
		{
			nextLayers[i]=0.0;
		}
		double[] getWeights = this.weights;
		double[] getValues = this.values;
		int nextNeuron = nextLayers.length;
		int currentWeight=  0;
		for (int i = 0; i<nextLayers.length;i++)
		{
			for (int j =0; j<getValues.length;j++)
			{
				for (int k = 0; k<nextNeuron;k++)
				{
					if(currentWeight<getWeights.length) 
					{
						nextLayers[i]+=getWeights[currentWeight]*getValues[j];
						currentWeight++;
					}
				}
			}
		}
		for (int i = 0; i<nextLayers.length;i++)
		{
			nextLayers[i] = sigmoid(nextLayers[i]);
		}
		System.out.println("Feed forward complete for layer!");
		return nextLayers;
	}
	
}
