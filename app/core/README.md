# Resume Core

```
export ARTIFACTS_AUTH=$(aws codeartifact get-authorization-token \
--domain wheelercloudguru \
--query authorizationToken \
--output text)
```

```
<settings>
    <servers>
        <server>
            <id>codeartifact</id>
            <username>aws</username>
            <password>${env.ARTIFACTS_AUTH}</password>
        </server>
    </servers>
</settings>
```
> settings.xml