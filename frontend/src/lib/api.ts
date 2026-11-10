import {
  dashboardAssetsSchema,
  type DashboardAsset,
} from "@/lib/schemas";

const API_BASE_URL =
  process.env.NEXT_PUBLIC_API_BASE_URL ?? "http://localhost:8080";

export async function getDashboardAssets(): Promise<DashboardAsset[]> {
  const response = await fetch(`${API_BASE_URL}/api/dashboard/assets`);

  if (!response.ok) {
    throw new Error("Failed to load dashboard assets");
  }

  const payload = await response.json();
  return dashboardAssetsSchema.parse(payload);
}