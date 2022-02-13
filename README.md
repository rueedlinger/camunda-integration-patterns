# Camunda Integration Patterns

http://localhost:8080/engine-rest/process-instance

POST http://localhost:8080/engine-rest/process-definition/key/process-rpc/start

```json
{
  "variables": {
    "userId": {
      "value": "102",
      "type": "Long"
    },
    "body": {
      "value": "the body",
      "type": "String"
    },
    "title": {
      "value": "the title",
      "type": "String"
    }
  },
  "businessKey": "myBusinessKey",
  "withVariablesInReturn": true
}
```
