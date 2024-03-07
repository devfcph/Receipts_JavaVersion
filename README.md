# Receipt Controller

This Java class represents a RESTful API controller for managing receipts. It utilizes the Spring Framework's annotations for configuration and REST endpoints. Below is an overview of the controller's functionality and endpoints.

## Endpoints

### Health Check

- **Endpoint:** `/health`
- **Method:** `GET`
- **Description:** Performs a health check to ensure that the API is available.
- **Response:**
  - Status Code: 200 (OK)
  - Body: "Hey! I'm available :)"

### Get All Receipts

- **Endpoint:** `/getAll`
- **Method:** `GET`
- **Description:** Retrieves a list of all receipts.
- **Response:**
  - Status Code: 200 (OK)
  - Body: List of receipts
  - Status Code: 400 (Bad Request)
  - Body: "Bad request: [Error Message]" (in case of an exception during processing)

### Get Receipt by ID

- **Endpoint:** `/getById/{id}`
- **Method:** `GET`
- **Description:** Retrieves a specific receipt by its ID.
- **Request Parameter:**
  - `{id}`: The unique identifier of the receipt.
- **Response:**
  - Status Code: 200 (OK)
  - Body: The requested receipt
  - Status Code: 400 (Bad Request)
  - Body: "Bad request: [Error Message]" (in case of an exception during processing)

### Process Receipt

- **Endpoint:** `/process`
- **Method:** `POST`
- **Description:** Processes a new receipt.
- **Request Body:**
  - JSON representation of a receipt object.
- **Response:**
  - Status Code: 201 (Created)
  - Body: The unique identifier of the created receipt (ReceiptId)
  - Status Code: 400 (Bad Request)
  - Body: "Bad request: [Error Message]" (in case of an exception during processing)

## Dependencies

- **ReceiptService:** Autowired dependency for handling receipt-related business logic.

## Usage

1. Ensure the application is running.
2. Use appropriate HTTP clients (e.g., Postman, cURL) to interact with the defined endpoints.

## Note

- In case of a Bad Request (400), the response body contains an error message indicating the nature of the issue.
