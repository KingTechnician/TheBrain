# TheBrain
A general purpose artificial neural network meant to both educate on the use of neural networks and to implement with a range of (preferably) numbers.

As a rising sophomore in Computer Science, I noticed that a lot of neural network frameworks in Java are somewhat confusing and can be frustrating for an early student if they don't know how to grasp certain concepts (back propagation, calculations of weights with neurons, etc.). As a result, I wanted to make a concise object that serves as a neural network. 

In order to do this, I created a initial class Layer. This holds the majority of the methods, which I will explain in detail below.

# Layer Object
The Layer object has these properties:
  -A double array that holds the values of the data
  -An integer that denotes the next layer
  -A double array that holds the weights between the instance called and the next layer
  -A double array that will hold the activations upon calculation.
 
There are two constructors.

  -One takes the size of the input (for that layer), and the desired size of the first hidden layer, and sets the values and next layer size respectively. It will create randomized weights, the size of which is determined by multiplying the input size by the next layer size.
  
    Example: A layer with 2 doubles for input, and the next layer is known to have a size of 5, there will be 10 randomized weights.
    
  -The second constructor assume the person implementing this has weights of their own that they would like to use. It will set those weights, along with the same next layer size to determine the size of the output.

There is also a method that will handle the majority of the calculations for the neural network.

The feedforward method will go through the process of creating the output:

  -Setting an array equal to the size of the next layer.
  
  -Each element in this array will be the sum of the product of all the values given in the input by all of their corresponding weights. This method will work given that the setValues method has been used to specify the input.
  
  -Finally, each of the calculated numbers in the array will be put through an activation function. In this particular case, for the purpose of simplicity, I have chosen the sigmoid function.
  ![image](https://user-images.githubusercontent.com/104329626/169711939-798b64a0-4973-4aef-8d03-348178bacf3c.png)
  
# InputLayer and HiddenLayer

The InputLayer and HiddenLayer objects can be talked about at the same time because they operate much the same.

They both inherit the constructors from the Layer object.

Their unique aspects are that they have a method that returns the weights between its own layer and the next, and a toString that will give a description of its layer, weight, and next layer size. 

# OutputLayer
The OutputLayer object is unique in that it does not require any calculations, so it mainly serves to hold output. As such, it does not need to inherit anything from the Layer class.

The OutputLayer object has a constructor for setting the size of the output layer, along with setting the values if and only if the pre-established size matches the values being set. It also applies the sigmoid function one more time, and has a toString method.

# Next steps?

I have yet to create a cost function, back propagation or train method, which will be my next steps. I also would like a cohesive way of saving trained weights. 
