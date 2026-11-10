#!/usr/bin/env bash
# Activates the Node.js version from .nvmrc (required by Next.js), then starts DB, backend and frontend.
set -e

cd "$(dirname "$0")/.."

# npm sets this variable and nvm refuses to work while it is defined
unset npm_config_prefix

export NVM_DIR="${NVM_DIR:-$HOME/.nvm}"
if [ ! -s "$NVM_DIR/nvm.sh" ]; then
  echo "nvm not found at $NVM_DIR. Install nvm or Node.js >= 20.9 manually." >&2
  exit 1
fi

# shellcheck disable=SC1091
. "$NVM_DIR/nvm.sh"
nvm install >/dev/null
nvm use >/dev/null
echo "Using Node $(node -v)"

[ -d node_modules ] || npm install
[ -d frontend/node_modules ] || npm --prefix frontend install

exec npm run dev
