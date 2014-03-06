Baristamatic Problem Solution for Trustwave
Author: Sidharth Sitaram Jhawar	
		MS-CS,Indiana University Bloomington
		
Packages: com.baristamatic.model
		  ->com.baristamatic.model.Ingredient : This class basically defines the model or a template for an Ingredient.
												The fields and method best describes an Ingredient and the choice of the
												fields was made out of the requirements.
		  ->com.baristamatic.model.Drink	  : This is another model or a template class which defines a Drink.
												Each drink has a list of ingredients.The fields are self explanatory.
		: com.baristamatic.app
		  ->com.baristamatic.app.CoffeeMachineSimulator: This class is the brain of the application, it will cater to the
														 request made by the user.The constructor of this class loads the 
														 ingredient inventory and the drinks menu. 
														 Method coffeeMachineDispenser gets the choice entered by the user
														 from the main class and according to the user choice , particular
														 switch case is executed. The default choice which caters to all the
														 invalid options.
														 Method dispenseDrink checks the ingredient inventory and dispenses 
														 the drink according to the availability of the ingredients used to 
														 prepare that particular drink.4
		: com.baristamatic.main
		  ->com.baristamatic.main.BaristamaticMain     : This class is basically the main class of the application. This class
														 reads the input from the command line and according to the input 
														 calls the method of the CoffeeMachineSimulator class.
														 
Note: The main strategy in completion of this application was to keep the code readable, modular and simple. The use of model
	  classes separated the modelling aspect of the application from the business logic. No design patterns are used as the 
	  application requirements were fairly simple and straight forward. The code is modular as in new ingredients or drinks 
	  can be added without much of the hassle. The class names and the method names are self explanatory.
		  