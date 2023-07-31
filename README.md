# portal-ng end-to-end ui tests
This project contains portal-ng edition end-to-end UI tests.

This project is using Java, Cucumber, Selenide and Allure.

## Run tests
If you want to test a remote instance of the Portal, change the $PORTAL_ENV variable:    
`export PORTAL_ENV=test-remote.properties`

or provide the base url in an environment variable PORTAL_BASE_URL=https://external-host.org

`export PORTAL_BASE_URL=https://external-host.org`

Then adjust the properties file as needed.


By default `test-local.properties` is used.

### In Chrome
To run the tests with Chrome from gradle wrapper:
```
./gradlew cucumber
```
or with
```
./gradlew clean cucumber
```
### In headless mode
There's also a task for running in a headless mode (used in pipelines):
```
./gradlew cucumberCli
```
## Local development

If you want to run a single scenario for debugging while developing any of the tests or creating a new one, you can do so.

First you have to specify a `@debug` tag in any of the `.feature` files adding the `@debug` tag above the line `Scenario:`
and then you can run the task to only run this scenario:

```
./gradlew cucumberLocalDebug
```

You can also add `@debug` to more scenarios to be executed within the project and run the task above again.

This will also work in IntelliJ Idea when you create a gradle configuration, so you can easily run tests that you are currently developing.

Don't forget to add `PORTAL_ENV=test-local.properties` as an environment variable in your IntelliJ configuration.

## Test Reports

To generate allure reports on MAC
you must install allure via **brew** and then:

```
allure generate --clean
```

the report will appear:
`./allure-report/index.html`
