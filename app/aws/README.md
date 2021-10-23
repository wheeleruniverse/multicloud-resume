## App AWS

```bash
mvn package
docker build -t app-aws:local .
docker run -p 9000:8080 --rm --name app-aws app-aws:local
```
