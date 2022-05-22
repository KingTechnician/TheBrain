package dataStructures;

public class OutputLayer 
{
	double[] values;
	public OutputLayer(int outputSize)
	{
		this.values = new double[outputSize];
	}
	public double[] getValues()
	{
		return this.values;
	}
	public void setValues(double[] theseValues)
	{
		for (int i = 0; i<theseValues.length;i++)
		{
			theseValues[i] = sigmoid(theseValues[i]);
		}
		this.values = theseValues;
	}
	public double sigmoid(double number)
	{
		double sigmoid = 1/(1+Math.exp(-1*number));
		return sigmoid;
	}
	public String toString()
	{
		String output = "";
		output+="Output Layer\n--------\n";
		output+="Output Size: "+this.values.length;
		return output;
	}
}
