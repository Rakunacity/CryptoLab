const net = require("node:net");

const jdbcUrl =
  process.env.SPRING_DATASOURCE_URL ||
  "jdbc:postgresql://localhost:5433/cryptolab";

const match = jdbcUrl.match(/^jdbc:postgresql:\/\/([^/:]+)(?::(\d+))?\/([^?]+)/);

if (!match) {
  console.error(
    `Invalid SPRING_DATASOURCE_URL for PostgreSQL: ${jdbcUrl}`,
  );
  process.exit(1);
}

const host = match[1];
const port = Number(match[2] || 5432);
const database = match[3];

const socket = new net.Socket();

socket.setTimeout(2000);

socket.once("connect", () => {
  socket.end();
  console.log(`PostgreSQL reachable at ${host}:${port}/${database}`);
  process.exit(0);
});

socket.once("timeout", () => {
  socket.destroy();
  console.error(`PostgreSQL is not reachable at ${host}:${port}/${database}.`);
  console.error("Start it with: npm run db:up");
  process.exit(1);
});

socket.once("error", () => {
  console.error(`PostgreSQL is not reachable at ${host}:${port}/${database}.`);
  console.error("Start it with: npm run db:up");
  process.exit(1);
});

socket.connect(port, host);