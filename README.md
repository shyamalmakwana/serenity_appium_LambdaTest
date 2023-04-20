# appium-serenity-lt

[Serenity](http://www.thucydides.info/docs/serenity/) Integration with LambdaTest for Appium.

Master branch contains **Selenium 3** samples, for **Selenium 4 - W3C protocol** please checkout [selenium-4](https://github.com/lt/serenity-lt/tree/selenium-4) branch

## Setup

- Clone the repo
- Install dependencies `mvn install`

## Running your tests

- To run a single test, run `mvn verify -P single`
- To run parallel tests, run `mvn verify -P parallel`

## Notes


  ```sh
  export LT_USERNAME=<lt-username> &&
  export LT_ACCESS_KEY=<lt-access-key> &&
  export APP_ID=<app_url or custom_id>
  ```
