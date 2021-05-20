
You need to create a service that interacts with a blockchain using smart contracts. The service will be responsible for storing energy trades to the blockchain, and also read the energy trades from the blockchain as well. 

A Python CLI script needs to be created that handles the following operations:

1. save a trade object to the blockchain. A trade object should consist of the following parameters: energy (float, in kWh), price (float, in cents), seller address (address of the seller on chain), buyer address (address of the buyer on chain). All trade object parameters have to be input arguments to the CLI script. The response of the smart contract should be a unique identifier of the saved trade.
2. read the trade that you just persisted to the blockchain. The only parameter should be the unique identifier of the trade (returned by operation #1).

For the blockchain part, you should use the Substrate framework for creating a private blockchain, running locally with only one node. A smart contract should be written in Ink in order to handle the operations of read/write of the trade objects to the blockchain. 

Finally, Docker/Docker Compose has to be used in order to install all the dependencies automatically. 

In order to submit your solution to this task a fork of this repo has to be created, and the solution can be committed to the fork. 
