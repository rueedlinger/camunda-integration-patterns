# Camunda Integration Patterns

http://localhost:8080/engine-rest/process-instance

POST http://localhost:8080/engine-rest/process-definition/key/process-rpc/start

```json
{
  "variables": {
    "aVariable": {
      "value": "aStringValue",
      "type": "String"
    },
    "anotherVariable": {
      "value": true,
      "type": "Boolean",
      "valueInfo": {
        "transient": true
      }
    }
  },
  "businessKey": "myBusinessKey",
  "withVariablesInReturn": true
}
```
