const { spawnSync } = require("node:child_process");
const net = require("node:net");

const jdbcUrl =
  process.env.SPRING_DATASOURCE_URL ||
  "jdbc:postgresql://localhost:5433/cryptolab";

const match = jdbcUrl.match(/^jdbc:postgresql:\/\/([^/:]+)(?::(\d+))?\/([^?]+)/);

if (!match) {
  console.error(`Invalid SPRING_DATASOURCE_URL for PostgreSQL: ${jdbcUrl}`);
  process.exit(1);
}

const host = match[1];
const port = Number(match[2] || 5432);
const database = match[3];

function checkReachable() {
  return new Promise((resolve) => {
    const socket = new net.Socket();

    socket.setTimeout(1500);

    socket.once("connect", () => {
      socket.end();
      resolve(true);
    });

    socket.once("timeout", () => {
      socket.destroy();
      resolve(false);
    });

    socket.once("error", () => {
      resolve(false);
    });

    socket.connect(port, host);
  });
}

async function main() {
  if (await checkReachable()) {
    console.log(`PostgreSQL already reachable at ${host}:${port}/${database}`);
    return;
  }

  console.log(`PostgreSQL is not reachable at ${host}:${port}/${database}.`);
  console.log("Starting Docker Compose service: postgres");

  const result = spawnSync("docker", ["compose", "up", "-d", "postgres"], {
    encoding: "utf8",
  });

  if (result.status !== 0) {
    const dockerOutput = [result.stdout, result.stderr]
      .filter(Boolean)
      .join("\n")
      .trim();

    if (dockerOutput) {
      console.error(dockerOutput);
    }

    console.error("Docker is not available for automatic PostgreSQL startup.");
    console.error("Start Docker Desktop or the Docker daemon, then run: npm run dev");
    console.error("If PostgreSQL is managed elsewhere, make sure SPRING_DATASOURCE_URL points to it.");
    process.exit(result.status || 1);
  }

  const maxAttempts = 15;
  for (let attempt = 1; attempt <= maxAttempts; attempt += 1) {
    if (await checkReachable()) {
      console.log(`PostgreSQL is ready at ${host}:${port}/${database}`);
      return;
    }
  }

  console.error(`PostgreSQL did not become reachable at ${host}:${port}/${database}.`);
  console.error("Check Docker status or start the database manually with: npm run db:up");
  process.exit(1);
}

main();