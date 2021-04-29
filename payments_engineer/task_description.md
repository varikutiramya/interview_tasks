
You need to create a payments gateway that processes and persists C2C energy trades. The gateway needs to be able to handle exchange of funds from the accounts of one customer to another, persist them to a database, and trigger the exchange of funds to an API stub that will mimic a bank/payment system. The gateway should support authentication in order to be able to distinguish individual users (ideally some form of token based authentication like JWT)

The API should consist of the following methods:
- POST /api/execute-payment
    - Should execute a payment for the logged-in customer. The parameters of the POST request should include the energy (in Kwh, float), the payment amount (in Euro, float), the seller name (string value, not needed to correspond to another user in the DB) and the payment token (hash value, more info below)
- GET /api/payments
    - Returns all payment info for the logged in customer for all past payments
- /api/payments/{payment-id}
    - Return information for a specific payment

You can use any Python framework you like for the REST API (Flask, DRF, Bottle), and the request/response content type should be JSON for all requests. 
The past payment information should be persisted in a database in order to be able to be queried from the GET API methods. 

In addition to the normal API the payment needs to be reported asynchronously as an event. In order to achieve that, a websocket needs to be created in order to send the trade/payment. Any websocket library (e.g. websockets/Django Channels) is acceptable. The websocket should report the same payment JSON object that the REST API reports. 
 
Each payment/trade should be associated with a payment token (which mimics a card or paypal token) that will uniquely identify the payment means of the buyer. 

Finally, a Dockerfile has to be created that would install all the dependencies automatically and serve the API once the container is started. 

In order to submit your solution to this task a fork of this repo has to be created, and the solution can be committed to the fork. 
