import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

public class PostgreSQLResource implements QuarkusTestResourceLifecycleManager {

    private static PostgreSQLContainer<?> container;

    @Override
    public Map<String, String> start() {

        container = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:15.5")
        )
            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("postgres");

        container.start();

        return Map.of(
            "quarkus.datasource.jdbc.url", container.getJdbcUrl(),
            "quarkus.datasource.username", "postgres",
            "quarkus.datasource.password", "postgres"
        );
    }

    @Override
    public void stop() {
        container.stop();
    }
}
