# Setting up databases

### Set up Cassandra in Docker

**Docker Setup**

If you prefer to run Cassandra locally in a containerized environment, run the following docker run command:

`docker run -p 9042:9042 --rm --name CONTAINER_NAME -d cassandra:4.0.7`

After the container is created, access the Cassandra query language shell:

`docker exec -it CONTAINER_NAME bash -c "cqlsh -u cassandra -p cassandra"`

And create a keyspace for the application:

`CREATE KEYSPACE DATABASE_NAME WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};`

Now that you have your database running, configure Spring Data Cassandra to access your database.

Add the following properties in your 
**application.properties** (src/main/resources/application.properties) to connect to your local database:

```
spring.cassandra.schema-action=CREATE_IF_NOT_EXISTS
spring.cassandra.request.timeout=10s
spring.cassandra.connection.connect-timeout=10s
spring.cassandra.connection.init-query-timeout=10s

spring.cassandra.local-datacenter=datacenter1
spring.cassandra.keyspace-name=DATABASE_NAME
```

Then use `CassandraRepository<Type, ID>` to access Cassandra database.

**CQL**
```
describe keyspaces;
use keyspace_name;
describe tables;
select * from table_name;
```

**References**

[Accessing Data with Cassandra](https://spring.io/guides/gs/accessing-data-cassandra)

[Spring Boot Cassandra CRUD example](https://www.bezkoder.com/spring-boot-cassandra-crud/)