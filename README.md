# Cryptolab

Cryptolab is a split-stack workspace with a Spring Boot backend and a Next.js frontend.

The current implementation includes one page: a Dashboard that shows a market table with these columns:

- Asset
- Price
- You own

Market prices are not stored in the database yet. The dashboard currently reads in-memory market data from the backend API.

## Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Next.js
- TypeScript
- TanStack Query
- Zod
- Tailwind CSS
- shadcn-style UI primitives
- Vitest + React Testing Library
- Playwright

## Project Structure

- `src/` Spring Boot backend
- `frontend/` Next.js frontend
- `docker-compose.yml` PostgreSQL service
- `scripts/` local development helpers

## Requirements

- Java 21
- Maven
- Node.js + npm
- Docker

## Run Locally

From the project root, one command:

```bash
npm start
```

`npm start` switches to the Node.js version from `.nvmrc` via nvm (installing it if needed), then runs `npm run dev`.
If Node.js >= 20.9 is already active, you can also run `npm install && npm run dev` directly.

What happens:

- `npm run dev` checks whether PostgreSQL is reachable
- if PostgreSQL is down, it tries to start `docker compose` automatically
- then it starts both backend and frontend together

App URLs:

- Frontend: `http://localhost:3000`
- Backend API: `http://localhost:8080/api/dashboard/assets`
- PostgreSQL: `localhost:5433`

## Database Commands

```bash
npm run db:up
npm run db:down
```

By default the backend uses the `postgres` Spring profile and reads:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

If these are not set, the backend falls back to the local defaults from `application-postgres.properties`.

## Testing

Backend:

```bash
mvn test
```

Frontend commands from the project root:

```bash
npm --prefix frontend test
npm --prefix frontend run build
npm --prefix frontend run lint
```

Frontend commands from `frontend/`:

```bash
cd frontend && npm run build
cd frontend && npm test
cd frontend && npm run lint
```

Workspace test shortcut:

```bash
npm test
```

## Notes

- Portfolio/trade persistence is scaffolded through JPA, but the dashboard still serves market prices from in-memory backend configuration.
- PostgreSQL is now required for backend startup.