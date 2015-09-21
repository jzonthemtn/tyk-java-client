# Tyk Java Client

This is a Java client for the [Tyk API Gateway](https://tyk.io/) available on [GitHub](https://github.com/lonelycode/tyk). This project fully implements the Tyk [v1.8](https://tyk.io/v1.8/rest-api/overview/) REST API. This client has not been fully tested and is still in development so please report any issues or problems. The goal of this project is to provide a client for Tyk to provide integration between Tyk and Java applications.

The REST API client is provided by [Retrofit](https://github.com/square/retrofit).

[![Build Status](https://travis-ci.org/jzonthemtn/tyk-java-client.png?branch=1.0)](https://travis-ci.org/jzonthemtn/tyk-java-cient)

## Usage

All requests follow the general pattern show below:

    TykClient client = new TykClient("http://endpoint", "tyk-authorization-key");

    // Create a request.
    CreateKeyRequest request = new CreateKeyRequest();

    // Send a request and get a response.
    CreateKeyResponse response = client.createApiKey(request);

    // Get what you need from the response.
    String newApiKey = response.getKey();

The `TykClient` has a separate constructor that takes a read timeout and connection timeout in seconds if the default 60 second timeout is unacceptable.

## Integration Tests

There is a `TykClientIT` class that will execute against a Tyk installation. Prior to running the tests in this class provide your Tyk installation URL, authorization key, and a valid API ID in the variables in this class.

## Contributing

Contributions in all areas (development, testing, documentation) are very much welcomed. Please fork and submit pull requests.

## License

This project is licensed under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0).

## About

This project is maintained by [Mountain Fog](http://www.mtnfog.com) and we can be contacted via email at [support@mtnfog.com](support@mtnfog.com).
