
You need to create a service that interacts with a blockchain using smart contracts. The service will be responsible for receiving and storing energy trades to the blockchain, and also read the energy trades from the blockchain as well. A REST API needs to be created that exposes the following endpoints:
1. POST request that is responsible for saving the trade object to the blockchain. The trade object should consist of the following parameters: energy (float, in kWh), price (float, in cents), seller address (address of the seller on chain), buyer address (address of the buyer on chain). The response should return a unique identifier of the saved trade
2. GET request that reads all trades from the blockchain
3. GET request that reads one trade from the blockchain. The only query parameter should be the unique identifier of the trade 

THe REST API should be implemented in Python. You can use any Python framework you like for the REST API (Flask, DRF, Bottle).

For the blockchain part, you should use the Substrate framework for creating a private blockchain, running locally with only one node. A smart contract should be written in Ink in order to handle the operations of read/write of the trade objects to the blockchain. 

Finally, Docker/Docker Compose has to be used in order to install all the dependencies automatically and serve the API once the container is started. 

In order to submit your solution to this task a fork of this repo has to be created, and the solution can be committed to the fork. 
