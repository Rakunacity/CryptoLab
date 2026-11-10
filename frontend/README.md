# Frontend

This frontend is a Next.js application for the Cryptolab dashboard.

## Stack

- Next.js App Router
- TypeScript
- Tailwind CSS
- TanStack Query
- Zod
- Vitest + React Testing Library
- Playwright

## Dashboard

The current UI contains one page: Dashboard.

It renders a table of market assets with these columns:

- Asset
- Price
- You own

The page fetches data from the backend endpoint:

```text
http://localhost:8080/api/dashboard/assets
```

You can override the backend URL with:

```bash
NEXT_PUBLIC_API_BASE_URL=http://localhost:8080
```

## Development

Run from the workspace root for the full stack:

```bash
npm run dev
```

Run only the frontend from this folder:

```bash
npm run dev
```

Open:

```text
http://localhost:3000
```

## Commands

```bash
npm run dev
npm run build
npm run lint
npm test
npm run test:e2e
```
