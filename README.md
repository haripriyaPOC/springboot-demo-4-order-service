# order-service

Sample order API with status and total

## Requirements
- Java 17
- Maven 3.9+ (optional if using Docker build)
- Docker (for container build)
- Kubernetes and kubectl (for Kubernetes deployment)

## Run locally
```bash
mvn spring-boot:run
```

Test the API:
```bash
curl http://localhost:8080/api/orders
curl http://localhost:8080/actuator/health
```

## Build a JAR
```bash
mvn clean package
java -jar target/order-service-0.0.1-SNAPSHOT.jar
```

## Build and run with Docker
```bash
docker build -t order-service:1.0.0 .
docker run --rm -p 8080:8080 order-service:1.0.0
```

Then test `http://localhost:8080/api/orders`.

## Deploy to Kubernetes
1. Update the image in `k8s/deployment.yaml` to the image you pushed to your registry.
2. Push the image to your registry, for example:
   ```bash
   docker tag order-service:1.0.0 YOUR_REGISTRY/order-service:1.0.0
   docker push YOUR_REGISTRY/order-service:1.0.0
   ```
3. Apply the manifests:
   ```bash
   kubectl apply -f k8s/
   kubectl rollout status deployment/order-service
   kubectl get pods,svc -l app=order-service
   ```
4. Test from inside the cluster or port-forward:
   ```bash
   kubectl port-forward svc/order-service 8080:80
   curl http://localhost:8080/api/orders
   ```

## Health checks
- `/actuator/health`
- `/actuator/health/readiness`
- `/actuator/health/liveness`

These are demo applications with in-memory/static data only; no database is required.
