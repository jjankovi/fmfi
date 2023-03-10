### Spustenie Quarkus aplikacie v DEV mode ##
```shell script
mvn compile quarkus:dev
```

### Pridanie rozsirenia "XY" do Quarkus aplikacie
```shell script
mvn quarkus:add-extension -Dextensions="XY"
```

### Pridanie InMemory H2 do aplikacnej konfiguracie
```shell script
quarkus.datasource.db-kind=h2
quarkus.datasource.jdbc.url=jdbc:h2:mem:test
quarkus.hibernate-orm.database.generation=drop-and-create
```

### Pridanie OpenApi konfiguracie
```shell script
quarkus.smallrye-openapi.info-title
quarkus.smallrye-openapi.info-description
quarkus.smallrye-openapi.info-version
```

### Pridanie Basic embedded security konfiguracie
```shell script
quarkus.security.users.embedded.enabled
quarkus.security.users.embedded.plain-text
quarkus.security.users.embedded.users.XY
quarkus.security.users.embedded.roles.XY
```
